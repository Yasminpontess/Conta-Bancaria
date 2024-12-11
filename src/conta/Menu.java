package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		// Instanciamento | Classe -> Objeto Utilizavel
		Conta conta1 = new Conta(123456, 0001, 1, "Maria das Neves", 500f);
		conta1.visualizar();
		conta1.sacar(12000.0f);
		conta1.visualizar();
		conta1.depositar(5000.0f);
		conta1.visualizar();

		// System.out.println("Saldo da conta é " + conta1.getSaldo());

		Scanner leia = new Scanner(System.in);
		

		int opcao;

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

			opcao = leia.nextInt();

			if (opcao == 9) {

				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "\nBanco do Brazil com Z - O seu Futuro começa aqui!" + Cores.ANSI_WHITE_BACKGROUND );
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
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

}
