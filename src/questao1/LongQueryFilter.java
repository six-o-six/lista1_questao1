package questao1;

/**
 * Filtro que aceita a consulta se ela tiver mais de 60 caracteres.
 * (Concrete Strategy)
 */
public class LongQueryFilter implements QueryFilter {
    private static final int MAX_LENGTH = 60;
    
    @Override
    public boolean shouldProcess(String query) {
        if (query == null) {
            return false;
        }
        // Retorna true se o comprimento da string for maior que MAX_LENGTH
        return query.length() > MAX_LENGTH;
    }
}