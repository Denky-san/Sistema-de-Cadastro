package Controller;

import java.io.*;
import java.util.Scanner;

public class cadastrarPergunta {

    public cadastrarPergunta(){
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Qual pergunta voce deseja adicionar?");
            String pergunta;
            pergunta = scanner.nextLine();

            FileReader arq = new FileReader("Model/formulario.csv");
            BufferedReader lerArq = new BufferedReader(arq);
            int aux = 1;

            //Leitura para descobrir a quantidade de perguntas cadastradas
            String linha;
            while ((linha = lerArq.readLine()) != null) {
                aux++;
            }
            lerArq.close();

            FileWriter arquivo = new FileWriter("Model/formulario.csv", true);
            PrintWriter gravarArq = new PrintWriter(arquivo);
            gravarArq.printf("\n" + aux + " - " +  pergunta);

            arquivo.close();
            System.out.println("Pergunta cadastrada com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
