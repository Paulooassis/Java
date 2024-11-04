package mvc.controller;

import mvc.dao.ClienteDAO;
import mvc.dao.EstacionamentoDAO;
import mvc.model.Estacionamento;
import mvc.model.UsoDeVaga;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import mvc.view.HistoricoUsoClienteView;

public class HistoricoUsoClienteController {
    private HistoricoUsoClienteView view;
    private EstacionamentoDAO estacionamentoDAO;
    private ClienteDAO clienteDAO;
    private ListaDeEstacionamentosController lista;

    public HistoricoUsoClienteController(ListaDeEstacionamentosController lista){
        this.lista = lista;
        this.estacionamentoDAO = EstacionamentoDAO.getInstance();
        this.clienteDAO = ClienteDAO.getInstance();
        this.view = new HistoricoUsoClienteView();

        this.view.btnFiltrar().addActionListener((e) -> {
            filtrar();
        });

        this.view.setVisible(true);
    }

    public void filtrar(){
        Object colunas[] = {"Nome", "Placa", "Valor Pago", "Data"};
DefaultTableModel tm = new DefaultTableModel(colunas, 0);

tm.setNumRows(0);
String str = this.view.getTxtIdCliente().getText();
int id = Integer.parseInt(str);

LocalDate dataInicio = view.getDataInicio().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
LocalDate dataFim = view.getDataFim().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

Estacionamento estacionamentoUsado = lista.getEstacionamentoSelecionado();

List<UsoDeVaga> usos = estacionamentoDAO.listarUsoDeVagasPorClienteEData(estacionamentoUsado, id, dataInicio, dataFim);

for (UsoDeVaga uso : usos) {
    // Pegar o nome do cliente a partir do ID do cliente
    String nomeCliente = clienteDAO.buscarNomePorId(uso.getVeiculo().getIdCliente());
    String placa = uso.getVeiculo().getPlaca();
    double valorPago = uso.calcularCobranca(); // Método que retorna o valor pago
    LocalDate data = uso.getData();
    
    // Adicionar os dados na tabela
    tm.addRow(new Object[]{nomeCliente, placa, valorPago, data.toString()});
}

view.getTbCliente().setModel(tm);

}

}
