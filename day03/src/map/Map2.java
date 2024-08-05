package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Map2 {
    public static void main(String[] args) {
        int sum = 0;
        int hap = 0;

        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("e", 5);

        //1. map에 있는 value드르이 합과 평균을 출력하시오.
        Collection<Integer> col = map.values();

        for (int value : col) {
            sum += value;
        }

        int avg = sum / col.size();

        System.out.println("sum = " + sum);
        System.out.println("average = " + avg);

        //2. map에 있는 키 값이 소문자인 value들의 합과 평균을 구하시오.

        Set<String> keys = map.keySet();
        for (String key : keys) {
            int value = map.get(key);
            if (key.charAt(0) >= 'a' && key.charAt(0) <= 'z') { //charAt를 사용하여 char로 변환
                hap += value;
            }
        }

        System.out.println("sum = " + hap);
        System.out.println("average = " + hap/keys.size());
    }
}
