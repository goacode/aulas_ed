package Aula02;
public class Pratica01 {
    public static void main(String[] args) {
        // Cria os três nós ainda independentes.
        NoChamado2 primeiro = new NoChamado2(101, "Configurar e-mail");
        NoChamado2 segundo = new NoChamado2(205, "Instalar impressora");
        NoChamado2 terceiro = new NoChamado2(307, "Redefinir senha");
        NoChamado2 quarto = new NoChamado2(410, "Atualizar sistema");
        // Forma a cadeia linear: 101 -> 205 -> 307 ->
        primeiro.proximo = segundo;
        segundo.proximo = terceiro;
        terceiro.proximo = quarto;
        // inicio identifica a entrada da cadeia.
        NoChamado2 inicio = primeiro;
        // atual percorre a cadeia sem modificar inicio.
        NoChamado2 atual = inicio;
        while (atual != null) {
            // Usa os dados do nó visitado.
            System.out.println(atual.codigo + " - " + atual.descricao);
            // Avança para o próximo nó.
            atual = atual.proximo;
        }
    }
}
