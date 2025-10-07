package questao1;

/**
 * Filtro que aceita a consulta se ela contiver a palavra 'friend' (amigo),
 * sem diferenciar maiúsculas de minúsculas.
 * (Concrete Strategy)
 */
public class ContainsFriendFilter implements QueryFilter {
    @Override
    public boolean shouldProcess(String query) {
        if (query == null) {
            return false;
        }
        // Converte para minúsculas e checa a ocorrência da palavra 'friend'
        return query.toLowerCase().contains("friend");
    }
}