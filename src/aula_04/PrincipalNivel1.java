package aula_04;

/*
 * NÍVEL 1 (tudo pronto): PREVER, EXECUTAR e COMPARAR.
 *
 * FINALIDADE NESTA AULA: ver a fila em funcionamento no Sistema de Chamados e conferir
 * que o primeiro chamado a entrar é o primeiro a sair (FIFO).
 *
 * ANTES de executar: desenhe no papel inicio e fim a cada passo (1 a 5) e anote o que
 * você espera ver na tela. DEPOIS: execute e compare.
 *
 * AO EXECUTAR: escreve 5 blocos de texto na tela. A fila começa vazia, recebe 3 chamados,
 * atende 1, consulta a frente, atende os outros 2 e tenta atender com a fila vazia.
 */
public class PrincipalNivel1 {
    public static void main(String[] args) {
        // Cria a fila de espera do suporte. Ela nasce vazia.
        FilaChamados fila = new FilaChamados();

        // Chegam três chamados, NESTA ORDEM: 101, 205 e 307.
        fila.enfileirar(101, "Configurar e-mail");
        fila.enfileirar(205, "Instalar impressora");
        fila.enfileirar(307, "Redefinir senha");

        // Passo 1: mostra a fila e as variáveis internas depois das três entradas.
        System.out.println("1) Depois de enfileirar 101, 205 e 307:");
        fila.mostrar();
        fila.depurar();

        // Passo 2: atende UM chamado. O nó que sai é guardado em "atendido".
        NoChamado atendido = fila.desenfileirar();
        System.out.println("2) Atendido agora: " + atendido.codigo + " - " + atendido.descricao);
        fila.mostrar();
        fila.depurar();

        // Passo 3: consulta quem é o próximo, SEM retirar da fila.
        System.out.println("3) Proximo da fila (frente): " + fila.frente().codigo);

        // Passo 4: atende os dois chamados que restavam (o retorno não será usado aqui).
        fila.desenfileirar();
        fila.desenfileirar();
        System.out.println("4) Depois de atender os tres:");
        fila.mostrar();
        fila.depurar();

        // Passo 5: tenta atender com a fila vazia. O método deve devolver null.
        NoChamado nenhum = fila.desenfileirar();
        System.out.println("5) Atender com a fila vazia devolve: " + nenhum);
    }
}
