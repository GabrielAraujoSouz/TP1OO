package Utilidades;

import javax.swing.JOptionPane;

import compras.Livro;
/**
 * Classe Painel
 * */
public interface Painel {
	/**
	 * Classe utilitaria para oturas classes
	 * */
	
	public static void pularLinha(int linhasaPular){
		for(int i = 0; i < linhasaPular; i++ ) {
			System.out.println();
			i++;
		}
	}
	
	public static String validaNome(String nome) {
	
		
		while(nome.length() < 3) {

			System.out.print("Nome invalido! O nome deve ter pelo menos 3 caracteres.\nDigite o nome novamente: ");
			
		}
		return nome;
	}
public static int validaQuantidade(Livro[] Livro, int quantidade, int contador) {
	
		
		while(quantidade < Livro[contador].getQuantidade()) {
			 quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade invalida Digite, novamente: "));
			System.out.print("Quantidade invalida Digite, novamente: ");
			
		}
		return quantidade;
	}
public static String validaCPF(String cpf) {
	
	
	while(cpf.length() < 7 || cpf.length() > 7) {

		System.out.print("CPF invalido o CPF deve ter 7 caracteres.Digite o nome novamente: ");
		cpf = JOptionPane.showInputDialog("CPF invalido o CPF deve ter 7 caracteres.Digite o nome novamente: ");
		
	}
	return cpf;
}
	


}
