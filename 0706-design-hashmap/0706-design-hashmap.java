// class MyHashMap {
//     int[][] table = new int[1000001][2];

//     public MyHashMap() {
//         for(int i = 0; i < table.length; i++) {
//             table[i][0] = -1;
//         }
//     }
//     public int hash(int key){
//         return key;
//     }
    
//     public void put(int key, int value) {
//         int idx = hash(key);
//         table[idx][0] = key;
//         table[idx][1] = value;
//     }
    
//     public int get(int key) {
//         int idx = hash(key);
//         if(table[idx][0] == -1) return -1;
//         return table[idx][1];
//     }
    
//     public void remove(int key) {
//         int idx = hash(key);
//         table[idx][0] = -1;
//         table[idx][1] = 0;
//     }
// }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */




class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node[] table;
    int size = 1000000; 

    public MyHashMap() {
        table = new Node[size];
    }

    public boolean contains(int key) {
        int idx = hash(key);
        
        if(table[idx] == null) return false;

        Node curr = table[idx];

        while(curr != null){
            if(curr.key == key) return true;
            curr = curr.next;
        }
        return false;
    }
    public int hash(int key){
        return key%size;
    }
    
    public void put(int key, int value) {
        
        int idx = hash(key);
        if(table[idx] == null){
            Node temp = new Node(key, value);
            table[idx] = temp;
            return;
        }
        
        Node curr = table[idx];

        while(curr != null){
            if(curr.key == key){
                curr.val = value;
                return;
            }
            if(curr.next == null){
               Node temp = new Node(key, value);
               curr.next = temp;
               return;
            }
            curr = curr.next;
        }
    }
    
    public int get(int key) {
        boolean search = contains(key);
        if(!search) return -1;
        
        int idx = hash(key);

        Node curr = table[idx];
        while(curr != null){
            if(curr.key == key) return curr.val;
            curr = curr.next;
        }
        return -1;

    }
    
    public void remove(int key) {
        boolean search = contains(key);
        if(!search) return;

        int idx = hash(key);

        Node prev = null;
        Node curr = table[idx];

        while(curr != null){

            if(curr.key == key){
                
                //first node to delete
                if(prev == null){
                    curr = curr.next;
                    table[idx] = curr;
                }

                //middle  node
                else prev.next = curr.next;

                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}
