package projeto_final_bloco_1.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_final_bloco_1.model.Produto;
import projeto_final_bloco_1.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private List<Produto> listaProduto = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void listarTodas() {
		// Método para  visualizar todos os registros da classe produto
		for (var produto : listaProduto) {
			produto.visualizar();
		}

	}

	@Override
	public void cadastrarProduto(Produto produto) {
		// Método para cadastrar um novo array na lista
		listaProduto.add(produto);
		System.out.println("\n🎉 Produto Cadastrado com sucesso!");
	}

	@Override
	public void atualizarProduto(Produto produto) {
		// Método para atualizar um produto já existente
		var buscarConta = buscarNaCollection(produto.getIdProduto());

		if (buscarConta != null) {
			listaProduto.set(listaProduto.indexOf(buscarConta), produto);
			System.out.printf("\nA Produto com id: %d foi atualizada com sucesso!%n", produto.getIdProduto());
		} else {
			System.out.printf("\nA Produto com id: %d não foi encontrada!%n", produto.getIdProduto());
		}
	}

	@Override
	public void consultarProduto(int id) {
		// Método para para consultar um produto específico

		var produto = buscarNaCollection(id);

		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.printf("\nProduto com id %d não foi encontrada!%n", id);
		}

	}

	@Override
	public void deletarProduto(int id) {
		//Método para deletar um produto a partir de seu Id
		var produto = buscarNaCollection(id);

		if (produto != null) {
			if (listaProduto.remove(produto) == true) {
				System.out.printf("\nProduto com id %d foi deletada com sucesso!%n", id);
			}
		} else {
			System.out.printf("\nProduto com id %d não foi encontrada!%n", id);
		}

	}

	// Métodos Auxiliares

	// Método para gerar um novo id evitando do usuario querer atribuir um id já
	// existente
	public int gerarId() {
		return ++id;
	}

	// Método para verificar se o Id já existe e buscar seus dados
	public Produto buscarNaCollection(int id) {
		for (var produto : listaProduto) {
			if (produto.getIdProduto() == id) {
				return produto;
			}
		}

		return null;
	}

}
