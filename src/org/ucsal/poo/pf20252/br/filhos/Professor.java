package src.org.ucsal.poo.pf20252.br.filhos;
import  src.org.ucsal.poo.pf20252.br.pais.*;


public class Professor extends Usuario{

    public Professor(String nome, String tipo) {
        super(nome, tipo);
    }

    @Override
    public double calcularMulta(double valor) {
        return valor * (3/100);
    }
}
