    package src.org.ucsal.poo.pf20252.br.filhos;
    import  src.org.ucsal.poo.pf20252.br.pais.*;


    public class Professor extends Usuario{

        public Professor(String nome) {
            super(nome, "PROFESSOR");
        }

        @Override
        public double calcularMulta(double valor) {
            return valor * 0.03;
        }
    }
