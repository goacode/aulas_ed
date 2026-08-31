package Aula02;

public class NoMusica {
    // Guarda o dado da música.
    String titulo;
    // Guarda a referência para a próxima música.
    NoMusica proximo;


    public NoMusica(String titulo) {
        // O objeto recebe o título informado ao construtor.
        this.titulo = titulo;
        // Ao nascer, o nó ainda não está ligado a outro.
        this.proximo = null;
    }
}