package Pessoa;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Utilidades.Painel;
import compras.Cesta;
import compras.Entrega;
import compras.Livro;
/**
 * Classe Cliente
 * */
public class Cliente extends Usuario {
	private int quantidadedePedidos;
	
	/**
	 * contem funções e atributos de Cliente e herda atributos de usuario
	 * */
	
	public int getQuantidadedePedidos() {
		return quantidadedePedidos;
	}
	public void setQuantidadedePedidos(int quantidadedePedidos) {
		this.quantidadedePedidos = quantidadedePedidos;
	}
	/**
	 * adiciona itens a cesta do cliente
	 * */
	public void atualizarCesta(Livro[] livroscatalogo, Cesta cestadoCliente) {
		
		Livro catalogo[] = new Livro[200];
		catalogo = livroscatalogo;
		
		String livrosSelecionados[] = new String[200];
		int resposta = 0;
		int contador = 0;
		float subtotal = 0;
		int quantidadeselecionada = 0;
		while(resposta == 0){
			int i = 0;
			String nomedoautordolivro = JOptionPane.showInputDialog("Digite o Nome OU IBNS do Livro para adicionar a sua cesta: ");
			while(catalogo[contador]!= null)
				contador++;
			for(i = 0; i < contador; i++) {
				if(nomedoautordolivro.equals(catalogo[i].getTitulo())){
				quantidadeselecionada = Painel.validaQuantidade(livroscatalogo, quantidadeselecionada, i);
			}
			
			
			int w = 0;
			i = 0;
			
			while(livrosSelecionados[w] != null)
				w++;
			contador = 0;
			while(catalogo[contador] != null)
				contador++;

			for(i = 0; i < contador; i++) {
				if(nomedoautordolivro.equals(catalogo[i].getTitulo())){
					livrosSelecionados[w] = nomedoautordolivro;
					System.out.println("Livro Encontrado");
					break;
				}
			System.out.println("Livro não encontrado");
			}
			float preçodoLivro = catalogo[i].getPreco();
			subtotal = subtotal + (preçodoLivro * quantidadeselecionada);
			System.out.println("subtotal = "+ subtotal);
			cestadoCliente.setSubTotal(subtotal);
		resposta = JOptionPane.showConfirmDialog(null, "deseja adicionar mais algum livro ?");
		if(resposta == 0) {
			cestadoCliente.setItemSelecionado(livrosSelecionados);
		}
		}
		}
	}
		/**
		 * Mostra compras ja executadas pelo cliente, podem estar pendentes ou nao
		 * */
		public void mostrarCompras(Entrega[] entregas, Cliente[] clientes, String emailCliente) {
			Cliente clienteLogado[] = new Cliente[200];
			Entrega olharEntregas[] = new Entrega[100];
			int contador = 0;
			
			olharEntregas = entregas;
			clienteLogado = clientes;
			String cpfdoCliente = null;
			while(clienteLogado[contador] != null)
				contador++;
			
			for(int i = 0; i < contador ; i++) {
				if(emailCliente.equals(clienteLogado[i].getEmail())){
					cpfdoCliente = clienteLogado[i].getCpf();
					break;
				}
			}
			contador = 0;
			while(olharEntregas[contador] != null)
				contador++;
			for(int i = 0; i < contador ; i++) {
				if(cpfdoCliente.equals(olharEntregas[i].getCpfdoCliente())){
					String datadeCriacao[] = new String[3];
					datadeCriacao = olharEntregas[i].getDatadeCriação();
					System.out.println("SERIAL DE ENTREGA: "+olharEntregas[i].getNumeroEntregar());
					System.out.println("CEP DE ENTREGA: "+olharEntregas[i].getCep());
					System.out.println("CPF DO CLIENTE: "+olharEntregas[i].getCpfdoCliente());
					System.out.println("CPF DO FUNCIONÁRIO RESPONSÁVEL: "+olharEntregas[i].getCpfdoFuncionarioResponsável());
					System.out.println("fORMA DE PAGAMENTO: "+olharEntregas[i].getFormadePagamento());
					System.out.println("ENDEREÇO DE ENTREGA: "+olharEntregas[i].getEnderecodeEntrega());
					System.out.println("DATA DE EMISSAO: "+datadeCriacao[0]+"/"+datadeCriacao[1]+"/"+datadeCriacao[2]);
					System.out.println("TOTAL A PAGAR: "+olharEntregas[i].getTotalaPagar());
					System.out.println("STATUS DE ENTREGA: "+olharEntregas[i].getStatusdeEntrega());
				}
			}
		}
	
}
