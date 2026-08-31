package Aula02;

public class NoChamado {
    // Dado numérico do chamado.
    int codigo;
    // Texto que descreve o problema.
    String descricao;
    // Referência para o próximo nó da cadeia.
    NoChamado proximo;
    public NoChamado(int codigo, String descricao) {
        // Inicializa os dados do objeto atual.
        this.codigo = codigo;
        this.descricao = descricao;
        // O nó nasce sem sucessor.
        this.proximo = null;
    }
}