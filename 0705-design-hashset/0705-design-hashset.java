// class MyHashSet {
//     boolean[] arr = new boolean[1000001];

//     public MyHashSet() {
        
//     }
    
//     public void add(int key) {
//         arr[key] = true;
//     }
    
//     public void remove(int key) {
//         arr[key] = false;
//     }
    
//     public boolean contains(int key) {
//         if(arr[key] == true) return true;
//         else return false;
//     }
// }
// //very very very imp question
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */




 class MyHashSet {

    class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }
    
    Node[] table;
    int size = 10000;

    public int hash(int key){
        return key%size;
    }

    public MyHashSet() {
        table = new Node[size];
    }

    public void add(int key) {
        boolean search = contains(key);
        if(search) return;
        
        int idx = hash(key);
        if(table[idx] == null){
            Node temp = new Node(key);
            table[idx] = temp;
            return;
        }
        
        Node curr = table[idx];

        while(curr.next != null){
           curr = curr.next;
        }
        Node temp = new Node(key);
        curr.next = temp;
    }
    
    public void remove(int key) {
        boolean search = contains(key);
        if(!search) return;

        int idx = hash(key);

        Node prev = null;
        Node curr = table[idx];

        while(curr != null){

            if(curr.val == key){
                
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
    
    public boolean contains(int key) {
        int idx = hash(key);
        
        if(table[idx] == null) return false;

        Node curr = table[idx];

        while(curr != null){
            if(curr.val == key) return true;
            curr = curr.next;
        }
        return false;
    }
}