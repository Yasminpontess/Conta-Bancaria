package conta;

import java.util.Scanner;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		

		//Instanciamento/ Instancia da Classe ContaCorrente
		ContaCorrente contac1 = new ContaCorrente(1234567, 0002, 1, "Maria de lurdes", 600f, 7000f);
		contac1.visualizar();
		
		//Instanciamento/ Instancia da Classe ContaCorrente com limite fixo
		ContaCorrente contac2 = new ContaCorrente(022, 00022, 1, "Francisca", 10f);
		contac2.visualizar(); // faz visualizar todos os atributos já informados
		contac2.sacar(5f);
		contac2.visualizar(); // faz visualizar todos os atributos já informados + o valor depois de sacar
		contac2.depositar(100f);
		contac2.visualizar(); // faz visualizar todos os atributos já informados + o valor depois de depositar
		
		
		//Instanciamento / Intancia da Classe Conta Poupança + incluindo o metodo sacar, depositar e visualizar.
		ContaPoupanca contap1 = new ContaPoupanca(00342, 0023, 2, "Ana", 12000f, "03/09/2002");
		contap1.visualizar();
		contap1.sacar(5000f);
		contap1.visualizar();
		contap1.depositar(100000f);
		contap1.visualizar();

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
