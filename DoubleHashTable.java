package assignment3.collision;

public class DoubleHashTable extends HashTable{
    int secondSize;
    DoubleHashTable(int tableSize){
        super(tableSize);
        secondSize = findNextSmallerPrime(this.tableSize);
    }

    public int insert(int n){
        int initialPos = hash1(n);
        int offset = hash2(n);
        int currentPos = initialPos,collisions = 0,i=1;
        while(hashTable[currentPos] != 0 && hashTable[currentPos] != n){
            collisions++;
            currentPos = (initialPos + i*offset) % tableSize;
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
    private int hash1(int n){
        return hash(n);
    }

    private int hash2(int n){
        return (secondSize - (n % secondSize));
    }

    private int findNextSmallerPrime(int n){
        while(true){
            boolean prime = true;
            if(n%2 == 0)
                n--;
            for(int i=3;i<=Math.floor(Math.sqrt(n));i += 2){
                if(n%i == 0){
                    prime = false;
                    break;
                }
            }
            if(prime == false)
                n = n-2;
            else
                return n;
        }     
    }
}
