package src.org.ucsal.poo.pf20252.br;

import src.org.ucsal.poo.pf20252.br.filhos.Aluno;
import src.org.ucsal.poo.pf20252.br.filhos.Professor;
import src.org.ucsal.poo.pf20252.br.pais.Livro;
import src.org.ucsal.poo.pf20252.br.pais.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorBiblioteca {
    private List<Usuario> usuarios;
    private List<Livro> livros;

    public GerenciadorBiblioteca() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    // --- Métodos de Cadastro ---

    public Usuario cadastrarUsuario(String nome, String tipo) {
        Usuario novoUsuario;
        if ("PROFESSOR".equalsIgnoreCase(tipo)) {
            novoUsuario = new Professor(nome);
        } else if ("ALUNO".equalsIgnoreCase(tipo)) {
            novoUsuario = new Aluno(nome);
        } else {
            throw new IllegalArgumentException("Tipo de usuário inválido: " + tipo);
        }
        usuarios.add(novoUsuario);
        return novoUsuario;
    }

    public Livro cadastrarLivro(String autor, String titulo, int isbn, int ano, double valor) {
        Livro novoLivro = new Livro(autor, titulo, isbn, ano, valor);
        livros.add(novoLivro);
        return novoLivro;
    }

    // --- Métodos de Empréstimo ---

    public boolean emprestarLivro(int matriculaUsuario, int isbnLivro, int diasEmprestimo) {
        Usuario usuario = buscarUsuarioPorMatricula(matriculaUsuario);
        Livro livro = buscarLivroPorISBN(isbnLivro);

        if (usuario == null || livro == null) {
            return false; // Usuário ou livro não encontrado
        }

        return livro.emprestar(diasEmprestimo, usuario);
    }

    public double devolverLivro(int isbnLivro, int diaDevolvido) {
        Livro livro = buscarLivroPorISBN(isbnLivro);

        if (livro == null || !livro.isEmprestado()) {
            return -1; // Livro não encontrado ou não emprestado
        }

        return livro.devolver(diaDevolvido); // Retorna a multa (0 se não houver)
    }

    // --- Métodos de Busca ---

    public Usuario buscarUsuarioPorMatricula(int matricula) {
        for (Usuario u : usuarios) {
            if (u.getMatricula() == matricula) {
                return u;
            }
        }
        return null;
    }

    public Livro buscarLivroPorISBN(int isbn) {
        for (Livro l : livros) {
            if (l.getIsbn() == isbn) {
                return l;
            }
        }
        return null;
    }

    // --- Métodos de Listagem ---

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
