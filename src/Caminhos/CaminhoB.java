package Caminhos;

import javax.swing.JOptionPane;
import Personagem.Membro;
import Jogo.Inventario;

public class CaminhoB {

    public static void executar(Membro jogador, Inventario inventario) {

        JOptionPane.showMessageDialog(null,
                "FRAUDE DIGITAL\n\n" +
                        "Você decide forjar documentos contra a Vertex.\n" +
                        "É arriscado. Se descobrirem, você é o criminoso.",
                "Raiz Zero", JOptionPane.PLAIN_MESSAGE);

        inventario.adicionarItem("Documentos Falsificados");
        jogador.setTemProvasFalsas(true);

        // Simula a perícia
        int sorte = (int)(Math.random() * 10);

        if (sorte <= 3) { // 40% de chance da fraude ser descoberta
            JOptionPane.showMessageDialog(null,
                    "A perícia detectou inconsistências nos documentos.\n\n" +
                            "Você está sendo processado por falsidade ideológica.",
                    "Fraude Descoberta", JOptionPane.ERROR_MESSAGE);

            Finais.Finais.gameOverFraude();

        } else {
            JOptionPane.showMessageDialog(null,
                    "Os documentos passaram pela análise inicial.\n\n" +
                            "Por enquanto, ninguém suspeitou.",
                    "Sucesso Temporário", JOptionPane.PLAIN_MESSAGE);

            Finais.Finais.caminhoB2(jogador, inventario);
        }
    }
}