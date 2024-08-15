package calcularFatorial;

public class Principal{
	public static void main(String[] args) {
		calculadora C[] = new calculadora[15];
		int vetorA[] = new int[15];
		int vetorB[] = new int[15];
		
		for(int i=0; i<15; i++) {
			C[i] = new calculadora();
			C[i].setNumero();
			vetorA[i] = C[i].getNumero();
		}
		
		for(int i=0; i<15; i++) {
			vetorB[i] = C[i].fatorial(vetorA[i]);
		}
		
		for(int i=0; i<15; i++) {
			System.out.println("O fatorial de " + vetorA[i] + " e " + vetorB[i]);
		}
	}
}