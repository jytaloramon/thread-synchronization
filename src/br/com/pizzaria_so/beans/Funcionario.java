/*
    Classe Funcionario ou Fornecedora de objetos para a pilhas
 */
package br.com.pizzaria_so.beans;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramon
 */
public class Funcionario implements Runnable {

    // Atributos
    private final Pilha pilha;
    private final String id;
    public Logs logs;

    // Construtor
    public Funcionario(Pilha pilha, String id) {
        this.pilha = pilha;
        this.id = id;
        Thread thread = new Thread(this);
        thread.setPriority(Thread.NORM_PRIORITY);
        logs = new Logs(thread);
        thread.start();
        logs.start();

    } // Fim contrutor

    // Sobrescrita método run, responsavel por execultar a tarefa dentro da thread
    @Override
    public void run() {
        
        int numero = new Random().nextInt(Sabores_pizza.getSabores().length);
        Pizza pizza = new Pizza(Sabores_pizza.getName(numero));

        try {
            if (pilha.add_pizza(pizza)) {
                System.out.println(id + "\n    -> Sucesso ao inserir");
                System.out.println("    --=>> Sabor: " + pizza.getSabor() + "\n");
            } else {
                System.out.println("Thread Funcionario id: " + id + "    -> Falha ao inserir");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Getter id
    public String getId() {
        return id;
    }
    
    

}
