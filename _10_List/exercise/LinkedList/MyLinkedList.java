package _10_List.exercise.LinkedList;

//import _10_List.practice.LinkedList.Node;

public class MyLinkedList {
    private Node head;
    private int numNodes = 0;

    public class Node {
        private Node next;
        private Object data;

        public Node (Object e) {
            this.data = e;
        }

        public Object getData () {
            return this.data;
        }
    }

    public MyLinkedList (Object e) {
        this.head = new Node(e);
    }

    // Khởi tạo node đầu tiên trong danh sách
    public Node initHead () {
        return new Node(null);
    }

    public Node creatNode (Object e) {
        Node temp = new Node(e);
        temp.next = null;
        temp.data = e;
        return temp;
    }

    // Thêm cuối danh sách
    public void addLast (Object e) {
        Node temp = creatNode(e);
        Node holder;

        if (this.head == null)
            this.head = temp;
        else {
            holder = this.head;
            while (holder.next != null) {
                holder = holder.next;
            }
            holder.next = temp;
            this.numNodes++;
        }
    }

    // Thêm đầu danh sách
    public void addFirst (Object e) {
        Node temp = creatNode(e);
        if (this.head == null)
            this.head = temp;
        else {
            temp.next = this.head;
            this.head = temp;
            this.numNodes++;
        }
    }

    // Truy cập phần tử tại vị trí index
    public Object get (int index) {
        Node temp = this.head;
        int i = 0;
        while (temp.next != null && i != index) {
            temp = temp.next;
            i++;
        }
        return temp.data;
    }

    public int indexOf (Object e) {
        int pos = 0;
        for (Node temp = this.head ; temp != null ; temp = temp.next) {
            if (temp.data == e) {
                return pos;
            }
            pos++;
        }
        return - 1;
    }

    public void add (Object e , int pos) {
        if (pos == 0 || this.head == null) {
            this.addFirst(e);
        } else {
            Node temp = this.head;
            int i = 1;
            while (i != pos && temp != null) {
                temp = temp.next;
                i++;
            }
            //Neu khong tim thay vi tri can tim
            if (i != pos) System.out.println("Vi tri them khong hop le");
            else {
                Node p = creatNode(e);
                p.next = temp.next;
                temp.next = p;
            }
        }
    }

    public void delHead () {
        if (this.head == null) System.out.println("List empty");
        else {
            this.head = this.head.next;
            this.numNodes--;
        }
    }

    public void delTail () {
        if (this.head == null || this.head.next == null) delHead();
        else {
            Node temp = this.head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            this.numNodes--;
        }
    }

    // Xoá tại vị trí
    public void removeAt (int pos) {
        if (pos == 0 || this.head == null || this.head.next == null) {
            this.delHead();
        } else {
            int i = 1;
            Node temp = this.head;
            while (i != pos && temp.next.next != null) {
                temp = temp.next;
                i++;
            }

            if (i != pos) System.out.println("Vi tri khong hop le!");
            else {
                temp.next = temp.next.next;
                this.numNodes--;
            }
        }
    }

    // Xoá 1 phần tử cho trước
    public void removeObj (Object o) {
        Node prev = null;

        if (this.head.data == o) {
            delHead();
        } else {
            for (Node temp = this.head ; temp != null ; temp = temp.next) {
                if (temp.data == o) {
                    Node i = this.head;
                    while (i.next != prev) {
                        i = i.next;
                    }
                    i.next = i.next.next;
                    break;
                } else {
                    prev = temp.next;
                }
            }
            this.numNodes--;
        }
    }

    // In các phần tử có trong danh sách
    public void printList () {
        for (Node temp = this.head ; temp != null ; temp = temp.next) {
            System.out.println(temp.data);
        }
    }

    public boolean contain (Object e) {
        for (Node temp = this.head ; temp != null ; temp = temp.next) {
            if (temp.data == e)
                return true;
        }
        return false;
    }

    // Trả về số lượng phần tử có trong danh sách
    public int getLength () {
        return numNodes;
    }

    // Tạo bản sao
    public MyLinkedList clone(){
        MyLinkedList ll = new MyLinkedList(head.data);
        ll.numNodes = 0;
        for (Node temp = head.next ; temp != null ; temp = temp.next){
            ll.addLast(temp.data);
        }
        return ll;
    }
}
