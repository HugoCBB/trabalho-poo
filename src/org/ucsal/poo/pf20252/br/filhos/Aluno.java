package src.org.ucsal.poo.pf20252.br.filhos;

import  src.org.ucsal.poo.pf20252.br.pais.*;

public class Aluno extends Usuario{
    public Aluno(String nome, String tipo) {
        super(nome, tipo);
    }

    @Override
    public double calcularMulta(double valor) {
        return valor * (1/100);
    }
}
