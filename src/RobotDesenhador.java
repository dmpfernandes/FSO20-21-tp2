import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class RobotDesenhador extends JFrame{
	public RobotDesenhador() {
		getContentPane().setLayout(null);
		
		JButton btnFrente = new JButton("Frente");
		btnFrente.setBounds(364, 23, 117, 29);
		getContentPane().add(btnFrente);
		
		JButton btnRetaguarda = new JButton("Retaguarda");
		btnRetaguarda.setBounds(364, 87, 117, 29);
		getContentPane().add(btnRetaguarda);
		
		JButton btnEsquerda = new JButton("Esquerda");
		btnEsquerda.setBounds(304, 53, 117, 29);
		getContentPane().add(btnEsquerda);
		
		JButton btnDireita = new JButton("Direita");
		btnDireita.setBounds(428, 53, 117, 29);
		getContentPane().add(btnDireita);
		
		JButton btnDesenharQuadrado = new JButton("Desenhar Quadrado");
		btnDesenharQuadrado.setBounds(321, 156, 218, 29);
		getContentPane().add(btnDesenharQuadrado);
		
		JButton btnDesenharCirculo = new JButton("Desenhar Circulo");
		btnDesenharCirculo.setBounds(323, 197, 216, 29);
		getContentPane().add(btnDesenharCirculo);
		
		JButton btnEspacarFormasGeometricas = new JButton("Espacar Formas Geometricas");
		btnEspacarFormasGeometricas.setBounds(321, 238, 218, 29);
		getContentPane().add(btnEspacarFormasGeometricas);
		
		JLabel lblNomeDoRobot = new JLabel("Nome do Robot:");
		lblNomeDoRobot.setBounds(6, 6, 102, 16);
		getContentPane().add(lblNomeDoRobot);
		
		textField = new JTextField();
		textField.setBounds(120, 1, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnOnoff = new JRadioButton("On/Off");
		rdbtnOnoff.setBounds(6, 54, 141, 23);
		getContentPane().add(rdbtnOnoff);
		
		JButton btnResetDebug = new JButton("Reset Debug");
		btnResetDebug.setBounds(6, 320, 117, 29);
		getContentPane().add(btnResetDebug);
		
		JTextArea textAreaDebug = new JTextArea();
		textAreaDebug.setBounds(6, 125, 287, 183);
		getContentPane().add(textAreaDebug);
		
		JLabel lblDebug = new JLabel("Debug:");
		lblDebug.setLabelFor(textAreaDebug);
		lblDebug.setBounds(6, 100, 61, 16);
		getContentPane().add(lblDebug);
	}

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
