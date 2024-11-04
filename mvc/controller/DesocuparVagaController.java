package mvc.controller;


import javax.swing.JOptionPane;

import mvc.dao.EstacionamentoDAO;
import mvc.model.Estacionamento;
import mvc.model.UsoDeVaga;
import mvc.view.DesocuparVagaView;

public class DesocuparVagaController {
    private EstacionamentoDAO estacionamentoDAO;
    private DesocuparVagaView view;
    private ListaDeEstacionamentosController lista;

    public DesocuparVagaController(ListaDeEstacionamentosController lista){
        this.view = new DesocuparVagaView();
        this.estacionamentoDAO = EstacionamentoDAO.getInstance();
        this.lista = lista;
    
        this.view.getBtnFiltrar().addActionListener((e)->{
            filtrar();
        });
    
        this.view.getBtnPagar().addActionListener((e)->{
            btnPagar();
        });
    
        this.view.setVisible(true);
    }

    public void filtrar(){
        String placa;

        placa = this.view.getTxtPlaca().getText();
        UsoDeVaga uso = estacionamentoDAO.pesquisarUsoDeVagaPorPlaca(placa);

    if (uso != null) {
        Estacionamento e = lista.getEstacionamentoSelecionado();

        UsoDeVaga novo = uso;
        novo.desocuparVaga();
    
    estacionamentoDAO.atualizarUsoDeVaga(e, uso, novo);
    
    double valorAPagar = uso.calcularCobranca();
    this.view.setValorAPagar(String.format("%.2f", valorAPagar));
    } else {
    JOptionPane.showMessageDialog(this.view, "Uso de vaga não encontrado para a placa informada.");
    }

    }

    public void btnPagar(){
        JOptionPane.showMessageDialog(view, "Pago com sucesso!");
        limparTela();

    }

    private void limparTela(){
        this.view.getTxtPlaca().setText("");
        this.view.setValorAPagar("");
    }
    
}
