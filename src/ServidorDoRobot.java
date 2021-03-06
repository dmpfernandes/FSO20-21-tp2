import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class ServidorDoRobot extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static ServidorDoRobot frame;
	private CanalDeComunicacao canal;
	private ReceberMensagem_Servico rmservice;
	private JTextArea textAreaComandosLidos;
	private JTextArea textAreaComandosExecutados;
	
	public ServidorDoRobot() {
		initGUI();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			frame = new ServidorDoRobot();
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
		Mensagem msg;
		canal = new CanalDeComunicacao();
		rmservice = new ReceberMensagem_Servico(canal, textAreaComandosLidos, textAreaComandosExecutados);
		rmservice.start();
		
	}

	private void initGUI() {
		getContentPane().setLayout(null);
		
		textAreaComandosLidos = new JTextArea();
		textAreaComandosLidos.setBounds(6, 52, 272, 323);
		getContentPane().add(textAreaComandosLidos);
		
		textAreaComandosExecutados = new JTextArea();
		textAreaComandosExecutados.setBounds(342, 52, 272, 323);
		getContentPane().add(textAreaComandosExecutados);
		
		JLabel lblComandosLidos = new JLabel("Comandos Lidos:");
		lblComandosLidos.setLabelFor(textAreaComandosLidos);
		lblComandosLidos.setBounds(6, 24, 109, 16);
		getContentPane().add(lblComandosLidos);
		
		JLabel lblComandosExecutados = new JLabel("Comandos Executados:");
		lblComandosExecutados.setLabelFor(textAreaComandosExecutados);
		lblComandosExecutados.setBounds(342, 24, 147, 16);
		getContentPane().add(lblComandosExecutados);

	}
}
