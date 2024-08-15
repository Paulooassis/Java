package prefeitura;

import java.util.Scanner; 

public class coletaDeDados {
	private Double salario;
	private int numero_filhos;
	
	public coletaDeDados() {
	}
	
	public coletaDeDados(Double salario, int numero_filhos) {
		this.salario = salario;
		this.numero_filhos = numero_filhos;
	}
	
	public void setInformacoes(Scanner teclado) {
		
		System.out.println("Digite o salario: ");
		salario = teclado.nextDouble();
		
		System.out.println("Digite o numero de filhos: ");
		numero_filhos = teclado.nextInt();
		
	}
	
	public Double getSalario() {
		return this.salario;
	}
	
	public int getNumeroDeFilhos() {
		return this.numero_filhos;
	}
	
	public Double calcularrenda(Double salario, int totaldepessoas) {
		return salario/totaldepessoas;
	}
}
