package conta.model;

public class ContaPoupanca extends Conta {

	private String aniversario;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, String aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
	}

	public String getAniversario() {
		return aniversario;
	}

	public void setAniversario(String aniversario) {
		this.aniversario = aniversario;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversario da conta: " + this.aniversario);
	}

}
