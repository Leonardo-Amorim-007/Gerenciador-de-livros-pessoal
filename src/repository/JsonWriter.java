package repository;
import model.Livro;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class JsonWriter {
    public void salvarLivro (ArrayList<Livro> livros, Path caminho) throws IOException {
        StringBuilder json = new StringBuilder();
        for (Livro livro : livros)
            json.append(montarJson(livro));

        Files.writeString(caminho, json.toString());
    }

    private String montarJson (Livro livro) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"id\":" + livro.getId());
        json.append(",\"titulo\":\"" + livro.getTitulo() + "\"");
        json.append(",\"autor\":\"" + livro.getAutor() + "\"");
        json.append(",\"qtdPg\":" + livro.getQtdPaginas());
        json.append(",\"tipo\":\"" + livro.getTipo() + "\"");
        json.append(",\"status\":\"" + livro.getStatus() + "\"");

        if(livro.getDataInicio() != null) {
            json.append(",\"dataInicio\":\"" + livro.getDataInicio() + "\"");
            if (livro.getDataFim() != null)
                json.append(",\"dataFim\":\"" + livro.getDataFim() + "\"");
        }

        json.append("}\n");

       return json.toString();
    }
}
