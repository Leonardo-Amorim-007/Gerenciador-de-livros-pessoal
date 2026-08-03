package view;
import model.Livro;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

import repository.LivroRepository;
import service.VerificacaoAlteracao;
import service.VerificacaoCadastro;

public class VisualizacaoLivro extends Funcoes {
    public void mostrarBiblioteca() {
        ArrayList<Livro> lista = new LivroRepository().listarLivros();
        int tamMaxTitulo = 0;
        int tamMaxAutor = 0;
        int tamMaxTipo = 0;
        int tamMaxQtdPg = 16;
        int tamMaxMediaLeitura = 24;
        boolean livroLendo = false;
        boolean livroLido = false;
        boolean livroNaoLido = false;

        for (Livro livro : lista) {
            tamMaxTitulo = Math.max(livro.getTitulo().length(), tamMaxTitulo);
            tamMaxAutor = Math.max(livro.getAutor().length(), tamMaxAutor);
            tamMaxTipo = Math.max(livro.getTipo().length(), tamMaxTipo);
            livroLendo = !(livro.getStatus().compareTo("Lendo") == 0);
            livroLido = !(livro.getStatus().compareTo("Lido") == 0);
            livroNaoLido = !(livro.getStatus().compareTo("Não Lido") == 0);
        }

        tamMaxTitulo += 2;
        tamMaxAutor += 2;
        tamMaxTipo += 2;

        int larguraMaxima = tamMaxTitulo + tamMaxAutor + tamMaxTipo + tamMaxQtdPg + tamMaxMediaLeitura + 4;
        
        titulo("Biblioteca de livros", larguraMaxima);

        if (!(livroLendo || livroLido || livroNaoLido)) {
            System.out.println("Não há livros cadastrados! ");
            System.out.println("Por favor, cadastre um novo livro.");
            System.out.println("+" + "-".repeat(larguraMaxima) + "+");
            return;
        }

        titulo("Lendo", larguraMaxima);
        if (livroLendo) {
            System.out.println("|" + centralizarMensagem("Título", tamMaxTitulo) + "|" +
                    centralizarMensagem("Autor", tamMaxAutor) + "|" +
                    centralizarMensagem("Tipo", tamMaxTipo) + "|" +
                    centralizarMensagem("Qtd de páginas", tamMaxQtdPg) + "|" +
                    centralizarMensagem("Média de leitura / dia", tamMaxMediaLeitura) + "|");

            for (Livro livro : lista) {
                if (livro.getStatus().compareTo("Lendo") == 0) {
                    System.out.println("|" + centralizarMensagem(livro.getTitulo(), tamMaxTitulo) + "|" +
                            centralizarMensagem(livro.getAutor(), tamMaxAutor) + "|" +
                            centralizarMensagem(livro.getTipo(), tamMaxTipo) + "|" +
                            centralizarMensagem(String.valueOf(livro.getQtdPaginas()), tamMaxQtdPg) + "|" +
                            centralizarMensagem("NDA", tamMaxMediaLeitura) + "|");
                }
            }
        } else
            System.out.println(esquerdaMensagem("Não há livros nessa categoria", larguraMaxima));

        titulo("Lido", larguraMaxima);
        if (livroLido) {
            System.out.println("|" + centralizarMensagem("Título", tamMaxTitulo) + "|" +
                    centralizarMensagem("Autor", tamMaxAutor) + "|" +
                    centralizarMensagem("Tipo", tamMaxTipo) + "|" +
                    centralizarMensagem("Qtd de páginas", tamMaxQtdPg) + "|" +
                    centralizarMensagem("Média de leitura / dia", tamMaxMediaLeitura) + "|");

            for (Livro livro : lista) {
                if (livro.getStatus().compareTo("Lido") == 0) {
                    System.out.println("|" + centralizarMensagem(livro.getTitulo(), tamMaxTitulo) + "|" +
                            centralizarMensagem(livro.getAutor(), tamMaxAutor) + "|" +
                            centralizarMensagem(livro.getTipo(), tamMaxTipo) + "|" +
                            centralizarMensagem(String.valueOf(livro.getQtdPaginas()), tamMaxQtdPg) + "|" +
                            centralizarMensagem(String.valueOf((int) livro.getMediaPaginasLidas()), tamMaxMediaLeitura) + "|");
                }
            }
        } else
            System.out.println(esquerdaMensagem("Não há livros nessa categoria", larguraMaxima));

        titulo("Não lido", larguraMaxima);
        if (livroNaoLido) {
            System.out.println("|" + centralizarMensagem("Título", tamMaxTitulo) + "|" +
                    centralizarMensagem("Autor", tamMaxAutor) + "|" +
                    centralizarMensagem("Tipo", tamMaxTipo) + "|" +
                    centralizarMensagem("Qtd de páginas", tamMaxQtdPg) + "|" +
                    centralizarMensagem("Média de leitura / dia", tamMaxMediaLeitura) + "|");

            for (Livro livro : lista) {
                if (livro.getStatus().compareTo("Não lido") == 0) {
                    System.out.println("|" + centralizarMensagem(livro.getTitulo(), tamMaxTitulo) + "|" +
                            centralizarMensagem(livro.getAutor(), tamMaxAutor) + "|" +
                            centralizarMensagem(livro.getTipo(), tamMaxTipo) + "|" +
                            centralizarMensagem(String.valueOf(livro.getQtdPaginas()), tamMaxQtdPg) + "|" +
                            centralizarMensagem("NDA", tamMaxMediaLeitura) + "|");
                }
            }
        } else
            System.out.println(esquerdaMensagem("Não há livros nessa categoria", larguraMaxima));
        System.out.println("+" + "-".repeat(larguraMaxima) + "+");
    }

    public void mostrarLivro(Livro livro) {
        int larguraMaxima = 100;

        // Mostrando o livro
        titulo(livro.getTitulo(), larguraMaxima);
        System.out.println(esquerdaMensagem("Id: " + livro.getId(), larguraMaxima));
        System.out.println(esquerdaMensagem("Autor: " + livro.getAutor(), larguraMaxima));
        System.out.println(esquerdaMensagem("Tipo: " + livro.getTipo(), larguraMaxima));
        System.out.println(esquerdaMensagem("Quantidade de página: " + livro.getQtdPaginas(), larguraMaxima));
        System.out.println(esquerdaMensagem("Status: " + livro.getStatus(), larguraMaxima));
        if(livro.getDataInicio() != null) {
            System.out.println(esquerdaMensagem("Início da leitura: " + mostrarData(livro.getDataInicio()), larguraMaxima));
            if (livro.getDataFim() != null) {
                System.out.println(esquerdaMensagem("Fim da leitura: " + mostrarData(livro.getDataFim()), larguraMaxima));
                System.out.println(esquerdaMensagem("Tempo de leitura (dias): " + livro.getTempoLeitura(), larguraMaxima));
                System.out.println(esquerdaMensagem("Média de páginas lidas P/dia: " + String.format("%.1f", livro.getMediaPaginasLidas()), larguraMaxima));
            }
        }

        divisoria(larguraMaxima);
    }

    public void cadastrarLivro () {
        int larguraMaxima = 100;
        VerificacaoCadastro verificar = new VerificacaoCadastro();

        // Coleta e verificação dos campos
        titulo("Cadastro de livro", larguraMaxima);

        leituraCampo("Título: ", verificar::verificarTitulo);

        leituraCampo("Autor: ", verificar::verificarAutor);

        leituraCampo("Quantidade de páginas: ", verificar::verificarQtdPaginas);

        leituraCampo("Tipo do livro: ", verificar::verificarTipo);

        leituraCampo("Status de leitura(Lido, Lendo, Não lido): ", verificar::verificarStatus);
        if(verificar.getLivro().getStatus().contains("Lendo") || verificar.getLivro().getStatus().contains("Lido")) {
            leituraCampo("Data de inicio da leitura: ", verificar::verificarDataInicio);

            if (verificar.getLivro().getStatus().contains("Lido"))
                leituraCampo("Data de fim da leitura: ", verificar::verificarDataFim);
        }

        verificar.salvarLivro();
        System.out.println("\nLivro salvo com sucesso!");

        divisoria(larguraMaxima);
    }

    public void alterarLivro () {
        VerificacaoAlteracao verificador = new VerificacaoAlteracao();
        ArrayList<Livro> lista = verificador.listarLivros();

        // Escolha do livro a ser modificado
        int larguraId = 0;
        int larguraTitulo = 0;

        for (Livro livro : lista) { // Coletando o tamanho do dados
            larguraId = Math.max(larguraId, String.valueOf(livro.getId()).length());
            larguraTitulo = Math.max(larguraTitulo, livro.getTitulo().length());
        }

        larguraId = larguraId%2 == 1?larguraId+1:larguraId+2;
        larguraTitulo = larguraTitulo%2==1?larguraTitulo+1:larguraTitulo+2;
        int larguraMaxima = larguraId + larguraTitulo + 4;

        titulo("Alteração", larguraMaxima);

        System.out.println("|" + centralizarMensagem("Id", larguraId) + "|" + centralizarMensagem("Título", larguraTitulo) + "|");

        for (Livro livro : lista) {
            System.out.println(esquerdaMensagem(
                    centralizarMensagem(" " + livro.getId(), larguraId) + "|" +
                            centralizarMensagem(livro.getTitulo(), larguraTitulo), larguraMaxima));
        }

        divisoria(larguraMaxima);

        leituraCampo("Por favor, informe o ID do livro que deseja modificar: ", verificador::coletaId);

        // Modificação do livro
        System.out.println("Aperte enter caso não deseje alterar o campo.\n");

        System.out.println("Título atual: " + verificador.getLivroAtual().getTitulo());
        leituraCampo("Título: ", verificador::verificarTitulo);

        System.out.println("Autor atual: " + verificador.getLivroAtual().getAutor());
        leituraCampo("Autor: ", verificador::verificarAutor);

        System.out.println("Quantidade de páginas atual: " + verificador.getLivroAtual().getQtdPaginas());
        leituraCampo("Quantidade de páginas: ", verificador::verificarQtdPaginas);

        System.out.println("Tipo atual: " + verificador.getLivroAtual().getTipo());
        leituraCampo("Tipo do livro: ", verificador::verificarTipo);

        System.out.println("Status atual: " + verificador.getLivroAtual().getStatus());
        leituraCampo("Status de leitura(Lido, Lendo, Não lido): ", verificador::verificarStatus);

        if (!verificador.getLivroAtual().getStatus().equals(verificador.getLivroAlterado().getStatus())) {
            if (verificador.getLivroAlterado().getStatus().contains("Lendo") || verificador.getLivroAlterado().getStatus().contains("Lido")) {
                leituraCampo("Data de inicio da leitura: ", verificador::verificarDataInicio);

                if (verificador.getLivroAlterado().getStatus().contains("Lido"))
                    leituraCampo("Data de fim da leitura: ", verificador::verificarDataFim);
            }
        }
        verificador.salvarLivro();
        System.out.println("Livro salvo com sucesso!");
    }

    // Funções da estrutura de visualização
    private static void leituraCampo(String mensagem, Consumer<String> validador) {
        while (true) {
            Scanner entrada = new Scanner(System.in);
            System.out.print(mensagem);
            String valor = entrada.nextLine();

            try {
                validador.accept(valor);
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}