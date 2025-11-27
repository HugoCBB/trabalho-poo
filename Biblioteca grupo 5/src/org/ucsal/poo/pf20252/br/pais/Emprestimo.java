package src.org.ucsal.poo.pf20252.br.pais;

public class Emprestimo {
    private int dataEmprestimo, dataDevolucao ;
    private Usuario usuario;

    public Emprestimo(int diaAtual, int diasEmprestimo, Usuario usuario) {
        this.dataEmprestimo = diaAtual;
        this.dataDevolucao = diaAtual + diasEmprestimo;
        this.usuario = usuario;
    }

    public int getDataEmprestimo() { return dataEmprestimo; }
    public int getDataDevolucao() { return dataDevolucao; }
    public Usuario getUsuario() { return usuario; }
}