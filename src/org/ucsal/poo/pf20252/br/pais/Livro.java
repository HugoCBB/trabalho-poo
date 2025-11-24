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

    public double getValor() {return valor; }

    public void setValor(double valor) { this.valor = valor; }

    @Override
    public boolean emprestar(int diasEmprestimo) {
        this.emprestimo.setDataEmprestimo(diasEmprestimo);
        System.out.println("Livro emprestado\nQuantidade de dias de emprestimo: " + diasEmprestimo);
        return true;
    }

    @Override
    public boolean devolver(int diaDevolvido, Usuario usuario) {
        this.emprestimo.setDataDevolucao(diaDevolvido);

        if(this.emprestimo.getDataEmprestimo() > this.emprestimo.getDataDevolucao() ) {
            double multa = usuario.calcularMulta(this.getValor());
            System.out.println("Livro devolvido com atraso\n Valor da multa: \n" + multa);
            return false;
        }
        System.out.println("Livro devolvido sem atraso");
        return this.statusLivro = false;
    }
}
