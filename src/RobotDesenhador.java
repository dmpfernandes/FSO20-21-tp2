import java.util.Random;

import javax.swing.JTextArea;

public class RobotDesenhador {

	private final int SensorMessageTime = 50; // Milliseconds

	boolean record, play, playinv;

	protected int touchSensor;

	protected int sensorUS;

	private final Random rnd;

	private final ILogger theLogger;
	
	public RobotDesenhador(LoggerRobot theLogger, JTextArea textAreaDebug) {
		this.rnd = new Random();
		theLogger.setDebugArea(textAreaDebug);

		record = false;
		play = false;
		playinv = false;

		this.theLogger = theLogger;
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
