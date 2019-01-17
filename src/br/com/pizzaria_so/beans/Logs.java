/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria_so.beans;

import java.util.ArrayList;

/**
 *
 * @author ramon
 */
public class Logs extends Thread {

    // Atributos
    private final Thread thread;
    private ArrayList<String> status;

    // Construtor
    public Logs(Thread thread) {
        this.thread = thread;
        status = new ArrayList();
        status.add("NEW");
        
    } // Fim Construtor 

    private String t = "";

    // Execulção assincrona
    @Override
    public synchronized void start() {

        // Enquanto a thread estiver execultando será coletado os logos de estado
        while (thread.getState() != Thread.State.TERMINATED) {
            if (thread.getState() != Thread.State.NEW) {
                t = "NEW";
            }
            if (thread.getState() != Thread.State.RUNNABLE) {
                t = "Running";
            } else if (thread.getState() != Thread.State.WAITING) {
                t = "waiting";
            } else if (thread.getState() != Thread.State.BLOCKED) {
                t = "Blocked";
            }

            // Se o status mudar será salvo no log 
            if (!t.equals(status.get(status.size() - 1))) {
                status.add(t);
            }
        }
        status.add("Terminated");
    }

    // Getter arraylist de log
    public ArrayList<String> getStatus() {
        return status;
    }

}
