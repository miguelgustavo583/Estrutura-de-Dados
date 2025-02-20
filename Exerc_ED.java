/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Arrays;

class PrimeiraED {
    private Object[] elementos = new Object[10];
    private int quantidadeElementos = 0;

    public void inserir(int indice, Object elemento) {
        if (indice < 0 || indice > quantidadeElementos) {
            System.err.println("Índice fora do intervalo permitido.");
            return;
        }
        
        if (quantidadeElementos == elementos.length) {
            aumentarCapacidade();
        }

        for (int i = quantidadeElementos; i > indice; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[indice] = elemento;
        quantidadeElementos++;
        System.out.println("Elemento inserido: " + Arrays.toString(elementos));
    }

    public void inserir(Object elemento) {
        if (quantidadeElementos == elementos.length) {
            aumentarCapacidade();
        }
        elementos[quantidadeElementos++] = elemento;
        System.out.println("Elemento inserido: " + Arrays.toString(elementos));
    }

    public void excluir(int indice) {
        if (indice < 0 || indice >= quantidadeElementos) {
            System.err.println("Índice inválido.");
            return;
        }
        
        for (int i = indice; i < quantidadeElementos - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[--quantidadeElementos] = null;
        System.out.println("Elemento removido: " + Arrays.toString(elementos));
    }

    public boolean contem(Object elemento) {
        for (int i = 0; i < quantidadeElementos; i++) {
            if (elemento.equals(elementos[i])) {
                System.out.println("Elemento localizado na posição: " + i);
                return true;
            }
        }
        System.out.println("Elemento não encontrado.");
        return false;
    }

    public Object obterElemento(int indice) {
        if (indice < 0 || indice >= quantidadeElementos) {
            System.err.println("Índice inválido.");
            return null;
        }
        System.out.println("Elemento na posição " + indice + ": " + elementos[indice]);
        return elementos[indice];
    }

    public int tamanho() {
        return quantidadeElementos;
    }

    private void aumentarCapacidade() {
        elementos = Arrays.copyOf(elementos, elementos.length * 2);
    }
}

public class Main {
    public static void main(String[] args) {
        Main estrutura = new Main();

        for (int i = 1; i <= 9; i++) {
            estrutura.inserir(i);
        }

        estrutura.obterElemento(8);
        estrutura.obterElemento(2);
        estrutura.inserir(1, 4);
        estrutura.contem(4);
        estrutura.excluir(1);
        estrutura.inserir(8, 12);
    }
}

