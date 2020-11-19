import javax.swing.JTextArea;

public interface ILogger {
  
  public String log(String message, Object... args);
  
}
