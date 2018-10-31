package Enigma;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dave on 8/17/17.
 */
public class EnigmaMachine{
    private Character[] input;
    private Plugboard plugboard;
    private Rotor[] rotors;
    private Reflector reflector;
    private Character[] output;
    private Character[] reference;
    private int nRotors = 3;

    public EnigmaMachine(Plugboard plugboard, int nRotors) {
        this.plugboard = plugboard;
        this.rotors = new Rotor[]{};
        this.reflector = new Reflector();
        this.reference = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        this.rotors = new Rotor[nRotors];
        ArrayList<Rotor> tempRotors = new ArrayList<>(nRotors);
        for (int i = 0; i < nRotors; i++) {
            tempRotors.add(new Rotor());
        }
        this.rotors = tempRotors.toArray(this.rotors);
    }

    public Character[] encrypt(Character[] message) {
        Character[] result = new Character[message.length];
        int rotVal = -1;
        int ch = 0;
        for (char char1 : message) {
            for (Rotor rotor : rotors) {
                rotor.rotate();
                if (rotVal < 0) {
                    rotVal = rotor.parseOut(Arrays.asList(reference).indexOf(char1));
                } else {
                    rotVal = rotor.parseOut(rotVal);
                }
//                rotor.rotate();
            }
            result[ch] = Arrays.asList(reference).get(rotVal);
            rotVal = -1;
            ch++;
        }
        output = result;
        return result;
    }

    public void setSettings(Character[] chars) {
        if (chars.length == rotors.length) {
            int i = 0;
            for (Rotor rotor : rotors) {
                if (Arrays.asList(reference).contains(chars[i])) {
                    rotor.setPosition(Arrays.asList(reference).indexOf(chars[i]));
                }
                i++;
            }
        }
    }
    
    //TODO: remove unneeded getters/setters
    public Character[] getInput() {
        return input;
    }

    public void setInput(Character[] input) {
        this.input = input;
    }

    public Plugboard getPlugboard() {
        return plugboard;
    }

    public void setPlugboard(Plugboard plugboard) {
        this.plugboard = plugboard;
    }

    public Rotor[] getRotors() {
        return rotors;
    }

    public void setRotors(Rotor[] rotors) {
        this.rotors = rotors;
    }

    public Reflector getReflector() {
        return reflector;
    }

    public void setReflector(Reflector reflector) {
        this.reflector = reflector;
    }

    public Character[] getOutput() {
        return output;
    }

    public String parseOutput() {
        StringBuilder string = new StringBuilder();
        for (Character ch : output) {
            string.append(ch);
        }
        return string.toString();
    }

    public void setOutput(Character[] output) {
        this.output = output;
    }

    public Character[] getReference() {
        return reference;
    }

    public void setReference(Character[] reference) {
        this.reference = reference;
    }

    public int getnRotors() {
        return nRotors;
    }

    public void setnRotors(int nRotors) {
        this.nRotors = nRotors;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Rotor rotor : rotors) {
            string.append(rotor.toString()).append("\n");
        }
        string.append(reflector);
        return string.toString();
    }
}
