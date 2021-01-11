import java.util.List;

public class EspacarFormasGeometricas {
	
	
	CanalDeComunicacao canal;

	public EspacarFormasGeometricas(CanalDeComunicacao canal) {
		this.canal = canal;
	}

	public void gerarComandosCirculo(boolean ativar) {
		List<Mensagem> circulo= DesenharCirculo.gerarComandos();
		if (ativar) {
			circulo.add(new Mensagem(0, 50));
		}
		circulo.forEach(c -> canal.put(c));
	}
	
	public void gerarComandosQuadrado(boolean ativar) {
		List<Mensagem> quadrado = DesenharQuadrado.gerarComandos();
		if (ativar) {
			quadrado.add(new Mensagem(0, 50));
		}
		quadrado.forEach(c -> canal.put(c));
	}
}
