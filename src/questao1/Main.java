package questao1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
    	
        // Source file (in the project's data/ folder)
        // CAMINHO CORRIGIDO: usa 'src/' e o nome exato do arquivo 'Hamlet' 
    	// A alteração também corrige o caminho 'questao1/Hamlet.txt' para 'src/questao1/Hamlet', que estava causando FileNotFoundException.
        File inputTextFile = new File("src/questao1/Hamlet");

        // Build object graph
        WebSearchModel model = new WebSearchModel(inputTextFile);
        Snooper snoop = new Snooper(model);

        // Execute
        model.pretendToSearch();
    }
}