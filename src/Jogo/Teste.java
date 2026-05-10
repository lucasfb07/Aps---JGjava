package Jogo;

import javax.swing.JOptionPane;
import Personagem.Membro;

public class Teste {

    //Atributo Estático
    public static final String FURTIVIDADE  = "Furtividade";
    public static final String INTELIGENCIA = "Inteligência";
    public static final String ARGUMENTACAO = "Argumentação";
    public static final String EVIDENCIA    = "Evidência";

    private static final int DIFICULDADE_MINIMA = 1;
    private static final int DIFICULDADE_MAXIMA = 10;

    // Sobrecarga
    public static boolean realizarTeste(Membro jogador, int dificuldade, String descricao, String atributo) {

        dificuldade = ajustarDificuldade(dificuldade);

        int dado          = rolarDado();
        int bonusAtributo = getBonusAtributo(jogador, atributo);
        int bonusItem     = getBonusItem(jogador, atributo);
        int resultado     = dado + bonusAtributo + bonusItem;

        boolean sucesso = resultado >= dificuldade;

        JOptionPane.showMessageDialog(null,
                "TESTE DE HABILIDADE\n\n" +
                        "Ação: " + descricao + "\n\n" +
                        jogador.getStatus() + "\n\n" +
                        "Dado:                " + dado + "\n" +
                        "Bônus de atributo:  +" + bonusAtributo + " (" + (atributo == null ? "Nenhum" : atributo) + ")\n" +
                        "Bônus de item:      +" + bonusItem + "\n" +
                        "Resultado final:     " + resultado + "\n" +
                        "Dificuldade:         " + dificuldade + "\n\n" +
                        (sucesso ? " SUCESSO!" : " FALHA!"),
                "Teste de Habilidade",
                sucesso ? JOptionPane.PLAIN_MESSAGE : JOptionPane.WARNING_MESSAGE);

        return sucesso;
    }

    public static boolean realizarTesteComRisco(Membro jogador, int dificuldade, String descricao, int danoDeFalha, String atributo) {
        try {
            boolean sucesso = realizarTeste(jogador, dificuldade, descricao, atributo);

            if (!sucesso) {
                aplicarConsequenciaDeFalha(jogador, danoDeFalha);
            }

            return sucesso;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro inesperado durante o teste:\n\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Rola o dado de 1 a 10
    private static int rolarDado() {
        return (int)(Math.random() * 10) + 1;
    }


    private static int ajustarDificuldade(int dificuldade) {
        if (dificuldade < DIFICULDADE_MINIMA) return DIFICULDADE_MINIMA;
        return Math.min(dificuldade, DIFICULDADE_MAXIMA);
    }

    // Retorna o atributo base do personagem conforme o tipo de teste
    private static int getBonusAtributo(Membro jogador, String atributo) {
        if (atributo == null) return 0;
        return switch (atributo) {
            case FURTIVIDADE -> jogador.getFurtividade();
            case INTELIGENCIA -> jogador.getInteligencia();
            case ARGUMENTACAO -> jogador.getArgumentacao();
            default -> 0;
        };
    }

    // Retorna o bônus de item conforme o tipo de teste
    private static int getBonusItem(Membro jogador, String atributo) {
        if (atributo == null) return 0;
        return switch (atributo) {
            case FURTIVIDADE -> jogador.getBonusFurtividade();
            case INTELIGENCIA -> jogador.getBonusInteligencia();
            case ARGUMENTACAO -> jogador.getBonusArgumentacao();
            case EVIDENCIA -> jogador.getBonusEvidencia();
            default -> 0;
        };
    }

    // Aplica dano e verifica morte
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