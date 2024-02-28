package Hashing;

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
}
public class HashMapCode {
    public static void main(String[] args) {
        
    }
}
