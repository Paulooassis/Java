package Relogio;

public class Horas {
	private int hora;
	private int minutos;
	private int segundos;
	
	public Horas(int hora, int minutos, int segundos) {
		/*
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
		*/
		this.ajustar(hora, minutos, segundos);
	}
	
	public void ajustar(int hora, int minutos, int segundos) {
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	public Boolean validar() {
		return (hora < 24 && hora >= 0) && (minutos < 60 && minutos >= 0) && (segundos < 60 && segundos >= 0);
	}
	
	public void incrementar(int quantidade, char posicao) {
		switch(posicao) {
			case 'h':
				if((hora+quantidade) < 24) {
					hora += quantidade;
				}else {
					System.out.println("Hora maxima atingida");
				}
				break;
				
			case 'm':
				
				if((minutos+quantidade) < 60) {
					minutos += quantidade;
				}else{
					while((minutos += quantidade) >= 60) {
						hora++;
						minutos -= quantidade;
						quantidade -= 60;
					}
				}
				
				break;
			case 's':
				
				if((segundos + quantidade) < 60) {
					segundos += quantidade;
				}else {
					while((segundos += quantidade) >= 60) {
						minutos++;
						segundos -= quantidade;
						quantidade -= 60;
						if(minutos >= 60) {
							hora++;
							minutos -= 60;
						}
					}
				}
				
				break;
			default:
				System.out.println("Posicao invalida.");
				break;
		}
	}
	
	public Boolean estaNaFrente(Horas outra) {
		Boolean resposta = false;
		if(this.hora > outra.hora) resposta = true;
		if(this.hora == outra.hora && this.minutos > outra.minutos) resposta = true;
		if(this.hora == outra.hora && this.minutos == outra.minutos && this.segundos > outra.segundos) resposta = true;
	
		return resposta;
	}
	
	public void getInformacoes() {
		System.out.println("Sao " + hora + ":" + minutos + ":" + segundos);
	}
}
