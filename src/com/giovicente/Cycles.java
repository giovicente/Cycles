package com.giovicente;

import java.util.Scanner;

public class Cycles {

    /*
    * Unicode Characters
    * https://en.wikipedia.org/wiki/Latin-1_Supplement
    * https://www.joelonsoftware.com/2003/10/08/the-absolute-minimum-every-software-developer-absolutely-positively-must-know-about-unicode-and-character-sets-no-excuses/
    * */

    public static void main(String[] args) {

        char continuation;
        Scanner scanner;
        String cycleWord;
        final String SECRET_SPOCK_STRING = "LIVELONGANDPROSPER";
        final int STAR_TREK_NUMBER_OF_EPISODES = 79;
        int lastPosition;

        do {
            // unicode \u00e1 == á
            System.out.print("Digite a palavra que formar\u00e1 o ciclo: ");
            scanner = new Scanner(System.in);
            cycleWord = scanner.next().toUpperCase();
            drawLine();

            /*
             * unicode \u00e7 == ç
             * unicode \u00e3 == ã
             * unicode \u00fa == ú
             * */
            System.out.print("Digite a posi\u00e7\u00e3o da \u00faltima letra: ");
            lastPosition = scanner.nextInt();
            drawLine();

            getAnswer(scanner);

            int wordLenght = cycleWord.length();
            // unicode \u00e9 == é
            System.out.println("O tamanho da palavra \u00e9: " + wordLenght);

            int remainder = lastPosition % wordLenght;
            // unicode \u00e9 == é
            System.out.println("O resto \u00e9 igual a " + remainder);

            // When the remainder is 0, the letter is in the last position
            if (remainder == 0) remainder = wordLenght;

            /*
            * unicode \u00e7 == ç
            * unicode \u00e3 == ã
            * unicode \u00e9 == é
            * */
            System.out.println("A letra da posi\u00e7\u00e3o " + lastPosition + " da String " + cycleWord + " \u00e9 " + cycleWord.charAt(remainder - 1));
            drawLine();

            continuation = getContinuation(scanner);

        } while (continuation == 'S');

        if (!(cycleWord.equals(SECRET_SPOCK_STRING) && lastPosition == STAR_TREK_NUMBER_OF_EPISODES)) {
            // unicode \u00f3 == ó
            System.out.println("Espero que tenha aproveitado o treino de l\u00f3gica!");
            drawLine();
        } else {
            drawSpock();
        }

        scanner.close();
    }

    private static void drawLine() {
        final int NUMBER_OF_DASHS = 59;
        int i = 0;

        for (System.out.print("* "); i <= NUMBER_OF_DASHS; i++) {
            System.out.print("-");
        }

        System.out.println(" *");
    }

    private static void getAnswer(Scanner scanner) {
        printAnswerInputMessage();
        char answer = Character.toUpperCase(scanner.next().charAt(0));
        drawLine();

        while (isInvalidAnswer(answer)) {
            printInvalidCharacterMessage();
            printAnswerInputMessage();
            answer = Character.toUpperCase(scanner.next().charAt(0));
            drawLine();
        }
    }

    private static void printAnswerInputMessage() {
        System.out.print("Deseja saber a resposta? [Aperte \"S\", e somente \"S\", seguido de ENTER para continuar]: ");
    }

    private static boolean isInvalidAnswer(char answer) {
        return (answer != 'S');
    }

    private static char getContinuation(Scanner scanner) {
        printContinuationInputMessage();
        char continuation = Character.toUpperCase(scanner.next().charAt(0));
        drawLine();

        while (isInvalidContinuation(continuation)) {
            printInvalidCharacterMessage();
            printContinuationInputMessage();
            continuation = Character.toUpperCase(scanner.next().charAt(0));
            drawLine();
        }

        return continuation;
    }

    private static void printContinuationInputMessage() {
        /*
         * unicode \u00e7 == ç
         * unicode \u00e3 == ã
         * */
        System.out.print("Deseja tentar com outra palavra e posi\u00e7\u00e3o? [S/N]: ");
    }

    private static boolean isInvalidContinuation(char continuation) {
        return (continuation != 'S' && continuation != 'N');
    }

    private static void printInvalidCharacterMessage() {
        // unicode \u00e1 == á
        System.out.println("Valor inv\u00e1lido. Por favor, digite um valor v\u00e1lido!");
        drawLine();
    }

    private static void drawSpock() {
        System.out.println(
                "                            .ss$$$$$$$$$$$$$$$ss.\n" +
                "                       .s$$$$$$$$$$$$$$$$$$$$$$$$$$ss.\n" +
                "                   .s$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$s\n" +
                "                 .$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$.\n" +
                "               .$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$s\n" +
                "             .$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$s.\n" +
                "            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n" +
                "          .$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n" +
                "          $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n" +
                "        .$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n" +
                "        $$$$$$$$$$$$$$$$$$$$                                  $$\n" +
                "        $$$$$$$$$$$$$$$$$$     .\n" +
                "       s$$$$$$$$$$$$$$$$$     sssss.                           s\n" +
                "      ss $$$$$$$$$$$$$$$          ssss                      ss$s\n" +
                "     sss   $$$$$$$$$$$            ssss$$$$ss              $$$$s.\n" +
                "    sssss   $$$$$$$$   s.      .sss$$$$$$$$sss      sss$$$$$$s\n" +
                "    ss$ssss  $$$$$$$  sss.  .ss$$$$$$ss$ss     .         s$$$$s.\n" +
                "    ss$s   s  $$$$$$ ss.ss           ..        ss           .sss\n" +
                "     ss   s $s $$$$$ ss..s.                   ss\n" +
                "      s ss$$$$s $$$$ ssssss.                 .ss\n" +
                "    ss     s$$$s $$$ ssssssssss..           ssss.              .\n" +
                "    ss      $$  s $$ ss..ss$$$$sss        .sssss              ..\n" +
                "     s      s$$ss  $ ssss.sss$$$sss       .sssss.     ss..\n" +
                "      s.     $     $ .sss . .ss$sss        .  sssssss...   ss$\n" +
                "        ss   sssss$$ ..ss   ...sssss            .sss.       s\n" +
                "          ss    $$ $ .ss..s .sssssss\n" +
                "            ss$$  $$  .ssssss .sssss              ..       $\n" +
                "                $$$$  .ss$$ssss...s.s        ..sss$$ssss.\n" +
                "               $$.$$$  .ss$$sss.. sss.    .ssss$$s..s$ss. s\n" +
                "               ss ssss  .sssssss...sss.      .ssss$$ss..  .\n" +
                "               ss  ssss   .ssssssss.sss.        .sss.\n" +
                "               ss    .ssss    .sssssssss.               s\n" +
                "               ss      .sssss.  .sssssss.s .. ..ss$s. .s\n" +
                "              ss         sssssss.  .sssssssssssss$$s. .ss\n" +
                "            $ss           ssssssss.   ..sssssssssss  .ss.\n" +
                "          $$$$.            .sssssssss.     ssssss ssss.$s\n" +
                "      s$$$$$$$$s.             ..ssssssssss......ssss. s$$$s\n" +
                "    .s$$$$$$$$$$$s.              .ssssssssssssssss. s$$$$$ss.\n" +
                "       s$$$$$$$$$$$$$$ss..          .ssssssssss. .s$$$$$$$$s\n" +
                "         s$$$$$$$$$$$$$$$$$$$ssss...   ...ss.. s$$$$$$$$$s\n" +
                "           s$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$s\n" +
                "              .s$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$s\n" +
                "                    .s$$$$$$$$$$$$$$$$$$$$$$$$$$$$$s\n" +
                "                          .s$$$$$$$$$$$$$$$$$$$$s\n" +
                "                                ..s$$$$$$$$$$s"
        );

        System.out.println(
                "  _      _           _                                       _ _____                                        \n" +
                " | |    (_)         | |                                     | |  __ \\                                      \n" +
                " | |     ___   _____| |     ___  _ __   __ _  __ _ _ __   __| | |__) | __ ___  ___ _ __   ___ _ __          \n" +
                " | |    | \\ \\ / / _ \\ |    / _ \\| '_ \\ / _` |/ _` | '_ \\ / _` |  ___/ '__/ _ \\/ __| '_ \\ / _ \\ '__|\n" +
                " | |____| |\\ V /  __/ |___| (_) | | | | (_| | (_| | | | | (_| | |   | | | (_) \\__ \\ |_) |  __/ |         \n" +
                " |______|_| \\_/ \\___|______\\___/|_| |_|\\__, |\\__,_|_| |_|\\__,_|_|   |_|  \\___/|___/ .__/ \\___|_|    \n" +
                "                                        __/ |                                     | |                       \n" +
                "                                       |___/                                      |_|                         "
        );
    }
}
