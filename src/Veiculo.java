public abstract class Veiculo {
    private int codigo;
    private String descricao;
    private String status;

    public Veiculo(String descricao) {
        this.descricao = descricao;
        this.codigo ++;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract double taxaDesbloqueio();

    public abstract double valorPorMin();

    public String getStatus() {
        return status;
    }

    

    
}
