
public class Viagem {
    private int inicio;
    private int termino;
    private Usuario usuario;
    private Veiculo veiculo;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private boolean emAndamento;

    public Viagem(int inicio, Usuario usuario, Veiculo veiculo, Estacao estacaoOrigem) {
        this.inicio = inicio * 60; // Convertendo para minutos
        this.usuario = usuario;
        this.veiculo = veiculo;
        this.estacaoOrigem = estacaoOrigem;
    }

    public void iniciar() {
        if (veiculo.liberar()) {
            this.emAndamento = true;
            estacaoOrigem.removerVeiculo(veiculo);
            int minutos = 0;
            try {
                while (emAndamento) {
                    minutos ++;
                    if (veiculo instanceof Recarregavel) {
                        ((Recarregavel) veiculo).descontarBateria();
                    }
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                this.emAndamento = false;
                this.termino = this.inicio + (minutos * 60);
            }
        }
    }

    public void encerrar(int termino, Estacao destino) {
        this.emAndamento = false;
        this.termino = termino * 60; // Convertendo para minutos
        this.estacaoDestino = destino;
        estacaoDestino.adicionarVeiculo(veiculo);
        System.out.println("Viagem finalizada ás/ao " + this.termino + " na estação " + estacaoDestino);
    }

    public int getInicio() {
        return inicio;
    }

    public int getTermino() {
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
        int totalMinutos = termino - inicio;
        return totalMinutos;
    }

    public double valorCobrado() {
        return duracaoTotal() * veiculo.valorPorMin();
    }

}
