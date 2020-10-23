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
public class ListaEncadeada {

    No inicial;

    public ListaEncadeada() {
    }

    public ListaEncadeada(String elemento) {
        this.inicial = new No(elemento);
    }

    public ListaEncadeada(No inicial) {
        this.inicial = inicial;
    }

    /**
     * Retorna primeiro nó da lista
     * @return No - Primeiro nó da lista 
     */    
    public No getPrimeiro() {
        return inicial;
    }

    /**
     * Retorna indice pesquisando o conteúdo do nó (elemento)
     * @return int - Retorna posição na lista. retorna -1 caso não encontre 
     */    
    public int getIndicePorElemento(String elemento) {
        int count = 0;
        No temp = this.inicial;
        while (temp != null) {
            String el = temp.getElemento();
            if (el.equals(elemento)) {
                return count;
            }

            temp = temp.getProximo();
            count++;
        }

        return -1;
    }
    
    /**
     * Retorna indice pesquisando pelo nó
     * @return int - Retorna posição na lista. retorna -1 caso não encontre 
     */        
    public int getIndicePorNo(No no) {
        return this.getIndicePorElemento(no.getElemento());
    }    

    /**
     * Retorna nó pesquisando pelo indice
     * @return No - Retorna nó na lista. retorna nulo caso não encontre 
     */     
    public No getNoPorIndice(int indice) {
        int count = 0;
        No temp = this.inicial;
        while (temp != null) {
            if (count == indice) {
                return temp;
            }

            temp = temp.getProximo();
            count++;
        }

        return null;
    }

    /**
     * Retorna tamango da lista
     * @return int - tamanho da lista 
     */
    public int tamanho() {
        int count = 0;
        No temp = this.inicial;
        while (temp != null) {
            temp = temp.getProximo();
            count++;
        }
        
        return count;
    } 

    /**
     * Verifica se a lista está vázia.
     * @return boolean
     */    
    public boolean estaVazia() {
        return this.inicial == null;
    }    
    
    /**
     * Adiciona um nó usando somente o elemento.
     */        
    public void adicionar(String elemento) {
        adicionar(new No(elemento));
    }
    
    /**
     * Adiciona um nó na primeira posição usando somente o elemento.
     */            
    public void adicionarPrimeiro(String elemento) {
        adicionarPrimeiro(new No(elemento));        
    }    

    /**
     * Adiciona um novo nó.
     */                
    public void adicionar(No no) {
        if (this.inicial == null) {
            this.inicial = no;
        } else {
            adicionarUltimaPosicao(no);
        }
    }

    /**
     * Adiciona um nó na primeira posição.
     */
    public void adicionarPrimeiro(No no) {
        this.inicial = new No(no.getElemento(), this.inicial);
    }

    /**
     * Remove um nó da lista e rearranja os demais nós da lista
     * para evitar quebra da mesma.
     */    
    public void remover(No no) {
        int indice = this.getIndicePorNo(no);
        if (indice == 0) {
            this.inicial = this.inicial.getProximo();
        } else if (indice >= 0) {
            No anterior = this.getNoPorIndice(indice - 1);
            No pesquisado = this.getNoPorIndice(indice);
            anterior.setProximo(pesquisado.getProximo());
        }
    }

    /**
     * Move um elemento da lista para o topo da mesma.
     */        
    public void topo(No no) {
        if(this.getIndicePorNo(no) > 0){
            this.remover(no);
            no.setProximo(this.inicial);
            this.inicial = no;
        }
    }
    
    /**
     * Limpa a lista encadeada.
     */            
    public void limpar() {
        this.inicial = null;
    }    

    /**
     * Adiciona um nó na última posição.
     */
    private void adicionarUltimaPosicao(No no) {
        No temp = this.inicial;
        while (temp != null) {
            if (temp.getProximo() == null) {
                temp.setProximo(no);
                break;
            }

            temp = temp.getProximo();
        }
    }
}
