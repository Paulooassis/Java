package INTERFACE;

public class Main {
    public static void main(String[] args) {
    	
        IOrdenavel[] dados = new IOrdenavel[5];
        dados[0] = new Aluno(5, "João");
        dados[1] = new Aluno(2, "Ana");
        dados[2] = new Aluno(4, "Carlos");
        dados[3] = new Aluno(1, "Bruna");
        dados[4] = new Aluno(3, "Lucas");
        
        IOrdenavel[] pedidos = new IOrdenavel[7];
        pedidos[0] = new Pedido(5,8);
        pedidos[1] = new Pedido(9,8);
        pedidos[2] = new Pedido(12,8);
        pedidos[3] = new Pedido(1,8);
        pedidos[4] = new Pedido(4,8);
        pedidos[5] = new Pedido(5,8);
        pedidos[6] = new Pedido(6,8);
        
        QUICKSORT quicksort = new QUICKSORT();
        
        quicksort.quicksort(pedidos, 0, pedidos.length - 1);

        for (IOrdenavel pedido : pedidos) {
        	if(pedido instanceof Pedido) {
        		Pedido outro = (Pedido) pedido;
                System.out.println(outro.getNumeroID());	
        	}
        }
        
        QUICKSORT quicksort2 = new QUICKSORT();
        
        quicksort2.quicksort(dados, 0, dados.length - 1);

        for (IOrdenavel dado : dados) {
        	if(dado instanceof Aluno) {
        		Aluno outro = (Aluno) dado;
                System.out.println(outro.getNome());	
        	}
        }
    }
}
