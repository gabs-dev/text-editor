package view;

import model.entities.Stack;
import model.exceptions.StackException;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    private Scanner input = new Scanner(System.in);
    private Stack<String> text = null;

    public void init() {
        menu();
    }

    private void menu() {
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
                System.out.println("Entrada inválida. Digite apenas números.");
                break;
            }
            switch (option) {
                case 1:
                    readFile();
                    break;
                case 2:
                    printFile();
                    break;
                case 3:
                    try {
                        saveFile();
                    } catch (StackException e) {
                        e.printStackTrace();
                    }
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

    /** Método responsável por fazer a leitura de um arquivo a partir de um diretório informado pelo usuário.
     */
    private void readFile() {
        System.out.println("------------------------");
        System.out.println("       LER ARQUIVO      ");
        System.out.println("------------------------");
        System.out.print("Nome ou caminho do arquivo: ");
        String path = input.next();
        System.out.println("------------------------");
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line = "", text = "";
            line = bufferedReader.readLine();
            while(line != null) {
                text += line;
                line = bufferedReader.readLine();
            }
            System.out.println("Arquivo lido com sucesso");
            fillStack(text);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /** Método que imprime no console o conteúdo do arquivo que foi armazenado na pilha.
     * Já imprime de forma legível.
     */
    private void printFile() {
        System.out.println("------------------------");
        System.out.println("    IMPRIMIR ARQUIVO    ");
        System.out.println("------------------------");
        if (text == null || text.isEmpty())
            System.out.println("Não há conteúdo para ser exibido");
        else {
            try {
                System.out.println(text.reverseStack());
            } catch (StackException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /** Método responsável por salvar o conteúdo da pilha em um arquivo .txt.
     * Já salva de forma legível.
     * @throws StackException - Exceção caso a pilha esteja vazia.
     */
    private void saveFile() throws StackException {
        System.out.println("------------------------");
        System.out.println("     SALVAR ARQUIVO     ");
        System.out.println("------------------------");
        if (text == null || text.isEmpty())
            System.out.println("Não há conteúdo para ser salvo.");
        else {
            System.out.println("Para que o arquivo seja salvo corretamente\n" +
                    "é necessário ter \\, \\\\ (Windows) ou / (Linux)\ndepois da última pasta.");
            System.out.print("Informe o diretório para salvar o arquivo: ");
            String path = input.next();
            try {
                if (isDirectory(path)) {
                    System.out.print("Nome do arquivo: ");
                    String fileName = input.next();
                    fileName += ".txt";
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + fileName))) {
                        bw.write(text.reverseStack().toString());
                        System.out.println("Arquivo salvo com sucesso em:\n" + path + fileName);
                    } catch (IOException e) {
                        System.err.println("Falha ao slavar o arquivo.\n" + e.getMessage());
                    }
                } else {
                    System.out.println("Diretório inválido");
                    saveFile();
                }
            } catch (NullPointerException e) {
                System.out.println("Nenhum diretório foi informado");
            }
        }
    }

    /** Método responsável por percorrer todos os caracteres do arquivo de texto e fazer a inserção dos caracteres
     * na pilha. A inserção já é feita considerando as condições do editor de texto.
     * @param text Conteúdo que foi lido do arquivo.
     */
    private void fillStack(String text) {
        if (!text.equals("") || text != null) {
            this.text = new Stack<>();
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c == '#') {
                    try {
                        this.text.pop();
                    } catch (StackException e) {
                        e.printStackTrace();
                    }
                } else if (c == '\\') {
                    try {
                        String s;
                        do {
                            s = this.text.pop();
                            if (s.equals("\n"))
                                this.text.push("\n");
                        } while (!s.equals("\n"));
                    } catch (StackException e) {
                        e.printStackTrace();
                    }
                } else if (c == '*') {
                    this.text.push("\n");
                }
                else if (c == '~') {
                    break;
                } else {
                    this.text.push(String.valueOf(c));
                }
            }
        }
    }

    /** Metódo responsável por verificar se um diretório existe.
     * @param path Diretório que deseja ser verificado.
     * @return boolean - true caso o diretório exista e false caso não.
     */
    private boolean isDirectory(String path) {
        File directory = null;
        if (path != null)
            directory = new File(path);
        else
            throw new NullPointerException("The parameter can't be null");
        return (directory.isDirectory());
    }

}
