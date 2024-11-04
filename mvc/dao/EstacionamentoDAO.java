package mvc.dao;

import mvc.model.Cliente;
import mvc.model.Estacionamento;
import mvc.model.UsoDeVaga;
import mvc.model.Vaga;
import mvc.model.Veiculo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EstacionamentoDAO extends AbstractDAO<Estacionamento> implements Serializable {
    private static EstacionamentoDAO instance;

    // Construtor privado para implementação do Singleton
    private EstacionamentoDAO() {
        super("C:\\Users\\paulo\\Desktop\\JavaPark\\turmamanha-g1-equipe-cao-do-xumelabs\\codigo\\JavaParking\\src\\main\\java\\mvc\\data\\Estacionamentos.dat");
    }

    // Método Singleton para garantir uma única instância
    public static EstacionamentoDAO getInstance() {
        if (instance == null) {
            instance = new EstacionamentoDAO();
        }
        return instance;
    }

    public void adicionarEstacionamento(Estacionamento estacionamento) {
        cadastrar(estacionamento);  
    }

    public void removerEstacionamento(Estacionamento estacionamento) {
        remover(estacionamento);  
    }

    public void adicionarClienteAoEstacionamento(Estacionamento estacionamento, Cliente cliente) {
        estacionamento.ListaDeClientes().add(cliente); // Adiciona cliente ao estacionamento
        ClienteDAO.getInstance().cadastrar(cliente); // Persiste o cliente no arquivo .dat
        atualizar(estacionamento, estacionamento); // Atualiza o estacionamento no .dat
    }

    public void adicionarUsoDeVagaAoEstacionamento(Estacionamento estacionamento, UsoDeVaga usoDeVaga) {
        estacionamento.ListaDeUsoDeVagas().add(usoDeVaga);
        UsoDeVagaDAO.getInstance().cadastrar(usoDeVaga);
        atualizar(estacionamento, estacionamento);
    }

    public List<Estacionamento> listaDeEstacionamentos() {
        return listarTodos();  
    }

    public Vaga pesquisarVaga(String numero) {
        return listarTodos().stream()
                .flatMap(estacionamento -> estacionamento.ListaDeVagas().stream()) 
                .filter(vaga -> vaga.getNumeroVaga().equals(numero)) 
                .findFirst()
                .orElse(null); 
    }

    public UsoDeVaga pesquisarUsoDeVagaPorPlaca(String placa) {
        // Para cada estacionamento, procurar o uso da vaga baseado na placa do carro
        return listarTodos().stream()
                .flatMap(estacionamento -> estacionamento.ListaDeUsoDeVagas().stream()) // Obter todos os usos de vagas de todos os estacionamentos
                .filter(usoDeVaga -> usoDeVaga.getVeiculo().getPlaca().equals(placa)) // Filtrar pelo uso da vaga com o veículo que tem a placa correspondente
                .findFirst()
                .orElse(null); 
    }

    public List<Cliente> getRankingDeClientesPorMes(Estacionamento estacionamento, YearMonth mes) {
    // Mapa para armazenar o total gasto de cada cliente
    Map<Cliente, Double> totalGastosPorCliente = new HashMap<>();

    estacionamento.ListaDeUsoDeVagas().stream()
        
        .filter(uso -> YearMonth.from(uso.getData()).equals(mes))
        .forEach(uso -> {
            // Obtem o cliente associado ao veículo do uso de vaga
            Veiculo veiculo = uso.getVeiculo();
            Cliente cliente = buscarClientePorId(veiculo.getIdCliente());

            // Se o cliente já estiver no mapa, soma o valor, senão, inicializa com o valor atual
            totalGastosPorCliente.merge(cliente, uso.calcularCobranca(), Double::sum);
        });

    // Retorna a lista de clientes ordenada pelo total gasto (do maior para o menor)
    return totalGastosPorCliente.entrySet().stream()
        .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue())) // Ordena pelo valor gasto
        .map(Map.Entry::getKey) // Retorna apenas os clientes
        .collect(Collectors.toList());
}

// Método auxiliar para buscar o cliente por ID (você pode implementar isso em ClienteDAO)
    private Cliente buscarClientePorId(int clienteId) {
    // Implemente a lógica para buscar um cliente pelo ID (exemplo, usando ClienteDAO)
    return ClienteDAO.getInstance().pesquisarPorId(clienteId);
    }

        // Método para calcular o valor total arrecadado do estacionamento
        public double calcularValorTotalArrecadado(Estacionamento estacionamento) {
            return estacionamento.ListaDeUsoDeVagas().stream() // Obter a lista de usos de vaga do estacionamento
                    .mapToDouble(UsoDeVaga::calcularCobranca) // Calcular a cobrança para cada uso de vaga
                    .sum(); // Somar todos os valores
        }
        
    
        public double calcularValorArrecadadoNoMes(YearMonth mes) {
            return listarTodos().stream() // Lista todos os estacionamentos
                    .flatMap(estacionamento -> estacionamento.ListaDeUsoDeVagas().stream()) // Obter todos os usos de vaga
                    .filter(uso -> {
                        LocalDate dataUso = uso.getData(); // Obtém a data do uso
                        YearMonth usoMes = YearMonth.from(dataUso); // Converte LocalDate para YearMonth
                        return usoMes.equals(mes); // Filtra pelo mês
                    })
                    .mapToDouble(UsoDeVaga::calcularCobranca) // Calcular a cobrança para cada uso
                    .sum(); // Somar todos os valores
        }        
    
        public void atualizarUsoDeVaga(Estacionamento estacionamento, UsoDeVaga usoAntigo, UsoDeVaga usoNovo) {
            List<UsoDeVaga> listaUsos = estacionamento.ListaDeUsoDeVagas();
    
            int index = listaUsos.indexOf(usoAntigo); // Encontrar o índice do uso antigo
            if (index >= 0) {
                listaUsos.set(index, usoNovo); // Substituir o uso antigo pelo novo
                salvarObjetos(); // Persistir as alterações
            } else {
                // Se o uso não for encontrado, você pode lançar uma exceção ou registrar um log
                System.out.println("Uso de vaga não encontrado para atualização.");
            }
        }

        // Método para calcular o valor médio por cada uso de vaga
        public double calcularValorMedioPorUso() {
            return listarTodos().stream() // Lista todos os estacionamentos
                    .flatMap(estacionamento -> estacionamento.ListaDeUsoDeVagas().stream()) // Obter todos os usos de vaga
                    .mapToDouble(UsoDeVaga::calcularCobranca) // Calcular a cobrança para cada uso
                    .average() // Calcular a média
                    .orElse(0); // Se não houver valores, retorna 0
        }
    
        // Método para listar todos os usos de vaga em um determinado período
        public List<UsoDeVaga> ListaDeUsoDeVagasPorData(LocalDate dataInicio, LocalDate dataFim) {
            return listarTodos().stream() // Lista todos os estacionamentos
                    .flatMap(estacionamento -> estacionamento.ListaDeUsoDeVagas().stream()) // Obter todos os usos de vaga
                    .filter(uso -> !uso.getData().isBefore(dataInicio) && !uso.getData().isAfter(dataFim)) // Filtrar pelo período
                    .collect(Collectors.toList()); // Coletar os usos de vaga filtrados
        }

        public List<UsoDeVaga> listarUsoDeVagasPorClienteEData(Estacionamento estacionamento, int idCliente, LocalDate dataInicio, LocalDate dataFim) {
            return estacionamento.ListaDeUsoDeVagas().stream()
                .filter(uso -> uso.getVeiculo().getIdCliente() == idCliente) // Filtrar pelo cliente
                .filter(uso -> !uso.getData().isBefore(dataInicio) && !uso.getData().isAfter(dataFim)) // Filtrar pelo intervalo de datas
                .collect(Collectors.toList()); // Coletar os usos de vaga filtrados
        }        

    public void atualizarEstacionamento(Estacionamento estacionamentoAntigo, Estacionamento estacionamentoNovo) {
        atualizar(estacionamentoAntigo, estacionamentoNovo);  
    }
}
