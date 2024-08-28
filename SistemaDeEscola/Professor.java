package SistemaDeEscola;

public class Professor extends Pessoa {
private String disciplina;
private double salario;
private int anosExperiencia;

public Professor(String nome, int idade, String cpf, String disciplina, double salario, int anosExperiencia) {
	super(nome, idade, cpf);
	this.disciplina = disciplina;
	this.anosExperiencia = anosExperiencia;
	this.salario = salario;
}

@Override
public void exibirDados() {
	super.exibirDados();
	System.out.println("Disciplina: " + this.disciplina + "\nSalario: " + this.salario + "\nAnos de Experiencia: " + this.anosExperiencia);
}

public double calcularBeneficios() {
	double bonus;
	bonus = this.salario*0.1;
	bonus += anosExperiencia * 100;
	return bonus;
	
}

public void aumentarSalario(double percentual) {
	this.salario += this.salario * percentual / 100;
}

public byte determinarCargaHoraria() {
	if(this.disciplina.equals("teorica")) {
		return 20;
	}else if(this.disciplina.equals("pratica")) {
		return 15;
	}else {
		return 0;
	}
}


}
