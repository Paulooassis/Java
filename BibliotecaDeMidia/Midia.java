package BibliotecaDeMidia;

public class Midia {
private String titulo;
private String autor;
private int duracao;

public Midia(String titulo, String autor, int duracao) {
	this.titulo = titulo;
	this.autor = autor;
	this.duracao = duracao;
}

public String getInfo() {
	return "Titulo: " + titulo + "\nAutor: " + autor + "\nDuracao: " + duracao;
}

public int getDuracao() {
	return duracao;
}
}
