package view;
import model.Livro;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

import service.VerificacaoLivro;

public class VisualizacaoLivro {
    private int larguraMaxima = 100;

    public void mostrarBilbioteca(ArrayList<Livro> lista) {
        int tamMaxTitulo = 0;
        int tamMaxAutor = 0;
        int tamMaxTipo = 0;
        int tamMaxQtdPg = 16;
        int tamMaxMediaLeitura = 24;

        for (Livro livro : lista) {
            tamMaxTitulo = Math.max(livro.getTitulo().length(), tamMaxTitulo);
            tamMaxAutor = Math.max(livro.getAutor().length(), tamMaxAutor);
            tamMaxTipo = Math.max(livro.getTipo().length(), tamMaxTipo);
        }

        tamMaxTitulo += 2;
        tamMaxAutor += 2;
        tamMaxTipo += 2;

        larguraMaxima = tamMaxTitulo + tamMaxAutor + tamMaxTipo + tamMaxQtdPg + tamMaxMediaLeitura + 4;
        
        titulo("Biblioteca de livros", larguraMaxima);

        titulo("Lendo", larguraMaxima);

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

        titulo("Lido", larguraMaxima);

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
                        centralizarMensagem(String.valueOf((int)livro.getMediaPaginasLidas()), tamMaxMediaLeitura) + "|");
            }
        }
        titulo("Não lido", larguraMaxima);

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

        System.out.println("+" + "-".repeat(larguraMaxima) + "+");
    }

    public void mostrarLivro(Livro livro) {

        // Mostrando o livro
        titulo(livro.getTitulo(), larguraMaxima);
        System.out.println(esquerdaMensagem("Id: " + livro.getId(), larguraMaxima));
        System.out.println(esquerdaMensagem("Autor: " + livro.getAutor(), larguraMaxima));
        System.out.println(esquerdaMensagem("Tipo: " + livro.getTipo(), larguraMaxima));
        System.out.println(esquerdaMensagem("Quantidade de página: " + livro.getQtdPaginas(), larguraMaxima));
        System.out.println(esquerdaMensagem("Status: " + livro.getStatus(), larguraMaxima));
        if(livro.getDataInicio() != null) {
            System.out.println(esquerdaMensagem("Ínicio da leitura: " + mostrarData(livro.getDataInicio()), larguraMaxima));
            if (livro.getDataFim() != null) {
                System.out.println(esquerdaMensagem("Fim da leitura: " + mostrarData(livro.getDataFim()), larguraMaxima));
                System.out.println(esquerdaMensagem("Tempo de leitura (dias): " + livro.getTempoLeitura(), larguraMaxima));
                System.out.println(esquerdaMensagem("Média de páginas lidas P/dia: " + String.format("%.1f", livro.getMediaPaginasLidas()), larguraMaxima));
            }
        }

        divisoria(larguraMaxima);
    }

    public void cadastrarLivro () {
        VerificacaoLivro verificar = new VerificacaoLivro();

        titulo("Cadastro de livro", larguraMaxima);

        // Coleta e verificação dos campos
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

        divisoria(larguraMaxima);

        mostrarLivro(verificar.getLivro());
    }

    // Funções da estrutura de visualização
    private void titulo(String mensagem, int largura) {
        divisoria(largura);

        if (mensagem.length() >= largura) {
            System.out.println("Título não encontrado!");
            return;
        }

        int esquerda = (largura - mensagem.length())/2;
        int direita =  largura - mensagem.length() - esquerda;

        System.out.println("|" + " ".repeat(esquerda) + mensagem + " ".repeat(direita) + "|");

        divisoria(largura);
    }

    private String centralizarMensagem(String mensagem, int largura) {
        if (mensagem.length() > largura) {
            return " " + mensagem + " ";
        }

        int esquerda = (largura - mensagem.length())/2;
        int direita =  largura - mensagem.length() - esquerda;

        return " ".repeat(esquerda) + mensagem + " ".repeat(direita);
    }

    private String esquerdaMensagem (String mensagem, int largura) {
        return "| " + mensagem + " ".repeat(largura-mensagem.length()-1) + "|";
    }

    private String mostrarData (LocalDate data) {
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        int ano = data.getYear();
        return  String.format("%02d", dia) + "/" + String.format("%02d", mes) +  "/" + ano;
    }

    private void divisoria (int largura) {
        System.out.println("+" + "-".repeat(largura) + "+");
    }

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