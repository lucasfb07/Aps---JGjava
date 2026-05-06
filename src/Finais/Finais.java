package Finais;

import javax.swing.JOptionPane;
import Personagem.Membro;
import Jogo.Inventario;

public class Finais {

    // CAMINHO A1 — tem provas reais
    public static void caminhoA1(Membro jogador, Inventario inventario) {

        String[] opcoes = {"Entregar ao Ministério Público", "Vazar nas redes sociais"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Você tem o Relatório Real da Vertex.\n\n" +
                        "O que você vai fazer com ele?",
                "O que fazer?", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            finalBom(jogador);
        } else {
            finalNeutro();
        }
    }

    // CAMINHO A2 — foi preso
    public static void caminhoA2(Membro jogador) {

        String[] opcoes = {"Fazer acordo de delação", "Ficar em silêncio"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Você está detido na sede da Vertex.\n\n" +
                        "Um advogado da empresa entra na sala.\n" +
                        "O que você faz?",
                "Preso", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            gameOverPreso();
        } else {
            gameOverPreso();
        }
        // (A2 ainda pode ser expandido pelo grupo)
    }

    // CAMINHO B2 — documentos falsos não descobertos
    public static void caminhoB2(Membro jogador, Inventario inventario) {

        String[] opcoes = {"Chantagear a Vertex", "Vazar os documentos"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Você tem documentos falsos que podem incriminar a Vertex.\n\n" +
                        "O que você vai fazer?",
                "Decisão", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            finalMau();
        } else {
            gameOverFraude();
        }
    }

    // ── OS FINAIS ──

    public static void finalBom(Membro jogador) {
        JOptionPane.showMessageDialog(null,
                        //"FINAL BOM\n\n" +
                        "O Ministério Público abriu investigação.\n" +
                        "A obra foi embargada.\n" +
                        "A área preservada continua de pé.\n\n" +
                        "Você não ficou rico. Mas fez a coisa certa.",
                "FIM — Vitória", JOptionPane.PLAIN_MESSAGE);
    }

    public static void finalNeutro() {
        JOptionPane.showMessageDialog(null,
                        //"FINAL NEUTRO\n\n" +
                        "O vídeo viralizou em 2 horas.\n" +
                        "A Vertex parou as obras por pressão popular.\n" +
                        "Mas sem processo jurídico, podem recomeçar em qualquer momento.\n\n" +
                        "A luta continua.",
                "FIM — Neutro", JOptionPane.PLAIN_MESSAGE);
    }

    public static void finalMau() {
        JOptionPane.showMessageDialog(null,
                        //"FINAL MAU\n\n" +
                        "A Vertex pagou para você se calar.\n" +
                        "O shopping foi construído.\n" +
                        "A área preservada não existe mais.\n\n" +
                        "Você tem dinheiro. E uma consciência pesada.",
                "FIM — Derrota", JOptionPane.WARNING_MESSAGE);
    }

    public static void gameOverFraude() {
        JOptionPane.showMessageDialog(null,
                "GAME OVER\n\n" +
                        "A fraude foi descoberta.\n" +
                        "Você responde por falsidade ideológica.\n" +
                        "A Vertex saiu ilesa.\n" +
                        "A área foi destruída.",
                "GAME OVER", JOptionPane.ERROR_MESSAGE);
    }

    public static void gameOverPreso() {
        JOptionPane.showMessageDialog(null,
                "GAME OVER\n\n" +
                        "Você foi preso em flagrante.\n" +
                        "Sem as provas, ninguém acredita em você.\n" +
                        "A Vertex continuou tudo como planejado.",
                "GAME OVER", JOptionPane.ERROR_MESSAGE);
    }
}