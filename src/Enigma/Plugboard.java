package Enigma;

import java.util.HashMap;

/**
 * Created by dave on 8/17/17.
 */
public class Plugboard{
    private HashMap<Character,Character> mapping;

    public Plugboard() {
        this.mapping = new HashMap<>();
    }

    public void addPlug(char char1, char char2) {
        if (char1 != char2) {
            this.mapping.put(char1, char2);
            this.mapping.put(char2, char1);
        }
    }

    public void removePlug(char char1) {
        if (mapping.containsKey(char1)) {
            mapping.remove(mapping.get(char1));
            mapping.remove(char1);

        }
    }

    public char swap(char char1){
        return mapping.get(char1);
    }
}
