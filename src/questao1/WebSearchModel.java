package questao1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList; // Mantido por compatibilidade, mas a lógica usa Map
import java.util.List;    // Mantido por compatibilidade, mas a lógica usa Map

/**
 * Perform "web search" (from a  file), notify the interested observers of each query.
 */
public class WebSearchModel {
    private final File sourceFile;
    // Alterado de List para Map: associa cada observador (Key) ao seu filtro (Value)
    private final Map<QueryObserver, QueryFilter> observers = new HashMap<>(); 
    // O campo 'queryFilter' global foi removido

    public interface QueryObserver {
        void onQuery(String query);
    }

    // Construtor do Modelo revertido para a versão original, sem filtro global.
    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            while ( true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                notifyAllObservers(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // MÉTODO MODIFICADO: Agora aceita um QueryFilter junto com o observador
    public void addQueryObserver(QueryObserver queryObserver, QueryFilter queryFilter) {
        observers.put(queryObserver, queryFilter); // Armazena o par
    }
    
    // O antigo addQueryObserver(QueryObserver) foi removido.

    private void notifyAllObservers(String line) {
        // Itera sobre todos os pares (Observer, Filter)
        for (Map.Entry<QueryObserver, QueryFilter> entry : observers.entrySet()) {
            QueryObserver obs = entry.getKey();
            QueryFilter filter = entry.getValue();

            // Aplica o filtro específico do observador antes de notificá-lo
            if (filter.shouldProcess(line)) { 
                obs.onQuery(line);
            }
        }
    }
}