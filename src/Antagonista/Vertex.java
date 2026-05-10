package Antagonista;

public final class Vertex {

    // Atributo Estático

    private final int nivelSeguranca;

    // METODO CONSTRUTOR
    public Vertex() {
        this.nivelSeguranca = 80;
    }

    // Retorna bônus de dificuldade baseado no nível de segurança
    // Nível 80 = +2 de dificuldade em todos os testes
    public int getBonusDificuldade() {
        if (nivelSeguranca >= 90) return 3;
        if (nivelSeguranca >= 70) return 2;
        if (nivelSeguranca >= 50) return 1;
        return 0;
    }

}