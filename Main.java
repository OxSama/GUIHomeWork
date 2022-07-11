import java.awt.EventQueue;
import java.awt.Point;

/**
 * Util class containing main method.
 * 
 * @author Stefan Hahn (2837462)
 */
public final class Main {
	/**
	 * Private constructor prevents instantiation.
	 */
	private Main() { }
	
	/**
	 * Launch the application.
	 * 
	 * @param	args		Console parameters
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIExercise frame = new GUIExercise(new Point(100, 100));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}