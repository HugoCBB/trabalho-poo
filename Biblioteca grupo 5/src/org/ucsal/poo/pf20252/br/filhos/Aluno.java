package src.org.ucsal.poo.pf20252.br.filhos;

import  src.org.ucsal.poo.pf20252.br.pais.*;

public class Aluno extends Usuario{
    public Aluno(String nome) {
        super(nome, "ALUNO");
    }

    @Override
    public double calcularMulta(double valor) {
        return valor * 0.01;
    }
}
