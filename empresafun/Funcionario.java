package empresafun;

import java.util.Scanner;

public class Funcionario {
public String nome;
public String sexo;
public String data_nascimento;
public int idade;
public int contadormulher = 0;
public int contadorhomem = 0;

public Funcionario() {
}

public Funcionario(String nome, String sexo, String data_nascimento, int idade) {
    this.nome = nome;
    this.sexo = sexo;
    this.data_nascimento = data_nascimento;
    this.idade = idade;
}

public void setInformacoes() {
	Scanner teclado = new Scanner(System.in);
	
	System.out.println("Digite seu nome: ");
	this.nome = teclado.nextLine();
	
	System.out.println("Digite seu sexo: ");
	this.sexo = teclado.nextLine();
	
	System.out.println("Digite sua data de nascimento: ");
	this.data_nascimento = teclado.nextLine();
	
	System.out.println("Digite sua idade: ");
	this.idade = teclado.nextInt();
}

public void exibirInformacoes() {
    System.out.println("O nome é: " + this.nome);
    
    System.out.println("O sexo é: " + this.sexo);
    
    System.out.println("A data de nascimento é: " + this.data_nascimento);
    
    System.out.println("O idade é: " + this.idade);
}

public String getSexo() {
	return this.sexo;
}

public int getIdade() {
	return this.idade;
}


public static double mediaPercentual(int totalPessoas, int totalGenero) {
    if (totalPessoas == 0) {
        return 0; // Evita divisão por zero
    }
    return ((double) totalGenero / totalPessoas) * 100;
}
}
