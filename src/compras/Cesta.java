package compras;

public class Cesta {
	private String itemSelecionado[] = new String[200];
	private String cpfdoCliente;
	private String datadeCria��o[] = new String [3];
	private float subTotal;
	/**
	 * Representa os itens que o cliente ir� selecionar
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
	
	public String[] getDatadeCria��o() {
		return datadeCria��o;
	}
	public void setDatadeCria��o(String[] datadeCria��o) {
		this.datadeCria��o = datadeCria��o;
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
