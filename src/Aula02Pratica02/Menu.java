package Aula02Pratica02;


public class Menu {
    static ListaChamados metodos = new ListaChamados();
    public static void main(String[] args){
        NoChamado inicio = new NoChamado(0, null);

        metodos.inserirNoFim(2, "Aha", inicio);
        metodos.inserirNoFim(3, "Agnetha", inicio);
        metodos.inserirNoInicio(1, "Voulez-Vous", inicio);

        System.out.println("Vazia? " + metodos.estaVazia(inicio));
        System.out.println("Tamanho: " + metodos.getTamanho(inicio));

        metodos.mostrar(inicio);

    }


}
