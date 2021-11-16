package compras;
import Utilidades.Painel;
/**
 * Classe Livro
 * */
public class Livro {
	/**
	 * contém os atributos de livro
	 * */
	private float preco;
	private String genero;
	private String autor;
	private String titulo;
	private String ISBN;
	private String editora;
	private int quantidade;
	private float desconto;
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	/**
	 * Mostra os livros ja cadastrados
	 * */
	public void mostrarCatalogo(Livro[] catalogo) {
		Painel.pularLinha(3);
		int contador = 0;
	    while(catalogo[contador] != null)
			contador++;
		System.out.println("Quantidade de Livros em estoque = "+contador);
		for(int i = 0; i < contador; i++) {
			System.out.println("Autor do livro: "+catalogo[i].getAutor());
			System.out.println("Título do livro: "+catalogo[i].getTitulo());
			System.out.println("quantidade de livros: "+catalogo[i].getQuantidade());
			Painel.pularLinha(2);
		}
		
	}
	

}
