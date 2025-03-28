package com.dsa.map;

import java.util.Arrays;
import java.util.Objects;

public class NativeMap< K, V > {
    class Entry< K, V > {
        K key;
        V value;
        Entry < K, V > next = null;

        Entry ( K key, V value ) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals ( Object o ) {
            if (o == null || getClass ( ) != o.getClass ( )) return false;
            Entry < ?, ? > entry = (Entry < ?, ? >) o;
            return Objects.equals ( key, entry.key );
        }

        @Override
        public int hashCode () {
            return Objects.hashCode ( key );
        }

        @Override
        public String toString () {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Entry < K, V >[] map;
    private double capacity;
    private double loadFactor = 0.75;
    private double count = 0;
    private boolean isResizeInProgress = false;

    public NativeMap () {
        capacity = 16;
        loadFactor = 0.75;
        map = (Entry < K, V >[]) new Entry[(int)capacity];
    }

    public int hashCode ( K key ) {
        return (int)Math.abs ( key.hashCode ( ) % capacity - 1 );
    }

    public boolean equals ( K key1, K key2 ) {
        return key1.equals ( key2 );
    }

    public boolean resize () {

        isResizeInProgress = true;
        double newCapacity = (int)capacity << 2;
        Entry < K, V >[] resizedMap = new Entry[(int)newCapacity];
        Entry < K, V >[] tempMap = map;
        map = new Entry[(int)newCapacity];

        for (int i = 0; i < capacity; i++) {
            if (tempMap[i] != null) {
                Entry < K, V > node = tempMap[i];
                while (node != null) {
                    put ( node.key, node.value );
                    node = node.next;
                }
            }
        }
        isResizeInProgress = false;
        capacity = newCapacity;
        return Boolean.TRUE;
    }

    public boolean put ( K key, V value ) {
        //check capacity
        int index = (int)hashCode ( key );
        if (map[index] == null) {
            count++;
            if ((count / capacity) > loadFactor  && !isResizeInProgress) {
                count = 0;
                resize ( );
            }
            map[index] = new Entry <> ( key, value );
        } else {
            //Check for the firstIndex
            Entry < K, V > parent = map[index];
            if (equals ( parent.key, key )) {
                //Update
                map[index] = new Entry <> ( key, value );
                return Boolean.TRUE;
            } else {
                Entry < K, V > current = parent.next;
                while (current != null) {
                    if (equals ( current.key, key )) {
                        Entry < K, V > temp = current.next;
                        parent.next = new Entry <> ( key, value );
                        temp.next = current;
                        return Boolean.TRUE;
                    }
                    parent = current;
                    current = current.next;
                }
                //reached end of the node
                parent.next = new Entry <> ( key, value );
            }
        }
        return Boolean.TRUE;
    }

    public V get ( K key ) {
        int index = hashCode ( key );
        Entry < K, V > node = map[index];
        while (node != null) {
            if (equals ( node.key, key )) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public String toString () {
        return "NativeMap{" +
                "map=" + Arrays.toString ( map ) +
                '}';
    }

    public static void main ( String[] args ) {
        NativeMap nativeMap = new NativeMap < Integer, Integer > ( );
        for (int i = 0; i <= 50; i++) {
            nativeMap.put ( i, i );
        }

        System.out.println ( nativeMap );

       /* System.out.println (nativeMap.get ( 3 ) );
        nativeMap.put ( 3,3 );
        System.out.println (nativeMap.get ( 3 ) );*/
    }

}
