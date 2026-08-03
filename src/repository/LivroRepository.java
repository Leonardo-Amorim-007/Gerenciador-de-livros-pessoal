package repository;
import model.Livro;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class LivroRepository {
    private final JsonWriter escrita = new JsonWriter();
    private final JsonReader leitura = new JsonReader();
    private final Path caminho = Path.of("Arquivos/livros.jsonl");
    private int ultimoId;
    private ArrayList<Livro> livros=null;

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
        for (Livro livro : livros) {
            ultimoId = Math.max(livro.getId(), ultimoId);
        }
    }

    public ArrayList<Livro> listarLivros (){return this.livros;}

    public Livro listarLivro (int id) {return livros.get(id-1);}

    public int ultimoId () {return ultimoId;}

    public int getQtdLivros () {return livros.size();}

    public void salvarLivro(Livro livro) {
        try {
            livros.add(livro);
            escrita.salvarLivro(livros, caminho);
            ultimoId++;
        } catch (IOException e) {
            throw new RuntimeException("Erro: Houve um problema ao salvar o livro no arquivo. \nERROR:" + e);
        }
    }

    public void alterarLivro(Livro livro) {
        try {
            livros.set(livro.getId()-1, livro);
            escrita.salvarLivro(livros, caminho);
        } catch (IOException e) {
            throw new RuntimeException("Erro: Houve um problema ao salvar o livro no arquivo. \nERROR:" + e);
        }
    }
}
