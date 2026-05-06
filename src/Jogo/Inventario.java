package Jogo;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<String> itens;

    // (Método Construtor)
    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String item) {
        itens.add(item);
    }

    public boolean temItem(String item) {
        return itens.contains(item);
    }

    public String listarItens() {
        if (itens.isEmpty()) return "Inventário vazio.";
        return String.join(", ", itens);
    }
}