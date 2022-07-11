import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * Implementation of javax.swing.JFrame which creates
 * the example GUI program.
 * 
 * @author Stefan Hahn (2837462)
 */
public class GUIExercise extends JFrame {
	private JPanel contentPane;
	
	/**
	 * Creates a frame.
	 * 
	 * @param	screenOffset		Point indicating where to place the window
	 */
	public GUIExercise(Point screenOffset) {
		setResizable(false);
		setTitle("GUI Aufgabe");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds((int) screenOffset.getX(), (int) screenOffset.getY(), 300, 100);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblText = new JLabel("GUI Aufgabe");
		lblText.setBounds(115, 10, 70, 14);
		contentPane.add(lblText);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 32, 274, 33);
		contentPane.add(panel);
		
		JButton btnMove = new JButton("Move");
		btnMove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent event) {
				if (event.getButton() == MouseEvent.BUTTON1) {
					Rectangle screenBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
					Component frame = SwingUtilities.getRoot(event.getComponent());
					
					int x = (int) Math.floor((screenBounds.width - frame.getWidth()) / 2);
					int y = (int) Math.floor((screenBounds.height - frame.getHeight()) / 2);
					
					frame.setLocation(x, y);
				}
			}
		});
		panel.add(btnMove);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent event) {
				if (event.getButton() == MouseEvent.BUTTON1) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							Component frame = SwingUtilities.getRoot(event.getComponent());
							
							try {
								GUIExercise childFrame = new GUIExercise(new Point(frame.getX() + 20, frame.getY() + 20));
								childFrame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		panel.add(btnOpen);
		
		JButton btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent event) {
				if (event.getButton() == MouseEvent.BUTTON1) {
					JFrame frame = (JFrame) SwingUtilities.getRoot(event.getComponent());
					
					WindowEvent wev = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
					Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
				}
			}
		});
		panel.add(btnClose);
	}
}