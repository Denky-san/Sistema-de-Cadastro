package Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class deletarPergunta {

    public deletarPergunta(){
        try {
            Scanner scanner = new Scanner(System.in);
            FileReader arq = new FileReader("Model/formulario.csv");
            BufferedReader lerArq = new BufferedReader(arq);
            List<String> perguntas = new ArrayList<>();

            //Leitura para carregar as perguntas em uma lista
            String linha;
            while ((linha = lerArq.readLine()) != null) {
                perguntas.add(linha);
            }
            lerArq.close();

            int pergunta;
            do{
                System.out.println("Qual pergunta você deseja remover? Para voltar ao menu anterior digite '0'");
                pergunta = Integer.parseInt(scanner.nextLine());

                if (pergunta == 0) {
                    System.out.println("Operação cancelada.");
                    return;
                }
                if (pergunta <= 4) {
                    System.out.println("Pergunta indisponível para remoção! Tente novamente.");
                }
            }
            while (pergunta <= 4);

            perguntas.remove(pergunta - 1);

            //criação do arquivo de perguntas novamente com a pergunta escolhida removida
            FileWriter arquivo = new FileWriter("Model/formulario.csv");
            PrintWriter gravarArq = new PrintWriter(arquivo);

            for (int i = 0; i < perguntas.size(); i++) {
                if (i == perguntas.size() - 1) {
                    gravarArq.print(perguntas.get(i));
                } else {
                    gravarArq.println(perguntas.get(i));
                }
            }
            arquivo.close();
            System.out.println("Pergunta deletada com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao acessar o arquivo.");
        } catch (NumberFormatException e) {
            System.err.println("Entrada inválida! Digite um número válido.");
        }
    }
}