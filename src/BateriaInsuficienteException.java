public class BateriaInsuficienteException extends Throwable {
    BateriaInsuficienteException() {
        super();
        System.out.println("Bateria insuficiente para iniciar uma viagem. A bateria deve estar com 20% ou mais para liberar o veículo.");
    }
}
