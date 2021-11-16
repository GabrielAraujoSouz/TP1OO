package Utilidades;

import javax.swing.JOptionPane;

import Pessoa.Cliente;
import Pessoa.Funcionario;
import compras.Entrega;
import compras.Livro;
/**
 * Classe Relatorio
 * */
public class Relatorio {
	Entrega usarDadosEntrega = new Entrega();
	/**
	 * imprime livros ja cadastrados na livraria
	 * */
	
public void livrosemEstoque(Livro[] usarDadosLivro) {
	Painel.pularLinha(1);
	int contador = 0;
    while(usarDadosLivro[contador] != null)
		contador++;
	System.out.println("Quantidade de Livros em estoque = "+contador);
	for(int i = 0; i < contador; i++) {
		System.out.println("Autor do livro: "+usarDadosLivro[i].getAutor());
		System.out.println("Título do livro: "+usarDadosLivro[i].getTitulo());
		System.out.println("quantidade de livros: "+usarDadosLivro[i].getQuantidade());
		Painel.pularLinha(2);
	}
	}
/**
 * imprime clientes ja cadastrados na livraria
 * */
public void clientesCadastradosnaLivraria(Cliente[] clienteCadastrado) {
	//contador de não nulos
	Painel.pularLinha(2);
	int contador = 0;
	while (clienteCadastrado[contador] != null)
		contador++;
	System.out.println("Quantidade de Clientes cadastrados na livraria = "+contador);
	Painel.pularLinha(1);
	for(int i = 0; i < contador; i++) {
		System.out.println("nome: " + clienteCadastrado[i].getNome());
		System.out.println("CPF: "+clienteCadastrado[i].getCpf());
		System.out.println("Email: "+clienteCadastrado[i].getEmail());
		Painel.pularLinha(1);
		}
	
}
/**
 * imprime pagamentos ja efetuados
 * */
public void pagamentosEfetuados(Entrega[] entregas) {
	Entrega olharEntregas[] = new Entrega[100];
	int contador = 0;
	
	olharEntregas = entregas;
	while(olharEntregas[contador] != null)
		contador++;
	for(int i = 0; i < contador ; i++) {
		if(olharEntregas[i].getStatusdeEntrega().equals("ENTREGUE")){
			String datadeCriacao[] = new String[3];
			datadeCriacao = olharEntregas[i].getDatadeCriação();
			Painel.pularLinha(2);
			System.out.println("SERIAL DE ENTREGA: "+olharEntregas[i].getNumeroEntregar());
			System.out.println("CEP DE ENTREGA: "+olharEntregas[i].getCep());
			System.out.println("CPF DO CLIENTE: "+olharEntregas[i].getCpfdoCliente());
			System.out.println("CPF DO FUNCIONÁRIO RESPONSÁVEL: "+olharEntregas[i].getCpfdoFuncionarioResponsável());
			System.out.println("fORMA DE PAGAMENTO: "+olharEntregas[i].getFormadePagamento());
			System.out.println("ENDEREÇO DE ENTREGA: "+olharEntregas[i].getEnderecodeEntrega());
			System.out.println("DATA DE EMISSÃO: "+datadeCriacao[0]+"/"+datadeCriacao[1]+"/"+datadeCriacao[2]);
			System.out.println("TOTAL A PAGAR: "+olharEntregas[i].getTotalaPagar());
			System.out.println("STATUS DE ENTREGA: "+olharEntregas[i].getStatusdeEntrega());
				
		}
	}
	
	
}


}
	