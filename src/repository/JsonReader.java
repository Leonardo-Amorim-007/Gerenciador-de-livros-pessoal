package repository;
import model.Livro;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class JsonReader {
    public ArrayList<Livro> leituraTodosLivros(Path caminho) throws IOException {
        // Leitura do Json
        BufferedReader livroTexto = Files.newBufferedReader(caminho);
        String json = livroTexto.readLine();

        // Objetos para armezenar
        ArrayList<Livro> biblioteca = new ArrayList<>();
        Livro livro = new Livro();

        // Variáveis de controle
        String variavel;
        int indexAnterior;
        int indexPosterior;
        int qtdVariaveis;

        while (json != null){
            qtdVariaveis = contagemVirgula(json);

            for (int i = 0; i <= qtdVariaveis; i++) {
                // Busca por qual é o nome do dado
                indexAnterior = json.indexOf("\"") + 1;
                indexPosterior = json.substring(indexAnterior).indexOf("\"") + indexAnterior;
                variavel = json.substring(indexAnterior, indexPosterior);

                // Busca pelo dado do tipo correspondente
                switch (variavel) {
                    case "id":
                        livro.setId(coletarNumero(json));
                        break;
                    case "titulo":
                        livro.setTitulo(coletarTexto(json));
                        break;
                    case "autor":
                        livro.setAutor(coletarTexto(json));
                        break;
                    case "qtdPg":
                        livro.setQtdPaginas(coletarNumero(json));
                        break;
                    case "tipo":
                        livro.setTipo(coletarTexto(json));
                        break;
                    case "status":
                        livro.setStatus(coletarTexto(json));
                        break;
                    case "dataInicio":
                        livro.setDataInicio(LocalDate.parse(coletarTexto(json)));
                        break;
                    case "dataFim":
                        livro.setDataFim(LocalDate.parse(coletarTexto(json)));
                        break;
                    default:
                        throw new RuntimeException("Arquivo json foi corrompido ou não é compatível com esse sistema");
                }

                json = json.substring(json.indexOf(",") + 1);

            }
            json = livroTexto.readLine();
            biblioteca.add(livro);
            livro = new Livro();
        }

        return biblioteca;
    }

    private int coletarNumero (String numText) {
        int  indexAnterior = numText.indexOf(":")+1;
        int indexPosterior = numText.substring(indexAnterior).indexOf(",")+indexAnterior;
        return Integer.parseInt(numText.substring(indexAnterior, indexPosterior));
    }

    private String coletarTexto (String text) {
        int indexAnterior = text.indexOf(":");
        int indexPosterior;

        if (text.lastIndexOf(":") != indexAnterior)
            indexPosterior = text.substring(indexAnterior).indexOf(",")+indexAnterior;
        else
            indexPosterior = text.substring(indexAnterior).indexOf("}")+indexAnterior;

        return text.substring(indexAnterior+2, indexPosterior-1);
    }

    private int contagemVirgula(String texto) {
        String novoTexto = texto.replace(",", "");
        return texto.length()-novoTexto.length();
    }
}
