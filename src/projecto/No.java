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
public class No {
	
    private final String nome;
    private double custoCaminho;
    private double piso;
    private Aresta[] adjacencias;
    private No parent;

    public No(String nome){

        this.nome = nome;

    }

    // Setters and Getters
	public double getCustoCaminho() {
		return custoCaminho;
	}

	public void setCustoCaminho(double custoCaminho) {
		this.custoCaminho = custoCaminho;
	}

	public Aresta[] getAdjacencias() {
		return adjacencias;
	}

	public void setAdjacencias(Aresta[] adjacencias) {
		this.adjacencias = adjacencias;
	}

	public No getParent() {
		return parent;
	}

	public void setParent(No parent) {
		this.parent = parent;
	}

	public String getNome() {
		return nome;
	}
	
	// ToString
	public String toString(){
	    return nome;
	}
    

}

