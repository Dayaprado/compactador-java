/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ado.ListaEncadeada;
import ado.No;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dayprado
 */
public class ListaEncadeadaTest {

    @Test
    public void PermitirIniciarListaVazia() {
        ListaEncadeada lista = new ListaEncadeada();
        Assert.assertEquals(null, lista.getPrimeiro());
    }

    @Test
    public void PermitirDefinirNoInicial() {
        No inicial = new No("1");
        ListaEncadeada lista = new ListaEncadeada(inicial);

        Assert.assertEquals(inicial, lista.getPrimeiro());
    }

    @Test
    public void PermitirAdicionarNo() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        lista.adicionar(primeiro);

        Assert.assertEquals(primeiro, lista.getPrimeiro());
    }

    @Test
    public void PermitirAdicionarMaisDeUmNo() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        No segundo = new No("2");
        lista.adicionar(primeiro);
        lista.adicionar(segundo);

        Assert.assertEquals(segundo, lista.getPrimeiro().getProximo());
    }

    @Test
    public void PermitirAdicionarNoInicioDaLista() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        No segundo = new No("2");
        lista.adicionar(primeiro);
        lista.adicionarPrimeiro(segundo);

        Assert.assertEquals(segundo.getElemento(), lista.getPrimeiro().getElemento());
    }

    @Test
    public void PermitirDefinirElementoInicial() {
        ListaEncadeada lista = new ListaEncadeada("1");
    }

    @Test
    public void PermitirAdicionarElemento() {
        String primeiro = "1";
        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionar(primeiro);

        Assert.assertEquals(primeiro, lista.getPrimeiro().getElemento());
    }

    @Test
    public void PermitirPesquisarIndicePorElemento() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        No segundo = new No("2");
        lista.adicionar(primeiro);
        lista.adicionar(segundo);

        int indice = lista.getIndicePorElemento(segundo.getElemento());
        
        Assert.assertEquals(1, indice);        
    }

    @Test
    public void PermitirPesquisarNoPorIndice() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        No segundo = new No("2");
        lista.adicionar(primeiro);
        lista.adicionar(segundo);

        No no = lista.getNoPorIndice(1);
        
        Assert.assertEquals(segundo, no);
    }

    @Test
    public void PermitirRemoverNo() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        lista.adicionar(primeiro);
        lista.remover(primeiro);

        Assert.assertEquals(null, lista.getPrimeiro());
    }

    @Test
    public void PermitirRemoverPrimeiroNo() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        No segundo = new No("2");
        No terceiro = new No("3");        

        lista.adicionar(primeiro);
        lista.adicionar(segundo);
        lista.adicionar(terceiro);        

        lista.remover(segundo);
        Assert.assertEquals(terceiro, lista.getPrimeiro().getProximo());
    }

    @Test
    public void PermitirRemoverQualquerNo() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        No segundo = new No("2");

        lista.adicionar(primeiro);
        lista.adicionar(segundo);

        lista.remover(segundo);
        Assert.assertEquals(primeiro, lista.getPrimeiro());
    }

    @Test
    public void PermitirObterIndiceDoNo() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        No segundo = new No("2");
        lista.adicionar(primeiro);
        lista.adicionar(segundo);

        int indice = lista.getIndicePorNo(segundo);
        
        Assert.assertEquals(1, indice);                
    }

    @Test
    public void PermitirTamanhoDaLista() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        No segundo = new No("2");
        lista.adicionar(primeiro);
        lista.adicionar(segundo);

        int tamanho = lista.tamanho();
        
        Assert.assertEquals(2, tamanho);
    }

    @Test
    public void PermitirMoverNoProTopo() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        No segundo = new No("2");
        No terceiro = new No("3");        

        lista.adicionar(primeiro);
        lista.adicionar(segundo);
        lista.adicionar(terceiro);
        
        lista.topo(terceiro);
        
        Assert.assertEquals(terceiro, lista.getPrimeiro());
        Assert.assertEquals(primeiro, lista.getPrimeiro().getProximo());
        Assert.assertEquals(segundo, lista.getPrimeiro().getProximo().getProximo());
    }
    
    @Test
    public void PermitirZerarLista() {
        ListaEncadeada lista = new ListaEncadeada();
        No primeiro = new No("1");
        No segundo = new No("2");
        No terceiro = new No("3");        

        lista.adicionar(primeiro);
        lista.adicionar(segundo);
        lista.adicionar(terceiro);
        
        lista.limpar();
        
        Assert.assertEquals(null, lista.getPrimeiro());
    }
}
