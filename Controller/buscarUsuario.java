package Controller;

import java.io.*;
import java.util.*;

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
            List<String> usuariosEncontrados = new ArrayList<>();

            while (linha != null) {
                String[] campos = linha.split(",");

                if (campos.length > 0) {
                    String nome = campos[0]; // Obtém o valor da coluna nome
                    String email = campos[1]; // Obtém o valor da coluna email
                    String idade = campos[2]; // Obtém o valor da coluna idade

                    if (nome.toLowerCase().contains(pesquisar.toLowerCase()) || email.toLowerCase().contains(pesquisar.toLowerCase()) || idade.equals(pesquisar)){
                        if (!usuariosEncontrados.contains(nome)) {
                            System.out.println(nome);
                            usuariosEncontrados.add(nome);
                        }
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