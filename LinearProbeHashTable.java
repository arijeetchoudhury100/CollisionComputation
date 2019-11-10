package assignment3.collision;

public class LinearProbeHashTable extends HashTable{
  
    LinearProbeHashTable(int tableSize){
        super(tableSize);
    }

    public int insert(int n){
        int initialPos = hash(n);
        int currentPos = initialPos,collisions = 0;
        while(hashTable[currentPos] != 0 && hashTable[currentPos] != n){
            collisions++;
            currentPos++;
            if(currentPos >= tableSize)
                currentPos -= tableSize;
            if(currentPos == initialPos){
                return collisions;
            }
        }
        hashTable[currentPos] = n;
        curSize++;
        return collisions;
    }
}

