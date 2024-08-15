package Medias;

import java.util.Scanner; 

public class principal{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		calculadoraDeMedias C = new calculadoraDeMedias();
		
		C.setLetra(teclado);
		
		if(C.getLetra().equalsIgnoreCase("A")) {
			C.setNumero(teclado);
			C.imprimirInformacoes(C.mediaAritmetica());
		}else if(C.getLetra().equals("P")) {
			C.setNumero(teclado);
			C.imprimirInformacoes(C.mediaPonderada());
		}else {
			System.out.println("Letra inválida.");
		}
		
		teclado.close();
	}
}