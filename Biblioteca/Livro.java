package Biblioteca;

public class Livro {
private String nome;
private String titulo;
private double preco;

public Livro(String nome, String titulo, double preco) {
	this.nome = nome;
	this.titulo = titulo;
	this.preco = preco;
}

public String getInfo() {
	return "Nome: " + nome + "\nTitulo: " + titulo + "\nPreco: R$ " + preco;
}

public double getPreco() {
	return preco;
}

public String getTitulo() {
	return titulo;
}

}

