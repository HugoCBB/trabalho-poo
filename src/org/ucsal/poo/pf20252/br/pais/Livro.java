package src.org.ucsal.poo.pf20252.br.pais;
import src.org.ucsal.poo.pf20252.br.interfaces.Emprestavel;

public class Livro extends Publicacao  {
    private String titulo, autor;
    private int isbn, ano;
    private double valor;

    public double getValor() {return valor; }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public void setAno(int ano) { this.ano = ano; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setIsbn(int isbn) { this.isbn = isbn; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setValor(double valor) { this.valor = valor; }
}
