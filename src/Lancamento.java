import java.time.LocalDate;
import java.time.LocalTime;

public class Lancamento {
    private LocalDate data;
    private LocalTime hora;
    private double valor;
    
    public Lancamento(LocalDate data, LocalTime hora, double valor) {
        this.data = data;
        this.hora = hora;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public double getValor() {
        return valor;
    }

}
