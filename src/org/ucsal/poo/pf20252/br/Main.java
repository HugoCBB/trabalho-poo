package src.org.ucsal.poo.pf20252.br;

import src.org.ucsal.poo.pf20252.br.filhos.Aluno;
import src.org.ucsal.poo.pf20252.br.filhos.Professor;
import src.org.ucsal.poo.pf20252.br.pais.Usuario;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        menu(scan);
    }

    public static void menu(Scanner scan) {

        System.out.println("===============================");
        System.out.println("                               ");
        System.out.println("GERENCIADOR DE BIBLIOTECA UCSAL");
        System.out.println("                               ");
        System.out.println("===============================");

        System.out.println("1 - CADASTRAR UM NOVO USUARIO");
        System.out.println("2 - LIVROS DISPONIVEIS PARA EMPRESTIMO");
        System.out.println("3 - EMPRESTIMO DE LIVRO");
        System.out.println("4 - DEVOLUCAO DE LIVRO");
        System.out.println("0 - SAIR");
        int esc = scan.nextInt();
        switch (esc){
            case 1:
                Usuario usuario = cadastrarUsuario(scan);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                break;
            default:
                System.out.println("OPCAO INVALIDA");
                break;
        }


    }
    public static Usuario cadastrarUsuario(Scanner scan) {
        System.out.println("CADASTRE O SEU PERFIL");
        System.out.println("NOME: ");
        String nome = scan.next();
        System.out.println("TIPO DE PERFIL [1 - PROFESSOR | 2 - ALUNO]: ");
        int tipo = scan.nextInt();

        if (tipo == 1) {
            System.out.println("PROFESSOR CADASTRADO COM SUCESSO");
            return new Professor(nome, "PROFESSOR");
        } else {
            System.out.println("ALUNO CADASTRADO COM SUCESSO");
            return new Aluno(nome, "ALUNO");
        }
    }



}
