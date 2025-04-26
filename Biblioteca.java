import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    //BD em memória
    private List<Livro> acervo = new ArrayList<>();

    public Livro adicionar(Livro novoLivro) throws Exception {
        if (novoLivro.getTitulo() == null || novoLivro.getTitulo().isEmpty() )
            throw new Exception("Título inválido!");
        
        acervo.add(novoLivro);

        return novoLivro;
    }


    public List<Livro> pesquisarPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisarTodos() {
        return acervo;
    }

    public boolean deletarLivro(String titulo) throws Exception {
        if (titulo == null || titulo.isEmpty()) {
            throw new Exception("Título inválido para exclusão!");
        }

        List<Livro> livrosParaRemover = new ArrayList<>();


        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livrosParaRemover.add(livro);
            }
        }

        boolean removido = acervo.removeAll(livrosParaRemover);

        return removido;
    }

}
