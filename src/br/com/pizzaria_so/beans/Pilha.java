/*
    Classe responsavel por montar a pilha de pizza, além de gerir inputs e outputs de objetos na pilha  
 */
package br.com.pizzaria_so.beans;

/**
 *
 * @author ramon
 */
public class Pilha {

    // Atributos
    private Pizza[] pi_pizzas;  // Pilha
    private final int tam_max;  // Tamanho maximo da pilha
    private int posi_atual;     // Posição atual da pilha

    // Construtor 
    public Pilha(int tam_max) {
        this.tam_max = tam_max;
        pi_pizzas = new Pizza[tam_max];
        posi_atual = -1;
        
    } //Fim Construtor 

    // Getters e Setters
    private void setPosi_atual(int posi_atual) {
        this.posi_atual = posi_atual;
    }

    public int getPosi_atual() {
        return posi_atual;
    }

    public int getTam_max() {
        return tam_max;
    }

    public Pizza[] getPi_pizzas() {
        return pi_pizzas;
    }
    // Fim Getters e Setters

    /* Método responsavel pela inserir de objetos na pilha*/
    public synchronized boolean add_pizza(Pizza pi_pizzas) throws InterruptedException {

        while (this.getPosi_atual() == this.getTam_max()) { // Enquanto a quantidade de objeto for maxima a thread permanece suspensa
            System.out.println("    |--=> Em espera para inserir");
            wait();
        }

        notifyAll();

        if (posi_atual + 1 < tam_max) {
            setPosi_atual(getPosi_atual() + 1);
            this.pi_pizzas[posi_atual] = pi_pizzas;
            return true;
        }
        return false;
    }

    /* Método responsavel pela retirar um objetos da pilha*/
    public synchronized String remove_pizza() throws InterruptedException {

        while (this.getPosi_atual() < 0) { // Enquanto a quantidade de objeto não tiver nenhum objeto a thread permanece suspensa
            System.out.println("    |--=> Em espera para retirar");
            wait();
        }

        notifyAll();

        String name = null;

        if (getPosi_atual() >= 0) {
            name = this.pi_pizzas[getPosi_atual()].getSabor();
            this.pi_pizzas[getPosi_atual()] = null;
            setPosi_atual(getPosi_atual() - 1);
        }
        return name;
    }

}
