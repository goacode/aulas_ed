package Aula02;

public class PlaylistAula01 {
    public static void main(String[] args) {
        // Cria três objetos independentes.
        NoMusica a = new NoMusica("Musica A");
        NoMusica b = new NoMusica("Musica B");
        NoMusica c = new NoMusica("Musica C");

        // Liga A a B e B a C. C permanece com proximo null.
        a.proximo = b;
        b.proximo = c;

        // A variável atual começa na primeira música.
        NoMusica atual = a;

        // Visita cada nó e avança até chegar a null.
        while (atual != null) {
            System.out.println(atual.titulo);
            atual = atual.proximo;
        }
    }
}