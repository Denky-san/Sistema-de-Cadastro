package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class listarUsuarios {

    public listarUsuarios(){
        try {
            FileReader arqUsuario = new FileReader("Model/usuarios.csv");
            BufferedReader lerArqUsuario = new BufferedReader(arqUsuario);
            String linha = lerArqUsuario.readLine();
            int aux = 1;

            while (linha != null) {
                String[] campos = linha.split(",");

                if (campos.length > 0) {
                    String primeiraColuna = campos[0]; // Obtém o valor da primeira coluna
                    System.out.println(aux + " - " + primeiraColuna);
                    aux++;
                }
                linha = lerArqUsuario.readLine();
            }
            arqUsuario.close();
        } catch (IOException e) {
            System.err.println();
        }
    }
}