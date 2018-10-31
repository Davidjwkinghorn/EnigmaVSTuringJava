package Enigma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dave on 8/17/17.
 */
public class Reflector{
    private int offset;
    private HashMap<Character, Character> wheel;
    private Character[] reference = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    Reflector() {
        this.wheel = new HashMap<>();
        for (int i = 0; i < reference.length; i++) {
            this.wheel.put(reference[i], reference[(i + 7) % 26]);
        }
    }
    
    /**
     * Sets the position of a reflector component.
     */
    void setPosition(int j) {
        for (int i = 0; i < reference.length; i++) {
            this.wheel.put(reference[i], reference[(i + j) % 26]);
        }
        this.offset = j;
    }

    public int parse(int char1) {
        return wheel.get(char1);
    }

    public int getOffset() {
        return offset;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < wheel.size(); i++) {
            string.append(reference[i]).append(", ");
        }
        return string.toString();
    }
}
