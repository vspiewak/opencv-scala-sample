import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;


public class WebcamDemo {

    public void run() {

        VideoCapture cap = new VideoCapture(0);

        if (!cap.isOpened()) {
            System.out.println("Webcam not found :(");
        } else {
            System.out.println("Found Webcam: " + cap);
            try {
                System.out.println("Waiting a bit, Webcam starting");
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


        JFrame jframe = new JFrame("Webcam");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        WebcamPanel panel = new WebcamPanel(cap, 10);

        jframe.setLayout(new BorderLayout());
        jframe.add(panel, BorderLayout.CENTER);
        jframe.setSize(frame.width(), frame.height());
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);

        panel.run();

    }

}
