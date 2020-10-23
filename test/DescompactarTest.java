/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ado.Descompactar;
import ado.ListaEncadeada;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author dayprado
 */
public class DescompactarTest {
    
    @Test
    public void PermitirExibirListaDePalavras() {
        Descompactar descompactar = new Descompactar();
        ListaEncadeada lista = descompactar.getLista();
        
        Assert.assertNotNull(lista);
    }
    
    @Test
    public void TodoDescompactadorIniciaComUmaListaVazia() {
        Descompactar descompactar = new Descompactar();
        ListaEncadeada lista = descompactar.getLista();
        
        Assert.assertNotNull(lista);
        Assert.assertTrue(lista.estaVazia());        
    }
    
    @Test
    public void PermitirAdicionarNovaPalavraNaLista() {
        Descompactar descompactar = new Descompactar();
        descompactar.descompactar("A");
        
        Assert.assertEquals("A", descompactar.getLista().getPrimeiro().getElemento());
    }
    
    @Test
    public void AListaDeveTerSomentePalavraAlfaNumerica() {
        Descompactar descompactar = new Descompactar();
        descompactar.descompactar("A ;");
        
        Assert.assertEquals("A", descompactar.getLista().getPrimeiro().getElemento());
        Assert.assertEquals(1, descompactar.getLista().tamanho());        
    }    
    
    @Test
    public void TodaNovaPalavraDeveIrParaOTopoDaLista() {
        Descompactar descompactar = new Descompactar();
        descompactar.descompactar("A a");
        
        Assert.assertEquals("a", descompactar.getLista().getPrimeiro().getElemento());
        Assert.assertEquals(2, descompactar.getLista().tamanho());                
    }
    
    @Test
    public void AListaDeveSerCaseSensitive() {
        Descompactar descompactar = new Descompactar();
        descompactar.descompactar("A a");
        
        Assert.assertEquals("a", descompactar.getLista().getPrimeiro().getElemento());
        Assert.assertEquals(2, descompactar.getLista().tamanho());                    
    }
    
    @Test
    public void AListaNaoDeveRepetirPalavra() {
        Descompactar descompactar = new Descompactar();
        descompactar.descompactar("A A");
        
        Assert.assertEquals("A", descompactar.getLista().getPrimeiro().getElemento());
        Assert.assertEquals(1, descompactar.getLista().tamanho());                    
    }
    
    @Test
    public void PermitirDescompactarUmaFrase() {
        Descompactar descompactar = new Descompactar();

        String e1 = "Dear Sally,";
        String e2 = "Please, please do it--it would please";
        
        String r1 = descompactar.descompactar("Dear Sally,");
        String r2 = descompactar.descompactar("Please, please do it--1 would 4");
        
        Assert.assertEquals(e1, r1);
        Assert.assertEquals(e2, r2);        
    }
    
    @Test
    public void PermitirDescompactarUmTexto() {
        Descompactar descompactar = new Descompactar();

        String e1 = "Dear Sally,\nPlease, please do it--it would please";
        String r1 = descompactar.descompactar("Dear Sally,\nPlease, please do it--1 would 4");
        
        Assert.assertEquals(e1, r1);        
    }
    
    @Test
    public void PermitirSubstituirNovaOcorrenciaPorPosicaoLista() {
        String esperado = "A a A";
        
        Descompactar descompactar = new Descompactar();
        String resultado = descompactar.descompactar("A a 2");
        
        Assert.assertEquals(esperado, resultado);
    }    
   
}
