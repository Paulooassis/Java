package INTERFACE;

public class QUICKSORT {

	public void quicksort(IOrdenavel[] dados, int inicio, int fim) {
		if(inicio >= fim) {
			return;
		}
		else {
			int particao = particao(dados, inicio, fim);
			quicksort(dados, inicio, particao - 1);
			quicksort(dados, particao+1, fim);
		}
	}
	
	public int particao(IOrdenavel[] dados, int inicio, int fim) {
		int posicao = inicio - 1;
		IOrdenavel pivot = dados[fim];
		
		for(int i = inicio; i< fim; i++) {
			if(dados[i].menorQue(pivot)) {
				posicao++;
				trocar(dados, posicao, i);
			}
		}
		
		posicao++;
		trocar(dados, posicao, fim);
		return posicao;
	}
	
	public void trocar(IOrdenavel[] dados, int posA, int posB) {
		IOrdenavel temp = dados[posA];
		dados[posA] = dados[posB];
		dados[posB] = temp;
	}


}
