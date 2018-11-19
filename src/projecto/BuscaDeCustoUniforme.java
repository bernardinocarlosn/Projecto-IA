/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author Lenovo
 */
public class BuscaDeCustoUniforme {
    
    
    // Metodo que efectua Busca em custo uniforme
	public static void buscaCustoUniforme(No estadoInicial, No estadoObjectivo, double piso){

        estadoInicial.setCustoCaminho(0);
        
        // Criacao de Fila de Prioridade
        PriorityQueue<No> fila = new PriorityQueue<No>(20, 
            new Comparator<No>(){

                //override compare method
                public int compare(No i, No j){
                    if(i.getCustoCaminho() > j.getCustoCaminho()){
                        return 1;
                    }
                    else if (i.getCustoCaminho() < j.getCustoCaminho()){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        );

        // Adicionasse o estado inicial na fila de prioridade
        fila.add(estadoInicial);
        
        // Criasse a lista de estados visitados (inicialmente vazia)
        Set<No> explorados = new HashSet<No>();
        
        boolean encontrado = false;

        // 
        do{
            
            /// retira da fila de prioridade
            No corrente = fila.poll();
            //adiciona na tabela de visitados
            explorados.add(corrente);
            
            //Verifica se estado objectivo
            if(corrente.getNome().equals(estadoObjectivo.getNome())){
                encontrado = true;
            }

            //percorre as adjacencias do actual no
            for(Aresta v: corrente.getAdjacencias()){
            	No filho = v.getAlvo();
                double custo = v.getDistancia();
                filho.setCustoCaminho(corrente.getCustoCaminho()+custo);

                if(!explorados.contains(filho) && !fila.contains(filho)){
                    
                  if(v.getPiso() >= piso){
                        filho.setParent(corrente);
                        fila.add(filho);
                    }
                    
                }

                else if((fila.contains(filho))&&(filho.getCustoCaminho()<corrente.getCustoCaminho())){
              
                    filho.setParent(corrente);
                    corrente = filho;
                }
            }
        }while(!fila.isEmpty());

    }
	
	// Metodo que percore cria a lista invertida
    public List<No> printPath(No alvo){
    	
        List<No> path = new ArrayList<No>();
        for(No l = alvo; l!=null; l = l.getParent()){
        	
            path.add(l);
        }

        Collections.reverse(path);

        return path;

    }
}
