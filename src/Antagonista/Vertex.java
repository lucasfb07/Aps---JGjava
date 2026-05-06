package Antagonista;

public final class Vertex {

    // Atributo Estático
    private static final String NOME_EMPRESA = "Vertex Corp";

    private final int nivelSeguranca;
    private boolean obraRealizada;

    // METODO CONSTRUTOR
    public Vertex() {
        this.nivelSeguranca = 80;
        this.obraRealizada = false;
    }

    public String getNome() { return NOME_EMPRESA; }
    public int getNivelSeguranca() { return nivelSeguranca; }
    public boolean isObraRealizada() { return obraRealizada; }
    public void setObraRealizada(boolean v) { this.obraRealizada = v; }
}