import java.time.LocalDate;
import java.time.LocalTime;

public class Carteira {
    private double saldo;
    private int id;

    public Carteira() {
        this.saldo = 0.0;
        this.id ++;
    }

    public void recarregarSaldo(LocalDate data, LocalTime hora, double valor){
        saldo += valor;
        System.out.println("Recarga de R$" + valor + "realizada em " + data + " às " + hora);
        System.out.println(saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }

    
}
