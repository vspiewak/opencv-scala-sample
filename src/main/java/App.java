import org.opencv.core.Core;

public class App {
  public static void main(String[] args) {
    
	// Load the native library.
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    
    new FaceDetector().run();
    
  }
}
