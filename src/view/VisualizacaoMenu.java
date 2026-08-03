package view;

public class VisualizacaoMenu extends Funcoes {
    private int larguraMaxima = 50;

    public void telaInicial () {

        titulo("Menu Principal", larguraMaxima);

        System.out.println(esquerdaMensagem(" Por favor, escolha uma das opções abaixo: ", larguraMaxima));
        System.out.println(esquerdaMensagem(" 1 - Cadastrar novo livro.", larguraMaxima));
        System.out.println(esquerdaMensagem(" 2 - Alterar informações de um Livro.", larguraMaxima));
        System.out.println(esquerdaMensagem(" 3 - Visualizar biblioteca de livros.", larguraMaxima));
        System.out.println(esquerdaMensagem(" 0 - Finalizar programa.", larguraMaxima));

        divisoria(larguraMaxima);
    }
}
