/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ado.Compactar;
import ado.ListaEncadeada;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author dayprado
 */
public class CompactarTest {
    
    @Test
    public void PermitirExibirListaDePalavras() {
        Compactar compactar = new Compactar();
        ListaEncadeada lista = compactar.getLista();
        
        Assert.assertNotNull(lista);
    }
    
    @Test
    public void TodoCompactadorIniciaComUmaListaVazia() {
        Compactar compactar = new Compactar();
        ListaEncadeada lista = compactar.getLista();
        
        Assert.assertNotNull(lista);
        Assert.assertTrue(lista.estaVazia());        
    }
    
    @Test
    public void PermitirAdicionarNovaPalavraNaLista() {
        Compactar compactar = new Compactar();
        compactar.compactar("A");
        
        Assert.assertEquals("A", compactar.getLista().getPrimeiro().getElemento());
    }
    
    @Test
    public void AListaDeveTerSomentePalavraAlfaNumerica() {
        Compactar compactar = new Compactar();
        compactar.compactar("A ;");
        
        Assert.assertEquals("A", compactar.getLista().getPrimeiro().getElemento());
        Assert.assertEquals(1, compactar.getLista().tamanho());        
    }    
    
    @Test
    public void TodaNovaPalavraDeveIrParaOTopoDaLista() {
        Compactar compactar = new Compactar();
        compactar.compactar("A a");
        
        Assert.assertEquals("a", compactar.getLista().getPrimeiro().getElemento());
        Assert.assertEquals(2, compactar.getLista().tamanho());                
    }
    
    @Test
    public void AListaDeveSerCaseSensitive() {
        Compactar compactar = new Compactar();
        compactar.compactar("A a");
        
        Assert.assertEquals("a", compactar.getLista().getPrimeiro().getElemento());
        Assert.assertEquals(2, compactar.getLista().tamanho());                    
    }
    
    @Test
    public void PermitirCompactarUmaFrase() {
        Compactar compactar = new Compactar();

        String e1 = "Dear Sally,";
        String e2 = "Please, please do it--1 would 4";
        
        String r1 = compactar.compactar("Dear Sally,");
        String r2 = compactar.compactar("Please, please do it--it would please");
        
        Assert.assertEquals(e1, r1);
        Assert.assertEquals(e2, r2);        
    }
    
    @Test
    public void PermitirCompactarUmTexto() {
        Compactar compactar = new Compactar();

        String e1 = "Dear Sally,\nPlease, please do it--1 would 4";
        String r1 = compactar.compactar("Dear Sally,\nPlease, please do it--it would please");
        
        Assert.assertEquals(e1, r1);        
    }
    
    @Test
    public void PermitirSubstituirNovaOcorrenciaPorPosicaoLista() {
        String esperado = "A a 2";
        
        Compactar compactar = new Compactar();
        String resultado = compactar.compactar("A a A");
        
        Assert.assertEquals(esperado, resultado);
    }
}
