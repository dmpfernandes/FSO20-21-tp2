import javax.swing.JFrame;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class RobotDesenhador extends JFrame {
	private static RobotDesenhador frame;

	public RobotDesenhador(LoggerRobot theLogger) {
		initGUI();
		this.rnd = new Random();
		theLogger.setDebugArea(textAreaDebug);

		record = false;
		play = false;
		playinv = false;

		this.theLogger = theLogger;
	}

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	private final int SensorMessageTime = 50; // Milliseconds

	boolean record, play, playinv;

	protected int touchSensor;

	protected int sensorUS;

	private final Random rnd;

	private final ILogger theLogger;
	
	private JTextArea textAreaDebug;

	public static void main(String[] args) {
		try {
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
		while (true) {

		}
	}

	private void initGUI() {
		getContentPane().setSize(650, 450);
		getContentPane().setLayout(null);

		JButton btnFrente = new JButton("Frente");
		btnFrente.setBounds(403, 9, 117, 29);
		getContentPane().add(btnFrente);

		JButton btnRetaguarda = new JButton("Retaguarda");
		btnRetaguarda.setBounds(403, 87, 117, 29);
		getContentPane().add(btnRetaguarda);

		JButton btnEsquerda = new JButton("Esquerda");
		btnEsquerda.setBounds(276, 45, 117, 29);
		getContentPane().add(btnEsquerda);

		JButton btnDireita = new JButton("Direita");
		btnDireita.setBounds(527, 45, 117, 29);
		getContentPane().add(btnDireita);

		JButton btnDesenharQuadrado = new JButton("Desenhar Quadrado");
		btnDesenharQuadrado.setBounds(356, 128, 218, 29);
		getContentPane().add(btnDesenharQuadrado);

		JButton btnDesenharCirculo = new JButton("Desenhar Circulo");
		btnDesenharCirculo.setBounds(358, 169, 216, 29);
		getContentPane().add(btnDesenharCirculo);

		JButton btnEspacarFormasGeometricas = new JButton("Espacar Formas Geometricas");
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
		rdbtnOnoff.setBounds(6, 54, 141, 23);
		getContentPane().add(rdbtnOnoff);

		JButton btnResetDebug = new JButton("Reset Debug");
		btnResetDebug.setBounds(6, 320, 117, 29);
		getContentPane().add(btnResetDebug);

		textAreaDebug = new JTextArea();
		textAreaDebug.setBounds(6, 125, 287, 183);
		getContentPane().add(textAreaDebug);

		JLabel lblDebug = new JLabel("Debug:");
		lblDebug.setLabelFor(textAreaDebug);
		lblDebug.setBounds(6, 100, 61, 16);
		getContentPane().add(lblDebug);

		JButton btnParar = new JButton("Parar");
		btnParar.setBounds(403, 45, 117, 29);
		getContentPane().add(btnParar);
	}

	public void setRecord(boolean r) {
		record = r;
	}

	public void setPlay(boolean p) {
		play = p;
	}

	public void setPlayInv(boolean p) {
		playinv = p;
	}

	public boolean OpenNXT(String nome) {
		this.theLogger.log("OpenNXT(%s)", nome);

		return true;
	}

	public void CloseNXT() {

		this.theLogger.log("CloseNXT()");
	}

	public void Parar(boolean b) {

		this.theLogger.log("Parar(%b)", b);

	}

	public void Reta(int distancia, boolean chkavoid) {
		this.theLogger.log("Reta(distancia->%d)", distancia);
	}

	public void CurvarEsquerda(int raio, int angulo, boolean chkavoid) {
		this.theLogger.log("CurvarEsquerda(raio->%d, angulo->%d)", raio, angulo);
	}

	public void CurvarDireita(int raio, int angulo, boolean chkavoid) {

		this.theLogger.log("CurvarDireita(raio->%d, angulo->%d)", raio, angulo);

	}

	public void SetVelocidade(int speed) {

		this.theLogger.log("SetSpeed(speed->%d)", speed);
	}

	public void SetTouchSensor(int touchSensor) {
		this.touchSensor = touchSensor;
		this.theLogger.log("SetTouchSensor(touchSensor->%d)", this.touchSensor);
	}

	public void SetSensorLowSpeed(int sensorUS) {
		this.sensorUS = sensorUS;
		this.theLogger.log("SetSensorLowspeed(sensorLS->%d)", this.sensorUS);
	}

	public boolean GetTouchSensor() {

		this.theLogger.log("GetTouchSensord()");
		return this.rnd.nextInt(1000) > 900;
	}

	public int GetSensorUS() {

		this.theLogger.log("GetSensorUS()");
		return this.rnd.nextInt(2555) / 10;
	}

	public int GetSensorDelay() {
		return SensorMessageTime;
	}

	public void stopRecord() {
	}

}
