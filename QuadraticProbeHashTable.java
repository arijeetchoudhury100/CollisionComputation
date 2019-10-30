public class QuadraticProbeHashTable{
    int tableSize;
    int curSize;
    int[] hashTable;

    QuadraticProbeHashTable(int tableSize){
        this.tableSize = findNextPrime(tableSize);
        hashTable = new int[this.tableSize];
        curSize = 0;
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

    private int hash(int n){
        return n % this.tableSize;
    }

    private int findNextPrime(int n){
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
