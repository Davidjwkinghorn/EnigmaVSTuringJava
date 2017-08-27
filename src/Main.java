import Enigma.EnigmaMachine;
import Enigma.Plugboard;
import Enigma.Reflector;

public class Main {

    public static void main(String[] args){
        EnigmaMachine enigmaMachine = new EnigmaMachine(
                new Plugboard(),
                3
        );
        Character[] settings = {'B', 'C', 'D'};
        enigmaMachine.setSettings(settings);
        System.out.println(enigmaMachine);
        Character[] message = {'A', 'B', 'C'};
        enigmaMachine.encrypt(message);
        System.out.println(enigmaMachine.parseOutput());
    }
}
