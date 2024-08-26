package Animais;

public class Animal {
private String nome;
private double comprimento;
private int numeroDePatas;
private String cor;
private String ambiente;
private double velocidadeMedia;

public Animal(String nome, double comprimento, int numeroDePatas, String cor, String ambiente, double velocidadeMedia) {
	this.nome = nome;
	this.comprimento = comprimento;
	this.numeroDePatas = numeroDePatas;
	this.cor = cor;
	this.ambiente = ambiente;
	this.velocidadeMedia = velocidadeMedia;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public double getComprimento() {
	return comprimento;
}

public void setComprimento(double comprimento) {
	this.comprimento = comprimento;
}

public int getNumeroDePatas() {
	return numeroDePatas;
}

public void setNumeroDePatas(int numeroDePatas) {
	this.numeroDePatas = numeroDePatas;
}

public String getCor() {
	return cor;
}

public void setCor(String cor) {
	this.cor = cor;
}

public String getAmbiente() {
	return ambiente;
}

public void setAmbiente(String ambiente) {
	this.ambiente = ambiente;
}

public double getVelocidadeMedia() {
	return velocidadeMedia;
}

public void setVelocidadeMedia(double velocidadeMedia) {
	this.velocidadeMedia = velocidadeMedia;
}

public void dados() {
	System.out.println("Nome: " + nome + "\nComprimento: " + comprimento + "\nNumero de patas: " + numeroDePatas + "\nCor: " + cor + "\nAmbiente: " + ambiente + "\nVelocidade Media: " + velocidadeMedia);
}


}
