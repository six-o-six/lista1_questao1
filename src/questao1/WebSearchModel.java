package questao1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Perform "web search" (from a  file), notify the interested observers of each query.
 */
public class WebSearchModel {
    private final File sourceFile;
    private final List<QueryObserver> observers = new ArrayList<>();
    private final QueryFilter queryFilter; // NOVO: Campo para a Strategy (filtro)

    public interface QueryObserver {
        void onQuery(String query);
    }

    // CONSTRUTOR MODIFICADO para receber a Strategy
    public WebSearchModel(File sourceFile, QueryFilter queryFilter) {
        this.sourceFile = sourceFile;
        this.queryFilter = queryFilter;
    }

    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            while ( true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                // USO DA STRATEGY: Aplica o filtro antes de notificar
                if (queryFilter.shouldProcess(line)) { 
                    notifyAllObservers(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addQueryObserver(QueryObserver queryObserver) {
        observers.add(queryObserver);
    }

    private void notifyAllObservers(String line) {
        for (QueryObserver obs : observers) {
            obs.onQuery(line);
        }
    }
}