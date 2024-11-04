package mvc.controller;

import java.time.YearMonth;
import java.util.ArrayList;

import mvc.dao.EstacionamentoDAO;
import mvc.model.Estacionamento;
import mvc.view.*;
import mvc.model.*;
import java.util.List;

public class RankingClientesController {
    private RankingClientesView view;
    private EstacionamentoDAO estacionamentoDAO;
    private ListaDeEstacionamentosController lista;

    public RankingClientesController(ListaDeEstacionamentosController lista){
        this.lista = lista;
        this.estacionamentoDAO = EstacionamentoDAO.getInstance();
        this.view = new RankingClientesView();

        this.view.setVisible(true);

        this.view.getBtnFiltrar().addActionListener((e) -> {
            filtrar();
        });
    }

    public void filtrar(){
        Estacionamento estacionamento = lista.getEstacionamentoSelecionado();

        int mes = this.view.getMesEscolhido().getMonth() + 1; 
        int anoAtual = java.time.Year.now().getValue(); // Ano atual

        YearMonth yearMonth = YearMonth.of(anoAtual, mes);

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes = estacionamentoDAO.getRankingDeClientesPorMes(estacionamento, yearMonth);

        this.view.setlistaDeClientes(clientes);
    }

}
