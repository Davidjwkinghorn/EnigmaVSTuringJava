package Enigma;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dave on 8/17/17.
 */
public class Rotor{
    private int setting;
    private Integer[] wheel;
    private Character[] reference = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    Rotor() {
        this.wheel = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 20, 21, 22, 23, 24, 25};
//        System.out.println(Arrays.toString(wheel));
    }

    void setPosition(int i) {
        while (i != wheel[0]) {
            rotate(1);
        }
        this.setting = i;
    }

    public void rotate() {
        rotate(2);
    }

    private void rotate(int k) {

        Integer[] result = new Integer[wheel.length];

        int j = 0;
        for (int i = k; i < wheel.length; i++) {
            result[j] = wheel[i];
            j++;
        }
        int x = k;
        for (int i = 0; i < k; i++) {
            result[wheel.length - x] = wheel[i];
            x--;
        }
        wheel = result;
//        System.out.println(Arrays.toString(wheel));
    }

    public int parseOut(int char1) {
        return wheel[char1];
    }

    public int parseBack(int char1) {
        return Arrays.asList(wheel).indexOf(char1);
    }

    public int getSetting() {
        return setting;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i : wheel) {
            string.append(reference[i]).append(", ");
        }
        return string.toString();
    }
}
