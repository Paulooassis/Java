package Biblioteca;

public class Carrinho {
    private Livro[] livros;
    private int quantidadeLivro;

    public Carrinho() {
        livros = new Livro[100];
        quantidadeLivro = 0;
    }

    public void adicionarLivro(Livro livro) {
        if (quantidadeLivro < 100) {
            livros[quantidadeLivro] = livro;
            quantidadeLivro++;
        } else {
            System.out.println("Carrinho cheio");
        }
    }

    public void removerLivro(String titulo) {
        boolean verificar = false;
        
        for (int i = 0; i < quantidadeLivro; i++) {
            if (livros[i].getTitulo().equals(titulo)) {
                for (int j = i; j < quantidadeLivro - 1; j++) {
                    livros[j] = livros[j + 1];
                }
                livros[quantidadeLivro - 1] = null;
                quantidadeLivro--;
                verificar = true;
                break;
            }
        }
        
        if (!verificar) {
            System.out.println("Nenhum livro encontrado.");
        }
    }

    public void listarLivros() {
        if (quantidadeLivro == 0) {
            System.out.println("O carrinho está vazio.");
            return;
        }
        
        for (int i = 0; i < quantidadeLivro; i++) {
            System.out.println(livros[i].getInfo() + "\n");
        }
    }

    public double calcularTotal() {
        double soma = 0.0;
        for (int i = 0; i < quantidadeLivro; i++) {
            soma += livros[i].getPreco();
        }
        return soma;
    }
}
