
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
            System.out.println("O veículo já está em uso.");
            return false;
        } else if (status.equals("Em Manutenção")){
            System.out.println("O veículo está em manutenção.");
            return false;
        }
        status = "Em uso";
        return true;
    }

    public void finalizarUso() {
        if (status.equals("Disponível")) {
            System.out.println("O veículo não está em uso.");
        }
        status = "Disponível";
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
