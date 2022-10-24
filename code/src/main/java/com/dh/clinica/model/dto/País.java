package com.dh.clinica.model.dto;

public class País {
    private String codigo;
    private String capital;

    public País(String codigo, String capital) {
        this.codigo = codigo;
        this.capital = capital;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
