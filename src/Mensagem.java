
public class Mensagem {
	
	private int id;
	private int tipo;
	private int raio = -1;
	private int angulo = -1;
	private int distancia = 0;
	private int parar = -1;
	
	public Mensagem(int tipo, int raio, int angulo){
		this.tipo = tipo;
		this.raio = raio;
		this.angulo = angulo;
	}
	
	public Mensagem(int tipo, int distancia){
		this.tipo = tipo;
		this.distancia = distancia;
	}
	
	public Mensagem(int tipo, boolean parar){
		this.tipo = tipo;
		this.parar = parar?1:0;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	public int getAngulo() {
		return angulo;
	}

	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getParar() {
		return parar;
	}

	public void setParar(int parar) {
		this.parar = parar;
	}

//	@Override
//	public String toString() {
//		
//		return "id: "+id+" tipo:"+tipo+" texto:"+texto;
//	}
	
}