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

    

}
