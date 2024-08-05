package set;

import java.util.HashSet;
import java.util.Random;
import java.util.HashSet;
import java.util.Random;

public class Set2 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        Random rand = new Random();

        // 1~10까지의 숫자를 random으로 생성하고 중복되지 않은 6개의 숫자를 넣으시오.
        for (int i=1; i<=6; i++) {
            int num = rand.nextInt(10) + 1;
            set.add(num);
        }

        for (int num : set) {
            System.out.println(num);
        }
    }
}

