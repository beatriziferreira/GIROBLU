
public abstract class Veiculo {
    private int codigo;
    private static int qtdVeiculos;
    private String status;
    private boolean estaEmUmaEstacao;

    public Veiculo() {
        this.status = "Disponível";
        qtdVeiculos ++;
        this.codigo = qtdVeiculos;
        this.estaEmUmaEstacao = false;
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
        estaEmUmaEstacao = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public abstract double taxaDesbloqueio();

    public abstract double valorPorMin();

    public String getStatus() {
        return status;
    }

    public void enviarManutenção(){
        status = "Em Manutenção";
    }

    public boolean isEstaEmUmaEstacao(){
        return estaEmUmaEstacao;
    }

    public void estaEmUmaEstacao(){
        estaEmUmaEstacao = true;
    }
    
}
