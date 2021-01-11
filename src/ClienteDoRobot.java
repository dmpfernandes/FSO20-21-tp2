import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteDoRobot extends JFrame {
	
	private EspacarFormasGeometricas espacarFormasGeometricas;
	private static final long serialVersionUID = 1L;
	private static ClienteDoRobot frame;
	private CanalDeComunicacao canal;
	private JTextField textField;
	private JTextArea textAreaDebug;
	private boolean espacar = false;
	private boolean onoff = false;
	
	public ClienteDoRobot() {
		initGUI();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			frame = new ClienteDoRobot();
			frame.setPreferredSize(new Dimension(650, 450));
		    frame.pack();
		    frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		
		
	}

	private void initGUI() {
		getContentPane().setSize(650, 450);
		getContentPane().setLayout(null);


		JButton btnDesenharQuadrado = new JButton("Desenhar Quadrado");
		btnDesenharQuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				espacarFormasGeometricas.gerarComandosQuadrado(espacar);
			}
		});
		btnDesenharQuadrado.setBounds(356, 128, 218, 29);
		getContentPane().add(btnDesenharQuadrado);

		JButton btnDesenharCirculo = new JButton("Desenhar Circulo");
		btnDesenharCirculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacarFormasGeometricas.gerarComandosCirculo(espacar);
			}
		});
		btnDesenharCirculo.setBounds(358, 169, 216, 29);
		getContentPane().add(btnDesenharCirculo);

		JButton btnEspacarFormasGeometricas = new JButton("Espacar Formas Geometricas");
		btnEspacarFormasGeometricas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacar = !espacar;
			}
		});
		btnEspacarFormasGeometricas.setBounds(356, 210, 218, 29);
		getContentPane().add(btnEspacarFormasGeometricas);

		JLabel lblNomeDoRobot = new JLabel("Nome do Robot:");
		lblNomeDoRobot.setBounds(6, 6, 102, 16);
		getContentPane().add(lblNomeDoRobot);

		textField = new JTextField();
		textField.setBounds(120, 1, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);

		JRadioButton rdbtnOnoff = new JRadioButton("On/Off");
		rdbtnOnoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onoff = !onoff;
				if(onoff) {
					canal = new CanalDeComunicacao();
					espacarFormasGeometricas = new EspacarFormasGeometricas(canal);
				}else {
					canal.fecharCanal();
				}
			}
		});
		rdbtnOnoff.setBounds(6, 54, 141, 23);
		getContentPane().add(rdbtnOnoff);

		JButton btnResetDebug = new JButton("Reset Debug");
		btnResetDebug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaDebug.setText("");
			}
		});
		btnResetDebug.setBounds(6, 320, 117, 29);
		getContentPane().add(btnResetDebug);

		textAreaDebug = new JTextArea();
		textAreaDebug.setBounds(6, 125, 287, 183);
		getContentPane().add(textAreaDebug);

		JLabel lblDebug = new JLabel("Debug:");
		lblDebug.setLabelFor(textAreaDebug);
		lblDebug.setBounds(6, 100, 61, 16);
		getContentPane().add(lblDebug);

		
	}
	
}
