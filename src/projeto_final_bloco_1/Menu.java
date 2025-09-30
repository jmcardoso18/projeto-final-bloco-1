package projeto_final_bloco_1;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_1.controller.ProdutoController;
import projeto_final_bloco_1.model.Acessorios;
import projeto_final_bloco_1.model.Higiene;
import projeto_final_bloco_1.model.Produto;
import projeto_final_bloco_1.util.Cores;

public class Menu {
	// Instânciando a classe scanner como constante para leitura de entrada de dados
		// em todos os métodos
		private static final Scanner sc = new Scanner(System.in);

		// Objeto controlador de produtos (responsável por cadastrar, listar, atualizar etc.)
		private static final ProdutoController produtoController = new ProdutoController();
		
		// Utilizando constantes para o Menu e evitar os números mágicos quando usar o
		// switch case

		private static final int CADASTRAR_PRODUTOS = 1;
		private static final int LISTAR_TODOS_PRODUTOS = 2;
		private static final int CONSULTAR_PRODUTOS = 3;
		private static final int ATUALIZAR_PRODUTOS = 4;
		private static final int DELETAR_PRODUTOS= 5;
		private static final int SAIR = 0;
		
		
		public static void main(String[] args) {
			
			//Chamando metodo criado para gerar dados de teste 
			criarContasTeste();
		
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
					cadastrarProduto();
					keyPress();
					break;
				
				case LISTAR_TODOS_PRODUTOS:
					System.out.println("Listar todos os produtos");
					listarTodosProdutos();
					keyPress();
					break;

				case CONSULTAR_PRODUTOS:
					System.out.println("Consultar produto por Id");
					consultarPorId();
					keyPress();
					break;

				case ATUALIZAR_PRODUTOS:
					
					System.out.println("Atualizar produto");
					atualizarProduto();
					
					keyPress();
					break;
					
				case DELETAR_PRODUTOS:
					
					System.out.println("Deletar produto");
					deletarProduto();
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

			System.out.println("************************************************************************");
			System.out.println("                                                                        ");			
			System.out.println(" AU AU ACESSÓRIOS AGRADECE PELA PREFERÊNCIA,VOLTE SEMPRE!!              ");
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
		private static void criarContasTeste() {

			produtoController.cadastrarProduto(new Acessorios(produtoController.gerarId(),1,"Coleira",10,10.2f,"Número 9"));
			produtoController.cadastrarProduto(new Higiene(produtoController.gerarId(),2,"Creme dental",12,20.3f,"Cães"));
		}
		
		// Método responsável por listar todas os produtos
		private static void listarTodosProdutos() {
			produtoController.listarTodas();
		}
		
		// Método responsável por criar uma nova produto com os dados digitados pelo usuário
		private static void cadastrarProduto() {
			

			System.out.print("Digite a categoria do produto (1 - Acessório|2 - Higiene): ");
			int categoria = sc.nextInt();
			
			System.out.print("Digite o nome do produto: ");
			sc.skip("\\R");
			String nomeProduto=sc.nextLine();
									
			System.out.print("Quantidade de estoque deste produto: ");
			int estoque = sc.nextInt();
			
			System.out.print("Digite o preço do produto: ");
			float preco = sc.nextFloat();
			
			switch(categoria) {
			case 1 ->{
				System.out.print("Digite o tamanho do acessório: ");
				sc.skip("\\R");
				String tamanho=sc.nextLine();
				produtoController.cadastrarProduto(new Acessorios(produtoController.gerarId(), categoria,nomeProduto,estoque, preco, tamanho));
			}
			case 2 -> {
				System.out.print("Este produto é indicado para qual tipo de animal (Cães,gatos ou ambos):");
				sc.skip("\\R");
				String indicadoPara=sc.nextLine();
				produtoController.cadastrarProduto(new Higiene(produtoController.gerarId(), categoria,nomeProduto,estoque, preco, indicadoPara));
			}
			default -> System.err.println( "Categoria de produto inválido!");
			}
		}
		
		// Método responsável por procurar uma produto já cadastrada pelo número
		private static void consultarPorId() {
			
			System.out.print("Digite o número da produto: ");
			int id = sc.nextInt();
			sc.nextLine();
			
			produtoController.consultarProduto(id);
		}
		
		// Método responsável por excluir uma produto existente pelo id
		private static void deletarProduto() {
			
			System.out.print("Digite o número da produto: ");
			int id = sc.nextInt();
			sc.nextLine();
			
			// Busca a produto pelo número
			Produto produto = produtoController.buscarNaCollection(id);

			// Verifica se a produto existe
			if(produto != null) {
			
				// Confirmação da exclusão
				System.out.print("\nTem certeza que deseja excluir esta produto? (S/N): ");
				String confirmacao = sc.nextLine();
				
				
				if(confirmacao.equalsIgnoreCase("S")) {
					produtoController.deletarProduto(id);
				}else {
					System.out.println("\nOperação cancelada!");
				}
				
			}else {
				System.out.printf("\nA produto número %d não foi encontrada!", id);
			}
		}
		
		// Método responsável por atualizar os dados de uma produto existentepelo id
		private static void atualizarProduto() {
			
			System.out.print("Digite o id do produto: ");
			int idProduto = sc.nextInt();

			
			// Busca a produto pelo número
			Produto produto = produtoController.buscarNaCollection(idProduto);
			
			// Se a produto existir
			if(produto != null) {

				
				// Obtém os dados atuais
				
				int id = produto.getIdProduto();
				int categoria = produto.getCategoria();
				String nome = produto.getNomeProduto();
				int quantidadeEstoque= produto.getQuantidadeEstoque();
				float preco= produto.getPrecoProduto();
				
				/**
				 * Se o usuário não digitou nada (entrada vazia), mantém o valor atual de 'agencia'.
				 * Caso contrário, converte o valor digitado (String) para número inteiro e 
				 * atribui à variável 'agencia'.				 * 
				 * Operador Ternário: condição ? ação caso seja verdadeira : ação caso seja falsa
				 * Isso vale para todas as entradas*/
				
				// Atualiza nome (ou mantém valor atual se apertar Enter)
				System.out.printf("Nome atual: %s\nDigite o novo nome do produto: (Pressione ENTER para manter o valor atual): ", nome);
				sc.nextLine();//outra maneira deLimpar buffer
				String entrada = sc.nextLine();
				nome = entrada.isEmpty() ? nome : entrada;
				
				
				// Atualiza quantidade no estoque (ou mantém valor atual se apertar Enter)
				System.out.printf("A quantidade atual do estoque é: %d\nDigite a nova quantidade (Pressione ENTER para manter o valor atual): ", quantidadeEstoque);
				entrada = sc.nextLine();
				quantidadeEstoque = entrada.isEmpty() ? quantidadeEstoque : Integer.parseInt(entrada);
							
				// Atualiza preço do produto (ou mantém valor atual se apertar Enter)
				System.out.printf("Preço atual: %.2f\nDigite o novo preço do produto (Pressione ENTER para manter o valor atual): ", preco);
				entrada = sc.nextLine();
				preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));
				/**
				 * Se o usuário não digitou nada (entrada vazia), mantém o valor atual de 'agencia'.
				 * Caso contrário, converte o valor digitado (String) para número Real (float),
				 * substitui a , pelo . (método replace) e atribui à variável 'saldo'.
				 * */
				
				
				// Se a produto for do categoria Conta Corrente
				switch(categoria) {
				case 1 ->{
					
					/**
					 * Como o objeto 'produto' é do categoria genérico Produto, precisamos convertê-la (casting) 
					 * para Acessorios.
					 * Isso é necessário porque apenas a classe Acessorios possui o atributo 'tamanho'.
					 * Após o casting, conseguimos acessar o método getTamanho() para obter o tamanho da produto.
					 * */
					String tamanho = ((Acessorios) produto).getTamanho();
					
					// Atualiza o limite da produto (ou mantém valor atual se apertar Enter)
					System.out.printf("Tamanho atual é: %s\nDigite o novo tamanho (Pressione ENTER para manter o valor atual): ", tamanho);
					entrada = sc.nextLine();
					tamanho = entrada.isEmpty() ? tamanho : entrada;
					
					/**
					 * Na atualização não utilizamos o método gerarNumero() no atributo 'id'.
					 * Isso porque o número da produto já existe e identifica unicamente essa produto.
					 * 
					 * Se chamarmos 'gerarNumero()', um novo número seria criado e substituiria o antigo,
					 * o que impediria a atualização dos dados.
					 */
					produtoController.atualizarProduto(
							new Acessorios(id, categoria,nome,quantidadeEstoque, preco, tamanho)
					);

				}
				// Se a produto for da categoria Higiene
				case 2 -> {
					
					/**
					 * Como o objeto 'produto' é do categoria genérico Produto, precisamos convertê-la (casting) 
					 * para Higiene.
					 * Isso é necessário porque apenas a classe Higiene possui o atributo 'indicadoPara:'.
					 * Após o casting, conseguimos acessar o método getIndicadoPara() para obter qual o animal indicado para esse produto
					 * */
					String indicadoPara = ((Higiene)produto).getIndicadoPara();
					
					// Atualiza o dia do aniversário (ou mantém valor atual se apertar Enter)
					System.out.printf("Indicação atual é :%s\nEste produto é indicado para qual tipo de animal (Cães,gatos ou ambos):",indicadoPara);
					entrada = sc.nextLine();
					indicadoPara = entrada.isEmpty() ? indicadoPara : entrada;
					produtoController.atualizarProduto(
							new Higiene(id, categoria,nome,quantidadeEstoque, preco, indicadoPara));
				}
				// Se o categoria da produto for inválido
				default -> System.out.println(Cores.TEXT_RED + "Tipo de produto inválido!" + Cores.TEXT_RESET);
				}
				
			}else {
				// Caso a produto não exista
				System.out.printf("\nO produto com id %d não foi encontrada!", idProduto);
			}
		}

}
