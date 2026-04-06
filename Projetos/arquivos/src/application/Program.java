package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class Program {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo .csv: ");
        String strPath = sc.nextLine();

        File sourceFile = new File(strPath);
        String sourceFolderStr = sourceFile.getParent();

        boolean success = new File(sourceFolderStr + "\\out").mkdir();

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {

            List<String> produtos = new ArrayList<>();
            String line = br.readLine();

            while(line != null){
                String[] lerProduto = line.split(",");
                String nome = lerProduto[0];
                double preco = Double.parseDouble(lerProduto[1]);
                int quantidade = Integer.parseInt(lerProduto[2]);

                double valorTotal = preco * quantidade;

                String produto = nome + "," + String.format("%.2f", valorTotal);

                produtos.add(produto);

                line = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                for(String item : produtos) {
                    bw.write(item);
                    bw.newLine();
                }

                System.out.println("Arquivo summary.csv criado com sucesso na pasta out!");

            } catch (IOException e){
                System.out.println("Erro ao escrever arquivo: " + e.getMessage());
            }
        }
        catch (IOException e){
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        sc.close();
    }
}