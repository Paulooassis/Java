package mvc.controller;

import mvc.dao.EstacionamentoDAO;
import java.time.YearMonth;
import mvc.model.Estacionamento;
import mvc.view.ValorArrecadadoView;

public class ValorArrecadadoController {
    private ValorArrecadadoView view;
    private ListaDeEstacionamentosController lista;
    private EstacionamentoDAO estacionamentoDAO;

    // Modificando o construtor para receber a lista existente
    public ValorArrecadadoController(ListaDeEstacionamentosController lista) {
        this.view = new ValorArrecadadoView();
        this.estacionamentoDAO = EstacionamentoDAO.getInstance();
        this.lista = lista; 

        this.view.getBtnFiltrar().addActionListener((e) -> {
            filtrar();
        });

        this.view.setVisible(true);
    }

    public void filtrar(){
        Estacionamento estacionamentoUsado = lista.getEstacionamentoSelecionado();
        double valorTotal = estacionamentoDAO.calcularValorTotalArrecadado(estacionamentoUsado);

        this.view.setValorTotal(valorTotal);

        int mes = this.view.getDataEscolhida().getMonth() + 1; // Corrigido para 1 a 12
        int anoAtual = java.time.Year.now().getValue(); // Ano atual

// Cria o YearMonth corretamente
        YearMonth yearMonth = YearMonth.of(anoAtual, mes);

// Calcula o valor arrecadado no mês selecionado
        double valorMes = estacionamentoDAO.calcularValorArrecadadoNoMes(yearMonth);
        this.view.setValorMes(valorMes);

        double valorMedio = estacionamentoDAO.calcularValorMedioPorUso();
        this.view.setValorMedio(valorMedio);
    }
}
