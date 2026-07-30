package repository;
import model.Livro;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class LivroRepository {
    private final JsonWriter escrita = new JsonWriter();
    private final JsonReader leitura = new JsonReader();
    private final Path caminho = Path.of("Arquivos/livros.jsonl");
    private int qtdLivros;
    private int ultimoId;
    private ArrayList<Livro> livros;

    public LivroRepository() {
        // Carregando os livros
        try {
            livros = leitura.leituraTodosLivros(caminho);
        } catch (IOException e) {
            if (e.toString().contains("NoSuchFileException")) {
                throw new RuntimeException("Erro: Não existe livros salvos!");
            } else
                throw new RuntimeException("Erro: Houve um problema com o arquivo. \nERROR:" + e);
        }

        // Identificando as váriaveis de controle
        qtdLivros = livros.size();

        for (Livro livro : livros) {
            ultimoId = Math.max(livro.getId(), ultimoId);
        }
    }

    public ArrayList<Livro> listarLivros (){
        return this.livros;
    }

    public int ultimoId () {return ultimoId;}

    public int getQtdLivros () {return qtdLivros;}

    public void salvarLivro(Livro livro) {
        try {
            escrita.salvarLivro(livro, caminho);
        } catch (IOException e) {
            throw new RuntimeException("Erro: Houve um problema ao salvar o arquivo. \nERROR:" + e);
        }
    }
}
