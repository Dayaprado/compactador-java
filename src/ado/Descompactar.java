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
public class Descompactar {

    String SL = "[\\w]+|[^A-Za-z0-9]+";
    String AN = "[aA-zZ]+";
    String N = "[0-9]+";
    String JN = "";
    String BL = "\n";

    Pattern pattern;
    ListaEncadeada lista;

    public Descompactar() {
        this.pattern = Pattern.compile(SL);
        this.lista = new ListaEncadeada();
    }

    public ListaEncadeada getLista() {
        return this.lista;
    }

    public String descompactar(String texto) {
        String[] linhas = texto.split(BL);

        for (int i = 0; i < linhas.length; i++) {
            linhas[i] = descompactarLinha(linhas[i]);
        }

        return String.join(BL, linhas);
    }

    private String descompactarLinha(String conteudo) {

        String[] palavras = quebrarString(conteudo);
        for (int i = 0; i < palavras.length; i++) {
            String palavra = palavras[i];
            No no = buscarNoPalavra(palavra);
            if (no != null) {
                palavras[i] = palavras[i].replace(palavra, no.getElemento());
                this.adicionarPalavra(no.getElemento());
            } else {
                this.adicionarPalavra(palavras[i]);
            }
        }

        String compactado = String.join(JN, palavras);
        return compactado;
    }

    private No buscarNoPalavra(String palavra) {
        if (palavra.matches(N)) {
            return this.lista.getNoPorIndice(Integer.parseInt(palavra) - 1);
        }

        return null;
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

    private String[] quebrarString(String conteudo) {
        ArrayList<String> resultado = new ArrayList<>();

        Matcher m = pattern.matcher(conteudo);
        while (m.find()) {
            resultado.add(m.group());
        }

        return resultado.toArray(new String[resultado.size()]);
    }
}
