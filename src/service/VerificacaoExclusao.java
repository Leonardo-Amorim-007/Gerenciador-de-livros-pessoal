package service;

import repository.LivroRepository;

public class VerificacaoExclusao {
    private final LivroRepository banco = new LivroRepository();

    public void deletarLivro (String idTexto) {
    idTexto = idTexto.trim();

    try {
        int id = Integer.parseInt(idTexto);
        if (id < 1)
            throw new IllegalArgumentException("Números menores que 1 são considerados inválidos!");
        else if (id <= banco.getQtdLivros()) {
            banco.excluirLivro(id);
            banco.salvar();
        }
    } catch (NumberFormatException e) {
        throw new NumberFormatException("Somente números so aceitos");
    }
}
}
