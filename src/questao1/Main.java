package questao1;

import java.io.File;

/**
 * Launch the web-search example
 */
public class Main {
    public static void main(String[] args) {
    	// Source file (in the project's data/ folder)
        // CAMINHO CORRIGIDO: usa 'src/' e o nome exato do arquivo 'Hamlet' 
    	// A alteração também corrige o caminho 'questao1/Hamlet.txt' para 'src/questao1/Hamlet', que estava causando FileNotFoundException.
        File inputTextFile = new File("src/questao1/Hamlet"); 

        // NOVO: Cria a instância do novo filtro (Strategy) - Filtra por consultas com pelo menos 10 caracteres.
        QueryFilter filterStrategy = new MinLengthFilter(10); 

        // Build object graph - Injeta a Strategy no Model
        // Este construtor agora requer o QueryFilter, conforme refatoração anterior
        WebSearchModel model = new WebSearchModel(inputTextFile, filterStrategy);
        Snooper snoop = new Snooper(model);

        // Execute
        model.pretendToSearch();
    }
}