import java.util.ArrayList;

public class Estacao {
    private String nome;
    private int qtdVagas;
    ArrayList<Veiculo> veiculos = new ArrayList<>(qtdVagas);
    
    public Estacao(String nome, int qtdVagas) {
        this.nome = nome;
        this.qtdVagas = qtdVagas;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo == null){
            throw new IllegalArgumentException("Veículo inválido.");
        }
        if (veiculo.isEstaEmUmaEstacao()){
            System.out.println("O veículo já está em outra estação.");
        }
        if (veiculos.size() < qtdVagas) {
            veiculos.add(veiculo);
            veiculo.estaEmUmaEstacao();
            System.out.println("Veículo adicionado: " + veiculo.toString() + " na estação " + nome);
        } else {
            throw new IllegalStateException("Não há vagas disponíveis na estação " + nome);
        }

    }

    public void removerVeiculo(Veiculo veiculo) {
        if (veiculos.remove(veiculo)) {
            System.out.println("Veículo removido: " + veiculo.toString() + " da estação " + nome);
        } else {
            System.out.println("Veículo não encontrado na estação " + nome);
        }
    }
    
}
