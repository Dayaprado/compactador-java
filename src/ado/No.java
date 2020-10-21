/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ado;

/**
 *
 * @author dayprado
 */
public class No {
    
    String elemento;
    No proximo;
    
    public No(String elemento) {
        this.elemento = elemento;
    }
    
    public No(String elemento, No proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public String getElemento() {
        return elemento;
    }
    
    public No getProximo() {
        return proximo;
    }
    
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No{" + "elemento=" + elemento + ", proximo=" + proximo + '}';
    } 
}
