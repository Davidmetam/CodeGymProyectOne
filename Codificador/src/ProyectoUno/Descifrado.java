package ProyectoUno;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Descifrado {
    private String input;
    private String output;
    private int key;

    public Descifrado(String input, int key, String output) {
        this.input = input;
        this.key = key;
        this.output = output;
    }

    public Descifrado(String input, String output) {
        this.input = input;
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

    public void descifrarConLlave(int key) {
        File file = new File(input);
        try (FileReader reader = new FileReader(file);
             BufferedReader inBuffer = new BufferedReader(reader)) {

            List<Character> listedData = new ArrayList<>();
            while (inBuffer.ready()) {
                listedData.add((char) inBuffer.read());
            }
            char[] salida = new char[listedData.size()];
            Alphabet alphabet = new Alphabet();
            List<Character> cleanAlphabet = alphabet.getAlphabeth();
            List<Character> alphabetWithKey = alphabet.getKeyAlphabet(key);
            int g = 0;
            for (int i = 0; i < listedData.size(); i++) {
                char d = listedData.get(i);
                int e = alphabetWithKey.indexOf(d);
                char f = cleanAlphabet.get(e);
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
        System.out.println("Archivo descifrado con la llave " + key + " ...");
        System.out.println("");
    }

    public void bruteForceAttack() {
        HashMap<Integer, char[]> bruteForceMap = new HashMap<>();
        File file = new File(input);
        try (FileReader reader = new FileReader(file);
             BufferedReader inBuffer = new BufferedReader(reader)) {

            List<Character> listedData = new ArrayList<>();
            while (inBuffer.ready()) {
                listedData.add((char) inBuffer.read());
            }
            for (int key = 1; key <= 61; key++) {
                char[] salida = new char[listedData.size()];
                Alphabet alphabet = new Alphabet();
                List<Character> cleanAlphabet = alphabet.getAlphabeth();
                List<Character> alphabetWithKey = alphabet.getKeyAlphabet(key);
                int g = 0;

                for (int i = 0; i < listedData.size(); i++) {
                    char d = listedData.get(i);
                    int e = alphabetWithKey.indexOf(d);
                    char f = cleanAlphabet.get(e);
                    salida[g] = f;
                    g++;
                }
                bruteForceMap.put(key, salida);
            }

            try (BufferedWriter outBuffer = new BufferedWriter(new FileWriter(output))) {

                for (Integer key : bruteForceMap.keySet()) {
                    String result = String.valueOf(bruteForceMap.get(key));
                    outBuffer.write("Llave numero: " + key + " - " + result + "\n");
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Descifrado por fuerza bruta completado...");
        System.out.println("");
    }
}
