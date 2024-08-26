package veiculos;

public class principal{
	public static void main(String[] args) {
		Carro C = new Carro("Toyota" , "Corolla", 4, 3);
		Moto M = new Moto("Fiat" , "Toro", "V");
		
		C.imprimirInformacoes();
		M.imprimirInformacoes();
		
	}
}