class MyHashMap {
    int[][] table = new int[1000001][2];

    public MyHashMap() {
        for(int i = 0; i < table.length; i++) {
            table[i][0] = -1;
        }
    }
    public int hash(int key){
        return key;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        table[idx][0] = key;
        table[idx][1] = value;
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(table[idx][0] == -1) return -1;
        return table[idx][1];
    }
    
    public void remove(int key) {
        int idx = hash(key);
        table[idx][0] = -1;
        table[idx][1] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */