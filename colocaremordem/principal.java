package colocaremordem;

import java.util.Scanner;

public class principal{
	public static void main(String[] args) {
		int numeros[] = new int[3];
		int temp;
		
		Scanner teclado = new Scanner(System.in);
		
		for(int i=0; i<3; i++) {
			System.out.println("Digite o numero: ");
			numeros[i] = teclado.nextInt();
		}
		
		teclado.close();
		
		for(int i = 0; i < 3-1; i++) {
			for(int j = 0; j < 3-1-i; j++) {
				if(numeros[j] > numeros[j + 1]) {
					temp  = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j + 1] = temp;
				}
			}
		}
		
		
		for(int i=0; i<3; i++) {
			System.out.println(numeros[i]);
		}
	}
}