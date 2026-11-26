import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        Estacao estacao = new Estacao("Vila Germânica", 20);
        Estacao estacao2 = new Estacao("FURB campus 1", 20);

        Veiculo v1 = new PatineteEletrico(60);
        Veiculo v2 = new Bicicleta();
        Veiculo v3 = new BicicletaEletrica(80);

        estacao.adicionarVeiculo(v1);
        estacao2.adicionarVeiculo(v2);
        estacao.adicionarVeiculo(v3);

        System.out.println(v1.getStatus());
        System.out.println(v2.getStatus());
        System.out.println(v3.getStatus());

        Usuario u1 = new Usuario("Carla", "carla@gmail.com");
        
        u1.getCarteira().adicionarRecarga(200);

        Viagem v = new Viagem(LocalTime.now(), u1, v2, estacao2);
        v.iniciar();
        v.encerrar(LocalTime.now().plusMinutes(12), estacao);

        try {
            u1.getCarteira().pagarViagem(v.valorCobrado());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Recarregue sua carteira para pagar a viagem.");
        }

        Usuario u2 = new Usuario("Ana", "ana@gmai.com");
        u2.mudarPlano(1);
        u2.getCarteira().adicionarRecarga(5);
        Viagem vi2 = new Viagem(LocalTime.now(), u2, v1, estacao);
        vi2.iniciar();
        vi2.encerrar(LocalTime.now().plusMinutes(25), estacao2);

        Usuario u3 = new Usuario("Bruno", "bruno@gmail.com");
        u3.mudarPlano(2);
        Viagem vi3 = new Viagem(LocalTime.now(), u3, v1, estacao);
        vi3.iniciar();
        vi3.encerrar(LocalTime.now().plusMinutes(20), estacao2);

        ((Recarregavel) v1).recarregar();
        Usuario u4 = new Usuario("Diego", "diego@gmail.com");
        u4.mudarPlano(1);
        Viagem vi4 = new Viagem(LocalTime.now(), u3, v1, estacao2);
        vi4.iniciar();
        vi4.encerrar(LocalTime.now().plusMinutes(10), estacao);

        Usuario u5 = new Usuario("Eduardo", "edu@gmail.com");
        u5.mudarPlano(2);
        Viagem vi5 = new Viagem(LocalTime.now(), u5, v2, estacao);
        vi5.iniciar();
        vi5.encerrar(LocalTime.now().plusMinutes(10), estacao2);

    }
}
