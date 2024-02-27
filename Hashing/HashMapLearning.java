package Hashing;

import java.util.HashMap;
import java.util.Set;

public class HashMapLearning{
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 150);
        map.put("Australia", 100);
        map.put("England", 80);

        // System.out.println(map.get("India"));
        // System.out.println(map.get("USA"));
        // System.out.println(map);

        // System.out.println(map.containsKey("India"));
        // System.out.println(map.remove("Australia"));
        // System.out.println(map);

        // System.out.println(map.size());
        // System.out.println(map.isEmpty());
        // map.clear();
        // System.out.println(map);

        Set<String> keys = map.keySet();
        for(String k : keys){
            System.out.println(k + " : " + map.get(k));
        }
    }
}