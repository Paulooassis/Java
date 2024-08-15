package verificarPar;
import java.util.Scanner;

public class parImpar {
private int numero;

public parImpar() {	
}

public parImpar(int numero){
	this.numero = numero;
}

public void setNumero() {
	Scanner teclado = new Scanner(System.in);
	
	System.out.println("Digite um numero: ");
	this.numero = teclado.nextInt();
}

public int getNumero() {
	return this.numero;
}

public int calcularParImpar(int numero) {
	if(numero % 2 == 0) {
		return 0;
	}else {
		return 1;
	}
}

}
