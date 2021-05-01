package blackjack;

import java.util.ArrayList;
import java.util.Collections;

import blackjack.Cartas.NaipeCarta;
import blackjack.Cartas.ValorCarta;

public class Baralho {
	
	ArrayList<Cartas> cartas = new ArrayList<>();
	
	public ArrayList<Cartas> getCartas() {
		return this.cartas;
	}
	
	public void gerarBaralho() {
		
		for(int posicaoNaipe = 0; posicaoNaipe < Cartas.NaipeCarta.quantidadeNaipes(); posicaoNaipe++) {
			
			for(int posicaoCarta = 0; posicaoCarta < Cartas.ValorCarta.quantidadeCartas(); posicaoCarta++) {

				ValorCarta valorAtual = Cartas.ValorCarta.getValores(posicaoCarta);
				NaipeCarta naipeAtual = Cartas.NaipeCarta.getNaipes(posicaoNaipe);

				Cartas carta = new Cartas(valorAtual, naipeAtual);
				cartas.add(carta);
			}
		}
	}
	
	public void reiniciarBaralho(Baralho baralho) {
		int tamanhoBaralho = this.cartas.size();
		
		for (int i = 0; i < tamanhoBaralho; i++) {
			baralho.cartas.add(this.cartas.get(i));
		}
		
		for (int i = 0; i < tamanhoBaralho; i++) {
			this.removerCarta(0);
		}
	}
	
	public void removerCarta(int posicao) {
		cartas.remove(posicao);
	}

	public void embaralharCartas() {
		Collections.shuffle(cartas);
	}
	
	public void adicionarCarta(Baralho baralho) {
		cartas.add(baralho.cartas.get(0));
		baralho.removerCarta(0);
	}
	
	public Cartas sortearCarta() {
		Cartas cartaSorteada = cartas.get(0);
		removerCarta(0);
		return cartaSorteada;
	}
	
	public void entregarCarta(Baralho baralhoDestino, Cartas carta) {
		baralhoDestino.cartas.add(carta);
	}
	
	public int calcularTamanhoBaralho() {
		return cartas.size();
	}
	
	public int calcularValorDaMao() {
		int total = 0;
		int quantAs = 0;
		
		for(Cartas carta: cartas) {
			switch(carta.getValor()) {
			case ÁS: quantAs++; break;
			case DOIS: total += 2; break;
			case TRÊS: total += 3; break;
			case QUATRO: total += 4; break;
			case CINCO: total += 5; break;
			case SEIS: total += 6; break;
			case SETE: total += 7; break;
			case OITO: total += 8; break;
			case NOVE: total += 9; break;
			case DEZ: total += 10; break;
			case VALETE: total += 10; break;
			case DAMA: total += 10; break;
			case REI: total += 10; break;
			}		
		}
			
		for(int i = 0; i < quantAs; i++) {
			if(total <= 10) {
				total += 11;
			} else {
				total += 1;
			}
		}
		
		return total;
	}

	@Override
	public String toString() {
		String baralho = "";
		for(Cartas carta: cartas) {
			baralho += carta.toString() + '\n';
		}
		return baralho;
	}
		
}
