// Classe No: Representa um nó da fila
class No {
    Object item;
    No prox;
 
    public No(Object item) {
        this.item = item;
        this.prox = null;
    }
}
 
// Classe Fila: Implementa a fila encadeada
public class Fila {
    private No inicio;
    private No fim;
 
    // Construtor: Cria uma fila vazia
    public Fila() {
        this.inicio = new No(null);
        this.fim = this.inicio;
        this.inicio.prox = null;
    }
    
    // Enfileira um elemento no final da fila
    public void enfileira(Object elemento) {
        No novoNo = new No(elemento);
        this.fim.prox = novoNo;
        this.fim = novoNo;
    }
 
    // Desenfileira o elemento do início da fila
    public Object desenfileira() throws Exception {
        if (vazia()) {
            throw new Exception("Erro: A fila está vazia");
        }
        No temp = this.inicio.prox;
        this.inicio.prox = temp.prox;
        if (this.inicio.prox == null) {
            this.fim = this.inicio;
        }
        return temp.item;
    }
 
    // Verifica se a fila está vazia
    public boolean vazia() {
        return this.inicio == this.fim;
    }
 
    // Imprime os elementos da fila
    public void imprime() {
        No atual = this.inicio.prox;
        while (atual != null) {
            System.out.print(atual.item + " | ");
            atual = atual.prox;
        }
        System.out.println();
    }
 
    // Método principal para teste
    public static void main(String[] args) {
        try {
            Fila fila = new Fila();
            
            // Testando enfileirar
            System.out.println("Enfileirando elementos: 10, 20, 30, 40");
            fila.enfileira(10);
            fila.enfileira(20);
            fila.enfileira(30);
            fila.enfileira(40);
            fila.imprime();
            
            // Testando desenfileirar
            System.out.println("\nDesenfileirando elemento: " + fila.desenfileira());
            fila.imprime();
            
            // Testando enfileirar novamente
            System.out.println("\nEnfileirando elemento: 50");
            fila.enfileira(50);
            fila.imprime();
 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}