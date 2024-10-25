package INTERFACE;

import java.time.LocalDate;

public class Pedido implements IOrdenavel {
	private static final int max_comidas = 10;
	private int idPedido;
	private LocalDate dataPedido;
	private int quantComidas;
	private boolean encerrado;
	
	public Pedido(int idPedido, int quantComidas) {
		this.quantComidas = quantComidas;
		this.idPedido = idPedido;
		this.encerrado = false;
	}
	
	public boolean verificarTamanho() {
		return this.quantComidas < max_comidas;
	}
	
	public void encerrar() {
		this.encerrado = true;
	}
	
	@Override
	public boolean menorQue(IOrdenavel outro) {
		if(outro instanceof Pedido) {
			Pedido outroPedido = (Pedido) outro;
			
			return this.idPedido < outroPedido.idPedido;
		}
		return false;
	}

	@Override
	public boolean igual(IOrdenavel outro) {
		if(outro instanceof Pedido) {
			Pedido outroPedido = (Pedido) outro;
			
			return this.idPedido == outroPedido.idPedido;
		}
		return false;
	}
	
	public int getNumeroID() {
		return this.idPedido;
	}
}
