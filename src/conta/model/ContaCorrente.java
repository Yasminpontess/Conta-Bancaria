package conta.model;

public class ContaCorrente extends Conta { // extends => herança//herda
	// Atributos caracteristicas que toda conta tem
	// Variaveis

	private float limite;

	// Métodos Especiais - Método Construtos
	// this => Classe Conta
	// Conta.numero = atributo
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;

	}
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = 100.00f;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	@Override
	public boolean sacar(float valor) { 
		
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
		
	}
	
    @Override
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de Credito: " + this.limite);
	}
	
}
