package src.org.ucsal.poo.pf20252.br.pais;

public class Usuario {
    private String nome, tipo;
    private int matricula;

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
    public void setMatricula(int matricula) { this.matricula = matricula; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
