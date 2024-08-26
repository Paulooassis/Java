package BibliotecaDeMidia;

public class Biblioteca {
private Midia midias[];
private int quantidadeDeMidias;

public Biblioteca() {
	midias = new Midia[100];
}

public void adicionarMidia(Midia midia) {
	if(quantidadeDeMidias > 100) {
		System.out.println("Midia esta cheia.");
	}else {
		midias[quantidadeDeMidias] = midia ;
		quantidadeDeMidias++;
	}
}

public void listarMidias() {
	if(quantidadeDeMidias == 0) {
		System.out.println("Nao possuem midias cadastradas.");
	}else {
		for(int i=0; i<quantidadeDeMidias; i++) {
			System.out.println(midias[i].getInfo() + "\n");
		}
	}
}

public int calcularDuracaoTotal() {
	int soma = 0;
	
	if(quantidadeDeMidias == 0) {
		return 0;
	}else {
		for(int i=0; i < quantidadeDeMidias; i++) {
			soma += midias[i].getDuracao();
		}
		return soma;
	}
}

}
