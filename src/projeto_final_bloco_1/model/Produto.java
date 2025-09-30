package projeto_final_bloco_1.model;

public abstract class Produto {
	
	//Atributos da Classe Produto
	private int idProduto;
	private int categoria;
	private String nomeProduto;
	private int quantidadeEstoque;
	private float precoProduto;
	
	
	//Método construtor
	public Produto(int idProduto, int categoria, String nomeProduto, int quantidadeEstoque,float precoProduto) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
		this.precoProduto = precoProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public float getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(float precoProduto) {
		this.precoProduto = precoProduto;
	}
	
public void visualizar() {
		
		String categoria = " ";
		
		switch(this.categoria) {
			case 1 -> categoria = "Acessorio";
			case 2 -> categoria = "Higiene";
			default -> categoria = "Inválido";
		}
		
		System.out.println("\n********************************************");
		System.out.println("Dados do Produto");
		System.out.println("********************************************");
		System.out.printf("Id do produto: %d%n", this.idProduto);
		System.out.printf("Nome do produto: %s%n", this.nomeProduto);
		System.out.printf("Categoria do produto: %s%n", categoria);
		System.out.printf("Quantidade do estoque: %d%n", this.quantidadeEstoque);
		System.out.printf("Preço do produto: %.2f%n", this.precoProduto);
	}



}
