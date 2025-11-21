package src.org.ucsal.poo.pf20252.br.filhos;

import  src.org.ucsal.poo.pf20252.br.pais.*;

public class Aluno extends Usuario{

    public double calcularMulta(Livro livro) {
        return livro.getValor() * (1/100);
    }
}
