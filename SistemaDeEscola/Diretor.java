package SistemaDeEscola;

public class Diretor extends Pessoa {
private int anosExperiencia;
private double bonusAnual;
private String departamento;

public Diretor(String nome, int idade, String cpf, int anosExperiencia, double bonusAnual, String departamento) {
	super(nome, idade, cpf);
	this.anosExperiencia = anosExperiencia;
	this.bonusAnual = bonusAnual;
	this.departamento = departamento;
}

@Override
public void exibirDados() {
	super.exibirDados();
	System.out.println("Anos de experiencia: " + this.anosExperiencia + "\nBonus Anual: " + this.bonusAnual + "\nDepartamento: " + this.departamento);
}

public double calcularBeneficios() {
	return anosExperiencia * 200.0;
}

public boolean elegivelAumentoBonus() {
	if(this.anosExperiencia >= 5) {
		return true;
	}else {
		return false;
	}
}

}
