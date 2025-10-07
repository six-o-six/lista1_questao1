package questao1;

import questao1.WebSearchModel.QueryObserver;

/**
 * Watches the search queries.
 * Implementa o padrão Observer (Observador) e define qual política de filtro
 * (Strategy) deseja usar para receber notificações.
 */
public class Snooper {
    private final WebSearchModel model;

    public Snooper(WebSearchModel model) {
        this.model = model;

        // 1. OBSERVER 'FRIEND'
        // Cria a estratégia que checa por "friend" (case-insensitive)
        QueryFilter friendFilter = new ContainsFriendFilter();
        
        // Registra o observador com sua estratégia e lógica de impressão
        model.addQueryObserver( new QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("Oh Yes! " + query);
            }
        }, friendFilter);


        // 2. OBSERVER DE CONSULTAS LONGAS
        // Cria a estratégia que checa por consultas com mais de 60 caracteres
        QueryFilter longQueryFilter = new LongQueryFilter();
        
        // Registra o observador com sua estratégia e lógica de impressão
        model.addQueryObserver( new QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("So long " + query);
            }
        }, longQueryFilter);
        
        
        // O código anterior (com o AcceptAllFilter) foi removido.
    }
}