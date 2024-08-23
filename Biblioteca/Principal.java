package Biblioteca;

public class Principal {
	public static void main(String[] args) {
		Livro L = new Livro("Pequeno Principe",  "Monteiro", 25.5);
		Livro L2 = new Livro("Pequeno Jorge",  "Java", 45.5);
		Livro L3 = new Livro("Principe",  "Canvas", 15.5);
		Livro L4 = new Livro("Paulo",  "Robespier", 50.0);
		Livro L5 = new Livro("Drummond",  "Pietrim", 75.5);
		Carrinho C = new Carrinho();
		
		C.adicionarLivro(L);
		C.adicionarLivro(L3);
		C.adicionarLivro(L5);
		
		C.removerLivro("Canvas");
		
		C.listarLivros();
		System.out.println("O valor total do carrinho e " +  C.calcularTotal());
	}
}
