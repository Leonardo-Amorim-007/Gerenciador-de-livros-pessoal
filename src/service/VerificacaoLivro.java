package service;
import model.Livro;
import repository.LivroRepository;
import java.time.DateTimeException;
import java.time.LocalDate;

public class VerificacaoLivro {
    private final Livro livro = new Livro();
    private final LivroRepository banco = new LivroRepository();

    public void verificarTitulo (String texto) {
        texto = texto.trim();
        if (texto.isBlank())
            throw new IllegalArgumentException("O campo não pode estar vazio!");
        else if (texto.length() > 200)
            throw new IllegalArgumentException("O campo não pode ter mais de 200 caracteres!");
        else
            livro.setTitulo(texto);
    }

    public void verificarAutor (String texto) {
        texto = texto.trim();
        if (texto.isBlank())
            throw new IllegalArgumentException("O campo não pode estar vazio!");
        else if (texto.length() > 100)
            throw new IllegalArgumentException("O campo não pode ter mais de 200 caracteres!");
        else
            livro.setAutor(texto);
    }

    public void verificarQtdPaginas (String texto) {
        texto = texto.trim();
        try {
            int qtdPaginas = Integer.parseInt(texto);
            if (qtdPaginas < 1)
                throw new IllegalArgumentException("Números menores que 0 não são considerados válidos!");
            else
                livro.setQtdPaginas(qtdPaginas);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Não é possível transformar: \"" + texto + "\" em número!!");
        }
    }

    public void verificarStatus(String texto) {
        texto = texto.trim();
        if (texto.equalsIgnoreCase("Nao lido"))
            texto = "Não lido";

        if (texto.equalsIgnoreCase("Lido") || texto.equalsIgnoreCase("Lendo") || texto.equalsIgnoreCase("Não lido")) {
            texto = texto.substring(0,1).toUpperCase() + texto.substring(1).toLowerCase(); // Função para colocar apenas a primeira linha maiúscula
            livro.setStatus(texto);
        } else
            throw new IllegalArgumentException("Apenas são aceitos os seguintes valores \"Lido\", \"Lendo\" e \"Não lido\"");
    }

    public void verificarTipo (String texto) {
        texto = texto.trim();
        if (texto.length() > 50)
            throw new IllegalArgumentException("O campo não pode ter mais de 50 caracteres!");
        else
            livro.setTipo(texto);
    }

    public void verificarDataInicio (String dataTexto) {
        dataTexto = dataTexto.trim();
        livro.setDataInicio(transformaData(dataTexto));
    }

    public void verificarDataFim (String dataTexto) {
        dataTexto = dataTexto.trim();
        LocalDate data = transformaData(dataTexto);
        if (data.isAfter(livro.getDataInicio()))
            livro.setDataFim(data);
        else
            throw new IllegalArgumentException("A data de finalização não pode ser de antes da data de inicio!");
    }

    public void salvarLivro () {
        livro.setId(banco.ultimoId()+1);
        banco.salvarLivro(livro);
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

    public Livro getLivro() {return livro;}
}