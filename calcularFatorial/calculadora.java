package calcularFatorial;
import java.util.Scanner;

public class calculadora {
private int num1;

public calculadora() {
}

public calculadora(int num1) {
	this.num1 = num1;
}

public void setNumero() {
	Scanner teclado = new Scanner(System.in);
	
	System.out.println("Digite o numero: ");
	this.num1 = teclado.nextInt();
}

public int getNumero() {
	return num1;
}

public int fatorial(int numero) {
	if(numero == 1) {
		return 1;
	}
	return numero * fatorial(numero - 1);
}

}
