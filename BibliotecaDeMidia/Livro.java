package BibliotecaDeMidia;

public class Livro extends Midia {
public Livro(String titulo, String autor, int duracao) {
	super(titulo, autor, duracao);
}

@Override
public String getInfo() {
	return super.getInfo();
}
}
