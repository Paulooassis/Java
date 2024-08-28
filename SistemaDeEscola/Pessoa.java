package SistemaDeEscola;

public class Pessoa {
private String nome;
private int idade;
private String cpf;

public Pessoa(String nome, int idade, String cpf) {
	this.nome = nome;
	this.idade = idade;
	this.cpf = cpf;
}

private boolean validarDados() {
	if(idade > 0 && nome != null) {
		return true;
	}else {
		return false;
	}
}

public void exibirDados() {
	if(validarDados()) {
		System.out.println("Nome: " + this.nome + "\nIdade: " + this.idade + "\nCpf: " + this.cpf);
	}else {
		System.out.println("Os dados digitados sao invalidos.");
	}
}

public boolean verificarMaioridade() {
	if(idade >= 18) {
		return true;
	}else {
		return false;
	}
}

public void saudacao() {
	System.out.println("Ola " + this.nome + "! Bem-vindo à escola.");
}

}
