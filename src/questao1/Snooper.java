package questao1;

/**
 * Watches the search queries
 */
public class Snooper {
    private final WebSearchModel model;

    public Snooper(WebSearchModel model) {
        this.model = model;

        // O Snooper escolhe seu filtro (neste caso, o filtro mais simples que aceita tudo)
        QueryFilter snooperFilter = new AcceptAllFilter(); 

        // MODIFICADO: Passa o observador E o filtro para o modelo
        model.addQueryObserver( new WebSearchModel.QueryObserver() {
            @Override
            public void onQuery(String query) {
                System.out.println("Query: " + query);
            }
        }, snooperFilter);
    }
}