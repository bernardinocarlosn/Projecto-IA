/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

/**
 *
 * @author Lenovo
 */

public class Grafo {
	
	private No l1,l2, l3, l4, l5, l6, l7, l8;
	
	// Constructor
	public Grafo () {
		
		//initializar o grafo com base no mapa de maputo
		l1 = new No("Maputo");
		l2 = new No("Catembe");
		l3 = new No("Matola");
		l4 = new No("Liberdade");
		l5 = new No("Marracuene");
		l6 = new No("Namaacha");
		l7 = new No("Ressano Garcia");
		l8 = new No("Malhampsene");
		
		//initializar as vias de acesso
		l1.setAdjacencias(new Aresta[]{
	            new Aresta(l2,7,5),
	            new Aresta(l3,11,3),
	            new Aresta(l4,9,1),
	            new Aresta(l5, 30,4)
	    });
		
		l2.setAdjacencias(new Aresta[]{
	            new Aresta(l6,55,1),
	            new Aresta(l1,7,5)
	    });
                
		l3.setAdjacencias(new Aresta[]{
	            new Aresta(l6,50,2),
	            new Aresta(l1,11,3),
	            new Aresta(l4, 6,2),
	            new Aresta(l8, 9,3)
	    });
                
                
                
		l4.setAdjacencias(new Aresta[]{
	            new Aresta(l1,9,1),
	            new Aresta(l5,24,3),
	            new Aresta(l8, 7,1),
	            new Aresta(l3, 6,2)
	    });
		
		l5.setAdjacencias(new Aresta[]{
	            new Aresta(l1,30,4),
	            new Aresta(l4,24,3),
	            new Aresta(l8,28,4)
	    });
		
		l6.setAdjacencias(new Aresta[]{
	            new Aresta(l2,55,1), // 55
	            new Aresta(l3,50,2), // 50
	            new Aresta(l7,260,4) // 260
	    });
		
		l7.setAdjacencias(new Aresta[]{
	            new Aresta(l6,260,4),
	            new Aresta(l8,80,4)
	    });
		
		l8.setAdjacencias(new Aresta[]{
	            new Aresta(l5,28,4),
	            new Aresta(l4,7,1),
	            new Aresta(l3, 9,3),
	            new Aresta(l7, 80,4)
	    });
		
	}
    
    /// getters e setters

    public No getL1() {
        return l1;
    }

    public No getL2() {
        return l2;
    }

    public No getL3() {
        return l3;
    }

    public No getL4() {
        return l4;
    }

    public No getL5() {
        return l5;
    }

    public No getL6() {
        return l6;
    }

    public No getL7() {
        return l7;
    }

    public No getL8() {
        return l8;
    }

}

