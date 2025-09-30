package projeto_final_bloco_1;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_1.util.Cores;

public class Menu {
	// Instânciando a classe scanner como constante para leitura de entrada de dados
		// em todos os métodos
		private static final Scanner sc = new Scanner(System.in);

		// Utilizando constantes para o Menu e evitar os números mágicos quando usar o
		// switch case

		private static final int CADASTRAR_PRODUTOS = 1;
		private static final int LISTAR_TODOS_PRODUTOS = 2;
		private static final int CONSULTAR_PRODUTOS = 3;
		private static final int ATUALIZAR_PRODUTOS = 4;
		private static final int DELETAR_PRODUTOS= 5;
		private static final int SAIR = 0;

		public static void main(String[] args) {
			// Declarando a variável
			int opcao = 1;// Opcão inicia com 1 porque escolhi a variável 0 para sair do menu

			while (opcao != 0) {
				exibirMenu();

				// validando e recebendo a opção para entrar no menu
				boolean loop = true;// Utilizando um "lopping" para só sair quando tiver um dado válido
				do {

					try {
						opcao = sc.nextInt();
						sc.nextLine();
						loop = false;
					} catch (InputMismatchException e) {
						opcao = -1;
						System.err.println(Cores.TEXT_RESET + "Opção inválida! Digite um número inteiro:");
						sc.nextLine();
					}
				} while (loop);

				// Iniciando o switch case para percorrer as opções do menu
				switch (opcao) {
				case CADASTRAR_PRODUTOS:
					System.out.println("Cadastrar produto");
					keyPress();
					break;
				
				case LISTAR_TODOS_PRODUTOS:
					System.out.println("Listar todos os produtos");
					keyPress();
					break;

				case CONSULTAR_PRODUTOS:
					
					System.out.println("Consultar produto por Id");
					keyPress();
					break;

				case ATUALIZAR_PRODUTOS:
					
					System.out.println("Atualizar produto");
					keyPress();
					break;
					
				case DELETAR_PRODUTOS:
					
					System.out.println("Deletar produto");
					keyPress();
					break;

				case SAIR:
					sobre();
					break;

				default:
					System.err.println("Opção inválida. Tente novamente.");
					keyPress();
					break;
				}
			}
			
			sc.close();
		}

		private static void exibirMenu() {// Método para exibir menu e não sobrecarregar o método main
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND_BRIGHT);// Iniciando menu colorido,utilizando cores.util
			System.out.println("************************************************************************");
			System.out.println("                                                                        ");
			System.out.println("                         AU AU ACESSÓRIOS                               ");
			System.out.println("                                                                        ");
			System.out.println("************************************************************************");
			System.out.println("                                                                        ");
			System.out.println("                      1- Cadastrar Produtos                             ");
			System.out.println("                      2- Listar todos os produtos                       ");
			System.out.println("                      3- Consultar por Id                               ");
			System.out.println("                      4- Atualizar produto                              ");
			System.out.println("                      5- Deletar Produto                                ");
			System.out.println("                      0- Sair                                           ");
			System.out.println("                                                                        ");
			System.out.println("************************************************************************");
			System.out.println("                                                                        ");
			System.out.println(Cores.TEXT_RESET+ "Entre com a opção desejada: ");// Finalizar menu colorido e pedindo para entrar coma opção
		}																												

		private static void sobre() {// Método para exibir mensagem de despedida e dados da desenvolvedora
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND_BRIGHT);// Iniciando menu colorido
			System.out.println(" AU AU ACESSÓRIOS AGRADECE PELA PREFERÊNCIA,VOLTE SEMPRE!!              ");
			System.out.println("                                                                        ");
			System.out.println("************************************************************************");
			System.out.println("                                                                        ");
			System.out.println("************************************************************************");
			System.out.println("Projeto desenvolvido por:                                               ");
			System.out.println("Jamila Moraes Cardoso - jmc18.ads@gmail.com                             ");
			System.out.println("GITHUB:github.com/jmcardoso18                                           ");
			System.out.println("LINKEDIN:https://www.linkedin.com/in/jamila-m-c/                        ");
			System.out.println("************************************************************************" + Cores.TEXT_RESET);
		}
		
		public static void keyPress() {//Método auxiliar para ir para próxima etapa só se apertar enter
			System.out.println(Cores.TEXT_RESET + "\nPressiona Enter para continuar...");
			sc.nextLine();
			}

}
