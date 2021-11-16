package compras;

import javax.swing.JOptionPane;

import Utilidades.Painel;
/**
 * Classe entrega
 * */
public class Entrega {
	/**
	 * Contem os itens que o cliente ira selecionar para comprar
	 * */
	private int numeroEntrega;
	private String cep;
	private String enderecodeEntrega;
	private String formadePagamento;
	private String itemSelecionado[] = new String[200];
	private String cpfdoCliente;
	private String cpfdoFuncionarioRespons�vel;
	private String datadeCria��o[] = new String [3];
	private float totalaPagar;
	private String StatusdeEntrega;
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEnderecodeEntrega() {
		return enderecodeEntrega;
	}
	public void setEnderecodeEntrega(String enderecodeEntrega) {
		this.enderecodeEntrega = enderecodeEntrega;
	}
	public String getFormadePagamento() {
		return formadePagamento;
	}
	public void setFormadePagamento(String formadePagamento) {
		this.formadePagamento = formadePagamento;
	}
	public String getCpfdoFuncionarioRespons�vel() {
		return cpfdoFuncionarioRespons�vel;
	}
	public void setCpfdoFuncionarioRespons�vel(String cpfdoFuncionarioRespons�vel) {
		this.cpfdoFuncionarioRespons�vel = cpfdoFuncionarioRespons�vel;
	}
	public String getCpfdoCliente() {
		return cpfdoCliente;
	}
	public void setCpfdoCliente(String cpfdoCliente) {
		this.cpfdoCliente = cpfdoCliente;
	}
	public float getTotalaPagar() {
		return totalaPagar;
	}
	public void setTotalaPagar(float totalaPagar) {
		this.totalaPagar = totalaPagar;
	}
	public float getNumeroEntregar() {
		return numeroEntrega;
	}
	public void setnumeroEntrega(int numeroEntrega) {
		this.numeroEntrega = numeroEntrega;
	}
	public String[] getDatadeCria��o() {
		return datadeCria��o;
	}
	public void setDatadeCria��o(String[] datadeCria��o) {
		this.datadeCria��o = datadeCria��o;
	}
	public String getStatusdeEntrega() {
		return StatusdeEntrega;
	}
	public void setStatusdeEntrega(String statusdeEntrega) {
		StatusdeEntrega = statusdeEntrega;
	}
	public String[] getItemSelecionado() {
		return itemSelecionado;
	}
	public void setItemSelecionado(String itemSelecionado[]) {
		this.itemSelecionado = itemSelecionado;
	}
	
	/**
	 * Preenche os atributos de Entrega
	 * */
	public void finalizarCompra(Cesta itensdaCesta, Entrega[] entregaFinal) {
		Entrega preencherEntregas = new Entrega();
		String cep = null, enderecodeEntrega = null, formadePagamento = null, cpfdoFuncionarioRespons�vel = null;
		System.out.println("total a Pagar = "+ itensdaCesta.getSubTotal());
		while(cep == null || cep.isEmpty())
		cep = JOptionPane.showInputDialog("Digite o CEP do cliente: ");
		while(enderecodeEntrega == null || enderecodeEntrega.isEmpty())
		enderecodeEntrega = JOptionPane.showInputDialog("Digite o endere�o de entrega: ");
		while(formadePagamento == null || formadePagamento.isEmpty())
		formadePagamento = JOptionPane.showInputDialog("Digite a forma de Pagamento ");
		while(cpfdoFuncionarioRespons�vel == null || formadePagamento.isEmpty())
		cpfdoFuncionarioRespons�vel = JOptionPane.showInputDialog("Digite o CPF do Funcion�rio a te atender: ");
		
		float totalaPagar = itensdaCesta.getSubTotal();
		
		String datadeCriacao[] = new String[3];
		datadeCriacao = itensdaCesta.getDatadeCria��o();
		
		
		preencherEntregas.setCep(cep);
		preencherEntregas.setCpfdoCliente(itensdaCesta.getCpfdoCliente());
		preencherEntregas.setCpfdoFuncionarioRespons�vel(cpfdoFuncionarioRespons�vel);
		preencherEntregas.setEnderecodeEntrega(enderecodeEntrega);
		preencherEntregas.setFormadePagamento(formadePagamento);
		preencherEntregas.setTotalaPagar(totalaPagar);
		preencherEntregas.setDatadeCria��o(datadeCriacao);
		preencherEntregas.setStatusdeEntrega("esperando confirmacao do funcionario");
		preencherEntregas.setItemSelecionado(itensdaCesta.getItemSelecionado());
		
		int contador = 0;
		while(entregaFinal[contador] != null)
			contador++;
		entregaFinal[contador] = preencherEntregas;
		
		preencherEntregas.setnumeroEntrega(contador);
		recibodeEntrega(entregaFinal, itensdaCesta, contador);
	}
	/**
	 * 
	 * Mostra ao cliente os dados finais preenchidos apos a finalizacao do pedido e pagamento
	 * 
	 * */
	private void recibodeEntrega(Entrega[] entregas, Cesta itensdaCesta, int contador) {
		String datadeCriacao[] = new String[3];
		datadeCriacao = entregas[contador].getDatadeCria��o();
		Painel.pularLinha(10);
		System.out.println("SERIAL DE ENTREGA: "+entregas[contador].getNumeroEntregar());
		System.out.println("CEP DE ENTREGA: "+entregas[contador].getCep());
		System.out.println("CPF DO CLIENTE: "+entregas[contador].getCpfdoCliente());
		System.out.println("CPF DO FUNCION�RIO RESPONS�VEL"+entregas[contador].getCpfdoFuncionarioRespons�vel());
		System.out.println("fORMA DE PAGAMENTO: "+entregas[contador].getFormadePagamento());
		System.out.println("ENDERE�O DE ENTREGA: "+entregas[contador].getEnderecodeEntrega());
		System.out.println("ENDERE�O DE ENTREGA: "+datadeCriacao[0]+"/"+datadeCriacao[1]+"/"+datadeCriacao[2]);
		System.out.println("TOTAL A PAGAR: "+entregas[contador].getTotalaPagar());
		System.out.println("STATUS DE ENTREGA: "+entregas[contador].getStatusdeEntrega());
	
	}
	
	

}
