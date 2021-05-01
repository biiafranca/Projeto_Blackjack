
public class Partida {
	Baralho baralho = new Baralho();
	
	public static void main(String[] args) {
		String[] baralhoPartida = new String[52];
		baralhoPartida = Baralho.gerarBaralho();
		
		for(String carta : baralhoPartida) {
			System.out.println(carta);
		}

	}
}
