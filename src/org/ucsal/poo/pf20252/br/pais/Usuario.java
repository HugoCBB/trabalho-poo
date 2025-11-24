package src.org.ucsal.poo.pf20252.br.pais;

public abstract class Usuario {
    private String nome, tipo;
    private int matricula;
    private static int contadorMatricula = 1;

    public Usuario(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.matricula = contadorMatricula++;
    }

    public abstract double calcularMulta(double valor);

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

    public String toString() {
    return nome + " (Matrícula: " + matricula + ", Tipo: " + tipo + ")";
    }
}
