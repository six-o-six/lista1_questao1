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
        
        // NOVO: Crie a instância do filtro (Strategy)
        QueryFilter filterStrategy = new AcceptAllFilter(); 

        // Build object graph - passe a Strategy para o Model
        WebSearchModel model = new WebSearchModel(inputTextFile, filterStrategy);
        Snooper snoop = new Snooper(model);

        // Execute
        model.pretendToSearch();
    }
}