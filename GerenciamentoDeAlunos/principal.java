package GerenciamentoDeAlunos;

public class principal {
	public static void main(String[] args) {
		Double[] notas1 = {7.8, 8.9, 5.4};
		Double[] notas2 = {4.8, 2.9, 1.4};
		Double[] notas3 = {0.8, 9.9, 3.4};
		
		Aluno A = new Aluno("Pedro", 18, notas1);
		Aluno A2 = new Aluno("jorjao", 14, notas2);
		Aluno A3 = new Aluno("Carlos", 11, notas3);
		
		Escola SantaMaria = new Escola();

		SantaMaria.adicionarAluno(A);
		SantaMaria.adicionarAluno(A2);
		SantaMaria.adicionarAluno(A3);
		
		SantaMaria.listarAlunos();
	}
}
