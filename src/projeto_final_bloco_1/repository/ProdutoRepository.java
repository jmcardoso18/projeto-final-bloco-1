package projeto_final_bloco_1.repository;

import projeto_final_bloco_1.model.Produto;

public interface ProdutoRepository {
	
	// Métodos do CRUD
	
		public void listarTodas();
		public void cadastrarProduto(Produto produto);
		public void atualizarProduto(Produto produto);
		public void consultarProduto(int id);
		public void deletarProduto(int id);
}
