package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.Graph;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class GraphImpl<N> implements Graph<N>{
    final private Map<N, HashSet<N>> grafo = new HashMap<>();

    /*
    public void addNode(N n){
        if(n != null && !this.grafo.containsKey(n)){
            grafo.put(n, new HashSet<>());
        }
    }
    */
    @Override
    public void addNode(N n){
        if(n != null && !this.grafo.containsKey(n)){
            grafo.putIfAbsent(n, new HashSet<>());
        }
    }

    /*
    public void addEdge(N source, N target){
        if(source != null && target != null){
            this.grafo.get(source).add(target);
            this.grafo.get(target).add(source);
        }
    }
    */
    @Override
    public void addEdge(N source, N target){
        if(source != null && target != null){
            this.grafo.get(source).add(target);
        }
    }

    /*
    public Set<N> nodeSet(){
        Set<N> s = new HashSet<>();
        for(N nodo : this.grafo.keySet()){
            s.add(nodo);
        }
        return s;
    }
    */
    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(this.grafo.keySet());
    }

    /*
    public Set<N> linkedNodes(N node){
        Set<N> s = new HashSet<>();
        for(N nodo : this.grafo.get(node)){
            s.add(nodo);
        }
        return s;
    }
    */
    @Override
    public Set<N> linkedNodes(final N node) {
        return grafo.get(node);
    }

    public boolean nodesExist(N source, N target){
        Set<N> s = new HashSet<>(nodeSet());
        return s.contains(source) && s.contains(target);
    }

    @Override
    public List<N> getPath(N source, N target){
        if(nodesExist(source, target)){
            Set<N> visited = new HashSet<>();
            List<N> path = new ArrayList<>();
            if(dfs(source, target, visited, path)){
                Collections.reverse(path);
                return path;
            }
            return Collections.emptyList();
        }
        else{
            return Collections.emptyList();
        }
    }

    public boolean dfs(N source, N target, Set<N> visited, List<N> path){
        if(source.equals(target)){
            path.add(source);
            return true;
        }

        visited.add(source);
        for(N n : this.grafo.get(source)){
            if(!visited.contains(n)){
                if(dfs(n, target, visited, path) == true){
                    path.add(source);
                    return true;
                }
            }
        }
        return false;
    }
    /*dfs(current, target, visited, path):

    // Caso base 1: sono arrivato al target!
    se current == target:
        aggiungi current al path
        ritorna true

    // Segno current come visitato
    aggiungi current a visited

    // Esploro tutti i vicini
    per ogni vicino di current:
        se vicino NON è in visited:
            // Provo ricorsivamente su questo vicino
            se dfs(vicino, target, visited, path) == true:
                // Il vicino ha trovato il target!
                // Aggiungo current al path (costruisco all'indietro)
                aggiungi current al path
                ritorna true

    // Nessun vicino ha trovato il target
    ritorna false
Punti chiave:

Aggiungi al visited prima di esplorare i vicini
Aggiungi al path solo se la ricorsione ha successo
Il path si costruisce "al contrario" durante il ritorno della ricorsione, quindi inverto con Collections.reverse*/
}
