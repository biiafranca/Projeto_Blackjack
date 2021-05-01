
public class Baralho {

	static String[] numeros = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	static String[] naipes = {"♥", "♦", "♣", "♠"};
	static String[] baralho = new String[52];
	static int i = 0;
	
	public static String[] gerarBaralho() {
		for(String naipe : naipes) {
			for(String numero : numeros) {
				baralho[i] = naipe + " " + numero;
				i++;
			}
		}
		return baralho;
	}
}
