package model;

import java.util.ArrayList;
public class Obras {
    private int id;
    private String titulo;
    private String resumo;
    private String tags;
    Usuarios usuarios;

    public Obras(String titulo, String resumo, String tags, Usuarios usuarios) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.tags = tags;
        this.usuarios = usuarios;
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

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Obras{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
