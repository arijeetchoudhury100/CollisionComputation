package assignment3.collision;

public class HashTable{
    protected int tableSize;
    protected int curSize;
    protected int[] hashTable;

    HashTable(int tableSize){
        this.tableSize = findNextPrime(tableSize);
        hashTable = new int[this.tableSize];
        curSize = 0;
    }

    public void print(){
        for(int i=0;i<this.tableSize;i++){
            System.out.println(i+":"+hashTable[i]);
        }
    }

    public int getCurrentSize(){
        return curSize;
    }

    public int getTableSize(){
        return tableSize;
    }
    protected int hash(int n){
        return n % this.tableSize;
    }

    protected int findNextPrime(int n){
        while(true){
            boolean prime = true;
            if(n%2 == 0)
                n++;
            for(int i=3;i<=Math.floor(Math.sqrt(n));i+=2){
                if(n%i == 0){
                    prime = false;
                    break;
                }
            }
            if(prime == false)
                n = n+2;
            else
                return n;
        }
    }
}

