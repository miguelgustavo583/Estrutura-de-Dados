/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Livros {
    
    public static class Livro {
        private String nome;
        private int ano;
        private double preco;
        private Livro anterior;

        public Livro(String nome, int ano, double preco) {
            this.nome = nome;
            this.ano = ano;
            this.preco = preco;
            this.anterior = null;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public Livro getAnterior() {
            return anterior;
        }

        public void setAnterior(Livro anterior) {
            this.anterior = anterior;
        }
    }
    
    public static class Lista {
        private Livro cabeca;
        private Livro anterior;
        
        public void adiciona(Livro livro) {
            if (cabeca == null) {
                cabeca = livro;
            } else {
                livro.setAnterior(cabeca);
                cabeca = livro;
            }
            anterior = cabeca;
        }
        
        public void remove() {
            if (cabeca != null) {
                cabeca = cabeca.getAnterior();
                anterior = cabeca;
            }
        }
        
        public Livro getCabeca() {
            return cabeca;
        }
        
        public void listarLivros() {
            Livro atual = cabeca;
            while (atual != null) {
                System.out.println("Nome: " + atual.getNome() + ", Ano: " + atual.getAno() + ", Preço: " + atual.getPreco());
                atual = atual.getAnterior();
            }
        }
    }
    
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.adiciona(new Livro("Livro A", 2020, 39.90));
        lista.adiciona(new Livro("Livro B", 2021, 54.80));
        lista.adiciona(new Livro("Livro C", 2022, 27.40));
        lista.adiciona(new Livro("Livro D", 2023, 45.90));
        lista.listarLivros();
    }
}
