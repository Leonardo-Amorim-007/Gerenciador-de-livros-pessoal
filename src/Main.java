import model.*;
import view.VisualizacaoLivro;
import test.DataMock;
import repository.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        VisualizacaoLivro view = new VisualizacaoLivro();
        view.cadastrarLivro();
    }
}
