package Aula03Pilha;

public class Pratica02Teste {

    public static void main(String[] args) {

        // Cria uma lista inicialmente vazia.
        ListaChamados lista =
                new ListaChamados();

        // Insere o primeiro chamado no final.
        // Como a lista está vazia, ele será
        // simultaneamente o primeiro e o último.
        lista.inserirNoFim(
                101,
                "Configurar e-mail"
        );

        // Insere outro chamado depois do último.
        lista.inserirNoFim(
                205,
                "Instalar impressora"
        );

        // Insere um chamado antes do primeiro.
        lista.inserirNoInicio(
                50,
                "Sistema indisponivel"
        );

        // Mostra os chamados na ordem criada.
        lista.mostrar();

        // Mostra a quantidade de elementos.
        System.out.println(
                "Tamanho: " + lista.getTamanho()
        );

        // Informa se a lista está vazia.
        System.out.println(
                "Vazia? " + lista.estaVazia()
        );
    }
}