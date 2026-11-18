import java.time.LocalDateTime;

public class Viagem {
    private LocalDateTime inicio;
    private LocalDateTime termino;
    private Usuario usuario;
    private Veiculo veiculo;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private boolean emAndamento;

    public Viagem(LocalDateTime inicio, Usuario usuario, Veiculo veiculo, Estacao estacaoOrigem) {
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

    public void encerrar(LocalDateTime termino, Estacao destino) {
        this.emAndamento = false;
        this.termino = termino;
        this.estacaoDestino = destino;
        estacaoDestino.adicionarVeiculo(veiculo);
        System.out.println("Viagem finalizada em " + this.termino + " na estação " + estacaoDestino);
    }

    public void ViagemEmAndamento() {
        try {
            if (veiculo instanceof Recarregavel) {
                ((Recarregavel) veiculo).descontarBateria(duracaoTotal());
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getTermino() {
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
        int totalMin = termino.getMinute() - inicio.getMinute();
        return totalMin;
    }

    public double valorCobrado() {
        return 0;
    }

}
