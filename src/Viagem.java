
import java.time.LocalTime;

public class Viagem {
    private LocalTime inicio;
    private LocalTime termino;
    private Usuario usuario;
    private Veiculo veiculo;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private boolean emAndamento;

    public Viagem(LocalTime inicio, Usuario usuario, Veiculo veiculo, Estacao estacaoOrigem) {
        this.inicio = inicio; 
        this.usuario = usuario;
        this.veiculo = veiculo;
        this.estacaoOrigem = estacaoOrigem;
    }

    public void iniciar() {
        if (veiculo.liberar()) {
            this.emAndamento = true;
            estacaoOrigem.removerVeiculo(veiculo);
        }

    }

    public void encerrar(LocalTime termino, Estacao destino) {
        this.emAndamento = false;
        this.termino = termino; 
        this.estacaoDestino = destino;
        veiculo.finalizarUso();
        int minutos = duracaoTotal();
            try {
                if (veiculo instanceof Recarregavel) {
                    ((Recarregavel) veiculo).descontarBateria(minutos);
                }
            } catch (IllegalStateException e) {
                System.out.println("Aviso: " + e.getMessage());
            }
        estacaoDestino.adicionarVeiculo(veiculo);
        System.out.println("Viagem finalizada ás/ao " + this.termino.getHour() + ":" + this.termino.getMinute() + " com o valor de R$ " + String.format("%.2f", valorCobrado()) + " e duração de " + duracaoTotal() + " minutos.");

        
    }
    
    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getTermino() {
        return termino;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Estacao getEstacaoOrigem() {
        return estacaoOrigem;
    }

    public Estacao getEstacaoDestino() {
        return estacaoDestino;
    }

    public boolean isEmAndamento() {
        return emAndamento;
    }

    public int duracaoTotal() {
        int totalMinutos = termino.getMinute() - inicio.getMinute() + (termino.getHour() - inicio.getHour()) * 60;
        return totalMinutos;
    }

    public double valorCobrado() {
        int minutos = duracaoTotal();
        return usuario.getPlano().calcularValor(veiculo, minutos);  
    }

}
