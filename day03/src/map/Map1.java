package map;

import java.util.*;

public class Map1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //list.add("A");
        //list.add(1);
        //list.add(1.2);
        HashMap<String, Integer> map = new HashMap<>();
        //HashMap<key, value>
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println(map.size());
        System.out.println(map);

        // key 값들을 조회
        Set<String> keys = map.keySet();
        for (String key : keys) {
            int value = map.get(key);
            System.out.println(key + ":" + value);
        }


        // value 값들을 조회
        Collection<Integer> col = map.values();
        Iterator<Integer> it = col.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }


    }
}
