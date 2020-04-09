import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 255);
		setLocationRelativeTo(null);
		setTitle("FiveBalls");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Button iniciarJuego = new Button("Iniciar juego");
		iniciarJuego.setBounds(100, 100, 70, 20);
		iniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hOLAA");
			}
		});
		contentPane.add(iniciarJuego, BorderLayout.EAST);
		
		Button puntuaciones = new Button("Ver puntuaciones");
		contentPane.add(puntuaciones, BorderLayout.WEST);
	}

}
