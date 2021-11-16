package Main;

import java.util.Scanner;

import javax.swing.*;

import Pessoa.Cliente;
import Pessoa.Funcionario;
import Utilidades.*;
import compras.Cesta;
import compras.Entrega;
import compras.Livro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
/**
 * Classe Principal
 * */
public class Main {
	/**
	 * Guia o codigo ate os outros metodos
	 * 
	 * */
		
	public static void main(String[] args) {
		
		final int LIMITEFUNCIONARIO = 50;
		Funcionario usarFuncionario = new Funcionario();
		Funcionario funcionarioCadastro [] = new Funcionario[LIMITEFUNCIONARIO];
		
		
		final int LIMITECLIENTE = 200;
		Cliente usarCliente = new Cliente();
		Cliente clienteCadastrado[] = new Cliente[LIMITECLIENTE]; 
		
		final int LIMITELIVRO = 200;
		Livro usarLivros = new Livro();
		Livro cadastrodeLivro[] = new Livro[LIMITELIVRO];
	//	Livro cadastrodeLivro = new Livro();
		
		final int LIMITEENTREGA = 100;
		Entrega entregas[] = new Entrega[LIMITEENTREGA];
		
		
		JFrame janelao = new JFrame();
		JButton cadastrarFuncionario = new JButton("cadastrar funcionario");
		JButton cadastrarCliente = new JButton("cadastrar Cliente");
		JButton login = new JButton("Login");
		JButton loginFuncionario = new JButton("Login Funcionario");
		JButton catalogo = new JButton("catalogo");
		janelao.setLayout(new FlowLayout(FlowLayout.LEFT));
		janelao.add(loginFuncionario);
		janelao.add(cadastrarCliente);
		janelao.add(cadastrarFuncionario);
		janelao.add(login);
		janelao.add(catalogo);
		
		janelao.setTitle("Tela Principal");
		janelao.setSize(500,400);
		janelao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelao.setVisible(true);
		
		//Botao de Login para Funcionarios
		loginFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emaildoFuncionario = JOptionPane.showInputDialog("Digite o email do Funcionario: ");
				while (emaildoFuncionario.isEmpty() == true)
				{
					emaildoFuncionario = JOptionPane.showInputDialog("Frase vazia, Digite o email do Funcionario: ");
				}
				
				String senhadoFuncionario = JOptionPane.showInputDialog("Digite Senha do Funcionario:  ");
				while (senhadoFuncionario.isEmpty() == true)
				{
					senhadoFuncionario = JOptionPane.showInputDialog("Frase vazia, Digite o senha do Funcionario: ");
				}
				loginParaFuncionario(funcionarioCadastro, emaildoFuncionario, senhadoFuncionario, clienteCadastrado, cadastrodeLivro, entregas);
				
			}	
		});
		//Botao de Cadastro para Clientes
		cadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				//while (emaildocliente.isEmpty() == true)
				while(clienteCadastrado[i] != null) {
					i++;
				}
				clienteCadastrado[i] = usarCliente.cadastrarCliente();
				System.out.println(i);
			}
		});
		// Botao de Cadastro para Funcionarios 
		cadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				//while (emaildocliente.isEmpty() == true)
				while(funcionarioCadastro[i] != null) {
					i++;
				}
				funcionarioCadastro[i] = usarFuncionario.cadastrarFuncionario();
				System.out.println(i);
			 
			}
		});
		// Botao de Login para Cliente 
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emaildocliente = JOptionPane.showInputDialog("Digite o email do cliente: ");
				while (emaildocliente.isEmpty() == true)
				{
					emaildocliente = JOptionPane.showInputDialog("Frase vazia, Digite o email do cliente: ");
				}
				
				String senhadocliente = JOptionPane.showInputDialog("Digite Senha do cliente:  ");
				while (senhadocliente.isEmpty() == true)
				{
					senhadocliente = JOptionPane.showInputDialog("Frase vazia, Digite o senha do cliente: ");
				}
				System.out.println("Obrigado por cadastrar");
					login(clienteCadastrado, emaildocliente, senhadocliente, cadastrodeLivro, entregas);
			}
		});
		
		// Botao para imprimir catalogo
		catalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usarLivros.mostrarCatalogo(cadastrodeLivro);
			}
		});
		
	}
	
	/**
	 * Login para o cliente interagir com o programa
	 * */
	public static void login(Cliente[] clienteCadastro, String emaildocliente, String senhadocliente, Livro[] livro, Entrega[] pedidos) {
		boolean check = false;
		Cesta cestadoCliente = new Cesta();
		Cliente clientelogado[] = new Cliente[200];
		Livro usarlivro = new Livro();
		clientelogado = clienteCadastro;
		int contador;
		while(check == false) {
			for(contador = 0; contador < 200; contador++) {
				if(emaildocliente.equals(clienteCadastro[contador].getEmail()) && senhadocliente.equals(clienteCadastro[contador].getSenha())) {
					check = false;
					System.out.println("Login bem sucedido !!");
					break;
				}
				else
					System.out.println("aguarde login");
			}
			check = true;
		}
		
		JFrame janelao = new JFrame();
		JButton atualizarCesta = new JButton("Atualizar cesta");
		JButton atualizarDados = new JButton("Atualizar Dados");
		JButton finalizarCompra = new JButton("Finalizar Compra");
		JButton mostrarCatalogo = new JButton("Mostrar catalogo");
		JButton mostrarComprasPassadas = new JButton("Mostrar Compras Passadas");
		janelao.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		janelao.add(atualizarCesta);
		janelao.add(mostrarComprasPassadas);
		janelao.add(atualizarDados);
		janelao.add(finalizarCompra);
		janelao.add(mostrarCatalogo);
		
		janelao.setTitle("Tela Do Cliente");
		janelao.setSize(500,400);
		janelao.setVisible(true);
		
		// Botao para adicionar itens a Cesta do cliente
		/* apos a utilizacao desse botao, nao sera possivel adicionar novos itens sem deletar os itens ja adicionados  */
		atualizarCesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			clienteCadastro[0].atualizarCesta(livro, cestadoCliente);
			
			String livrosSelecionados[] = new String[200];
			livrosSelecionados = cestadoCliente.getItemSelecionado();
			cestadoCliente.mostrarItens(cestadoCliente, livrosSelecionados);
			}
		});
		
		// Botao para finalizar a compra
		finalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja Finalizar sua compra? ");
				if (resposta == 0) {
					String datadaCompra[]= new String[3];
					datadaCompra[0] = JOptionPane.showInputDialog("Digite a Data do dia de hoje: ");
					datadaCompra[1] = JOptionPane.showInputDialog("Digite a Data do mês de hoje: ");
					datadaCompra[2] = JOptionPane.showInputDialog("Digite a Data do ano de hoje: ");
					for(int contador = 0; contador < 200; contador++) {
						String checaremail, checarSenha;
						checaremail = JOptionPane.showInputDialog("Digite seu email: ");
						checarSenha = JOptionPane.showInputDialog("Digite sua senha: ");
						if(emaildocliente.equals(checaremail) && senhadocliente.equals(checarSenha)) {
							System.out.println("Login bem sucedido !!");
							String cpfDaCompra = clienteCadastro[contador].getCpf();
							cestadoCliente.setCpfdoCliente(cpfDaCompra);	
							cestadoCliente.setDatadeCriação(datadaCompra);
							Entrega finalizar = new Entrega();
							finalizar.finalizarCompra(cestadoCliente, pedidos);
							break;
						}
						else
					System.out.println("Login incorreto");
					
					}
			}
			}
		});
		
		// Botao para imprimir catalogo
		mostrarCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			usarlivro.mostrarCatalogo(livro);
			}
		});
		//Botao para imprimir compras passadas
		mostrarComprasPassadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteCadastro[0].mostrarCompras(pedidos, clienteCadastro, emaildocliente);
			}
		});
		
		// Botao para Atualizar cadastro do Cliente
				atualizarDados.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int contador = 0;
					while (clienteCadastro[contador] != null)
						contador++;
					for(int i = 0; i < contador; i++) {
						if(emaildocliente.equals(clienteCadastro[i].getEmail()) && senhadocliente.equals(clienteCadastro[i].getSenha()))
							clienteCadastro[i] = clienteCadastro[0].cadastrarCliente();
					}
					}
				});
		
	}
	/**
	 * Login para o Funcionario interagir com o programa
	 * */
	
	public static void loginParaFuncionario(Funcionario[] funcionariosCadastrados, String emaildofuncionario, String senhadofuncionario, Cliente[] clienteCadastrado, Livro[] livros, Entrega[] attEntregas) {
		boolean check = false;
		
		//Livro cadastrodeLivro[] = new Livro[300];
		
		while(check == false) {
			for(int contador = 0; contador < 200; contador++) {
				//emaildocliente.equals(clienteCadastrado[contador].getEmail())
				if(emaildofuncionario.equals(funcionariosCadastrados[contador].getEmail()) && senhadofuncionario.equals(funcionariosCadastrados[contador].getSenha())) {
					check = false;
					System.out.println("Login bem sucedido !!");
					break;
				}
				else
					System.out.println("aguarde login");
			}
			check = true;
			
		}
		JFrame janelao = new JFrame();
			// atualizarDadosFuncionario
			//atualizarEntrega
			JButton cadastrarLivro = new JButton("Cadastrar Livro");
			JButton imprimirRelatorio = new JButton("Relatorio");
			JButton atualizarDados = new JButton("Atualizar Dados Livro");
			JButton atualizarDadosFuncionario = new JButton("Atualizar Dados Funcioanrio");
			JButton atualizarEntrega = new JButton("Atualizar Entrega");
			janelao.setLayout(new FlowLayout(FlowLayout.LEFT));
			janelao.add(cadastrarLivro);
			janelao.add(atualizarDadosFuncionario);
			janelao.add(imprimirRelatorio);
			janelao.add(atualizarDados);
			janelao.add(atualizarEntrega);
			
			janelao.setTitle("Tela Do Funcionario");
			janelao.setSize(500,400);
			janelao.setVisible(true);
			
			// Botao para imprimir um relatorio detalhado
			imprimirRelatorio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				funcionariosCadastrados[0].imprimirRelatorio(clienteCadastrado, livros, attEntregas);
				}
			});
			
			// Botao para cadastrar livro
			cadastrarLivro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				funcionariosCadastrados[0].cadastrarLivro(livros);
				}
			});
			
			// Botao para atualizar dados do livro
			atualizarDados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				funcionariosCadastrados[0].cadastrarLivro(livros);
				//funcionarioCadastro[i] = usarFuncionario.cadastrarFuncionario();
				}
			});
			
			//Botao para atualizar dados pessoais do funcionario
			atualizarDadosFuncionario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					int contador = 0;
					while (funcionariosCadastrados[contador] != null)
						contador++;
					for(int i = 0; i < contador; i++) {
						if(emaildofuncionario.equals(funcionariosCadastrados[i].getEmail()) && senhadofuncionario.equals(funcionariosCadastrados[i].getSenha()))
							funcionariosCadastrados[i] = funcionariosCadastrados[0].cadastrarFuncionario();
					}
					
				}
			});
			//Atualizar status de entrega 
			atualizarEntrega.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					funcionariosCadastrados[0].listadeEntrega(attEntregas, funcionariosCadastrados, emaildofuncionario);
				
				}
			});
			
		
	}

}
