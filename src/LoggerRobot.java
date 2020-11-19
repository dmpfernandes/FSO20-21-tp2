import javax.swing.JTextArea;

public class LoggerRobot implements ILogger{
	
	private JTextArea textAreaDebug;

	@Override
	public String log(String message, Object... args) {
		textAreaDebug.setText(textAreaDebug.getText() + message);
		return null;
	}
	
	public void setDebugArea(JTextArea textAreaDebug) {
		this.textAreaDebug = textAreaDebug;
	}


}
