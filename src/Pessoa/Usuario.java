package Pessoa;

import javax.swing.JOptionPane;

import Utilidades.Painel;
/**
 * Classe Usuario
 * */
public abstract class Usuario {
	/**
	 * Classe que contem atributos para outras classes filhas e seus metodos
	 * */
	private String identificador;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String email;
	private String senha;
	
	
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * cadastra um novo cliente na livraria 
	 * */
	public  Cliente cadastrarCliente() {
		String identificador = new String();
		String nomedoCliente = new String();
		String cpfdocliente = new String();
		String endereçodocliente = new String();
		String telefonedocliente = new String();
		String emaildocliente = new String();
		String senhadocliente = new String();
		Cliente cliente = new Cliente();
		
		
			identificador = JOptionPane.showInputDialog("Digite o identificador do cliente: ");
			while (identificador.isEmpty() == true)
			{
				identificador = JOptionPane.showInputDialog("Digite o identificador novamente: ");
			}
			
			nomedoCliente = JOptionPane.showInputDialog("Digite o Nome do cliente: ");
			while (nomedoCliente.isEmpty() == true)
			{
				nomedoCliente = JOptionPane.showInputDialog("Digite o Nome do cliente: ");
				nomedoCliente = Painel.validaNome(nomedoCliente);
			}
			
			cpfdocliente = JOptionPane.showInputDialog("Digite o CPF do cliente:  ");
			while (cpfdocliente.isEmpty() == true)
			{
				cpfdocliente = JOptionPane.showInputDialog("Frase vazia, Digite o CPF do cliente:");
				cpfdocliente = Painel.validaCPF(cpfdocliente);
			}

			endereçodocliente = JOptionPane.showInputDialog("Digite o endereço do cliente: ");
			while (endereçodocliente.isEmpty() == true)
			{
				endereçodocliente = JOptionPane.showInputDialog("Frase vazia, Digite o endereço do cliente: ");
			}

			telefonedocliente = JOptionPane.showInputDialog("Digite o telefone do cliente: ");
			while (telefonedocliente.isEmpty() == true)
			{
				telefonedocliente = JOptionPane.showInputDialog("Frase vazia, Digite o telefone do cliente: ");
			}
			
			emaildocliente = JOptionPane.showInputDialog("Digite o email do cliente: ");
			while (emaildocliente.isEmpty() == true)
			{
				emaildocliente = JOptionPane.showInputDialog("Frase vazia, Digite o email do cliente: ");
			}
			
			senhadocliente = JOptionPane.showInputDialog("Digite Senha do cliente:  ");
			while (senhadocliente.isEmpty() == true)
			{
				senhadocliente = JOptionPane.showInputDialog("Frase vazia, Digite o senha do cliente: ");
			}
			System.out.println("Obrigado por cadastrar");
			
		cliente.setIdentificador(identificador);
		cliente.setNome(nomedoCliente);
		cliente.setCpf(cpfdocliente);
		cliente.setEndereco(endereçodocliente);
		cliente.setTelefone(telefonedocliente);
		cliente.setEmail(emaildocliente);
		cliente.setSenha(senhadocliente);
		return cliente;
	}
	
	/**
	 * Cadastra um novo funcionario na livraria
	 * */
	public Funcionario cadastrarFuncionario() {
		//simulação de cadastro
		Funcionario funcionario = new Funcionario(); 
		String identificador = new String();
		String nomedoFuncionario = new String();
		String cpfdoFuncionario = new String();
		String endereçodoFuncionario = new String();
		String telefonedoFuncionario = new String();
		String emaildoFuncionario = new String();
		String senhadoFuncionario = new String();
		
		identificador = JOptionPane.showInputDialog("Digite o identificador do Funcionario: ");
		while (identificador.isEmpty() == true)
		{
			identificador = JOptionPane.showInputDialog("Digite o identificador novamente: ");
		}
		
		nomedoFuncionario = JOptionPane.showInputDialog("Digite o Nome do Funcionario: ");
		while (nomedoFuncionario.isEmpty() == true)
		{
			nomedoFuncionario = JOptionPane.showInputDialog("Digite o Nome do Funcionario: ");
		}
		
		cpfdoFuncionario = JOptionPane.showInputDialog("Digite o CPF do Funcionario:  ");
		while (cpfdoFuncionario.isEmpty() == true)
		{
			cpfdoFuncionario = JOptionPane.showInputDialog("Frase vazia, Digite o CPF do Funcionario:");
		}

		endereçodoFuncionario = JOptionPane.showInputDialog("Digite o endereço do Funcionario: ");
		while (endereçodoFuncionario.isEmpty() == true)
		{
			endereçodoFuncionario = JOptionPane.showInputDialog("Frase vazia, Digite o endereço do Funcionario: ");
		}

		telefonedoFuncionario = JOptionPane.showInputDialog("Digite o telefone do Funcionario: ");
		while (telefonedoFuncionario.isEmpty() == true)
		{
			telefonedoFuncionario = JOptionPane.showInputDialog("Frase vazia, Digite o telefone do Funcionario: ");
		}
		String cargo = JOptionPane.showInputDialog("Digite o Cargo do Funcionario: ");
		while (cargo.isEmpty() == true)
		{
			cargo = JOptionPane.showInputDialog("Frase vazia, Digite o telefone do Funcionario: ");
		}
		
		emaildoFuncionario = JOptionPane.showInputDialog("Digite o email do Funcionario: ");
		while (emaildoFuncionario.isEmpty() == true)
		{
			emaildoFuncionario = JOptionPane.showInputDialog("Frase vazia, Digite o email do Funcionario: ");
		}
		
		senhadoFuncionario = JOptionPane.showInputDialog("Digite Senha do Funcionario:  ");
		while (senhadoFuncionario.isEmpty() == true)
		{
			senhadoFuncionario = JOptionPane.showInputDialog("Frase vazia, Digite o senha do Funcionario: ");
		}
		System.out.println("Obrigado por cadastrar");
		
		
		funcionario.setIdentificador(identificador);
		funcionario.setNome(nomedoFuncionario);
		funcionario.setCpf(cpfdoFuncionario);
		funcionario.setEndereco(endereçodoFuncionario);
		funcionario.setTelefone(telefonedoFuncionario);
		funcionario.setEmail(emaildoFuncionario);
		funcionario.setSenha(senhadoFuncionario);
		funcionario.setCargo(cargo);
		return funcionario;
	}
}
