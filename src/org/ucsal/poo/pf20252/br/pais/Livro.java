package src.org.ucsal.poo.pf20252.br.pais;
public class Livro {
    private String titulo, autor;
    private int isbn, ano;  

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
}
