package model;

public class Capitulos {
    private int id;
    private String titulo;
    private String conteudo;
    private int numero;
    Obras obras;

    public Capitulos() {}

    public Capitulos(String titulo, String conteudo, int numero, Obras obras) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.numero = numero;
        this.obras = obras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Obras getObras() {
        return obras;
    }

    public void setObras(Obras obras) {
        this.obras = obras;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Capitulos{" +
                "numero=" + numero +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
