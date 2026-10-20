package aula_04;

/*
 * NÍVEL 2 (pequena modificação): usa o método ultimo(), que VOCÊ vai criar em FilaChamados
 * copiando o frente() e trocando a variável devolvida (veja o roteiro).
 *
 * FINALIDADE NESTA AULA: com frente() e ultimo() dá para ver, ao mesmo tempo, as duas
 * pontas da fila. Depois, ao comentar a linha "fim = null" do desenfileirar, vê-se por que
 * ela existe: o defeito não aparece em enfileirar nem em desenfileirar, só aparece aqui.
 *
 * ANTES de executar: escreva o que espera ver nas linhas A, B e C.
 *
 * AO EXECUTAR: escreve 3 linhas (A, B, C) e as variáveis internas da fila.
 * Se o NetBeans marcar erro em ultimo(), o método ainda não foi criado em FilaChamados.
 */
public class PrincipalNivel2 {
    public static void main(String[] args) {
        // Cria a fila e coloca três chamados nela: 101, 205 e 307.
        FilaChamados fila = new FilaChamados();
        fila.enfileirar(101, "Configurar e-mail");
        fila.enfileirar(205, "Instalar impressora");
        fila.enfileirar(307, "Redefinir senha");

        // Linha A: com a fila cheia, mostra as duas pontas.
        System.out.println("A) Fila cheia:           frente=" + codigoOuNull(fila.frente())
                + " | ultimo=" + codigoOuNull(fila.ultimo()));

        // Atende um chamado (o do início).
        fila.desenfileirar();

        // Linha B: depois de uma saída, mostra as duas pontas de novo.
        System.out.println("B) Depois de atender 1: frente=" + codigoOuNull(fila.frente())
                + " | ultimo=" + codigoOuNull(fila.ultimo()));

        // Atende os dois chamados que restavam: agora a fila fica vazia.
        fila.desenfileirar();
        fila.desenfileirar();

        // Linha C: com a fila vazia, as duas pontas deveriam ser null.
        System.out.println("C) Fila vazia:           frente=" + codigoOuNull(fila.frente())
                + " | ultimo=" + codigoOuNull(fila.ultimo()));

        // Mostra as variáveis internas para conferir o que está guardado em inicio e fim.
        fila.depurar();
    }

    // Método auxiliar: devolve o código do nó como texto, ou "null" se não houver nó.
    // FINALIDADE: evita um erro (NullPointerException) ao pedir .codigo de uma referência null.
    static String codigoOuNull(NoChamado no) {
        // Se não há nó, devolve o texto "null"; se há, devolve o código dele como texto.
        return (no == null) ? "null" : String.valueOf(no.codigo);
    }
}
