package Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class buscarUsuario {
    public buscarUsuario(){
        Scanner scanner = new Scanner(System.in);
        String pesquisar;

        System.out.println("Qual usuário você deseja encontrar?");
        pesquisar = scanner.nextLine();

        //Lê arquivo usuarios
        try {
            FileReader arq = new FileReader("Model/usuarios.csv");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();

            while (linha != null) {
                String[] campos = linha.split(",");

                if (campos.length > 0) {
                    String coluna = campos[0]; // Obtém o valor da coluna nome
                    if (coluna.toLowerCase().contains(pesquisar.toLowerCase())){
                        System.out.println(campos[0]);
                    }
                    coluna = campos[1];//obtem o valor da coluna email
                    if (coluna.toLowerCase().contains(pesquisar.toLowerCase())){
                        System.out.println(campos[0]);
                    }
                    coluna = campos[2];//obtem o valor da coluna idade
                    if (coluna.equals(pesquisar)){
                        System.out.println(campos[0]);
                    }
                }
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.err.println();
        }
    }
}
