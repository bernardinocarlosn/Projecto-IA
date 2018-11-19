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
public class Aresta {

	private double distancia;// criterio c1
        private double piso;
	private final No alvo;
	
	public Aresta(No localidadeAlvo, double custoLocalidade, double piso){
		distancia = custoLocalidade;
		alvo = localidadeAlvo;	
                this.piso = piso;
	}

	// Metodos getters
	public double getDistancia() {
		return distancia;
	}

	public No getAlvo() {
		return alvo;
	}

        public double getPiso() {
            return piso;
        }

        public void setPiso(double piso) {
            this.piso = piso;
        }

        public void setDistancia(double distancia) {
            this.distancia = distancia;
        }
        
}
