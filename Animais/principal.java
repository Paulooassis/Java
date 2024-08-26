package Animais;

public class principal{
	public static void main(String[] args) {
		Mamifero M = new Mamifero("camelo", 150, 4, "Amarelo", "Terra", 2.0, "mato");
		Peixe P = new Peixe("Tubarao", 300, 0, "Cinzento", "Mar", 1.5, "Putao");
		
		P.dadosPeixe();
		System.out.println("---------------------------");
		M.dadosMamifero();
	}
}