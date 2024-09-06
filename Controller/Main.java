package Controller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Menu
        System.out.println("Seja Bem vindo ao nosso sistema de cadastro! O que Deseja fazer hoje?\n"+
                "1 - Cadastrar o usuário\n" +
                "2 - Listar todos usuários cadastrados\n"+
                "3 - Cadastrar nova pergunta no formulário\n"+
                "4 - Deletar pergunta do formulário\n"+
                "5 - Pesquisar usuário por nome ou idade ou email\n");

        Scanner scanner = new Scanner(System.in);
        int escolha =  Integer.parseInt(scanner.nextLine());

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
            default:
                System.out.println("Opção Inválida, tente novamente mais tarde!");
        }
    }
}
