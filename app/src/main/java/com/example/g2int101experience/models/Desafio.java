package com.example.g2int101experience.models;

import android.widget.ImageView;

public class Desafio {
    String titulo , imgUlr;

    public Desafio(String titulo, String imgUlr) {
        this.titulo = titulo;
        this.imgUlr = imgUlr;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImgUlr() {
        return imgUlr;
    }

    public void setImgUlr(String imgUlr) {
        this.imgUlr = imgUlr;
    }
}
