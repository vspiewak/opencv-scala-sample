import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;


public class WebcamDemo {

    public void run() {

        VideoCapture cap = new VideoCapture(0);

        if (!cap.isOpened()) {
            System.out.println("Webcam not found :(");
        } else {
            System.out.println("Found Webcam: " + cap);
            try {
                System.out.println("Wait a bit, Webcam start");
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
            }
        }

        Mat frame = new Mat();
        cap.read(frame);
        Highgui.imwrite("webcam.jpg", frame);

        Mat frameBlur = new Mat();
        Imgproc.blur(frame, frameBlur, new Size(10, 10));
        Highgui.imwrite("webcam-blurred.jpg", frameBlur);

        Imgproc.GaussianBlur(frame, frameBlur, new Size(25, 25), 30);
        Highgui.imwrite("webcam-gaussian.jpg", frameBlur);

        cap.release();

    }
}
