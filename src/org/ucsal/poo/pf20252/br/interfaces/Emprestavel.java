package src.org.ucsal.poo.pf20252.br.interfaces;

import src.org.ucsal.poo.pf20252.br.pais.Usuario;

public interface Emprestavel {
    boolean emprestar(int diasEmprestimo, Usuario usuario);
    boolean devolver(int diaDevolvido);
}