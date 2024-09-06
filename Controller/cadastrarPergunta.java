package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class cadastrarPergunta {

    public cadastrarPergunta(){
        try {
            Scanner scanner = new Scanner(System.in);
            FileWriter arquivo = new FileWriter("Model/formulario.csv", true);
            PrintWriter gravarArq = new PrintWriter(arquivo);

            System.out.println("Qual pergunta voce deseja adicionar?");
            String pergunta;
            pergunta = scanner.nextLine();
            gravarArq.printf("\n" + pergunta);
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
