public class MinhaSegundaED {
 
    private String[] nomes = new String[26];
    public int total_nomes = 0;
     
    public int getIndice(String nome) {
        if (nome == null || nome.isEmpty()) {
            return -1;
        }
        char primeiraLetra = Character.toUpperCase(nome.charAt(0));
        switch (primeiraLetra) {
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case 'D': return 3;
            case 'E': return 4;
            case 'F': return 5;
            case 'G': return 6;
            case 'H': return 7;
            case 'I': return 8;
            case 'J': return 9;
            case 'K': return 10;
            case 'L': return 11;
            case 'M': return 12;
            case 'N': return 13;
            case 'O': return 14;
            case 'P': return 15;
            case 'Q': return 16;
            case 'R': return 17;
            case 'S': return 18;
            case 'T': return 19;
            case 'U': return 20;
            case 'V': return 21;
            case 'W': return 22;
            case 'X': return 23;
            case 'Y': return 24;
            case 'Z': return 25;
            default: return -1;
        }
    }
     
    public void adiciona(String nome) {
        int indice = getIndice(nome);
        if (indice >= 0 && indice < 26 && !posicaoOcupada(indice)) {
            nomes[indice] = nome;
            total_nomes++;
        }
    }
     
    private boolean posicaoOcupada(int posicao) {
        return nomes[posicao] != null;
    }
     
    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < 26;
    }
     
    public void remove(String nome) {
        int indice = getIndice(nome);
        if (posicaoValida(indice) && posicaoOcupada(indice) && nomes[indice].equals(nome)) {
            nomes[indice] = null;
            total_nomes--;
        }
    }
     
    public boolean contem(String nome) {
        int indice = getIndice(nome);
        return posicaoValida(indice) && posicaoOcupada(indice) && nomes[indice].equals(nome);
    }
     
    public String getNome(int posicao) {
        if (posicaoValida(posicao)) {
            return nomes[posicao];
        }
        return null;
    }
     
    public int totalNomes() {
        return total_nomes;
    }
     
    public static void main(String[] args) {
        MinhaSegundaED ed = new MinhaSegundaED();
        ed.adiciona("Ana");
        ed.adiciona("Bruno");
        ed.adiciona("Carlos");
        
        
        System.out.println("Total de nomes: " + ed.totalNomes());
        System.out.println("Contém 'Ana'? " + ed.contem("Ana"));
        
        ed.remove("Ana");
        System.out.println("Contém 'Ana' após remoção? " + ed.contem("Ana"));
    }
     
    }