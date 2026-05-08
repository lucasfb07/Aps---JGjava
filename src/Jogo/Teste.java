package Jogo;

import javax.swing.JOptionPane;
import Personagem.Membro;

public class Teste {

    // Faz um teste e retorna true (sucesso) ou false (falha)
    // dificuldade: número de 1 a 10 (quanto maior, mais difícil)
    public static boolean realizarTeste(Membro jogador, int dificuldade, String descricao) {

        int dado = (int)(Math.random() * 10) + 1; // 1 a 10
        int resultado = dado + jogador.getBonusItem();

        JOptionPane.showMessageDialog(null,
                " TESTE: " + descricao + "\n\n" +
                        jogador.getStatus() + "\n\n" +
                        "Dado: " + dado + "  +  Bônus: " + jogador.getBonusItem() +
                        "  =  " + resultado + "\n" +
                        "Dificuldade necessária: " + dificuldade,
                "Teste de Habilidade", JOptionPane.PLAIN_MESSAGE);

        return resultado >= dificuldade;
    }

    // Teste com consequência de dano em caso de falha parcial
    public static boolean realizarTesteComRisco(Membro jogador, int dificuldade,
                                                String descricao, int danoDeFalha) {
        boolean sucesso = realizarTeste(jogador, dificuldade, descricao);

        if (!sucesso) {
            boolean morreu = jogador.receberDano(danoDeFalha);

            JOptionPane.showMessageDialog(null,
                    "Você sofreu consequências da falha.\n" +
                            "Dano recebido: -" + danoDeFalha + " de vida\n\n" +
                            jogador.getStatus(),
                    morreu ? "Você foi a baixo..." : "Dano sofrido",
                    morreu ? JOptionPane.ERROR_MESSAGE : JOptionPane.WARNING_MESSAGE);

            if (morreu) {
                Finais.Finais.gameOverVidaZero();
            }
        }

        return sucesso;
    }
}
