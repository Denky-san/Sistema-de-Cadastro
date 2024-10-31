package Controller;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do{
            try {
        System.out.println("\nSeja Bem vindo ao nosso sistema de cadastro! O que Deseja fazer hoje?\n"+
                "1 - Cadastrar o usuário\n" +
                "2 - Listar todos usuários cadastrados\n"+
                "3 - Cadastrar nova pergunta no formulário\n"+
                "4 - Deletar pergunta do formulário\n"+
                "5 - Pesquisar usuário por nome ou idade ou email\n"+
                "6 - Sair\n"+
                "Escolha uma opção: ");

                escolha = scanner.nextInt();
                scanner.nextLine();

        switch (escolha) {
            case 1:
                 new cadastrarUsuario();
                break;
            case 2:
                new listarUsuarios();
                break;
            case 3:
                new cadastrarPergunta();
                break;
            case 4:
                new deletarPergunta();
                break;
            case 5:
                new buscarUsuario();
                break;
            case 6:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.nextLine(); // Consome a entrada inválida para evitar loop infinito
            }
        } while (escolha != 6);

        scanner.close();
    }
}
