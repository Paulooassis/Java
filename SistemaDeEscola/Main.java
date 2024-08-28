package SistemaDeEscola;

import java.util.ArrayList;

public class Main{
	public static void main(String[] args) {
		ArrayList<Pessoa> pessoas = new ArrayList<>();

        Aluno aluno1 = new Aluno("Ana", 20, "12300", "2023001", 8.5, 2023);
        Professor professor1 = new Professor("Joao", 45, "1312", "Math", 500.0, 10);
        Diretor diretor1 = new Diretor("Carlos", 50, "11256", 15, 15000.0, "Adm");

        pessoas.add(aluno1);
        pessoas.add(professor1);
        pessoas.add(diretor1);

        for (Pessoa pessoa : pessoas) {
            pessoa.exibirDados();																																									
            System.out.println();
        }
	}
}