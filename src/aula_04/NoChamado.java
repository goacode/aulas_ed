package aula_04;

/*
 * NoChamado: um NÓ da fila. Guarda UM chamado de suporte e a ligação com o próximo nó.
 *
 * FINALIDADE NESTA AULA: é a mesma classe da Aula 02. A fila não inventa um nó novo;
 * ela apenas liga os mesmos nós de outro jeito: entra pelo fim, sai pelo início.
 *
 * AO EXECUTAR: esta classe não tem main; ela só é usada pelas outras. Cada
 * "new NoChamado(...)" cria um objeto com um chamado e proximo = null.
 */
public class NoChamado {
    // Guarda o número (identificador) do chamado, por exemplo 101.
    int codigo;

    // Guarda o texto que descreve o problema, por exemplo "Configurar e-mail".
    String descricao;

    // Guarda a referência para o PRÓXIMO nó da fila. Vale null quando não há próximo.
    NoChamado proximo;

    // Construtor: roda uma vez, quando o nó é criado com "new".
    public NoChamado(int codigo, String descricao) {
        // O atributo codigo do objeto recebe o valor informado na criação.
        this.codigo = codigo;

        // O atributo descricao do objeto recebe o texto informado na criação.
        this.descricao = descricao;

        // O nó nasce solto: ainda não está ligado a nenhum outro nó.
        this.proximo = null;
    }
}
