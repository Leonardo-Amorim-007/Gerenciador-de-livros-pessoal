import view.*;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        VisualizacaoLivro livroView = new VisualizacaoLivro();
        VisualizacaoMenu menuView = new VisualizacaoMenu();
        Scanner entrada = new Scanner(System.in);
        int opcao=0;

        // Rodando o programa
        while (true) {
            menuView.telaInicial();

            System.out.print("Qual é sua opção: ");
            try {
                opcao = entrada.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Apenas números entre 0 e 4 são aceitos!");
            }

            entrada.nextLine(); // Limpeza do buffer

            switch (opcao) {
                case 0:
                    System.out.println(" ");
                    System.out.println("Finalizando programa.");
                    System.exit(0);
                case 1:
                    System.out.println(" ");
                    livroView.cadastrarLivro();
                    break;
                case 2:
                    System.out.println(" ");
                   livroView.alterarLivro();
                    break;
                case 3:
                    System.out.println(" ");
                    livroView.mostrarBiblioteca();
                    System.out.println("Aperte enter para voltar");
                    entrada.nextLine();
                    break;
                case 4:
                    System.out.println(" ");
                    livroView.deletarLivro();
                default:
                    System.out.println(" ");
                    System.out.println("Apenas números de 1 a 4 são válidos!");
            }
            System.out.println(" ");
        }
    }
}