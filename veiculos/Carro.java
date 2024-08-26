package veiculos;

public class Carro extends Veiculo {
private int numeroDePortas;
private int numeroDeAssentos;

public Carro(String marca, String modelo, int numeroDePortas, int numeroDeAssentos) {
	super(marca, modelo);
	this.numeroDeAssentos = numeroDeAssentos;
	this.numeroDePortas = numeroDePortas;
}

@Override
public void imprimirInformacoes() {
	System.out.println("Marca: " + getMarca() + "\nModelo: " + getModelo() + "\nNumero de portas: " + numeroDePortas + "\nNumero de Assentos: " + numeroDeAssentos);
}

public void setNumeroDeAssentos(int num) {
	this.numeroDeAssentos = num;
}

public int getNumeroDeAssentos() {
	return this.numeroDeAssentos;
}

public void setNumeroDePortas(int num) {
	this.numeroDePortas = num;
}

public int getNumeroDePortas() {
	return this.numeroDePortas;
}

}
