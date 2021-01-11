import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;


public class CanalDeComunicacao {

	private RandomAccessFile memoryMappedFile;
	private static MappedByteBuffer map;
	private static File file;
	final static int MAX_BUFFER = 384;
	private int idx = 0; 
	private static int putCounter = 0;
	private int getCounter = 0;
	
	public CanalDeComunicacao() {
		file = new File("teste");
		try {
			this.memoryMappedFile = new RandomAccessFile(file, "rw");
			this.map = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, MAX_BUFFER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//file.deleteOnExit();
	}

	public void put(Mensagem msg) {
		
		map.position(putCounter);
		map.putInt(idx);
		map.putInt(msg.getTipo());
		map.putInt(msg.getAngulo());
		map.putInt(msg.getDistancia());
		map.putInt(msg.getRaio());
		map.putInt(msg.getParar());
		putCounter++;
		idx++;
		if(putCounter == 15)putCounter=0;
		
	}

	public Mensagem get() {
		if(getCounter >= 383)getCounter=0;
		map.position(getCounter);
		Integer id = map.getInt();
		Integer tipo = map.getInt();
		Integer angulo = map.getInt();
		Integer distancia = map.getInt();
		Integer raio = map.getInt();
		Integer parar = map.getInt();
		if(parar != -1) {
			Mensagem msg = new Mensagem(tipo,parar == 1?true:false);
			msg.setId(id);
			getCounter += 24;
			return msg;
		}
		if(raio != -1 || angulo != -1) {
			Mensagem msg = new Mensagem(tipo,raio,angulo);
			msg.setId(id);
			getCounter += 24;
			return msg;
		}
		if(distancia != 0) {
			Mensagem msg = new Mensagem(tipo,distancia);
			msg.setId(id);
			getCounter += 24;
			return msg;
		}
		return null;
	}
	
	public void fecharCanal() {
		try {
			this.memoryMappedFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
}
