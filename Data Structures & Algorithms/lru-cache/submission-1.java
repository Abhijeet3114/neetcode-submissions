class LRUCache {

    HashMap<Integer, Node> cache;
    int capacity;
    DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.dll = new DoublyLinkedList();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            dll.moveFreqAccessed(node);
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node toUpdate = cache.get(key);
            toUpdate.value = value; // update the value
            cache.put(key, toUpdate); // override the value in cache
            dll.moveFreqAccessed(toUpdate); // remove and add at the end
        }
        else{
            Node toAdd = new Node(key, value);
            cache.put(key, toAdd);
            dll.insert(toAdd);
            if(capacity < cache.size()){
                Node toRemove = dll.head.next;
                cache.remove(toRemove.key);
                dll.remove(toRemove);
            }
            System.out.println("Added "+toAdd.key);
        }
    }


    class Node{
        Integer key;
        Integer value;
        Node next;
        Node prev;

        Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
    }

    class DoublyLinkedList{
        Node head, tail;

        DoublyLinkedList(){
            this.head = new Node(null, null);
            this.tail = new Node(null, null);
            this.head.next = tail;
            this.tail.prev = head;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void insert(Node node){
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
        }

        public void moveFreqAccessed(Node node){
            remove(node);
            insert(node);
        }

        
    }
}
