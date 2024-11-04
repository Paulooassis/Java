package mvc.controller;

import mvc.dao.ClienteDAO;
import mvc.dao.EstacionamentoDAO;
import mvc.model.Cliente;
import mvc.model.Estacionamento;
import mvc.view.CadastrarClienteView;
import javax.swing.JOptionPane;

public class CadastrarClienteController {
private ClienteDAO clienteDAO;
private CadastrarClienteView view;
private ListaDeEstacionamentosController lista;
private EstacionamentoDAO estacionamentoDAO;

public CadastrarClienteController(ListaDeEstacionamentosController lista){
    this.clienteDAO = ClienteDAO.getInstance();
    this.view = new CadastrarClienteView();
    this.estacionamentoDAO = EstacionamentoDAO.getInstance();
    this.lista = lista;

    this.view.btnCadastrarCliente().addActionListener((e) -> {
        addCliente();
    });

    this.view.setVisible(true);
}

public void addCliente(){

    if(this.view.btnAnonimo().isSelected()){
        Cliente c = new Cliente();
        clienteDAO.cadastrarCliente(c);

        Estacionamento estacionamentoUsado = lista.getEstacionamentoSelecionado();
        estacionamentoDAO.adicionarClienteAoEstacionamento(estacionamentoUsado, c);

        System.out.println(c.getNome() + c.getIdentificador());
        
        JOptionPane.showMessageDialog(view, "ID = " + c.getIdentificador());
        JOptionPane.showMessageDialog(view, "Cliente Anonimo salvo com sucesso!");

        limparTela();
        view.btnAnonimo().setSelected(false);
    }else{
        String nome = this.view.getNome().getText();
        Cliente c = new Cliente(nome);
        clienteDAO.cadastrarCliente(c);

        System.out.println(c.getNome() + c.getIdentificador());
        
        JOptionPane.showMessageDialog(view, "ID = " + c.getIdentificador());
        JOptionPane.showMessageDialog(view, "Cliente salvo com sucesso!");
        limparTela();
    }
}

private void limparTela() {
    try {
        this.view.getNome().setText("");
    } catch (Exception e) {
        System.err.println("Erro ao limpar campos: " + e.getMessage());
    }
}
}
