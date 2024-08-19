package InvertendoVetor;

import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
    	String fraseDesejada;
    	
    	Scanner teclado = new Scanner(System.in);
    	System.out.println("Digite a frase que deseja inverter: ");
    	fraseDesejada = teclado.nextLine();
    	
    	teclado.close();
    	
    	
        char[] frase = fraseDesejada.toCharArray();
        
        int contador = 0;
        boolean emPalavra = false;
        
        for (int i = 0; i < frase.length; i++) {; 
            if (frase[i] == ' ') {
               if (emPalavra) {
                  emPalavra = false;
                  contador++;
               }
            } else {
              emPalavra = true;
            }
        }
        
        if (emPalavra) {
            contador++;
        }
        
        int numPalavras = contador;
        
        char[][] palavras = new char[numPalavras][];
        int palavraIndex = 0;
        int inicio = 0;
        
        for (int i = 0; i <= frase.length; i++) {
            if (i == frase.length || frase[i] == ' ') {
                char[] palavra = new char[i - inicio];
                for (int k = 0; k < palavra.length; k++) {
                    palavra[k] = frase[inicio + k];
                }
                palavras[palavraIndex++] = palavra;
                inicio = i + 1;
            }
        }
        
        char[] resultado = new char[frase.length];
        int pos = 0;
        
        for (int i = palavras.length - 1; i >= 0; i--) {
            char[] palavra = palavras[i];
            for (int j = 0; j < palavra.length; j++) {
                resultado[pos++] = palavra[j];
            }
            if (i > 0) {
                resultado[pos++] = ' ';
            }
        }
        
        for (int i = 0; i < resultado.length; i++) {
            char c = resultado[i];
            System.out.print(c);
        }
    }
    
}
