package questao1;

/**
 * Implementação de filtro de consulta que aceita apenas linhas com
 * um número mínimo de caracteres.
 * (Concrete Strategy)
 */
public class MinLengthFilter implements QueryFilter {
    private final int minLength;

    public MinLengthFilter(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean shouldProcess(String query) {
        // Retorna true se a consulta tiver pelo menos o número mínimo de caracteres (ignorando espaços em branco)
        return query != null && query.trim().length() >= minLength;
    }
}