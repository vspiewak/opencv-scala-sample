import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;


public class WebcamDemo {

	public void run() {
		
		VideoCapture cap = new VideoCapture(0);
		
		if(!cap.isOpened()) {
			System.out.println("Webcam not found :(");
		} else {
			System.out.println("Found Webcam: " + cap);
		}
		
		Mat frame = new Mat();
		cap.retrieve(frame);
		
		Highgui.imwrite("webcam.jpg", frame);
		Mat frameBlur = new Mat();
		Imgproc.blur(frame, frameBlur, new Size(5, 5));
		Highgui.imwrite("webcam-blurred.jpg", frameBlur);
		
		Imgproc.GaussianBlur(frame, frameBlur, new Size(25, 25), 10);
		Highgui.imwrite("webcam-gaussian.jpg", frameBlur);
		
		cap.release();
		
	}
}
