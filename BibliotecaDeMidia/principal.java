package BibliotecaDeMidia;

public class principal{
	public static void main(String[] args) {
		Livro L = new Livro("PP", "Romero brito", 50);
		Biblioteca B = new Biblioteca();
		
		B.adicionarMidia(L);
		B.listarMidias();
		
		System.out.println(B.calcularDuracaoTotal());
	}
}