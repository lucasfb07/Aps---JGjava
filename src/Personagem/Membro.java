package Personagem;

import javax.swing.JOptionPane;

// Herança
public class Membro extends Personagem {

    // Atributo específico do Membro
    private boolean temProvasReais;
    private boolean temProvasFalsas;
    private boolean foiPreso;

    // METODO CONSTRUTOR
    public Membro(String nome) {
        super(nome, 100, 50);
        this.temProvasReais = false;
        this.temProvasFalsas = false;
        this.foiPreso = false;
    }

    @Override
    public void agir() {
        JOptionPane.showMessageDialog(null,
                getNome() + " está em ação!",
                "Ação", JOptionPane.PLAIN_MESSAGE);
    }

    // Getters e Setters
    public boolean isTemProvasReais() { return temProvasReais; }
    public boolean isTemProvasFalsas() { return temProvasFalsas; }
    public boolean isFoiPreso() { return foiPreso; }

    public void setTemProvasReais(boolean v) { this.temProvasReais = v; }
    public void setTemProvasFalsas(boolean v) { this.temProvasFalsas = v; }
    public void setFoiPreso(boolean v) { this.foiPreso = v; }
}