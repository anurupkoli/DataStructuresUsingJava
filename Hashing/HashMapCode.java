package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

class HashMapNew<K, V> { 
    private class Node{
        K key;
        V value;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        } 
    }
    private int size;
    private int nodes;
    private LinkedList<Node> buckets[];

    @SuppressWarnings("unchecked")
    HashMapNew(){
        this.nodes = 0;
        this.size = 4;
        buckets = new LinkedList[4];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key){
        int hash = key.hashCode();
        return hash % size;
    }
    private int searchInLL(K key, int bi){
        LinkedList<Node> list = buckets[bi];
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).key == key){
                return i;
            }
        }
        return -1;
    }
    @SuppressWarnings("unchecked")
    private void reHash(){
        LinkedList<Node> oldBucket[] = buckets;
        buckets = new LinkedList[size*2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < oldBucket.length; i++) {
            LinkedList<Node> ll = oldBucket[i];
            for (int j = 0; j < ll.size(); j++) {
                Node node = ll.remove();
                put(node.key, node.value);
            }
        }
    }
    public void put(K key, V value){
        int bi = hashFunction(key);
        int ki = searchInLL(key, bi);

        if(ki != -1){
            Node node = buckets[bi].get(ki);
            node.value = value;
        }
        else{
            buckets[bi].add(new Node(key, value));
            this.nodes++;
        }
        
        double lambda = (double) this.nodes/this.size;
        if(lambda > 2.0){
            reHash();
        }
    }

    public boolean containsKey(K key){
        int bi = hashFunction(key);
        int ki = searchInLL(key, bi);
        if(ki == -1){
            return false;
        }
        return true;
    }

    public V get(K key){
        int bi = hashFunction(key);
        int ki = searchInLL(key, bi);
        if(ki == -1){
            return null;
        }

        Node node = buckets[bi].get(ki);
        return node.value;
    }

    public V remove(K key){
        int bi = hashFunction(key);
        int ki = searchInLL(key, bi);
        if(ki == -1){
            return null;
        }

        Node node = buckets[bi].remove(ki);
        this.nodes--;
        return node.value;
    }

    public ArrayList<K> keySet(){
        ArrayList<K> list = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Node> nodes = buckets[i];
            for (Node node : nodes) {
                list.add(node.key);
            }
        }
        return list;
    }

    public boolean isEmpty(){
        if(nodes == 0){
            return true;
        }
        return false;
    }
}
public class HashMapCode {
    public static void main(String[] args) {
        HashMapNew<String, Integer> map = new HashMapNew<String, Integer>();
        map.put("Anurup", 8625);
        map.put("Prajwal", 1000);
        System.out.println(map.keySet());
    }
}
