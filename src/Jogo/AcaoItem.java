package Jogo;

import javax.swing.JOptionPane;
import Personagem.Membro;


public class AcaoItem {
    //Metodo estatico e encapsulamento
    public static void oferecerUsoKitMedico(Membro Jogador, Inventario inventario) {
        //Verificação de guarda: evita o uso desnecessario
        if (!inventario.temItem(Inventario.KIT_MEDICO)) {
            return;
        }
        if (Jogador.getVida() >= 100) {
            return;
        }
        String[] opcoes = {"Usar Kit Medico", "Guardar para depois"};

        int escolha = JOptionPane.showOptionDialog(null,
                "Você possui um Kit Médico.\n\n" +
                        "Vida atual: " + Jogador.getVida() + "/100\n\n" +
                        "Usar o kit recupera 40 pontos de vida,\n" +
                        "mas reduz 1 ponto de um atributo à sua escolha.\n\n" +
                        "Deseja usar agora?",
                "Kit Médico",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        if (escolha == 0) {
            //encapsulamento - logica de penalidade
            boolean penalidadeAplicada = escolherPenalidade(Jogador);

            if (!penalidadeAplicada) {
                JOptionPane.showMessageDialog(null,
                        "Você decidiu não usar o Kit Médico agora.",
                        "Kit Médico Guardado",
                        JOptionPane.PLAIN_MESSAGE);
                return;
            }

            Jogador.curar(40);
            inventario.removerItem(Inventario.KIT_MEDICO);

            JOptionPane.showMessageDialog(null,
                    "Você usou o Kit Médico.\n\n" +
                            "Vida recuperada: +40\n" +
                            "O item foi removido do inventário.\n\n" +
                            Jogador.getStatus(),
                    "Kit Médico Usado",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
    //Metodo estatico - acessado somente na propria classe
    private static boolean escolherPenalidade(Membro jogador) {

        String[] atributos = {"Furtividade", "Inteligência", "Argumentação"};

        while (true) {
            int escolha = JOptionPane.showOptionDialog(null,
                    """
                            Usar o Kit Médico exige tempo e concentração.
                            
                            Escolha qual atributo será reduzido em 1 ponto:""",
                    "Penalidade do Kit Médico",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    atributos,
                    atributos[0]);

            if (escolha == 0) {
                if (jogador.getFurtividade() > 0) {
                    jogador.reduzirFurtividade(1);
                    return true;
                }
            } else if (escolha == 1) {
                if (jogador.getInteligencia() > 0) {
                    jogador.reduzirInteligencia(1);
                    return true;
                }
            } else if (escolha == 2) {
                if (jogador.getArgumentacao() > 0) {
                    jogador.reduzirArgumentacao(1);
                    return true;
                }
            } else {
                return false;
            }

            JOptionPane.showMessageDialog(null,
                    "Esse atributo já está em 0.\n" +
                            "Escolha outro atributo para reduzir.",
                    "Atributo inválido",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}


