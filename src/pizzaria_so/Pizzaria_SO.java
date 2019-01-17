/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria_so;

import br.com.pizzaria_so.beans.Cliente;
import br.com.pizzaria_so.beans.Funcionario;
import br.com.pizzaria_so.beans.Pilha;
import br.com.pizzaria_so.beans.Pizza;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ramon
 */
public class Pizzaria_SO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Pilha pilha = new Pilha(11);
        Funcionario funcionario = null;

        for (int i = 0; i < 20; i++) {
            new Cliente(pilha, "Thread Cliente id: " + i);
        }

        for (int i = 0; i < 20; i++) {
            if(i == 14){
                funcionario = new Funcionario(pilha, "Thread Funcionario id: " + i);
            }
            new Funcionario(pilha, "Thread Funcionario id: " + i);
        }

        System.out.println("\n\nPilha");

        Thread.sleep(5000);

        for (Pizza pi_pizza : pilha.getPi_pizzas()) {
            System.out.println(pi_pizza);
        }

        System.out.println(funcionario.getId()+"\n\n");
        
        for (String t : funcionario.logs.getStatus()) {
            System.out.println(t);
        }
    }

}
