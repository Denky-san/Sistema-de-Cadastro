package Controller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.sun.tools.javac.util.StringUtils.toUpperCase;

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
                //Lê arquivo formulario
                Usuario usuario = new Usuario();
                String imputUsuario;
                List<Object> dados = new ArrayList<>();

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
                usuario.setNome((String) dados.get(0));
                usuario.setEmail((String) dados.get(1));
                usuario.setIdade(Integer.parseInt((String) dados.get(2)));
                usuario.setAltura(Double.parseDouble((String) dados.get(3)));

                try {
                    FileWriter arquivoUsuario = new FileWriter("Model/usuarios.csv", true);
                    PrintWriter gravarArqUsuario = new PrintWriter(arquivoUsuario);

                    gravarArqUsuario.printf(usuario.getNome() + ", " +
                            usuario.getEmail() + ", " +
                            usuario.getIdade() + ", " +
                            usuario.getAltura() + "\n");

                    arquivoUsuario.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
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
                break;
            case 3:
                try {
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
                break;
            case 4:
                try {
                    //primeira leitura para saber qtd de linhas no arquivo
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
                break;
            case 5:
                break;
            default:
                System.out.println("Opção Inválida, tente novamente mais tarde!");
        }
    }
}
