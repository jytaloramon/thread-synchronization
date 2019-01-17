/*
    Classe responsavel por inicializar um array de sabores 
 */
package br.com.pizzaria_so.beans;

/**
 *
 * @author ramon
 */
public class Sabores_pizza {

    private static final String[] sabores = {
        "Abobrinha e Bacon", "Frango com Catupiry", "Primavera", "Tricolor", "Chocolate",
        "Atum", "Bolonhesa", "Calabresa", "Frango", "Mexicana", "Vegetariana"
    };

    public static String[] getSabores() {
        return sabores;
    }

    public static String getName(int valor) {
        return sabores[valor];
    }
}
