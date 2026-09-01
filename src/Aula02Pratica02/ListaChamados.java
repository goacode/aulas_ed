package Aula02Pratica02;


public class ListaChamados {


        public boolean estaVazia(NoChamado inicio){
            if (inicio.descricao == null) {
                return true;
            } else {
                return false;
            }
        }

        public int getTamanho(NoChamado inicio){
            NoChamado atual = inicio;
            int qtde = 0;
            while (atual.proximo != null) {
                qtde++;
                atual = atual.proximo;
            }
            return qtde;
        }

        public void inserirNoInicio(int codigo, String descricao, NoChamado inicio){
            NoChamado novo = new NoChamado(codigo, descricao);
            if (estaVazia(inicio)) {
                inicio = novo;
            } else {
                novo.proximo = inicio;
            }
        }


        public void inserirNoFim(int codigo, String descricao, NoChamado inicio){
            NoChamado novo = new NoChamado(codigo, descricao);
            NoChamado atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }


        public void mostrar(NoChamado inicio){
            NoChamado atual = inicio;
            while(atual.proximo != null){
                System.out.println(atual.descricao);
                atual = atual.proximo;
            }

        }


    }
