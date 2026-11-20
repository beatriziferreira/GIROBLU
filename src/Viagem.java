
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
        }

    }

    public void encerrar(int termino, Estacao destino) {
        this.emAndamento = false;
        this.termino = termino * 60; // Convertendo para minutos
        this.estacaoDestino = destino;
        int minutos = duracaoTotal();
            try {
                if (veiculo instanceof Recarregavel) {
                    ((Recarregavel) veiculo).descontarBateria(minutos);
                }
            } catch (IllegalStateException e) {
                System.out.println("Aviso: " + e.getMessage());
            }
        estacaoDestino.adicionarVeiculo(veiculo);
        System.out.println("Viagem finalizada ás/ao " + this.termino + " com o valor de R$ " + valorCobrado());
        try {
            usuario.getCarteira().pagarViagem(valorCobrado());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Recarregue sua carteira para pagar a viagem.");
        }
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
        int minutos = duracaoTotal();
        return usuario.getPlano().calcularValor(veiculo, minutos);  
    }

}
