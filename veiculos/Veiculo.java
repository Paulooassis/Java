package veiculos;

public class Veiculo {
private String marca;
private String modelo;

public Veiculo(String marca, String modelo) {
	this.marca = marca;
	this.modelo = modelo;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getMarca() {
	return marca;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public String getModelo() {
	return modelo;
}

public void imprimirInformacoes() {
	System.out.println("A marca e: " + marca + "\nO modelo e: " + modelo);
}

}