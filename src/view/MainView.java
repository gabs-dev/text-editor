package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    public void init() {
        menu();
    }

    private void menu() {
        Scanner input = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("------------------------");
            System.out.println("          MENU          ");
            System.out.println("------------------------");
            System.out.println("1 - Ler arquivo");
            System.out.println("2 - Imprimir arquivo");
            System.out.println("3 - Salvar arquivo");
            System.out.println("0 - Encerrar programa");
            try {
                System.out.println("------------------------");
                System.out.print("Opção: ");
                option = input.nextInt();
                System.out.println("------------------------");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida!");
                menu();
            }
            switch (option) {
                case 1:
                    readFile();
                    break;
                case 2:
                    printFile();
                    break;
                case 3:
                    saveFile();
                    break;
                case 0:
                    System.out.println("Encerrando aplicação...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (option != 0);
    }

    private void readFile() {
    }

    private void printFile() {
    }

    private void saveFile() {
    }

}
