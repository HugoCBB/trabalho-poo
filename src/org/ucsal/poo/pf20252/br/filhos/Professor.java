package src.org.ucsal.poo.pf20252.br.filhos;
import  src.org.ucsal.poo.pf20252.br.pais.*;


public class Professor extends Usuario{
    public double calcularMulta(Livro livro) {
        return livro.getValor() * (3/100);
    }
}
