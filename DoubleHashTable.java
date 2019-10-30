public class DoubleHashTable{
    int tableSize;
    int secondSize;
    int curSize;
    int[] hashTable;
    DoubleHashTable(int tableSize){
        this.tableSize = findNextPrime(tableSize);
        secondSize = findNextSmallerPrime(this.tableSize);
        hashTable = new int[this.tableSize];
        curSize = 0;
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

    private int hash1(int n){
        return n % this.tableSize;
    }

    private int hash2(int n){
        return (secondSize - (n % secondSize));
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
