/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ado.No;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dayprado
 */
public class NoTest {

    @Test
    public void PermitirAdicionarElemento() {
        String conteudo = "teste";
        No no = new No(conteudo);
        
        Assert.assertEquals(conteudo, no.getElemento());
    }
    
    @Test
    public void PermitirInicializarComReferenciaAoProximoNo() {
        No proximo = new No("2");
        No inicial = new No("1", proximo);
        
        Assert.assertEquals(proximo.getElemento(), inicial.getProximo().getElemento());
    }
    
    @Test
    public void QuandoHouverSomenteElementoProximoNoSeraNulo() {
        No inicial = new No("1");
        Assert.assertEquals(null, inicial.getProximo());
    }
    
    @Test
    public void PermitirAtualizarProximoNo() {
        No proximo = new No("2");
        No inicial = new No("1", proximo);
        
        No novoProximo = new No("3");
        inicial.setProximo(novoProximo);
        
        Assert.assertEquals(novoProximo.getElemento(), inicial.getProximo().getElemento());
    }
    
    @Test
    public void PermitirVisualizarInformacoesDoNo() {
        No proximo = new No("2");
        No inicial = new No("1", proximo);
        
        String esperado = "No{" + "elemento=" + inicial.getElemento() + ", proximo=" + inicial.getProximo() + '}';
        
        Assert.assertEquals(esperado, inicial.toString());
    }
}
