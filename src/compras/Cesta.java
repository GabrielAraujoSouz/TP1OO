package compras;

public class Cesta {
	private String itemSelecionado[] = new String[200];
	private String cpfdoCliente;
	private String datadeCriação[] = new String [3];
	private float subTotal;
	/**
	 * Representa os itens que o cliente irá selecionar
	 * */
	
	public String[] getItemSelecionado() {
		return itemSelecionado;
	}
	public void setItemSelecionado(String[] itemSelecioando) {
		this.itemSelecionado = itemSelecioando;
	}
	public String getCpfdoCliente() {
		return cpfdoCliente;
	}
	public void setCpfdoCliente(String cpfdoCliente) {
		this.cpfdoCliente = cpfdoCliente;
	}
	
	public String[] getDatadeCriação() {
		return datadeCriação;
	}
	public void setDatadeCriação(String[] datadeCriação) {
		this.datadeCriação = datadeCriação;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	/**
	 * mostra os livros que o cliente selecionou
	 * */
	public void mostrarItens(Cesta itensdacesta, String[] livrosSelecionados) {
		int contador = 0;
		while(livrosSelecionados[contador] != null)
			contador++;
		for(int i = 0; i < contador; i++) {
		System.out.println("segundo print Livros na cesta: "+livrosSelecionados[i]);
		}
	}
	

}
