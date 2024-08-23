package GerenciamentoDeAlunos;

public class Escola {
private Aluno[] alunos;
private int quantidadeDeAlunos;

public Escola() {
	alunos = new Aluno[100];
	quantidadeDeAlunos = 0;
}

public void adicionarAluno(Aluno aluno) {
	if(quantidadeDeAlunos > 100) {
		System.out.println("Numero maximo de alunos atingido.");
	}else {
		alunos[quantidadeDeAlunos] = aluno;
		quantidadeDeAlunos++;
	}
}

public void listarAlunos() {
	if(quantidadeDeAlunos == 0) {
		System.out.println("Nao possuem alunos cadastrados.");
	}else {
		for(int i=0; i<quantidadeDeAlunos; i++) {
			System.out.println(alunos[i].getInfo());
			System.out.println();
		}
	}
}

public Double calcularMediaGeral() {
	Double somaDeMedias = 0.0;
	
	for(int i=0; i<quantidadeDeAlunos; i++) {
		somaDeMedias += alunos[i].calcularMedia();
	}
	
	return somaDeMedias/quantidadeDeAlunos;
}

}

