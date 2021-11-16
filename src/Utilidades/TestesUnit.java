package Utilidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import compras.Livro;

import Pessoa.*;;

class TestesUnit {
	Funcionario livro = new Funcionario();
	@Test
	void testarCPF() {
		Painel.validaCPF("1234");
	}
	@Test
	void testarNome() {
		Painel.validaNome("an");
	}
	@Test
	void testarCadastroFuncionario() {
		livro.cadastrarFuncionario();
	}
}
