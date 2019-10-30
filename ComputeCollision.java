package assignment3.collision;

import java.util.Random;

class ComputeCollision{
    public static void main(String[] args){
        LinearProbeHashTable l = new LinearProbeHashTable(100);
        QuadraticProbeHashTable q = new QuadraticProbeHashTable(100);
        DoubleHashTable d = new DoubleHashTable(100);
        Random r = new Random();
        int s = l.getTableSize(),lcol = 0,qcol = 0,dcol = 0;
        while(l.getCurrentSize() < (s/2)){
            int item = r.nextInt(1000);
            lcol += l.insert(item);
            qcol += q.insert(item);
            dcol += d.insert(item);
        }
        System.out.println("Number of collisions using linear probing: "+lcol);
        System.out.println("Number of collisions using quadratic probing: "+qcol);
        System.out.println("Number of collisions using double hashing: "+dcol);

    }
}