package SistemaDeEscola;

public class Aluno extends Pessoa {
private String matricula;
private double notaFinal;
private int anoLetivo;

private boolean notaValida(double notaFinal) {
	if(notaFinal >= 0.0 && notaFinal <= 10.0) {
		return true;
	}else {
		return false;
	}
}

public Aluno(String nome, int idade, String cpf, String matricula, double notaFinal, int anoLetivo){
	super(nome, idade, cpf);
	this.matricula = matricula;
	
	if(notaValida(notaFinal)) {
		this.notaFinal = notaFinal;
	}else {
		this.notaFinal = 0.0;
	}
	
	this.anoLetivo = anoLetivo;
}

public double calcularBeneficios() {
	if(this.notaFinal >= 9.0) {
		return 1000.0;
	}else if(this.notaFinal >= 7.0) {
		return 500.0;
	}else {
		return 0.0;
	}
}

public double calcularMediaSemestral(double nota1, double nota2) {
	if(notaValida(nota1) && notaValida(nota2)) {
		return (nota1 + nota2)/2;
	}else {
		System.out.println("Nota invalida");
		return 0.0;
	}
}

public boolean verificarAprovacao() {
	if(this.notaFinal >= 7) {
		return true;
	}else {
		return false;
	}
}

@Override
public void exibirDados() {
	super.exibirDados();
	System.out.println("Matricula: "  + this.matricula + "\nNota final: " + this.notaFinal + "Ano letivo: " + this.anoLetivo);
}

}
