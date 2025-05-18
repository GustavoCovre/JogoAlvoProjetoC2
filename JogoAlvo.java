package Aplicativo;

import Entidades.Alvo;
import Entidades.AlvoBranco;
import Entidades.AlvoPreto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoAlvo {
    private List<Alvo> alvos = new ArrayList<>();
    private int maxTiros = 12;

    public void iniciarJogo() {
        Random rand = new Random();
        alvos.clear();
        Alvo.setQuantADestruir(3);

        while (alvos.size() < 5) {
            int x = rand.nextInt(4) + 1;
            int y = rand.nextInt(4) + 1;

            boolean posicaoOcupada = false;
            for (Alvo a : alvos) {
                if (a.getPosX() == x && a.getPosY() == y) {
                    posicaoOcupada = true;
                    break;
                }
            }
            if (posicaoOcupada) {
                continue;
            }

            if (alvos.size() < 2) {
                alvos.add(new AlvoBranco(x, y));
            } else {
                alvos.add(new AlvoPreto(x, y));
            }
        }

        System.out.println("Jogo iniciado com 2 alvos brancos e 3 alvos pretos.");
    }

    public void atira() {
        Scanner scanner = new Scanner(System.in);
        int tirosRestantes = maxTiros;

        while (tirosRestantes > 0 && Alvo.getQuantADestruir() > 0) {
            System.out.println("\nTiros restantes: " + tirosRestantes);
            System.out.print("Informe posição X do tiro (1-4): ");
            int tiroX = scanner.nextInt();
            System.out.print("Informe posição Y do tiro (1-4): ");
            int tiroY = scanner.nextInt();

            boolean acertou = false;
            Alvo alvoAcertado = null;

            for (Alvo alvo : alvos) {
                if (alvo.acerta(tiroX, tiroY)) {
                    acertou = true;
                    alvoAcertado = alvo;
                    break;
                }
            }

            if (acertou) {
                if (alvoAcertado instanceof AlvoBranco) {
                    System.out.println("Você acertou um Alvo Branco!");
                    int x = alvoAcertado.getPosX();
                    int y = alvoAcertado.getPosY();
                    alvos.remove(alvoAcertado);
                    alvos.add(new AlvoPreto(x, y));
                } else if (alvoAcertado instanceof AlvoPreto) {
                    System.out.println("Você acertou um Alvo Preto!");
                    alvos.remove(alvoAcertado);
                }
            } else {
                System.out.println("Você não acertou nenhum alvo.");
            }

            tirosRestantes--;

            if (Alvo.getQuantADestruir() <= 0) {
                System.out.println("Você venceu!");
                break;
            }
        }

        if (Alvo.getQuantADestruir() > 0) {
            System.out.println("Game Over.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        JogoAlvo jogo = new JogoAlvo();
        jogo.iniciarJogo();
        jogo.atira();
    }
}
