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

    public No getPrimeiro() {
        return inicial;
    }

    public int getIndicePorElemento(String elemento) {
        int count = 0;
        No temp = this.inicial;
        while (temp != null) {
            if (temp.getElemento() == elemento) {
                return count;
            }

            temp = temp.getProximo();
            count++;
        }

        return -1;
    }
    
    public int getIndicePorNo(No no) {
        return this.getIndicePorElemento(no.getElemento());
    }    

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

    public int tamanho() {
        int count = 0;
        No temp = this.inicial;
        while (temp != null) {
            temp = temp.getProximo();
            count++;
        }
        
        return count;
    } 
    
    public void adicionar(String elemento) {
        adicionar(new No(elemento));
    }

    public void adicionar(No no) {
        if (this.inicial == null) {
            this.inicial = no;
        } else {
            adicionarUltimaPosicao(no);
        }
    }

    public void adicionarPrimeiro(No no) {
        this.inicial = new No(no.getElemento(), this.inicial);
    }

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
    
    public void topo(No no) {
        if(this.getIndicePorNo(no) > 0){
            this.remover(no);
            no.setProximo(this.inicial);
            this.inicial = no;
        }
    }
    
    public void limpar() {
        this.inicial = null;
    }    

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
