package veiculos;

public class Moto extends Veiculo {
private String tipoDeGuidon;

public Moto(String marca, String modelo, String tipoDeGuidon) {
	super(marca, modelo);
	this.tipoDeGuidon = tipoDeGuidon;
}

public void setTipoDeGuidon(String tipo) {
	this.tipoDeGuidon = tipo;
}

public String getTipoDeGuidon() {
	return this.tipoDeGuidon;
}

@Override
public void imprimirInformacoes() {
	System.out.println("Marca: " + getMarca() + "\nModelo: " + getModelo() + "\nTipo de Guidon: " + tipoDeGuidon);
}
}
