package prefeitura;

import java.util.Scanner;

public class principal{
	public static void main(String[] args) {
		int quantidadeDePessoas;
		Double media = 0.0;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite quantas pessoas: ");
		quantidadeDePessoas = teclado.nextInt();
		
		
		coletaDeDados C[] = new coletaDeDados[quantidadeDePessoas];
		
		for(int i=0; i<quantidadeDePessoas; i++) {
				C[i].setInformacoes(teclado);
		}
		
		teclado.close();
		
		for(int i=0; i<quantidadeDePessoas; i++) {
			media += C[i].calcularrenda(C[i].getSalario(), quantidadeDePessoas);
		}
		
		System.out.println("A media e " + media);
	}
}