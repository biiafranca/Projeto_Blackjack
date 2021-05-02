package blackjack;

import java.util.Scanner;

public class PartidaBlackjack {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		JogadorUsuario jogador = new JogadorUsuario();
		Jogador dealer = new Jogador();
		boolean jogadorVenceu = false;
		boolean empate = false;
		boolean jogoAtivo = true;
		
		// Valor do saldo inicial do jogador
		jogador.setSaldo(100.0);
		
		// Gerando o baralho para iniciar a partida
		Baralho baralhoRodada = new Baralho();
		baralhoRodada.gerarBaralho();
		baralhoRodada.embaralharCartas();
		
		// Instanciando cartas do jogador e do dealer		
		Baralho cartasJogador = new Baralho();
		Baralho cartasDealer = new Baralho();
	
		// Continuar jogo apenas enquanto há dinheiro para aposta
		while(jogador.getSaldo() > 0) {
			
			System.out.println("Você possui R$ " + jogador.getSaldo() +", quanto deseja apostar?");
			System.out.println("(Digite 0 para sair do jogo)");
			jogador.setProposta(scanner.nextDouble());
			
			if(jogador.getProposta() == 0) {
				jogoAtivo = false;
				break;
			}
			
			if(jogador.getProposta() > jogador.getSaldo()) {
				System.out.println("\nErro! Aposta maior que o saldo atual. \n");
				continue;
			} else {
				jogador.setAposta(jogador.getProposta());
			}
			
			System.out.println("\nApostando... \n");
			boolean fimDaPartida = false;
			
			// Duas cartas para o jogador
			cartasJogador.adicionarCarta(baralhoRodada);
			cartasJogador.adicionarCarta(baralhoRodada);
			
			// Duas cartas para o dealer
			cartasDealer.adicionarCarta(baralhoRodada);
			cartasDealer.adicionarCarta(baralhoRodada);
			
			// Vez do Jogador
			while(jogoAtivo) {
				
				System.out.println("Sua mão: \n" + cartasJogador.toString());
				System.out.println("Total: " + cartasJogador.calcularValorDaMao() + '\n');
				
				System.out.println("Mão do dealer: \n" + cartasDealer.getCartas().get(0));
				System.out.println("[carta escondida]\n");
				
				// Escolher entre continuar (Hit) ou parar
				System.out.println("Deseja (1)Continuar ou (2)Parar? \n");
				int escolha = scanner.nextInt();
				
				//// Continuar
					if(escolha == 1) {
						cartasJogador.adicionarCarta(baralhoRodada);
						
						// Conferir se mão do jogador "estourou"
						if(cartasJogador.calcularValorDaMao() > 21) {
							System.out.println("Sua mão: \n" + cartasJogador.toString());
							System.out.println("Total: " + cartasJogador.calcularValorDaMao() + '\n');
							fimDaPartida = true;
							break;
						}
					}
					
			    //// Parar
					if(escolha == 2 ) {
						break;
					}
				}
			
			// Fim da vez do jogador, contagem de pontos
			jogador.setPontos(cartasJogador.calcularValorDaMao());
			dealer.setPontos(cartasDealer.calcularValorDaMao());
			
			// Vez do dealer
			// Enquanto o dealer tiver menos de 17 pontos deverá continuar recebendo cartas
			while((dealer.getPontos() < 17) && !fimDaPartida){
				cartasDealer.adicionarCarta(baralhoRodada);
				dealer.setPontos(cartasDealer.calcularValorDaMao());
			}
			
			// Mostrar cartas do dealer
			System.out.println("Mão do dealer: \n" + cartasDealer.toString());
			System.out.println("Total: " + dealer.getPontos());
			
			// Resultados
			// Conferir se mão do dealer "estourou"
			if((dealer.getPontos() > 21) && !fimDaPartida){
				fimDaPartida = true;
				jogadorVenceu = true;
			}	
			// Conferir se dealer venceu por pontuação
			else if((dealer.getPontos() > jogador.getPontos()) && !fimDaPartida) {
				fimDaPartida = true;
			}
			// Conferir se empatou
			else if((dealer.getPontos() == jogador.getPontos()) && !fimDaPartida){
				fimDaPartida = true;
				empate = true;
			}
			// Conferir se jogador venceu por pontuação
			else if((jogador.getPontos() > dealer.getPontos()) && !fimDaPartida){
				fimDaPartida = true;
				jogadorVenceu = true;
			}

			// Apresentando resultados
			System.out.println("\nResultado: Jogador " + jogador.getPontos() + " x " + dealer.getPontos() + " Dealer \n");
			
			if(!empate) {
				
				if(jogadorVenceu) {
					jogador.ganhaAposta();
					System.out.println("Parabéns! Você venceu essa partida! \n");
				} else {
					jogador.perdeAposta();
					System.out.println("Que pena! Você perdeu a partida :( \n");
				}
				
			} else {
				System.out.println("Você e o dealer empataram. \n");
			}
			
			// Reiniciando baralho e resultados para nova partida
			cartasJogador.reiniciarBaralho(baralhoRodada);
			cartasDealer.reiniciarBaralho(baralhoRodada);
			jogadorVenceu = false;
			empate = false;
		}
		
		// Fim do jogo		
		if(jogador.getSaldo() == 0) {
			System.out.println("Seu saldo acabou! \n");
		}
		
		System.out.println("Fim de jogo.");
		scanner.close();
		
	}

}
