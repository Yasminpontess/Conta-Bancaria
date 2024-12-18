package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("Criar Contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Yasmin Pontes", 12392.99f, 10000.0f);
		contas.cadastrar(cc1);

		ContaCorrente cp1 = new ContaCorrente(contas.gerarNumero(), 12567, 2, "Ygor Rodrigues", 183082.99f, 100887.0f);
		contas.cadastrar(cp1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 12345, 1, "Isabelly Pontes", 92.99f, 100.0f);
		contas.cadastrar(cc2);

		ContaCorrente cp2 = new ContaCorrente(contas.gerarNumero(), 12390, 2, "Cinara Pinheiro", 82.99f, 100000.0f);
		contas.cadastrar(cp2);

		while (true) {

			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_WHITE_BACKGROUND
					+ "|_____________________________________________________|");
			System.out.println("|                                                     |");
			System.out.println("|                BANCO DO NUBANC                      |");
			System.out.println("|                                                     |");
			System.out.println("|_____________________________________________________|");
			System.out.println("|                                                     |");
			System.out.println("|            1 - Criar Conta                          |");
			System.out.println("|            2 - Listar todas as Contas               |");
			System.out.println("|            3 - Buscar Conta por Numero              |");
			System.out.println("|            4 - Atualizar Dados da Conta             |");
			System.out.println("|            5 - Apagar Conta                         |");
			System.out.println("|            6 - Sacar                                |");
			System.out.println("|            7 - Depositar                            |");
			System.out.println("|            8 - Transferir valores entre Contas      |");
			System.out.println("|            9 - Sair                                 |");
			System.out.println("|                                                     |");
			System.out.println("|_____________________________________________________|");
			System.out.println("|Entre com a opção desejada:                          |");
			System.out.println("|                                                     |" + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\n Digite valores inteiros");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {

				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "\nBanco do Brazil com Z - O seu Futuro começa aqui!"
						+ Cores.ANSI_WHITE_BACKGROUND);
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Criar Conta\n\n");

				System.out.println("Digite o numero da Agencia: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome completo do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o tipo da conta (1 - CC ou 2 - CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Listar todas as Contas\n\n");
				contas.listarTodas();

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Consultar dados da Conta - por número\n\n");
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					tipo = buscaConta.getTipo();

					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();

					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = leia.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}

					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}
				} else {
					System.out.println("A Conta não foi encontrada!");
				}
				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Apagar a Conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Saque\n\n");

				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();

				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Depósito\n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do Depósito (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);
				
				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Transferência entre Contas\n\n");
				System.out.println("Digite o numero da conta de Origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o nuemro da conta de Destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o valor da Transferência (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);
				
				contas.transferir(numero,numeroDestino, valor);

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "\nOpção Inválida!\n" + Cores.TEXT_RESET);

				keyPress();
				break;
			}

		}
	}

	public static void sobre() {
		System.out.println("|_________________________________________________________|");
		System.out.println("|      Projeto Desenvolvido por: Yasmin da Silva Pontes   |");
		System.out.println("|      Generation Brasil - yasminpontes@generation.org    |");
		System.out.println("|      https://github.com/Yasminpontess                   |");
		System.out.println("|                                                         |");
		System.out.println("|_________________________________________________________|");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}
