public class Usuario {
    private String nome;
    private String email;
    private Plano plano;
    private Carteira carteira;
   
    public Usuario(String nome, String email, Plano plano) {
        this.nome = nome;
        this.email = email;
        this.plano = plano;
        this.carteira = new Carteira();
    }

    public String getNome() {
        return nome;
    }

    public Plano getPlano() {
        return plano;
    }

    public String getEmail() {
        return email;
    }

    public int idCarteira() {
        return carteira.getId();
    }

}
