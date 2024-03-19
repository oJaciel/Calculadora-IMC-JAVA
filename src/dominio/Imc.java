package dominio;

public class Imc {

    //Atributos
    private Long cpf;
    private String nome;
    private Float peso;
    private Float altura;
    private Float imc;

    //Método Construtor
    public Imc() {
    }

    //Getters e Setters
    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    //Métodos da Classe
    public Float CalculaImc() {
        Float imc = peso / (altura * altura);
        return imc;
    }

    public String VerificaImc() {
        imc = this.CalculaImc();
        if (imc < 18.5) {
            return "Magreza";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Normal";
        } else if (imc >= 25 && imc <= 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc <= 39.9) {
            return "Obesidade";
        } else {
            return "Obesidade Grave";
        }
    }

}
