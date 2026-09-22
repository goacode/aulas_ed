package Pilha;

public class NoMusica {

    int codigo;
    String titulo;

    NoMusica proximo;

    NoMusica(){
        this(0, "", null);
    }

    NoMusica(int codigo, String titulo, NoMusica proximo){
        this.codigo = codigo;
        this.titulo = titulo;
        this.proximo = null;
    }
}
