package ProyectoUno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Cifrado {
    private String input;
    private String output;
    private int key;

    public Cifrado(String input, int key, String output){
        this.input = input;
        this.key = key;
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void cifrar() {
        File file = new File(input);
        try(FileReader reader = new FileReader(file);
            BufferedReader inBuffer = new BufferedReader(reader)){

            List<Character> listedData = new ArrayList<>();
            while (inBuffer.ready()){
                listedData.add((char) inBuffer.read());
            }
            char[] salida = new char[listedData.size()];
            Alphabet alphabet = new Alphabet();
            List<Character> cleanAlphabet = alphabet.getAlphabeth();
            List<Character> alphabetWithKey = alphabet.getKeyAlphabet(key);
            int g = 0;
            for (int i = 0; i < listedData.size(); i++) {
                char d = listedData.get(i);
                int e = cleanAlphabet.indexOf(d);
                char f = alphabetWithKey.get(e);
                salida[g] = f;
                g++;
            }
                try (BufferedWriter outBuffer = new BufferedWriter(new FileWriter(output))) {
                    outBuffer.write(salida);
                }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Arcivo cifrado con exito...");
        System.out.println("");
    }

}
