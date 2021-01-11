import javax.swing.JTextArea;

public class ReceberMensagem_Servico extends Thread{

	private CanalDeComunicacao canal;
	private JTextArea textAreaComandosLidos,textAreaComandosExecutados;
	private Integer id = null;
	private RobotDesenhador robot;
	private final LoggerRobot theLogger;
	
	public ReceberMensagem_Servico(CanalDeComunicacao canal, JTextArea textAreaComandosLidos,JTextArea textAreaComandosExecutados) {
		this.canal = canal;
		this.textAreaComandosLidos = textAreaComandosLidos;
		this.textAreaComandosExecutados = textAreaComandosExecutados;
		theLogger = new LoggerRobot();
		this.robot= new RobotDesenhador(theLogger, textAreaComandosExecutados);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Mensagem msg = canal.get();
			
			if(msg != null) {
				
				if(id == null || id < msg.getId()) {
					id = msg.getId();
					textAreaComandosLidos.setText(textAreaComandosLidos.getText() + "\n" + msg.toString());
				}

				int tipo = msg.getTipo();
				switch (tipo) {
				case 0://Reta
					if(msg.getDistancia()!=0) {
						robot.Reta(msg.getDistancia(), false);
					}
					break;
				case 1://Parar
					if(msg.getParar()!=-1) {
						robot.Parar(msg.getParar()==1?true:false);
					}
					break;
				case 2://Curvar Esquerda
					robot.CurvarEsquerda(msg.getRaio(), msg.getAngulo(), false);
					break;
				case 3://Curvar Direita
					robot.CurvarDireita(msg.getRaio(), msg.getAngulo(), false);
					break;
				default:
					break;
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
