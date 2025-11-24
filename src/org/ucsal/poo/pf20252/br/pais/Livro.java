package src.org.ucsal.poo.pf20252.br.pais;
import src.org.ucsal.poo.pf20252.br.interfaces.Emprestavel;

public class Livro extends Publicacao implements Emprestavel {
    private double valor;
    private boolean statusLivro = false;

    private Emprestimo emprestimo;

    public Livro(String autor, String titulo, int isbn, int ano, double valor) {
        super(autor, titulo, isbn, ano);
        this.valor = valor;
    }

    public double getValor() { return valor; }

    @Override
    public boolean emprestar(int diasEmprestimo, Usuario usuario) {
        if (statusLivro) return false;

        this.emprestimo = new Emprestimo(0, diasEmprestimo, usuario);
        this.statusLivro = true;

        return true;
    }

    @Override
    public boolean devolver(int diaDevolvido) {
        if (!statusLivro) return false;

        int atraso = diaDevolvido - emprestimo.getDataDevolucao();

        if (atraso > 0) {
            double multa = emprestimo.getUsuario().calcularMulta(this.valor) * atraso;
            System.out.println("Atraso de " + atraso + " dias.");
            System.out.println("Multa total: R$ " + multa);
        } else {
            System.out.println("Devolvido sem atraso.");
        }

        statusLivro = false;
        emprestimo = null;
        return true;
    }

    public boolean isEmprestado() {
        return statusLivro;
    }
}
