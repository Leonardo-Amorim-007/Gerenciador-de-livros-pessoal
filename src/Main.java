import view.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
                System.out.println("Apenas números entre 0 e 3 são aceitos!");
            }

            entrada.nextLine(); // Limpeza do buffer

            switch (opcao) {
                case 0:
                    descerTela();
                    System.out.println("Finalizando programa.");
                    System.exit(0);
                case 1:
                    descerTela();
                    livroView.cadastrarLivro();
                    break;
                case 2:
                    descerTela();
                   livroView.alterarLivro();
                    break;
                case 3:
                    descerTela();
                    livroView.mostrarBilbioteca();
                    System.out.println("Aperte enter para voltar");
                    entrada.nextLine();
                    break;
                default:
                    descerTela();
                    System.out.println("Apenas números de 1 a 3 são válidos!");
            }
            descerTela();
        }
    }

    private static void descerTela () {System.out.print("\n".repeat(50));}
}