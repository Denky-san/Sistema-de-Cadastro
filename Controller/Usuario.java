package Controller;
import java.text.DecimalFormat;

public class Usuario {
    private String nome;
    private String email;
    private int idade;
    private double altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.length() < 10){
        nome = null;
            System.out.println("Nome inválido! Tente novamente");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!email.contains("@")){
            email = null;
            System.out.println("Email inválido! Tente novamente");
        }
        this.email = email;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {

        DecimalFormat df = new DecimalFormat("#.00");
        altura = Double.parseDouble(df.format(altura));

        if(altura > 3 || altura < 0.60){
            altura = 0;
            System.out.println("Altura inválida! Tente novamente");
        }
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 18 || idade > 130 ){
            System.out.println("Idade inválida! Tente novamente");
            idade = 0;
        }
        this.idade = idade;
    }
}
