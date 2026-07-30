package view;

import java.time.LocalDate;

public class Funcoes {
    void titulo(String mensagem, int largura) {
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

    String centralizarMensagem(String mensagem, int largura) {
        if (mensagem.length() > largura) {
            return " " + mensagem + " ";
        }

        int esquerda = (largura - mensagem.length())/2;
        int direita =  largura - mensagem.length() - esquerda;

        return " ".repeat(esquerda) + mensagem + " ".repeat(direita);
    }

    String esquerdaMensagem(String mensagem, int largura) {
        return "| " + mensagem + " ".repeat(largura-mensagem.length()-1) + "|";
    }

    String mostrarData(LocalDate data) {
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        int ano = data.getYear();
        return  String.format("%02d", dia) + "/" + String.format("%02d", mes) +  "/" + ano;
    }

    void divisoria(int largura) {System.out.println("+" + "-".repeat(largura) + "+");}
}
