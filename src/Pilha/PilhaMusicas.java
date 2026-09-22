package Pilha;

import Pilha.NoMusica;

public class PilhaMusicas {

    NoMusica topo = new NoMusica(0, "", null);
    int tamanho;

    public boolean isVazia(NoMusica pilha){
        if(pilha == null){
            return true;
        }else{
            return false;
        }
    }

    public int getTamanho(){
        return tamanho;
    }

    public void empilhar(int codigo, String titulo, NoMusica pilha){

        pilha = new NoMusica(codigo, titulo, null);

        pilha.proximo = topo;
        topo = pilha;
        tamanho++;

    }
}
