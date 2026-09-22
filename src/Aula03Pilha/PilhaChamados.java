package Aula03Pilha;

public class PilhaChamados {

    // Referência para o nó que está no topo da pilha.
    private NoChamado topo;
    // Quantidade de chamados atualmente empilhados.
    private int tamanho;

    // Construtor: cria uma pilha inicialmente vazia.
    public PilhaChamados() {
        topo = null;
        tamanho = 0;
    }

    // Retorna true quando não existe nenhum chamado empilhado.
    public boolean estaVazia() {
        return topo == null;
    }

    // Devolve a quantidade de chamados na pilha.
    public int getTamanho() {
        return tamanho;
    }

    // Empilha um novo chamado resolvido no topo.
    public void empilhar(int codigo, String descricao) {

        // Cria o nó que será empilhado.
        NoChamado novo = new NoChamado(codigo, descricao);

        // O novo nó passa a apontar para o antigo topo,
        // preservando o restante da pilha.
        novo.proximo = topo;
        // O novo nó passa a ser o topo da pilha.
        topo = novo;
        // Registra que existe um chamado a mais empilhado.
        tamanho++;
    }

    // Remove e devolve o chamado que está no topo.
    // Devolve null se a pilha estiver vazia.
    public NoChamado desempilhar() {
        // Não há o que desempilhar quando a pilha está vazia.
        if (estaVazia()) {
            return null;
        }
        // Guarda a referência do nó que está no topo.
        NoChamado removido = topo;
        // O topo passa a ser o nó seguinte, descartando o antigo topo.
        topo = topo.proximo;
        // Registra que a pilha passou a ter um chamado a menos.
        tamanho--;
        // Devolve o nó que foi removido.
        return removido;
    }

    // Consulta o chamado que está no topo, sem removê-lo.
    // Devolve null se a pilha estiver vazia.
    public NoChamado consultarTopo() {
        return topo;
    }

    // Mostra todos os chamados empilhados, do topo até a base.
    public void mostrar() {
        // Começa o percurso pelo topo da pilha.
        NoChamado atual = topo;
        // Visita cada nó até chegar ao final da pilha.
        while (atual != null) {
            System.out.println(atual.codigo + " - " + atual.descricao);
            atual = atual.proximo;
        }
    }
}

