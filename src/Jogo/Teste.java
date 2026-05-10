package Jogo;

import javax.swing.JOptionPane;
import Personagem.Membro;

public class Teste {
    public static final String FURTIVIDADE = "Furtividade";
    public static final String INTELIGENCIA = "Inteligência";
    public static final String ARGUMENTACAO = "Argumentação";

    private static final int DIFICULDADE_MINIMA = 1;
    private static final int DIFICULDADE_MAXIMA = 10;

    // Sobrecarga - teste antigo sem atributo específico
    public static boolean realizarTeste(Membro jogador, int dificuldade, String descricao) {
        return realizarTeste(jogador, dificuldade, descricao, null);
    }

    // Sobrecarga - teste usando atributo específico
    public static boolean realizarTeste(Membro jogador, int dificuldade, String descricao, String atributo) {

        dificuldade = ajustarDificuldade(dificuldade);

        int dado = rolarDado();
        int bonusItem = jogador.getBonusItem();
        int bonusAtributo = getBonusAtributo(jogador, atributo);
        int resultado = dado + bonusItem + bonusAtributo;

        boolean sucesso = resultado >= dificuldade;

        JOptionPane.showMessageDialog(null,
                "TESTE DE HABILIDADE\n\n" +
                        "Ação: " + descricao + "\n\n" +
                        jogador.getStatus() + "\n\n" +
                        "Dado: " + dado + "\n" +
                        "Bônus de item: +" + bonusItem + "\n" +
                        "Atributo usado: " + (atributo == null ? "Nenhum" : atributo) + "\n" +
                        "Bônus do atributo: +" + bonusAtributo + "\n" +
                        "Resultado final: " + resultado + "\n" +
                        "Dificuldade necessária: " + dificuldade + "\n\n" +
                        (sucesso ? "SUCESSO!" : "FALHA!"),
                "Teste de Habilidade",
                sucesso ? JOptionPane.PLAIN_MESSAGE : JOptionPane.WARNING_MESSAGE);

        return sucesso;
    }

    // Sobrecarga - teste com risco sem atributo específico
    public static boolean realizarTesteComRisco(Membro jogador, int dificuldade,
                                                String descricao, int danoDeFalha) {
        return realizarTesteComRisco(jogador, dificuldade, descricao, danoDeFalha, null);
    }

    // Tratamento de Exceções - teste com risco e atributo específico
    public static boolean realizarTesteComRisco(Membro jogador, int dificuldade,
                                                String descricao, int danoDeFalha,
                                                String atributo) {
        try {
            boolean sucesso = realizarTeste(jogador, dificuldade, descricao, atributo);

            if (!sucesso) {
                aplicarConsequenciaDeFalha(jogador, danoDeFalha);
            }

            return sucesso;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro inesperado durante o teste:\n\n" + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private static int rolarDado() {
        return (int) (Math.random() * 10) + 1;
    }

    private static int ajustarDificuldade(int dificuldade) {
        if (dificuldade < DIFICULDADE_MINIMA) return DIFICULDADE_MINIMA;
        if (dificuldade > DIFICULDADE_MAXIMA) return DIFICULDADE_MAXIMA;
        return dificuldade;
    }

    private static int getBonusAtributo(Membro jogador, String atributo) {
        if (atributo == null) return 0;

        if (atributo.equals(FURTIVIDADE)) {
            return jogador.getFurtividade();
        }

        if (atributo.equals(INTELIGENCIA)) {
            return jogador.getInteligencia();
        }

        if (atributo.equals(ARGUMENTACAO)) {
            return jogador.getArgumentacao();
        }

        return 0;
    }

    private static void aplicarConsequenciaDeFalha(Membro jogador, int danoDeFalha) {
        if (danoDeFalha <= 0) return;

        boolean morreu = jogador.receberDano(danoDeFalha);

        JOptionPane.showMessageDialog(null,
                "Você sofreu consequências da falha.\n\n" +
                        "Dano recebido: -" + danoDeFalha + " de vida\n\n" +
                        jogador.getStatus(),
                morreu ? "Vida zerada" : "Dano sofrido",
                morreu ? JOptionPane.ERROR_MESSAGE : JOptionPane.WARNING_MESSAGE);

        if (morreu) {
            Finais.Finais.gameOverVidaZero();
        }
    }
}
