package Pessoa;

import javax.swing.JOptionPane;

import Utilidades.Painel;
import Utilidades.Relatorio;
import compras.Entrega;
import compras.Livro;
/**
 * Classe Funcionario
 * */
public class Funcionario extends Usuario{
	/**
	 * contem atributos de funcionario e herda atributos de usuario
	 * */
	private String cargo;
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 * preenche os dados do objeto livro
	 * */
	public Livro[] cadastrarLivro(Livro[] livro) {
		//simulação de cadastro
			Livro cadastroLivro = new Livro();
			String ISBNdolivro = new String();
			String genero = new String();
			String nomedoautordolivro = new String();
			String titulodolivro = new String();
			String editoradolivro = new String();
			int preco;
			int quantidadedelivros;
			int descontodolivro;
			int contador = 0;

				ISBNdolivro = JOptionPane.showInputDialog("Digite o ISBN do livro: ");
				while (ISBNdolivro.isEmpty() == true)
					ISBNdolivro = JOptionPane.showInputDialog("Digite o ISBN do livro: ");
				
				nomedoautordolivro = JOptionPane.showInputDialog("Digite o Nome do autor do livro: ");
				while (nomedoautordolivro.isEmpty() == true)
					nomedoautordolivro = JOptionPane.showInputDialog("Digite o Nome do autor do livro: ");
				
				titulodolivro = JOptionPane.showInputDialog("Digite o título do livro: ");
				while (titulodolivro.isEmpty() == true)
					titulodolivro = JOptionPane.showInputDialog("Digite o título do livro: ");
				
				editoradolivro = JOptionPane.showInputDialog("Digite a editora do livro: ");
				while (editoradolivro.isEmpty() == true)
					editoradolivro = JOptionPane.showInputDialog("Digite a editora do livro: ");
				
				
				genero = JOptionPane.showInputDialog("Digite a generodo livro: ");
				while (genero.isEmpty() == true)
					genero = JOptionPane.showInputDialog("Digite a genero do livro: ");
				
				quantidadedelivros = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de livros: "));
				descontodolivro = Integer.parseInt(JOptionPane.showInputDialog("Digite o desconto do livro: "));
				preco = Integer.parseInt(JOptionPane.showInputDialog("Digite o preço do livro: "));
				cadastroLivro.setISBN(ISBNdolivro);
				cadastroLivro.setAutor(nomedoautordolivro);
				cadastroLivro.setTitulo(titulodolivro);
				cadastroLivro.setEditora(editoradolivro);
				cadastroLivro.setQuantidade(quantidadedelivros);
				cadastroLivro.setDesconto(descontodolivro);
				cadastroLivro.setGenero(genero);
				cadastroLivro.setPreco(preco);
				System.out.println(cadastroLivro.getAutor());
				System.out.println(cadastroLivro.getEditora());
				while(livro[contador] != null)
					contador++;
				livro[contador] = cadastroLivro;
				return livro;
		}
	/**
	 * Mostra os dados referente aos preenchimentos dos objetos
	 * */
	public void imprimirRelatorio(Cliente[] clienteCadastrado, Livro[] livro, Entrega[] entregas) {
		Relatorio usarRelatorio = new Relatorio();
		usarRelatorio.livrosemEstoque(livro);
		usarRelatorio.clientesCadastradosnaLivraria(clienteCadastrado);
		usarRelatorio.pagamentosEfetuados(entregas);
	}
	
	/**
	 * Lista para que o funcionario possa atualizar o pedido do cliente
	 * */
	public void listadeEntrega(Entrega[] entregas, Funcionario[] funcionario, String emaildoFuncionario) { 
		Funcionario funcionarioResponsavel[] = new Funcionario[50];
		Entrega olharEntregas[] = new Entrega[100];
		int contador = 0;
		
		olharEntregas = entregas;
		funcionarioResponsavel = funcionario;
		String cpfdoFuncionario = null;
		while(funcionarioResponsavel[contador] != null)
			contador++;
		
		for(int i = 0; i < contador ; i++) {
			if(emaildoFuncionario.equals(funcionarioResponsavel[i].getEmail())){
				cpfdoFuncionario = funcionarioResponsavel[i].getCpf();
				break;
			}
		}
		contador = 0;
		while(olharEntregas[contador] != null)
			contador++;
		for(int i = 0; i < contador ; i++) {
			if(cpfdoFuncionario.equals(olharEntregas[i].getCpfdoFuncionarioResponsável())){
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
				int resposta = JOptionPane.showConfirmDialog(null, "DESEJA MUDAR O STATUS DA COMPRA PARA ENVIADO? ");
				if (resposta == 0) {
					olharEntregas[i].setStatusdeEntrega("ENTREGUE");
						}
					
			}
		}
		
	}
	
	/**
	 * atualiza dados de algum livro ja cadastrado
	 * */
	private void atualizarlivroCadastrado(Livro Livros) {
		
	}
	
}
