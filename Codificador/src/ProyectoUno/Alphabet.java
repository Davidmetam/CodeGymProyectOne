package ProyectoUno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabet {
    private String alphabeth = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,\":-!? ";


    public Alphabet() {
    }

    public List<Character> getAlphabeth() {
        char[] data = alphabeth.toCharArray();
        List<Character> listedAlphabeth = new ArrayList<>();
        for(char i: data){
            listedAlphabeth.add(i);
        }
        return listedAlphabeth;
    }


    public List getKeyAlphabet(int key){
        char[] keyAlphabet = alphabeth.toCharArray();
        List<Character> listed = new ArrayList<>();
        for(char i: keyAlphabet){
            listed.add(i);
        }
        Collections.rotate(listed, key);
        return listed;
    }

}
