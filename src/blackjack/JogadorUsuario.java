package blackjack;

public class JogadorUsuario extends Jogador {
	
	private double saldo;
	private double aposta;
	private double proposta;
	

	public void ganhaAposta() {
		this.saldo += this.aposta;
	}
	
	public void perdeAposta() {
		this.saldo -= this.aposta;
	}	
	
	//GETTERS E SETTERS
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getAposta() {
		return aposta;
	}
	
	public void setAposta(double aposta) {
		this.aposta = aposta;
	}
	
	public double getProposta() {
		return proposta;
	}

	public void setProposta(double proposta) {
		this.proposta = proposta;
	}

}
