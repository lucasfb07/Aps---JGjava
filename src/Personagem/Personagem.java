package Personagem;

public abstract class Personagem {

    // (Encapsulamento)
    private String nome;
    private int pontosDeVida;
    private int reputacao; // afeta qual final vai ter

    // METODO CONSTRUTO
    public Personagem(String nome, int pontosDeVida, int reputacao) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.reputacao = reputacao;
    }

    // Método Abstrato Cada Personagem agr é diferente
    public abstract void agir();

    // Get/Set
    public String getNome() { return nome; }
    public int getPontosDeVida() { return pontosDeVida; }
    public int getReputacao() { return reputacao; }

    public void setPontosDeVida(int pv) { this.pontosDeVida = pv; }
    public void setReputacao(int rep) { this.reputacao = rep; }
}