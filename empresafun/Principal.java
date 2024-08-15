package empresafun;

public class Principal{
	public static void main(String[] args) {
		Funcionario F[] = new Funcionario[10];
		
		for(int i=0; i<F.length; i++) {
			F[i] = new Funcionario();
			F[i].setInformacoes();
		}
		
		//VARIAVEIS DE CONTADORES
		
		int contarHomem = 0, contarMulher = 0, somarIdade = 0, somarIdadeMulheres = 0, somarIdadeHomens = 0;
		Double porcertagemMulheres, porcentagemHomens, mediaIdadeTotal, mediaIdadeHomens, mediaIdadeMulheres;
		
		
		for(int i=0; i<F.length; i++) {
			if(F[i].getSexo().equalsIgnoreCase("masculino")) {
				contarHomem++;
				somarIdadeHomens += F[i].getIdade();
			}else if(F[i].getSexo().equalsIgnoreCase("feminino")) {
				contarMulher++;
				somarIdadeMulheres += F[i].getIdade();
			}
			somarIdade += F[i].getIdade();
		}
		
		porcertagemMulheres = Funcionario.mediaPercentual(F.length, contarMulher);
		porcentagemHomens = Funcionario.mediaPercentual(F.length, contarHomem);
		mediaIdadeTotal = (double)somarIdade/F.length;
		mediaIdadeMulheres = (double)somarIdadeMulheres/contarMulher;
		mediaIdadeHomens = (double)somarIdadeHomens/contarHomem;
		
		System.out.println("O Total de funcionario e: " + F.length);
		System.out.println("Total de homens: " + contarHomem);
		System.out.println("Total de mulheres: " + contarMulher);
		System.out.println("Porcetual de homens: " + porcentagemHomens  + "%");
		System.out.println("Porcetual de mulheres: " + porcertagemMulheres + "%");
		System.out.println("A media de idade e: " + mediaIdadeTotal);
		System.out.println("A media de homens e: " + mediaIdadeHomens);
		System.out.println("A media de mulheres e: " + mediaIdadeMulheres);
	}
}