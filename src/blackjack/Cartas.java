package blackjack;

public class Cartas {
	
	public enum ValorCarta {
		
		ÁS, DOIS, TRÊS, QUATRO, CINCO, SEIS, SETE, OITO, NOVE, DEZ, VALETE, DAMA, REI;
		
		public static ValorCarta getValores(int posicao) {
			ValorCarta[] valores = ValorCarta.values();
			return valores[posicao];
			
		}

		public static int quantidadeCartas() {
			return ValorCarta.values().length;
		}
		
	}
	
	public enum NaipeCarta {
		
		COPAS, OUROS, PAUS, ESPADAS;
		
		public static NaipeCarta getNaipes(int posicao) {
			NaipeCarta[] naipes = NaipeCarta.values();
			return naipes[posicao];
			
		}

		public static int quantidadeNaipes() {
			return NaipeCarta.values().length;
		}
		
	}
	
	private ValorCarta valor;
	private NaipeCarta naipe;
	
	// CONSTRUTOR
	public Cartas(ValorCarta valor, NaipeCarta naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}

	// GETTERS
	public ValorCarta getValor() {
		return this.valor;
	}

	public NaipeCarta getNaipe() {
		return this.naipe;
	}

	@Override
	public String toString() {
		return this.valor + " DE " + this.naipe;
	}

}
