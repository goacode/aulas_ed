package Aula03Pilha;

public class Principal {
    public static void main(String[] args) {
        // Cria a pilha que vai guardar o histórico de chamados resolvidos.
        PilhaChamados historico = new PilhaChamados();
        // Empilha o primeiro chamado resolvido.
        historico.empilhar(101, "Configurar e-mail");
        // Empilha o segundo chamado resolvido.
        historico.empilhar(205, "Instalar impressora");
        // Empilha o terceiro chamado resolvido.
        historico.empilhar(307, "Redefinir senha");
        // Mostra o histórico, do mais recente para o mais antigo.
        System.out.println("HISTORICO ATUAL");
        historico.mostrar();
        // Consulta qual foi o último chamado resolvido, sem remover.
        NoChamado ultimo = historico.consultarTopo();
        System.out.println("Ultimo resolvido: " + ultimo.codigo + " - " +
                ultimo.descricao);
        // Mostra quantos chamados existem no histórico.
        System.out.println("Tamanho: " + historico.getTamanho());
    }
}
