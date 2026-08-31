package Aula02;
public class Pratica01 {
    public static void main(String[] args) {
        // Cria os três nós ainda independentes.
        NoChamado primeiro = new NoChamado(101, "Configurar e-mail");
        NoChamado segundo = new NoChamado(205, "Instalar impressora");
        NoChamado terceiro = new NoChamado(307, "Redefinir senha");
        // Forma a cadeia linear: 101 -> 205 -> 307 ->
        primeiro.proximo = segundo;
        segundo.proximo = terceiro;
        // inicio identifica a entrada da cadeia.
        NoChamado inicio = primeiro;
        // atual percorre a cadeia sem modificar inicio.
        NoChamado atual = inicio;
        while (atual != null) {
            // Usa os dados do nó visitado.
            System.out.println(atual.codigo + " - " + atual.descricao);
            // Avança para o próximo nó.
            atual = atual.proximo;
        }
    }
}
