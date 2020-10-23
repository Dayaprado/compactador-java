/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author dayprado
 */
public class Main {
    public static void main(String[] args) {
        
        // Ler os arquivos originais
        String original = "./src/arquivos/original.txt";
        String compactado = "./src/arquivos/compactado.txt";
        
        String textoOriginal = lerArquivo(original);
        String textoComprimido = lerArquivo(compactado);   
        
        // Processar
        Compactar c = new Compactar();
        String resultadoCompactado = c.compactar(textoOriginal);
        
        Descompactar d = new Descompactar();
        String resultadoOriginal = d.descompactar(textoComprimido);        
        
        // Escrever os arquivos com resultado da compressão/descompressão
        String novoOriginal = "./src/arquivos/original-final.txt";
        String novoCompactado = "./src/arquivos/compactado-final.txt";
        
        escreverArquivo(novoOriginal, resultadoOriginal);
        escreverArquivo(novoCompactado, resultadoCompactado);
    }
    
    private static String lerArquivo(String arquivo) {
        ArrayList<String> linhas = new ArrayList<>();
        BufferedReader reader = null;
        try {
            String linha;
            reader = new BufferedReader(new FileReader(arquivo));
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
            
            return String.join("\n", linhas);
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        return "";
    }
    
    private static void escreverArquivo(String caminho, String arquivo) {
        try (PrintWriter pw = new PrintWriter(caminho)) {
                pw.println(arquivo);
        }catch(Exception e){}
    }
}
