package repository;
import model.Livro;
import java.io.IOException;
import java.nio.file.*;

public class JsonWriter {
    public void salvarLivro (Livro livro, Path caminho) throws IOException {
        String json = montarJson(livro);

        // Alterar essa lógica
        if (Files.exists(caminho)) {
            json = "\n" + json;
        }

        Files.writeString(caminho, json, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
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

        json.append("}");

       return json.toString();
    }
}
