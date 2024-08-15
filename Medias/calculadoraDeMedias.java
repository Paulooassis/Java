package Medias;

import java.util.Scanner; 


public class calculadoraDeMedias {
private Double[] notas = new Double[3];
private String letra;

public calculadoraDeMedias() {
}

public void setNumero(Scanner teclado) {	
	for(int i=0; i<3; i++) {
		System.out.println("Digite o " + (i+1) + " nota: ");
		this.notas[i] = teclado.nextDouble();
	}
}

public Double mediaAritmetica() {
	Double soma = 0.0;
	
	for(int i=0; i<3; i++) {
		soma+= notas[i];
	}
	
	return soma/3;
}

public Double mediaPonderada() {
	Double soma = 0.0;
	
	soma += (notas[0]*5) + (notas[1]*3) + (notas[2]*2);
	
	return soma/10;
}

public void setLetra(Scanner teclado) {	
	System.out.println("Digite um letra: ");
	this.letra = teclado.next();
}

public String getLetra() {
	return this.letra;
}

public void imprimirInformacoes(Double valor) {
	System.out.println("A media e " + valor);
}

}
