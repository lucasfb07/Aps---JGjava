package Jogo;

import Personagem.Membro;

import javax.swing.*;
import java.util.ArrayList;

public class Inventario {

    // Atributo Estático / Atributo Final
    public static final String RADIO_COMUNICADOR = "Rádio Comunicador";
    public static final String CREDENCIAL_FALSA  = "Credencial Falsa";
    public static final String PENDRIVE_HACKER   = "Pendrive Hacker";
    public static final String GRAVADOR          = "Gravador";
    public static final String KIT_MEDICO        = "Kit Médico";
    public static final String RELATORIO_REAL    = "Relatório Real da Vertex";
    public static final String DOCUMENTOS_FALSOS = "Documentos Falsificados";

    // Encapsulamento
    private ArrayList<String> itens;

    // Método Construtor
    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String item, Membro jogador) {
        itens.add(item);

        String descricao = "";
        String efeito = "";

        switch (item) {
            case RADIO_COMUNICADOR:
                jogador.aumentarBonusItem(2);
                descricao = "Aparelho de comunicação com sua equipe da ONG.";
                efeito = "+2 nos testes gerais durante a missão.";
                break;

            case CREDENCIAL_FALSA:
                jogador.aumentarBonusItem(3);
                descricao = "Crachá com identidade forjada de funcionário da Vertex.";
                efeito = "+3 nos testes de entrada e diálogo.";
                break;

            case PENDRIVE_HACKER:
                jogador.aumentarBonusItem(3);
                descricao = "Dispositivo com ferramentas de invasão digital da ONG.";
                efeito = "+3 nos testes digitais.";
                break;

            case GRAVADOR:
                jogador.aumentarBonusItem(2);
                descricao = "Gravador de áudio disfarçado de caneta.";
                efeito = "+2 nos testes para obter evidências.";
                break;

            case KIT_MEDICO:
                descricao = "Kit de primeiros socorros preparado pela ONG.";
                efeito = "Pode ser usado antes de escolhas importantes para recuperar vida, mas reduz 1 atributo.";
                break;

            case RELATORIO_REAL:
                descricao = "Documento verdadeiro escondido pela Vertex.";
                efeito = "Desbloqueia decisões com provas reais.";
                break;

            case DOCUMENTOS_FALSOS:
                descricao = "Documentos falsificados contra a Vertex.";
                efeito = "Pode incriminar a empresa, mas existe risco de perícia descobrir a fraude.";
                break;

            default:
                descricao = "Item registrado no inventário.";
                efeito = "Efeito definido pela história.";
                break;
        }

        JOptionPane.showMessageDialog(null,
                "ITEM OBTIDO\n\n" +
                        item + "\n\n" +
                        descricao + "\n\n" +
                        "Efeito: " + efeito + "\n\n" +
                        jogador.getStatus(),
                "Novo Item", JOptionPane.PLAIN_MESSAGE);
    }

    // Sobrecarga - versão sem jogador para itens sem efeito imediato
    public void adicionarItem(String item) {
        itens.add(item);
    }

    public boolean temItem(String item) {
        return itens.contains(item);
    }

    public void removerItem(String item) {
        itens.remove(item);
    }

    public String listarItens() {
        if (itens.isEmpty()) return "Inventário vazio.";
        return String.join(", ", itens);
    }
}
