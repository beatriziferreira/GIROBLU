
import java.time.LocalTime;

public class Viagem {
    private LocalTime inicio;
    private LocalTime termino;
    private Usuario usuario;
    private Veiculo veiculo;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private boolean emAndamento;
    private boolean finalizada;

    public Viagem(LocalTime inicio, Usuario usuario, Veiculo veiculo, Estacao estacaoOrigem) {
        this.inicio = inicio; 
        this.usuario = usuario;
        this.veiculo = veiculo;
        this.estacaoOrigem = estacaoOrigem;
    }

    public void iniciar() {
        if (finalizada) {
            throw new IllegalStateException("A viagem já foi finalizada.");
        }
        try {
            if (veiculo.liberar()) {
                estacaoOrigem.removerVeiculo(veiculo);
                emAndamento = true;
                System.out.println("Viagem iniciada ás/ao " + this.inicio.getHour() + ":" + this.inicio.getMinute() + " com o veículo " + veiculo.toString() + " pelo usuário " + usuario.getNome() + " na estação " + estacaoOrigem.getNome());
            } else {
                System.out.println("Não foi possível iniciar a viagem. O veículo não pôde ser liberado.");
            }
        } catch (BateriaInsuficienteException e) {
            System.out.println(e.getMessage());
        }
       
    }

    public void encerrar(LocalTime termino, Estacao destino) {
        if (!emAndamento){
            throw new IllegalStateException("A viagem não está em andamento.");
        }
        if (termino == null || destino == null){
            throw new IllegalArgumentException("Termino e/ou destino não podem ser nulos.");
        }
        this.emAndamento = false;
        this.finalizada = true;
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
            
        estacaoDestino.adicionarVeiculo(veiculo);
        System.out.println("Viagem finalizada ás/ao " + this.termino.getHour() + ":" + this.termino.getMinute() + " com o valor de R$ " + String.format("%.2f", valorCobrado()) + " e duração de " + duracaoTotal() + " minutos.");
    }

        
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
