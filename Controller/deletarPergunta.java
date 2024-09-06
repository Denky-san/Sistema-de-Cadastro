package Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class deletarPergunta {

    public deletarPergunta(){
        try {
            //primeira leitura para saber qtd de linhas no arquivo
            Scanner scanner = new Scanner(System.in);
            FileReader arq = new FileReader("Model/formulario.csv");
            BufferedReader lerArq = new BufferedReader(arq);
            List<String> perguntas = new ArrayList<>();
            int qtdLinhas = 0;

            String linha = lerArq.readLine();
            while (linha != null) {
                qtdLinhas++;
                linha = lerArq.readLine();
            }
            arq.close();

            int pergunta;
            System.out.println("Qual pergunta você deseja remover?");
            pergunta = Integer.parseInt(scanner.nextLine());

            while (pergunta <= 4 || pergunta > qtdLinhas ){
                System.out.println("Pergunta indisponivel para remoção! Qual pergunta você deseja remover?");
                pergunta = Integer.parseInt(scanner.nextLine());
            }

            //segunda leitura para criar lista com a pergunta removida
            FileReader arq2 = new FileReader("Model/formulario.csv");
            BufferedReader lerArq2 = new BufferedReader(arq2);
            int aux = 0;
            linha = lerArq2.readLine();
            while (linha != null ) {
                aux++;
                if (aux!= pergunta && !linha.trim().isEmpty()){
                    perguntas.add(linha);
                }
                linha = lerArq2.readLine(); // lê da segunda até a última linha
            }
            arq2.close();

            //criação do arquivo de perguntas novamente com a pergunta escolhida removida
            FileWriter arquivo = new FileWriter("Model/formulario.csv");
            PrintWriter gravarArq = new PrintWriter(arquivo);
            for (int i = 0; i < qtdLinhas - 1; i++){
                gravarArq.printf(perguntas.get(i) + "\n");
            }
            arquivo.close();

        } catch (IOException e) {
            System.err.println();
        }
    }
}
