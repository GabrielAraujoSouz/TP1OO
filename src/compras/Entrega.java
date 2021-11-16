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
	private String cpfdoFuncionarioResponsável;
	private String datadeCriação[] = new String [3];
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
	public String getCpfdoFuncionarioResponsável() {
		return cpfdoFuncionarioResponsável;
	}
	public void setCpfdoFuncionarioResponsável(String cpfdoFuncionarioResponsável) {
		this.cpfdoFuncionarioResponsável = cpfdoFuncionarioResponsável;
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
	public String[] getDatadeCriação() {
		return datadeCriação;
	}
	public void setDatadeCriação(String[] datadeCriação) {
		this.datadeCriação = datadeCriação;
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
		String cep = null, enderecodeEntrega = null, formadePagamento = null, cpfdoFuncionarioResponsável = null;
		System.out.println("total a Pagar = "+ itensdaCesta.getSubTotal());
		while(cep == null || cep.isEmpty())
		cep = JOptionPane.showInputDialog("Digite o CEP do cliente: ");
		while(enderecodeEntrega == null || enderecodeEntrega.isEmpty())
		enderecodeEntrega = JOptionPane.showInputDialog("Digite o endereço de entrega: ");
		while(formadePagamento == null || formadePagamento.isEmpty())
		formadePagamento = JOptionPane.showInputDialog("Digite a forma de Pagamento ");
		while(cpfdoFuncionarioResponsável == null || formadePagamento.isEmpty())
		cpfdoFuncionarioResponsável = JOptionPane.showInputDialog("Digite o CPF do Funcionário a te atender: ");
		
		float totalaPagar = itensdaCesta.getSubTotal();
		
		String datadeCriacao[] = new String[3];
		datadeCriacao = itensdaCesta.getDatadeCriação();
		
		
		preencherEntregas.setCep(cep);
		preencherEntregas.setCpfdoCliente(itensdaCesta.getCpfdoCliente());
		preencherEntregas.setCpfdoFuncionarioResponsável(cpfdoFuncionarioResponsável);
		preencherEntregas.setEnderecodeEntrega(enderecodeEntrega);
		preencherEntregas.setFormadePagamento(formadePagamento);
		preencherEntregas.setTotalaPagar(totalaPagar);
		preencherEntregas.setDatadeCriação(datadeCriacao);
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
		datadeCriacao = entregas[contador].getDatadeCriação();
		Painel.pularLinha(10);
		System.out.println("SERIAL DE ENTREGA: "+entregas[contador].getNumeroEntregar());
		System.out.println("CEP DE ENTREGA: "+entregas[contador].getCep());
		System.out.println("CPF DO CLIENTE: "+entregas[contador].getCpfdoCliente());
		System.out.println("CPF DO FUNCIONÁRIO RESPONSÁVEL"+entregas[contador].getCpfdoFuncionarioResponsável());
		System.out.println("fORMA DE PAGAMENTO: "+entregas[contador].getFormadePagamento());
		System.out.println("ENDEREÇO DE ENTREGA: "+entregas[contador].getEnderecodeEntrega());
		System.out.println("ENDEREÇO DE ENTREGA: "+datadeCriacao[0]+"/"+datadeCriacao[1]+"/"+datadeCriacao[2]);
		System.out.println("TOTAL A PAGAR: "+entregas[contador].getTotalaPagar());
		System.out.println("STATUS DE ENTREGA: "+entregas[contador].getStatusdeEntrega());
	
	}
	
	

}
