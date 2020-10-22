/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ado;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dayprado
 */
public class Compactar {

    String SL = "[\\w]+|[^A-Za-z0-9]+";
    String AN = "[aA-zZ]+";
    String JN = "";
    String BL = "\n";

    Pattern pattern;
    ListaEncadeada lista;
    
    public Compactar() {
        this.pattern = Pattern.compile(SL);
        this.lista = new ListaEncadeada();
    }

    public ListaEncadeada getLista() {
        return this.lista;
    }
    
    public String compactar (String texto){
        String[] linhas = texto.split(BL);
        
        for (int i = 0; i < linhas.length; i++) {
            linhas[i] = compactarLinha(linhas[i]);
        }
        
        return String.join(BL, linhas);
    } 
    
    private String compactarLinha(String conteudo) {

        String[] palavras = quebrarString(conteudo);
        for (int i = 0; i < palavras.length; i++) {
            String palavra = palavras[i];
            int indice = buscarIndicePalavra(palavra);
            if (indice >= 0) {
                String novo = Integer.toString(indice + 1);
                palavras[i] = palavras[i].replace(palavra, novo);
            }

            this.adicionarPalavra(palavra);
        }

        String compactado = String.join(JN, palavras);
        return compactado;
    }

    private int buscarIndicePalavra(String palavra) {
        if (palavra.matches(AN)) {
            return this.lista.getIndicePorElemento(palavra);
        }

        return -1;
    }

    private void adicionarPalavra(String palavra) {
        if (palavra.matches(AN)) {
            int indice = this.lista.getIndicePorElemento(palavra);
            if (indice > -1) {
                this.lista.topo(this.lista.getNoPorIndice(indice));
            } else {
                this.lista.adicionarPrimeiro(palavra);
            }
        }
    }
    
    private String[] quebrarString(String conteudo){
        ArrayList<String> resultado = new ArrayList<>();
        
        Matcher m = pattern.matcher(conteudo);
        while(m.find()){
            resultado.add(m.group());
        }

        return resultado.toArray(new String[resultado.size()]);
    }

}
