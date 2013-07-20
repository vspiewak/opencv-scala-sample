import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class WebcamPanel extends JPanel implements Runnable {

    VideoCapture cap;
    private int fps;

    public WebcamPanel(VideoCapture cap, int fps) {
        this.cap = cap;
        this.fps = fps;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Mat frame = new Mat();
        cap.read(frame);
        BufferedImage image = Utils.matToBuffer(frame);
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }

    @Override
    public void run() {

        while (true) {

            try {

                Thread.sleep(1000 / fps);  // milliseconds

            } catch (InterruptedException ex) {

                // release webcam on exit
                cap.release();

            }

            this.repaint();
        }

    }


}