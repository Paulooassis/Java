package Animais;

public class Peixe extends Animal {
private String caracteristica;

public Peixe(String nome, double comprimento, int numeroDePatas, String cor, String ambiente, double velocidadeMedia, String caracteristica) {
	super(nome, comprimento, numeroDePatas, cor, ambiente, velocidadeMedia);
	this.caracteristica = caracteristica;
}

public String getCaracteristica() {
	return caracteristica;
}

public void setCaracteristica(String caracteristica) {
	this.caracteristica = caracteristica;
}

public void dadosPeixe() {
	super.dados();
	System.out.println("Caracteristica: " + this.caracteristica);
}

}
