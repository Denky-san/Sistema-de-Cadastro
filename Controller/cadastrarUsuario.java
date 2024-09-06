package Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cadastrarUsuario {

    public cadastrarUsuario(){
        //Lê arquivo formulario
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        String imputUsuario;
        List<String> dados = new ArrayList<>();

        try {
            FileReader arq = new FileReader("Model/formulario.csv");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                System.out.println(linha);
                imputUsuario = scanner.nextLine();
                dados.add(imputUsuario);
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();
        } catch (IOException e) {
            System.err.println();
        }
        usuario.setNome(dados.get(0));
        usuario.setEmail(dados.get(1));
        usuario.setIdade(Integer.parseInt(dados.get(2)));
        usuario.setAltura(Double.parseDouble(dados.get(3)));

        try {
            FileWriter arquivoUsuario = new FileWriter("Model/usuarios.csv", true);
            PrintWriter gravarArqUsuario = new PrintWriter(arquivoUsuario);

            if (!usuario.getNome().isEmpty() && !usuario.getEmail().isEmpty() && usuario.getIdade() != 0 && usuario.getAltura()!= 0) {
                gravarArqUsuario.printf(usuario.getNome() + "," +
                        usuario.getEmail() + "," +
                        usuario.getIdade() + "," +
                        usuario.getAltura() + "\n");
            }

            arquivoUsuario.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
