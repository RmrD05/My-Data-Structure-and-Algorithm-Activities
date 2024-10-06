class Node{
    int data;
    Node next;

     public Node(int data){
        this.data = data;
        this.next = null;
      }
     }
    class Queue{
        private Node front, rear;

        public Queue(){
            this.front = this.rear = null;
        }
        public void enqueue(int data){
            Node newNode = new Node(data);
                if(this.rear == null){
                    this.front = this.rear = newNode;
                    System.out.println(data + " enqueued to enqueue");
                    return;
                }
                this.rear.next = newNode;
                this.rear = newNode;
                System.out.println(data + "enqueued to queue");
            }
            public void dequeue(){
                if(this.front == null){
                    System.out.println("Queue is empty");
                    return;
                }
                int dequeuedValue = this.front.data;
                this.front = this.front.next;

                if(this.front == null){
                    this.rear = null;
                }
                System.out.println(dequeuedValue + " dequeued from queue");
             }
            public int peek(){
                if(this.front == null){
                    System.out.println("Queue is empty");
                    return -1;
                }
                return this.front.data;
            }
            public boolean isEmpty(){
                return this.front == null;
            }

            public void printQueue(){
                if(this.front == null){
                    System.out.println("Queue is empty");
                    return;
                }
                Node current = front;
                System.out.println("Queue: ");
                while( current != null){
                    System.out.println(current.data + " ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    public class QueueUsingLinkedList{
        public static void main(String[] args) {
            Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();

        System.out.println("Front element is " + queue.peek());

     
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(100);

        queue.printQueue();
        System.out.println("Front element is " + queue.peek());
     }
    }

