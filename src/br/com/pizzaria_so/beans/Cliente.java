/*
    Classe Cliente ou Consumidor de objetos da pilhas
 */
package br.com.pizzaria_so.beans;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramon
 */
public class Cliente implements Runnable {

    // Atributos
    private final Pilha pilha;
    private String id;

    // Construtor
    public Cliente(Pilha pilha, String id) {
        this.pilha = pilha;
        this.id = id;
        Thread thread = new Thread(this);
        thread.setPriority(thread.MAX_PRIORITY);
        thread.start();
        
    } // Fim Construtor

    // Sobrescrita método run, responsavel por execultar a tarefa dentro da thread
    @Override
    public void run() {
        
        try {
            String name = pilha.remove_pizza();
            
            if (name != null) {
                System.out.println(id+ "\n    -> Sucesso ao retirar pizza");
                System.out.println("    -->> Sabor: " + name + "\n");
            } else {
                System.out.println("Thread Cliente id: " + id + "    -> Falha ao retirar pizza");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
