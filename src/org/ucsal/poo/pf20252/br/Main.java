package src.org.ucsal.poo.pf20252.br;

import src.org.ucsal.poo.pf20252.br.filhos.Aluno;
import src.org.ucsal.poo.pf20252.br.filhos.Professor;
import src.org.ucsal.poo.pf20252.br.pais.Livro;
import src.org.ucsal.poo.pf20252.br.pais.Usuario;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Usuario usuario;
    private static Livro livro;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        menu(scan);
    }

    public static void menu(Scanner scan) {
        while (true) {

            System.out.println("===============================");
            System.out.println("                               ");
            System.out.println("GERENCIADOR DE BIBLIOTECA UCSAL");
            System.out.println("                               ");
            System.out.println("===============================");

            System.out.println("1 - CADASTRAR USUARIO");
            System.out.println("2 - CADASTRAR LIVRO");
            System.out.println("3 - EMPRESTIMO DE LIVRO");
            System.out.println("4 - DEVOLUÇÃO DE LIVRO");
            System.out.println("0 - SAIR");
            System.out.println("Escolha: ");
            int esc = scan.nextInt();
            switch (esc) {
                case 1:
                    cadastrarUsuario(scan);
                    break;
                case 2:
                    cadastrarLivro(scan);
                    break;
                case 3:
                    emprestar(scan);
                    break;
                case 4:
                    devolver(scan);
                    break;
                case 0:
                    System.out.println("Saindo da biblioteca...");
                    return;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        }
    }

    private static void cadastrarUsuario(Scanner sc) {
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Tipo (1 - Professor, 2 - Aluno): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo == 1) {
            usuario = new Professor(nome);
        } else {
            usuario = new Aluno(nome);
        }

        System.out.println("Usuário cadastrado!");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println();
    }

    private static void cadastrarLivro(Scanner sc) {
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("ISBN: ");
        int isbn = sc.nextInt();
        sc.nextLine();

        System.out.print("Ano: ");
        int ano = sc.nextInt();
        sc.nextLine();

        System.out.print("Valor: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        livro = new Livro(autor, titulo, isbn, ano, valor);

        System.out.println("Livro cadastrado!");
    }

    private static void emprestar(Scanner sc) {
        if (usuario == null || livro == null) {
            System.out.println("Cadastre usuário e livro primeiro!");
            return;
        }

        if (livro.isEmprestado()) {
            System.out.println("Livro já está emprestado!");
            return;
        }

        System.out.print("Quantos dias de empréstimo? ");
        int dias = sc.nextInt();

        if (livro.emprestar(dias, usuario)) {
            System.out.println("Livro emprestado!");
        }
    }

    private static void devolver(Scanner sc) {
        if (livro == null || !livro.isEmprestado()) {
            System.out.println("Nenhum livro emprestado!");
            return;
        }

        System.out.print("Quantos dias se passaram? ");
        int diaDevolvido = sc.nextInt();

        livro.devolver(diaDevolvido);
    }
}
