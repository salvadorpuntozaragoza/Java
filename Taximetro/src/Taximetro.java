import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Label;

public class Taximetro {

	private JFrame frame;
	private JTextField txtHolaMundo;
	private Label label, label_1;
	private String[] estado, pulso, bandera, sensorPulso;
	private int i = 0, j = 0;
	private int banderazoInicial = 10;
	private int cobroTotal = 0;
	private int pulsosTotales = 0;
	private double distanciaRecorrida = 0;
	private int kmRecorridos = 0;
	private Color amaosc = new Color(212, 215, 179);
	private long inicio, fin, total;
	private int minutos = 0;
	private JLabel lblIndicadorDePulsos;
	private JLabel lblIndicadorDeEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taximetro window = new Taximetro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Taximetro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_M) {
					i++;
					if(i == 3) {
						i = 0;
						label_1.setBackground(Color.YELLOW);
					}
					if(i == 1) {
						j = 1;
						cobroTotal = banderazoInicial;
						label_1.setBackground(amaosc);
						inicio = System.currentTimeMillis();
					}
					if(i == 2)
						j = 0;
					
					
					if(i == 2) {
						fin = System.currentTimeMillis();
						total = (fin - inicio) / 1000;
						minutos = (int) (total / 60);
						
						pulsosTotales = pulsosTotales + (minutos * 5);
						System.out.println(pulsosTotales + " pulsos");
						
						distanciaRecorrida = pulsosTotales * 2.5;
						System.out.println(distanciaRecorrida + " mts");
						
						kmRecorridos = (int) (distanciaRecorrida / 1000) ;
						System.out.println(kmRecorridos + " kms");
						
						cobroTotal = cobroTotal + kmRecorridos * 10;
						kmRecorridos = 0;
						pulsosTotales = 0;
						distanciaRecorrida = 0;
						txtHolaMundo.setText(estado[i] + " $" + cobroTotal);
					}else
						txtHolaMundo.setText(estado[i]);
				}
				
				if(e.getKeyCode() == KeyEvent.VK_P) {
					if(i == 1) {
						fin = System.currentTimeMillis();
						total = (fin - inicio) / 1000;
						minutos = (int) (total / 60);
						System.out.println(total + " s");
						
						pulsosTotales = pulsosTotales + 1 + (minutos * 5);
						System.out.println(pulsosTotales + " pulsos");
						
						distanciaRecorrida = pulsosTotales * 2.5;
						System.out.println(distanciaRecorrida + " mts");
						
						kmRecorridos = (int) (distanciaRecorrida / 1000) ;
						System.out.println(kmRecorridos + " kms");
						
						label.setBackground(Color.GREEN);
						try {
							Thread.sleep(50);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						label.setBackground(Color.RED);
						
						inicio = System.currentTimeMillis();
					}
				}
					
			}
		});
		panel.setFocusable(true);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		estado = new String[3];
		pulso = new String[2];
		bandera = new String[2];
		sensorPulso = new String[2];
		estado[0] = "LIBRE";
		estado[1] = "OCUPADO";
		estado[2] = "PAGAR";
		pulso[0] = "OFF";
		pulso[1] = "ON";
		bandera[1] = "OFF";
		bandera[0] = "ON";
		sensorPulso[0] = "OFF";
		sensorPulso[1] = "ON";
		
		txtHolaMundo = new JTextField();
		txtHolaMundo.setBackground(new Color(0, 255, 0));
		txtHolaMundo.setEditable(false);
		txtHolaMundo.setHorizontalAlignment(SwingConstants.CENTER);
		txtHolaMundo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHolaMundo.setText(estado[i] + bandera[j]);
		txtHolaMundo.setBounds(44, 91, 345, 76);
		panel.add(txtHolaMundo);
		
		label = new Label("");
		label.setBackground(Color.RED);
		label.setBounds(63, 53, 14, 15);
		panel.add(label);
		
		label_1 = new Label("LIBRE");
		label_1.setAlignment(Label.CENTER);
		label_1.setBackground(Color.YELLOW);
		label_1.setBounds(291, 46, 62, 22);
		panel.add(label_1);
		
		lblIndicadorDePulsos = new JLabel("Indicador de pulsos");
		lblIndicadorDePulsos.setBounds(24, 33, 116, 14);
		panel.add(lblIndicadorDePulsos);
		
		lblIndicadorDeEstado = new JLabel("Indicador de estado");
		lblIndicadorDeEstado.setBounds(273, 18, 116, 22);
		panel.add(lblIndicadorDeEstado);
	}
}
