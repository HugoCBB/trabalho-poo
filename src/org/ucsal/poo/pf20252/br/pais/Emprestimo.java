package src.org.ucsal.poo.pf20252.br.pais;

public class Emprestimo {
    private int dataEmprestimo, dataDevolucao;
    private boolean status;

    public int getDataDevolucao() {
        return dataDevolucao;
    }
    public int getDataEmprestimo() {
        return dataEmprestimo;
    }
    public boolean getStatus() {
        return this.status;
    }

    public void setDataDevolucao(int dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDataEmprestimo(int dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
