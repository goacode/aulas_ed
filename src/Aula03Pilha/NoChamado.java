package Aula03Pilha;

public class NoChamado {

    // Guarda o código numérico do chamado.
    int codigo;

    // Guarda a descrição do chamado.
    String descricao;

    // Guarda uma referência para o próximo nó.
    NoChamado proximo;

    // Construtor utilizado para criar um novo nó.
    public NoChamado(int codigo, String descricao) {

        // Inicializa os dados do chamado.
        this.codigo = codigo;
        this.descricao = descricao;

        // O novo nó começa sem apontar para outro nó.
        this.proximo = null;
    }
}