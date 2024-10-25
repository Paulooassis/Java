package INTERFACE;

import java.time.LocalDate;
import java.time.Period;

public class Aluno implements IOrdenavel{
private static final int QTAVALIACOES;
protected String nome;
protected int matricula;
protected LocalDate dataNascimento;
protected double avaliacoes[];

static {
	QTAVALIACOES = 4;
}

public Aluno(int matricula, String nome) {
	this.matricula = matricula;
	this.nome = nome;
	this.avaliacoes = new double[QTAVALIACOES];
}

public boolean aprovado() {
	double soma = 0;
	for(int i = 0; i < QTAVALIACOES; i++) {
		soma += this.avaliacoes[i];
	}
	return soma >= 60;
}

public double notaFinal() {
	double soma = 0;
	for(int i = 0; i < QTAVALIACOES; i++) {
		soma += this.avaliacoes[i];
	}
	return soma;
}

public boolean formado() {
	LocalDate hoje = LocalDate.now();
	Period periodo = Period.between(this.dataNascimento, hoje);
	return 24 > periodo.getYears();
}

@Override
public boolean menorQue(IOrdenavel outro) {
	if(outro instanceof Aluno) {
		Aluno outroAluno = (Aluno) outro;
		
		return this.matricula < outroAluno.matricula;
	}
	return false;
}

@Override
public boolean igual(IOrdenavel outro) {
	if(outro instanceof Aluno) {
		Aluno outroAluno = (Aluno) outro;
		
		return this.matricula == outroAluno.matricula;
	}
	return false;
}

public String getNome() {
	return this.nome;
}
}
