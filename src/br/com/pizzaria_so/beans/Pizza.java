/*
    Classe modelo pizza 
 */
package br.com.pizzaria_so.beans;

/**
 *
 * @author ramon
 */
public class Pizza {

    // Atributos
    private String sabor;
    private boolean status;

    // Construtor 
    public Pizza(String sabor) {
        this.sabor = sabor;
        this.status = false;

    } // Fim construtos

    // Getters e Setters
    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    // Fim Getters e Setters

}
