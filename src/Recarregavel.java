public interface Recarregavel {
    int bateriaAtual();
    void descontarBateria(int minutos);
    void recarregar();
}
