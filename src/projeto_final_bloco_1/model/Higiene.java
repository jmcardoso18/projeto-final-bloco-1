package projeto_final_bloco_1.model;

public class Higiene extends Produto {
	
	private String indicadoPara;

	public Higiene(int idProduto, int categoria, String nomeProduto, int quantidadeEstoque, float precoProduto, String indicadoPara) {
		super(idProduto, categoria, nomeProduto, quantidadeEstoque, precoProduto);
		this.indicadoPara=indicadoPara;
	}

	public String getIndicadoPara() {
		return indicadoPara;
	}

	public void setIndicadoPara(String indicadoPara) {
		this.indicadoPara = indicadoPara;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("Produto indicado para (Cães, Gatos ou Ambos): %s%n", this.indicadoPara);
	}
}
