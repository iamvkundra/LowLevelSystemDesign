package DesignHashMap;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    /*
    * Cell defines the Key-Value pair.
    * */
    public static class HashMap<K, V> {
        private class Cell {
            K key;
            V value;

            Cell(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        /*
        *
        *
        * */
        private int size;
        private LinkedList<HashMap.Cell>[] buckets;
        public HashMap() {
            initbuckets(4);
            size = 0;
        }
        /*
        * Initialization of bucket is done. when object is made.
        * */
        private void initbuckets(int N){
            buckets = new LinkedList[N];
            for(int bi = 0; bi<buckets.length; bi++){
                buckets[bi] = new LinkedList<>();
            }
        }

        /*
        * @funtion getIndexWithinBucket:
        * This function takes the key and the bucketIndex. we go to that bucketIndex and scan the bucket with key provided as a input.
        * if it matches we send index, if not return -1.
        * */
        private int getIndexWithinBucket(K key, int bucketindex){
            int index = 0;
            for(Cell node : buckets[bucketindex]){
                if(node.key.equals(key)){
                    return index;
                }
                index++;
            }
            return -1;
        }
        /*
        * @param hc - This gives us the hashcode and this is handled by java, if the hashcode comes in negative value,
        * we make it positive and divide the hashcode with bucketsize.
        * so the range with be between 0-bucket,length.
        * */
        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)% buckets.length;
        }
        /*
        * @function - Put(Key, Value) -
        * we first try to find the hashcode and this, gives us the bucket index, and then we search the element in the bucket list.
        * if the index is -1
        * - make a cell and add the cell to the corresponding bucket.
        * if the index is not -1, then update the result.
        * */
        public void put(K key, V value) throws Exception{
            int bucketindex = hashFunction(key);
            int di = getIndexWithinBucket(key, bucketindex);
            if(di == -1){ // insert
                Cell node = new Cell(key, value);
                buckets[bucketindex].add(node);
                size++;
            }else{
                Cell node = buckets[bucketindex].get(di);
                node.value = value;
            }
            double lamda = size*1.0/buckets.length;
            if(lamda > 2){
                rehash();
            }

        }
        /*
        * @function - rehash()
        * if the lamda(ie. Load Factor) goes above 2. we double the size of bucket and append the old bucket element in the new doubled bucket.
        * so, while appending old bucket element to new one.
        * our size of the bucket is going to change, so no hash is going to be same as before.
        *
        * */
        public void rehash() throws Exception {
            LinkedList<HashMap.Cell>[]  old = buckets;
            initbuckets(buckets.length*2);
            for(int i=0;i<old.length;i++){
                for(Cell node : buckets[i]){
                    put(node.key, node.value);
                }
            }

        }
        public V get(K key) throws Exception{
            int bucketindex = hashFunction(key);
            int di = getIndexWithinBucket(key, bucketindex);
            if(di != -1){ // insert
                return (V) buckets[bucketindex].get(di).value;
            }else{
                return null;
            }
        }
        /*
        * @Function - containsKey -
        * it just check the index if the element is present in the corresponding bucket,
        * then return true ,
        * if not then return false.
        * */
        public boolean containsKey(K key){
            int bucketIndex = hashFunction(key);
            int di = getIndexWithinBucket(key, bucketIndex);
            if(di != -1){
                return true;
            }else{
                return false;
            }
        }
        public V remove(K key){
            int bucketIndex = hashFunction(key);
            int di = getIndexWithinBucket(key, bucketIndex);
            if(di !=  -1){
                Cell node = buckets[bucketIndex].remove(di);
                size--;
                return node.value;
            }else{
                return null;
            }
        }
        public int size() throws Exception{
            return size;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length;i++){
                for(Cell node : buckets[i]){
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public void display(){
            for(int i=0;i< buckets.length; i++){
                for(Cell node : buckets[i]) {
                    System.out.println(node.key + " -> " + node.value.toString());
                }
            }
        }
    }
}
