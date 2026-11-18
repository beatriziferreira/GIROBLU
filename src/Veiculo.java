
public abstract class Veiculo {
    private int codigo;
    private String descricao;
    private String status;
    private Usuario usuario;

    public Veiculo(String descricao) {
        this.descricao = descricao;
        this.status = "Disponível";
        this.codigo ++;
    }

    public boolean liberar(){
        if (status.equals("Em uso")){
            throw new IllegalStateException("O veículo já está em uso.");
        } else if (status.equals("Em Manutenção")){
            throw new IllegalStateException("O veículo está em manutenção.");
        }
        status = "Em uso";
        return true;
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

    public void enviarManutenção(){
        status = "Em Manutenção";
    }

    public Usuario getUsuario(){
        return usuario;
    }

    
}
