package assignment3.collision;

public class QuadraticProbeHashTable extends HashTable{
    
    QuadraticProbeHashTable(int tableSize){
        super(tableSize);
    }
    
    public int insert(int n){
        int initialPos = hash(n);
        int currentPos = initialPos,i = 1,collisions = 0;
        while(hashTable[currentPos] != 0 && hashTable[currentPos] != n){
            collisions++;
            currentPos = initialPos + i*i;
            if(currentPos >= tableSize)
                currentPos -= tableSize;
            if(currentPos == initialPos){
                return collisions;
            }
            i++;
        }
        hashTable[currentPos] = n;
        curSize++;
        return collisions;
    }
}
