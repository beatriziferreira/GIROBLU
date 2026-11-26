import java.time.LocalDate;
import java.time.LocalTime;

public class Recarga {
    private LocalDate data;
    private LocalTime hora;
    private double valor;
    
    public Recarga(LocalDate data, LocalTime hora, double valor) {
        if (valor <= 0){
            throw new IllegalArgumentException("Valor da recarga deve ser maior que zero.");
        }
        if (data == null || hora == null){
            throw new IllegalArgumentException("Data e hora da recarga não podem ser nulas.");
        }
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
