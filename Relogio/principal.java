package Relogio;

public class principal{
	public static void main(String[] args) {
		Horas h = new Horas(10, 52, 00);
		Horas h2 = new Horas(23, 51, 40);
		
		h.incrementar(11540, 's');
		
		if(h.validar() == false) {
			h.getInformacoes();
			System.out.println("Horas invalidas");
			return;
		}
		
		h.getInformacoes();
		System.out.println(h.estaNaFrente(h2));
	}
}