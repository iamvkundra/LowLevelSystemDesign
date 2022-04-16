package DesignHashMap;

import java.util.ArrayList;
import java.util.List;

public class RunHashMap {
    public static void main(String[] args) throws Exception {
        Main.HashMap<Integer, List<Integer>> map = new Main.HashMap<>();
        map.put(2,new ArrayList<>());
        map.get(2).add(3);
        map.get(2).add(2);
        map.get(2).add(8);

        map.put(9,new ArrayList<>());
        map.get(9).add(3);
        map.get(9).add(2);
        map.get(9).add(8);

        map.display();
        System.out.println(map.containsKey(2));
        /*
        * Result Output:
        * 9 -> [3, 2, 8]
          2 -> [3, 2, 8]
          true
        * */
    }
}
