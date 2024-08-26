import java.util.Scanner;

public class ContaBancaria {
private int numero;
private String cpf;
private double limite;
private double saldo;

private boolean validarNumeroDaConta(int num) {
	if(num > 99999 || num < 10000) {
		return false;
	}else {
		return true;
	}
}

public ContaBancaria(int numero, String cpf, double limite, double saldo) {
	if(validarNumeroDaConta(numero)) {
		this.numero = numero;
	}else {
		this.numero = 0;
	}
	this.cpf = cpf;
	this.limite = limite;
	this.saldo = saldo;
}


public void sacar(double valor) {
	if(saldo >= valor) {
		saldo -= valor;
	}else if((saldo + limite) >= valor) {
		saldo -= valor;
	}else {
		System.out.println("Valor indisponivel para saque");
	}
}

public void depositar(double valor) {
	double resultado;
	
	if(saldo >= 0) {
		saldo += valor;
	}else {
		resultado = saldo*(-1)*0.03;
		saldo += valor - resultado;
	}
}

public String getInfo() {
	return "Numero: " + numero + "\nCPF: " + cpf + "\nlimite: " + limite + "\nSaldo: "  + saldo;
}

public static void main(String[] args) {
	ContaBancaria C = new ContaBancaria(50, "10215", 200.0, 150.2);
	
	double valor;
	
	Scanner teclado = new Scanner(System.in);
	System.out.println("Digite um valor para depositar: ");
	valor = teclado.nextDouble();
	
	C.depositar(valor);
	System.out.println(C.getInfo());
	
	System.out.println("Digite um valor para sacar: ");
	valor = teclado.nextDouble();
	
	teclado.close();
	
	C.sacar(valor);
	System.out.println(C.getInfo());
}

}
