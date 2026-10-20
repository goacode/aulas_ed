package aula_04;

/*
 * NÍVEL 3 (use o que aprendeu nos níveis 1 e 2): escreva o laço de ATENDIMENTO.
 *
 * FINALIDADE NESTA AULA: o dia a dia do suporte é "atender todos os chamados na ordem em
 * que chegaram". Você vai escrever esse atendimento usando só os métodos da fila.
 *
 * O QUE FAZER: no lugar indicado, escreva um laço que atenda TODOS os chamados e imprima,
 * para cada um, uma linha no formato:  Atendendo: 101 - Configurar e-mail
 *
 * AO EXECUTAR (depois de você escrever o laço): escreve os 4 chamados na ordem de chegada
 * e, no final, confirma que a fila esvaziou e que ultimo() devolve null.
 * Este nível usa ultimo(), criado no Nível 2.
 */
public class PrincipalNivel3 {
    public static void main(String[] args) {
        // Cria a fila e coloca quatro chamados nela, NESTA ORDEM: 101, 205, 307 e 412.
        FilaChamados fila = new FilaChamados();
        fila.enfileirar(101, "Configurar e-mail");
        fila.enfileirar(205, "Instalar impressora");
        fila.enfileirar(307, "Redefinir senha");
        fila.enfileirar(412, "Trocar toner");

        // Mostra quantos chamados estão esperando (deve ser 4).
        System.out.println("Chamados esperando: " + fila.getTamanho());

        // >>> NÍVEL 3: ESCREVA O LAÇO DE ATENDIMENTO AQUI (e apague este aviso). <<<
        // Perguntas para guiar o raciocínio:
        //   1) Até quando o atendimento deve continuar?  (qual método responde isso?)
        //   2) Qual método tira o próximo chamado da fila?
        //   3) Onde ficam o código e a descrição do chamado que acabou de sair?

        while(!fila.estaVazia()){
            System.out.println("Atendendo: " + fila.frente().codigo + " - " + fila.frente().descricao);
            fila.desenfileirar();
        }


        // Depois do atendimento, confirma que a fila está vazia.
        System.out.println("Fila vazia? " + fila.estaVazia());

        // Confirma que ultimo() também é null quando a fila esvazia (invariante 1).
        System.out.println("Ultimo da fila: " + codigoOuNull(fila.ultimo()));
    }

    // Método auxiliar: devolve o código do nó como texto, ou "null" se não houver nó.
    static String codigoOuNull(NoChamado no) {
        // Se não há nó, devolve o texto "null"; se há, devolve o código dele como texto.
        return (no == null) ? "null" : String.valueOf(no.codigo);
    }
}
