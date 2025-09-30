package projeto_final_bloco_1.model;

public class Acessorios extends Produto{
	
	private String tamanho;

	public Acessorios(int idProduto, int categoria, String nomeProduto, int quantidadeEstoque, float precoProduto,String tamanho) {
		super(idProduto, categoria, nomeProduto, quantidadeEstoque, precoProduto);
		this.tamanho=tamanho;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("Tamanho do acessório: %s%n", this.tamanho);
	}

}
