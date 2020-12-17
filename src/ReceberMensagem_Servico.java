import javax.swing.JTextArea;

public class ReceberMensagem_Servico extends Thread{

	private CanalDeComunicacao canal;
	private JTextArea textArea;
	private Integer id = null;

	public ReceberMensagem_Servico(CanalDeComunicacao canal, JTextArea textArea) {
		this.canal = canal;
		this.textArea = textArea;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Mensagem msg = canal.get();
			
			if(msg != null) {
				
				if(id == null || id < msg.getId()) {
					id = msg.getId();
					textArea.setText(textArea.getText() + "\n" + msg.toString());
				}
				
				
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
