package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Livro {
    private int id;
    private int qtdPaginas;
    private int tempoLeitura;
    private float mediaPaginasLidas;
    private String titulo;
    private String autor;
    private String status;
    private String tipo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    // Métodos sets
    public void setId(int id) {this.id = id;}
    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
        atualizarInformacoes();
    }
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAutor(String autor) {this.autor = autor;}
    public void setStatus(String status) {this.status = status;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public void setDataInicio(LocalDate data) {
        this.dataInicio = data;
        atualizarInformacoes();
    }
    public void setDataFim(LocalDate data) {
        this.dataFim = data;
        atualizarInformacoes();
    }

    // Métodos get
    public int getId() {return this.id;}
    public int getQtdPaginas() {return this.qtdPaginas;}
    public int getTempoLeitura() {return this.tempoLeitura;}
    public float getMediaPaginasLidas() {return mediaPaginasLidas;}
    public String getTitulo() {return this.titulo;}
    public String getAutor() {return this.autor;}
    public String getStatus() {return this.status;}
    public String getTipo() {return this.tipo;}
    public LocalDate getDataInicio() {return dataInicio;}
    public LocalDate getDataFim() {return dataFim;}

    // Funções
    private void atualizarInformacoes() {
        // Atualização do tempo de leitura
        if (qtdPaginas >= 0 && dataInicio != null && dataFim != null) {
            tempoLeitura = (int) ChronoUnit.DAYS.between(dataInicio, dataFim);
            mediaPaginasLidas = (float) qtdPaginas / (float) tempoLeitura;
        }
    }
}