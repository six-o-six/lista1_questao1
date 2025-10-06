package questao1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Source file (in the project's data/ folder)
        File inputTextFile = new File("questao1/Hamlet.txt");

        // Build object graph
        WebSearchModel model = new WebSearchModel(inputTextFile);
        Snooper snoop = new Snooper(model);

        // Execute
        model.pretendToSearch();
    }
}
