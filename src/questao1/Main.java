package questao1;

import java.io.File;

/**
 * Launch the web-search example
 */
public class Main {
    public static void main(String[] args) {
        // Source file (caminho corrigido)
        File inputTextFile = new File("src/questao1/Hamlet"); 

        // Build object graph - O construtor do WebSearchModel não aceita mais um filtro global.
        WebSearchModel model = new WebSearchModel(inputTextFile);
        
        // O Snooper agora gerencia e injeta o filtro desejado.
        Snooper snoop = new Snooper(model); 

        // Execute
        model.pretendToSearch();
    }
}