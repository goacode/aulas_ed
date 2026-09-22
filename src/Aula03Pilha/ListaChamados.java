package Aula03Pilha;

public class ListaChamados {

    // Referência para o primeiro nó da lista.
    private NoChamado inicio;

    // Referência para o último nó da lista.
    private NoChamado fim;

    // Quantidade de nós pertencentes à lista.
    private int tamanho;

    // Construtor: cria uma lista inicialmente vazia.
    public ListaChamados() {

        // Não existe primeiro nó.
        inicio = null;

        // Não existe último nó.
        fim = null;

        // A lista começa sem elementos.
        tamanho = 0;
    }

    // Verifica se a lista está vazia.
    public boolean estaVazia() {

        // Se inicio for null, não existe primeiro nó.
        return inicio == null;
    }

    // Devolve a quantidade de elementos da lista.
    public int getTamanho() {

        // Retorna o valor registrado no atributo tamanho.
        return tamanho;
    }

    // Insere um novo chamado no início da lista.
    public void inserirNoInicio(
            int codigo,
            String descricao
    ) {

        // Cria o novo nó.
        NoChamado novo =
                new NoChamado(codigo, descricao);

        // Verifica se esta será a primeira inserção.
        if (estaVazia()) {

            // O novo nó será o primeiro.
            inicio = novo;

            // Como é o único nó, também será o último.
            fim = novo;

        } else {

            // Liga o novo nó ao primeiro nó atual.
            // Essa atribuição preserva a lista antiga.
            novo.proximo = inicio;

            // Atualiza a entrada da lista.
            inicio = novo;
        }

        // Registra que existe um elemento a mais.
        tamanho++;
    }

    // Insere um novo chamado no final da lista.
    public void inserirNoFim(
            int codigo,
            String descricao
    ) {

        // Cria o novo nó.
        NoChamado novo =
                new NoChamado(codigo, descricao);

        // Verifica se esta será a primeira inserção.
        if (estaVazia()) {

            // O novo nó será simultaneamente
            // o primeiro e o último.
            inicio = novo;
            fim = novo;

        } else {

            // O último nó antigo passa a apontar
            // para o novo nó.
            fim.proximo = novo;

            // Atualiza a referência do último nó.
            fim = novo;
        }

        // Registra que existe um elemento a mais.
        tamanho++;
    }

    // Percorre e mostra todos os chamados.
    public void mostrar() {

        // A referência auxiliar começa no primeiro nó.
        NoChamado atual = inicio;

        // Continua enquanto houver um nó para visitar.
        while (atual != null) {

            // Mostra os dados do nó atual.
            System.out.println(
                    atual.codigo + " - " + atual.descricao
            );

            // Avança para o próximo nó.
            atual = atual.proximo;
        }
    }
}