package service;

import model.Livro;
import repository.LivroRepository;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class VerificacaoAlteracao {
    private final LivroRepository banco = new LivroRepository();
    private Livro livro = new Livro();
    private Livro livroAlterado = new Livro();

    public ArrayList<Livro> listarLivros (){return banco.listarLivros();}

    public void coletaId (String idTexto) {
        idTexto = idTexto.trim();

        try {
            int id = Integer.parseInt(idTexto);
            if (id < 1)
                throw new IllegalArgumentException("Números menores que 1 são considerados inválidos!");
            else
                if (id <= banco.getQtdLivros())
                    this.livro = banco.listarLivro(id);
            return;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Somente números so aceitos");
        }
    }

    public Livro getLivroAtual() {return livro;}

    public Livro getLivroAlterado() {return livroAlterado;}

    public void verificarTitulo (String texto) {
        texto = texto.trim();
        if (texto.isBlank()) {
            livroAlterado.setTitulo(livro.getTitulo());
            return;
        }

        if (texto.length() > 200)
            throw new IllegalArgumentException("O campo não pode ter mais de 200 caracteres!");
        else
            livroAlterado.setTitulo(texto);
    }

    public void verificarAutor (String texto) {
        texto = texto.trim();
        if (texto.isBlank()) {
            livroAlterado.setAutor(livro.getAutor());
            return;
        }
        if (texto.length() > 100)
            throw new IllegalArgumentException("O campo não pode ter mais de 200 caracteres!");
        else
            livroAlterado.setAutor(texto);
    }

    public void verificarQtdPaginas (String texto) {
        texto = texto.trim();
        if (texto.isBlank()) {
            livroAlterado.setQtdPaginas(livro.getQtdPaginas());
            return;
        }
        try {
            int qtdPaginas = Integer.parseInt(texto);
            if (qtdPaginas < 1)
                throw new IllegalArgumentException("Números menores que 1 não são considerados válidos!");
            else
                livroAlterado.setQtdPaginas(qtdPaginas);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Não é possível transformar: \"" + texto + "\" em número!!");
        }
    }

    public void verificarTipo (String texto) {
        texto = texto.trim();

        if (texto.length() > 50)
            throw new IllegalArgumentException("O campo não pode ter mais de 50 caracteres!");
        else if (texto.isBlank())
            livroAlterado.setTipo(livro.getTipo());
        else
            livroAlterado.setTipo(texto);
    }

    public void verificarStatus(String texto) {
        texto = texto.trim();

        if (texto.isBlank()) {
            livroAlterado.setStatus(livro.getStatus());
            return;
        }

        if (texto.equalsIgnoreCase("Nao lido"))
            texto = "Não lido";

        if (texto.equalsIgnoreCase("Lido") || texto.equalsIgnoreCase("Lendo") || texto.equalsIgnoreCase("Não lido")) {
            texto = texto.substring(0,1).toUpperCase() + texto.substring(1).toLowerCase(); // Função para colocar apenas a primeira linha maiúscula
            livroAlterado.setStatus(texto);
        } else
            throw new IllegalArgumentException("Apenas são aceitos os seguintes valores \"Lido\", \"Lendo\" e \"Não lido\"");
    }

    public void verificarDataInicio (String dataTexto) {
        dataTexto = dataTexto.trim();
        if (dataTexto.isBlank()) {
            livroAlterado.setDataInicio(livro.getDataInicio());
            return;
        }
        livro.setDataInicio(transformaData(dataTexto));
    }

    public void verificarDataFim (String dataTexto) {
        dataTexto = dataTexto.trim();
        if (dataTexto.isBlank()) {
            livroAlterado.setDataFim(livro.getDataFim());
            return;
        }
        LocalDate data = transformaData(dataTexto);
        if (data.isAfter(livro.getDataInicio()))
            livro.setDataFim(data);
        else
            throw new IllegalArgumentException("A data de finalização não pode ser de antes da data de início!");
    }

    public void salvarLivro () {
        livroAlterado.setId(livro.getId());
        banco.alterarLivro(livroAlterado);
    }

    private LocalDate transformaData (String dataTexto) {
        int primeiraBarra = dataTexto.indexOf("/");
        int segundaBarra = dataTexto.lastIndexOf("/");

        if (primeiraBarra == -1 || segundaBarra == -1)
            throw new NumberFormatException("Apenas será aceitos números no formato: DD/MM/ANO");

        try {
            int dia = Integer.parseInt(dataTexto.substring(0, primeiraBarra));
            int mes = Integer.parseInt(dataTexto.substring(primeiraBarra+1, segundaBarra));
            int ano = Integer.parseInt(dataTexto.substring(segundaBarra+1));

            if (ano < 0)
                throw new IllegalArgumentException("Bom, são aceitos apenas valores acima de 0, também dúvido que vc tava vivo antes de cristo!");
            if (mes < 0 || mes > 12)
                throw new IllegalArgumentException("Apenas são válidos os meses entre 1 - 12");
            if (dia < 0 || dia > 31)
                throw new IllegalArgumentException("Apenas são válidos os dias entre de 1 - 31");

            return LocalDate.of(ano, mes, dia);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Apenas será aceitos números no formato: DD/MM/ANO");
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("A data: " + dataTexto + " não existe, por favor informe uma data válida!");
        }
    }
}
