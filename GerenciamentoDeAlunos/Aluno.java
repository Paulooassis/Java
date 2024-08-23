package GerenciamentoDeAlunos;

public class Aluno {
private String nome;
private int idade;
private Double[] notas;

public Aluno(String nome, int idade, Double[] notas) {
	this.nome = nome;
	this.idade = idade;
	this.notas = notas;
}

public String getNome(){
	return nome;
}

public int getIdade(){
	return idade;
}

public Double[] getNotas(){
	return notas;
}

public String getInfo() {
	String Informacao = "Nome: " + nome + "\nIdade: " + idade + "\nNotas: ";
	
	for(int i=0; i< notas.length; i++) {
		
		Informacao += notas[i];
		
		if(i != notas.length-1) {
			Informacao += ",";
		}
	}
	return Informacao;
}

public Double calcularMedia() {
	Double soma = 0.0;
	for(int i=0; i< notas.length; i++) {
		soma += notas[i];
	}
	return soma/notas.length;
}

}
