package verificarPar;

public class Principal{
	public static void main(String[] args) {
		parImpar N[] = new parImpar[10];
		int vetorA[] = new int[10];
		int ParImpar[] = new int[2];
		int contarPar = 0, contarImpar = 0;
		
		for(int i=0; i<10; i++) {
			N[i] = new parImpar();
			N[i].setNumero();
			vetorA[i] = N[i].getNumero();
		}

		for(int i=0; i<10; i++) {
			if(N[i].calcularParImpar(vetorA[i]) == 0) {
				contarPar++;
			}else {
				contarImpar++;
			}
		}
		
		ParImpar[0] = contarPar;
		ParImpar[1] = contarImpar;
		
		System.out.println("Possuem " + ParImpar[0] + " numero pares e " + ParImpar[1] + " numeros impares.");
	}
}