package aula_04;

/*
 * FilaChamados: a FILA DE ESPERA do Sistema de Chamados de Suporte.
 *
 * REGRA (FIFO, First In First Out): o primeiro chamado que entra é o primeiro que sai.
 *   - ENTRA pelo FIM     -> método enfileirar
 *   - SAI pelo INÍCIO    -> método desenfileirar
 *
 * FINALIDADE NESTA AULA: ver, no código, como duas referências (inicio e fim) fazem a
 * fila crescer pelo fim e diminuir pelo início, sem percorrer a fila inteira.
 *
 * INVARIANTES (verdades que precisam valer ANTES e DEPOIS de cada operação):
 *   1) inicio == null   <=>   fim == null   <=>   tamanho == 0     (fila vazia)
 *   2) se a fila NÃO está vazia, então fim.proximo == null          (o último não aponta
 *      para ninguém)
 *
 * AO EXECUTAR: esta classe não tem main. Ela é usada por PrincipalNivel1, 2 e 3.
 */
public class FilaChamados {
    // Referência para o PRIMEIRO nó: é daqui que o próximo chamado sai para atendimento.
    private NoChamado inicio;

    // Referência para o ÚLTIMO nó: é por aqui que um chamado novo entra.
    private NoChamado fim;

    // Quantidade de chamados que estão esperando na fila.
    private int tamanho;

    // Construtor: roda uma vez, quando a fila é criada com "new FilaChamados()".
    public FilaChamados() {
        // Fila nova não tem primeiro nó.
        inicio = null;

        // Fila nova não tem último nó.
        fim = null;

        // Fila nova não tem nenhum chamado esperando.
        tamanho = 0;
    }

    /*
     * ESTAVAZIA: responde "não há ninguém esperando?".
     * FINALIDADE NESTA AULA: é a pergunta que enfileirar e desenfileirar fazem antes de
     *   mexer nas referências, porque a fila vazia é um caso especial.
     * AO EXECUTAR: devolve true se não há chamados; devolve false caso contrário.
     */
    public boolean estaVazia() {
        // Sem primeiro nó, não existe nenhum chamado na fila.
        return inicio == null;
    }

    /*
     * GETTAMANHO: informa quantos chamados estão esperando.
     * FINALIDADE NESTA AULA: mostrar que o contador é atualizado a cada entrada e saída,
     *   sem precisar percorrer a fila para contar.
     * AO EXECUTAR: devolve o valor guardado em tamanho. Não altera a fila.
     */
    public int getTamanho() {
        // Devolve o contador mantido por enfileirar e desenfileirar.
        return tamanho;
    }

    /*
     * ENFILEIRAR: o chamado novo ENTRA PELO FIM da fila.
     * FINALIDADE NESTA AULA: mostrar que entrar no fim é rápido, porque a referência
     *   fim já aponta para o último nó (nenhum percurso é necessário).
     * AO EXECUTAR: a fila ganha um chamado no fim; os que já esperavam não mudam de lugar.
     */
    public void enfileirar(int codigo, String descricao) {
        // Cria o nó que vai guardar o chamado novo (ele nasce com proximo = null).
        NoChamado novo = new NoChamado(codigo, descricao);

        // Caso 1: a fila está vazia (ainda não existe último nó para ligar ao novo).
        if (estaVazia()) {
            // O nó novo passa a ser o PRIMEIRO da fila...
            inicio = novo;

            // ...e também o ÚLTIMO, porque é o único.
            fim = novo;
        } else {
            // Caso 2: já existem chamados. O último nó atual passa a apontar para o novo.
            fim.proximo = novo;

            // O nó novo passa a ser o ÚLTIMO da fila.
            fim = novo;
        }

        // Registra que existe um chamado a mais esperando.
        tamanho++;
    }

    /*
     * DESENFILEIRAR: o chamado do INÍCIO sai da fila para ser atendido.
     * FINALIDADE NESTA AULA: mostrar o caso de borda, que é o momento em que a fila fica
     *   vazia: inicio vira null e fim também precisa voltar a ser null.
     * AO EXECUTAR: devolve o nó que estava no início e o retira da fila. Se a fila estiver
     *   vazia, não altera nada e devolve null.
     */
    public NoChamado desenfileirar() {
        // Fila vazia: não há quem atender. Devolve null e não mexe em nada.
        if (estaVazia()) {
            return null;
        }

        // Guarda o primeiro nó antes de mexer em inicio (senão ele seria perdido).
        NoChamado atendido = inicio;

        // O início avança para o próximo nó. Se não havia próximo, inicio vira null.
        inicio = inicio.proximo;

        // Se o início virou null, a fila acabou de ficar vazia...
        if (inicio == null) {
            // ...e então o fim também precisa voltar a ser null (invariante 1).
            fim = null;
        }

        // Registra que existe um chamado a menos esperando.
        tamanho--;

        // Entrega ao chamador o nó que saiu da fila.
        return atendido;
    }

    /*
     * FRENTE: consulta quem será atendido agora, SEM tirar da fila.
     * FINALIDADE NESTA AULA: separar CONSULTAR (não muda a fila) de REMOVER (muda a fila).
     * AO EXECUTAR: devolve o primeiro nó (ou null, se a fila estiver vazia). Não altera nada.
     */
    public NoChamado frente() {
        // Apenas devolve a referência inicio. Nenhuma referência é alterada.
        return inicio;
    }

    // >>> NÍVEL 2: crie aqui o método ultimo(), copiando o frente() (veja o roteiro). <<<

    /*
     * MOSTRAR: imprime a fila do início para o fim.
     * FINALIDADE NESTA AULA: permitir "enxergar" a fila a cada passo e comparar com o
     *   desenho feito no papel.
     * AO EXECUTAR: escreve uma linha na tela. Não altera a fila.
     */
    public void mostrar() {
        // Fila vazia: avisa e encerra o método (return sem valor sai do método).
        if (estaVazia()) {
            System.out.println("(fila vazia)");
            return;
        }

        // Começa no primeiro nó, usando uma referência auxiliar para não mover inicio.
        NoChamado atual = inicio;

        // Repete enquanto atual apontar para um nó que existe.
        while (atual != null) {
            // Imprime o código do chamado e uma seta para o próximo.
            System.out.print(atual.codigo + " -> ");

            // Avança a referência auxiliar para o próximo nó.
            atual = atual.proximo;
        }

        // Fecha a linha mostrando que a cadeia termina em null.
        System.out.println("null");
    }

    /*
     * DEPURAR: mostra as três variáveis internas da fila.
     * FINALIDADE NESTA AULA: conferir os invariantes. Aqui se vê para onde apontam
     *   inicio e fim em cada momento (inclusive quando a fila está vazia).
     * AO EXECUTAR: escreve uma linha na tela. Não altera a fila.
     */
    public void depurar() {
        // Para cada referência: se for null escreve "null", senão escreve o código do nó.
        String i = (inicio == null) ? "null" : String.valueOf(inicio.codigo);
        String f = (fim == null) ? "null" : String.valueOf(fim.codigo);

        // Imprime as três variáveis lado a lado.
        System.out.println("inicio=" + i + " | fim=" + f + " | tamanho=" + tamanho);
    }

    public NoChamado ultimo() {
        // Apenas devolve a referência fim. Nenhuma referência é alterada.
        return fim;
    }

}
