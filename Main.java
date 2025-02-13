/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main {

    private Object[] objetos = new Object[10];
    public int totalDeObjetos = 0;

    public void adiciona(int posicao, Object objeto) {
        if (!posicaoValida(posicao) && posicao != totalDeObjetos) {
            throw new IllegalArgumentException("Posição inválida");
        }
        if (totalDeObjetos == objetos.length) {
            redimensionaVetor();
        }
        for (int i = totalDeObjetos; i > posicao; i--) {
            objetos[i] = objetos[i - 1];
        }
        objetos[posicao] = objeto;
        totalDeObjetos++;
    }

    public void adiciona(Object objeto) {
        if (totalDeObjetos == objetos.length) {
            redimensionaVetor();
        }
        objetos[totalDeObjetos] = objeto;
        totalDeObjetos++;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeObjetos;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= totalDeObjetos;
    }

    public void remove(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = posicao; i < totalDeObjetos - 1; i++) {
            objetos[i] = objetos[i + 1];
        }
        objetos[totalDeObjetos - 1] = null;
        totalDeObjetos--;
    }

    public boolean contem(Object objeto) {
        for (int i = 0; i < totalDeObjetos; i++) {
            if (objetos[i].equals(objeto)) {
                return true;
            }
        }
        return false;
    }

    public Object getObjeto(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return objetos[posicao];
    }

    public int tamanho() {
        return totalDeObjetos;
    }

    private void redimensionaVetor() {
        Object[] novoArray = new Object[objetos.length * 2];
        for (int i = 0; i < objetos.length; i++) {
            novoArray[i] = objetos[i];
        }
        objetos = novoArray;
    }

    public static void main(String[] args) {
        Main ed = new Main();
        ed.adiciona("Objeto 1");
        ed.adiciona("Objeto 2");
        ed.adiciona(1, "Objeto 1.5");

        System.out.println("Tamanho: " + ed.tamanho());
        System.out.println("Contém 'Objeto 1.5'? " + ed.contem("Objeto 1.5"));

        ed.remove(1);
        System.out.println("Após remoção, contém 'Objeto 1.5'? " + ed.contem("Objeto 1.5"));
    }
}

