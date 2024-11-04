package mvc.controller;

import javax.swing.JOptionPane;

import mvc.dao.EstacionamentoDAO;
import mvc.dao.UsoDeVagaDAO;
import mvc.dao.VagaDAO;
import mvc.model.Estacionamento;
import mvc.model.UsoDeVaga;
import mvc.model.Vaga;
import mvc.model.VagaDefault;
import mvc.model.VagaIdoso;
import mvc.model.VagaPcd;
import mvc.model.VagaVip;
import mvc.model.Veiculo;
import mvc.view.EstacionarCarroView;

public class EstacionarCarrroController {
    private EstacionarCarroView view;
    private ListaDeEstacionamentosController lista;
    private EstacionamentoDAO estacionamentoDAO;

    // Modificando o construtor para receber a lista existente
    public EstacionarCarrroController(ListaDeEstacionamentosController lista) {
        this.view = new EstacionarCarroView();
        this.estacionamentoDAO = EstacionamentoDAO.getInstance();
        this.lista = lista; // Inicializa com a instância existente

        this.view.btnEstacionar().addActionListener((e) -> {
            estacionar();
        });

        this.view.setVisible(true);
    }

    public void estacionar() {
        String IdCliente = view.getTxtIdCliente().getText();
        String Placa = view.getTxtPlaca().getText();
        String numeroVaga = view.getTxtNumeroVaga().getText();

        int id = Integer.parseInt(IdCliente);

        Vaga vaga = estacionamentoDAO.pesquisarVaga(numeroVaga);
        Veiculo veiculo = new Veiculo(Placa, id);

        if (vaga != null) {
            Estacionamento estacionamentoUsado = lista.getEstacionamentoSelecionado();

            UsoDeVaga u;

            if (vaga instanceof VagaDefault) {
                u = new UsoDeVaga(veiculo, new VagaDefault(numeroVaga));
            } else if (vaga instanceof VagaIdoso) {
                u = new UsoDeVaga(veiculo, new VagaIdoso(numeroVaga));
            } else if (vaga instanceof VagaVip) {
                u = new UsoDeVaga(veiculo, new VagaVip(numeroVaga));
            } else if (vaga instanceof VagaPcd) {
                u = new UsoDeVaga(veiculo, new VagaPcd(numeroVaga));
            } else {
                JOptionPane.showMessageDialog(view, "Tipo de vaga não encontrado!");
                return;
            }

            estacionamentoDAO.adicionarUsoDeVagaAoEstacionamento(estacionamentoUsado, u);
            JOptionPane.showMessageDialog(view, "Estacionado com sucesso!");

            limparTela();
        } else {
            JOptionPane.showMessageDialog(view, "Vaga não encontrada!");
        }
    }

    public void limparTela() {
        this.view.getTxtIdCliente().setText("");
        this.view.getTxtNumeroVaga().setText("");
        this.view.getTxtPlaca().setText("");
    }
}

