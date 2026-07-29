package test;
import model.Livro;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataMock {
    public ArrayList<Livro> dadosMockados () {
        ArrayList<Livro> lista = new ArrayList<>();
        Livro livro = new Livro();

        livro.setId(1);
        livro.setTitulo("Percy Jackson Vol I");
        livro.setAutor("Rick Riordan");
        livro.setQtdPaginas(252);
        livro.setStatus("Lido");
        livro.setTipo("Físico");
        livro.setDataInicio(LocalDate.of(2026, 6, 25));
        livro.setDataFim(LocalDate.of(2026, 8, 19));
        lista.add(livro);
        livro = new Livro();

        livro.setId(2);
        livro.setTitulo("Percy Jackson Vol II");
        livro.setAutor("Rick Riordan");
        livro.setQtdPaginas(279);
        livro.setStatus("Lido");
        livro.setTipo("Físico");
        livro.setDataInicio(LocalDate.of(2026, 8, 20));
        livro.setDataFim(LocalDate.of(2026, 8, 30));
        lista.add(livro);
        livro = new Livro();

        livro.setId(3);
        livro.setTitulo("Harry Potter e a Pedra Filosofal");
        livro.setAutor("J. K. Rowling");
        livro.setQtdPaginas(264);
        livro.setStatus("Lido");
        livro.setTipo("Digital");
        livro.setDataInicio(LocalDate.of(2026, 9, 1));
        livro.setDataFim(LocalDate.of(2026, 9, 12));
        lista.add(livro);
        livro = new Livro();

        livro.setId(4);
        livro.setTitulo("O Hobbit");
        livro.setAutor("J. R. R. Tolkien");
        livro.setQtdPaginas(336);
        livro.setStatus("Lendo");
        livro.setTipo("Físico");
        livro.setDataInicio(LocalDate.of(2026, 9, 15));
        lista.add(livro);
        livro = new Livro();

        livro.setId(5);
        livro.setTitulo("1984");
        livro.setAutor("George Orwell");
        livro.setQtdPaginas(416);
        livro.setStatus("Lido");
        livro.setTipo("Digital");
        livro.setDataInicio(LocalDate.of(2026, 7, 5));
        livro.setDataFim(LocalDate.of(2026, 7, 20));
        lista.add(livro);
        livro = new Livro();

        livro.setId(6);
        livro.setTitulo("A Guerra dos Mundos");
        livro.setAutor("H. G. Wells");
        livro.setQtdPaginas(224);
        livro.setStatus("Lido");
        livro.setTipo("Físico");
        livro.setDataInicio(LocalDate.of(2026, 5, 10));
        livro.setDataFim(LocalDate.of(2026, 5, 18));
        lista.add(livro);
        livro = new Livro();

        livro.setId(7);
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setQtdPaginas(288);
        livro.setStatus("Não lido");
        livro.setTipo("Digital");
        lista.add(livro);
        livro = new Livro();

        livro.setId(8);
        livro.setTitulo("O Pequeno Príncipe");
        livro.setAutor("Antoine de Saint-Exupéry");
        livro.setQtdPaginas(96);
        livro.setStatus("Lido");
        livro.setTipo("Físico");
        livro.setDataInicio(LocalDate.of(2026, 4, 1));
        livro.setDataFim(LocalDate.of(2026, 4, 3));
        lista.add(livro);
        livro = new Livro();

        livro.setId(9);
        livro.setTitulo("O Código Da Vinci");
        livro.setAutor("Dan Brown");
        livro.setQtdPaginas(480);
        livro.setStatus("Lendo");
        livro.setTipo("Digital");
        livro.setDataInicio(LocalDate.of(2026, 10, 2));
        lista.add(livro);
        livro = new Livro();

        livro.setId(10);
        livro.setTitulo("As Crônicas de Nárnia");
        livro.setAutor("C. S. Lewis");
        livro.setQtdPaginas(752);
        livro.setStatus("Lido");
        livro.setTipo("Físico");
        livro.setDataInicio(LocalDate.of(2026, 2, 1));
        livro.setDataFim(LocalDate.of(2026, 2, 28));
        lista.add(livro);
        livro = new Livro();

        livro.setId(11);
        livro.setTitulo("Duna");
        livro.setAutor("Frank Herbert");
        livro.setQtdPaginas(680);
        livro.setStatus("Não lido");
        livro.setTipo("Físico");
        lista.add(livro);

        return lista;
    }

    public Livro dataLivro () {
        Livro livro = new Livro();
        livro.setId(3);
        livro.setTitulo("Harry Potter e a Pedra Filosofal");
        livro.setAutor("J. K. Rowling");
        livro.setQtdPaginas(264);
        livro.setStatus("Lido");
        livro.setTipo("Digital");
        livro.setDataInicio(LocalDate.of(2026, 9, 5));
        livro.setDataFim(LocalDate.of(2026, 9, 12));
        return livro;
    }
}