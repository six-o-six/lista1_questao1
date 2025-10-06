package questao1;

/**
 * Interface que define o contrato para filtrar consultas (linhas) lidas da fonte de dados.
 * (Strategy Pattern)
 */
public interface QueryFilter {
    /**
     * Determina se uma consulta deve ser processada e enviada aos observadores.
     * @param query A linha lida (a consulta).
     * @return true se a consulta deve ser processada, false caso contrário.
     */
    boolean shouldProcess(String query);
}