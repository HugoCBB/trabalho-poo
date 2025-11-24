package src.org.ucsal.poo.pf20252.br.pais;

abstract class Publicacao {
    private String titulo, autor;
    private int isbn, ano;

    public Publicacao(String autor, String titulo, int isbn, int ano) {
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.ano = ano;
    }

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
