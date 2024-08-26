package Animais;

public class Mamifero extends Animal {
private String alimento;

public Mamifero(String nome, double comprimento, int numeroDePatas, String cor, String ambiente, double velocidadeMedia, String alimento) {
	super(nome, comprimento, numeroDePatas, cor, ambiente, velocidadeMedia);
	this.alimento = alimento;
}

public void setAlimento(String alimento) {
	this.alimento = alimento;
}

public String getAlimento() {
	return this.alimento;
}

public void dadosMamifero() {
	super.dados();
	System.out.println("Alimento: " + alimento);
}

}
