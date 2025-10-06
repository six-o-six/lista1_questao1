package questao1;

/**
 * Implementação padrão do filtro de consulta que aceita todas as linhas.
 * (Concrete Strategy)
 */
public class AcceptAllFilter implements QueryFilter {
    @Override
    public boolean shouldProcess(String query) {
        // Aceita todas as consultas, mantendo o comportamento original
        return true;
    }
}