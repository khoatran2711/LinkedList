/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HELLO
 */
public class MyList {

    Node head;
    Node tail;

    public MyList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        if ((head == null) && (tail == null)) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        while (head != null) {
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
        tail = null;
    }

    public void addLast(Person x) {
        Node N = new Node(x, null);
        if (isEmpty()) {
            head = N;
            tail = N;
        } else {
            N.next = null;
            tail.next = N;
            tail = N;
        }
    }

    public void visit(Node p) {
        if (p != null) {
            System.out.println(p.infor);
        }
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println("");
    }

    public void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    // (2)
    public Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.infor.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    // (3)
    public void addFirst(Person x) {
        Node N = new Node(x, null);
        if (isEmpty()) {
            head = N;
            tail = N;
        } else {
            N.next = head;
            head = N;
        }
    }

    // (4)
    void insertAfter(Node q, Person x) {
        if (q == null) {
            return;
        }
        if (q == tail) {
            addLast(x);
            return;
        }
        Node p = head;
        while (p != null && p != q) {
            p = p.next;
        }
        if (p != null) {
            Node newNode = new Node(x);
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    // (5)
    public void insertBefore(Node q, Person x) {
        if (q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        if (p != null) {
            Node newNode = new Node(x);
            newNode.next = q; // Cập nhật newNode.next để trỏ tới nút sau đó (q).
            p.next = newNode; // Cập nhật p.next để trỏ tới newNode.
        }
    }

    // (6)
    public void remove(Node q) {
        if (isEmpty() || q == null) {// Mảng rỗng hoặc giá trị cần xóa không tồn tại thì return.
            return;
        }

        if (q == head) {// Nếu giá trị cần xóa ở đầu danh sách thì head = head.next
            head = head.next;
            if (head == null) { // Nếu mảng chỉ có một giá trị duy nhất thì tail = null
                tail = null;
            }
            return;
        }
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }

        if (p != null) {
            p.next = q.next; // Xóa giá trị tham chiếu q
            if (q == tail) {
                tail = p;
            }
        }
    }

    // (7)
    public void remove(String xName) {
        Node p = head;
        Node prev = null;
        while (p != null) {
            if (p.infor.name.equals(xName)) {
                if (prev == null) {
                    head = p.next;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    prev.next = p.next;
                    if (p == tail) {
                        tail = prev;
                    }
                }
                return;
            }
            prev = p;
            p = p.next;
        }
    }

// (8)
    public void remove(int xAge) {
        Node p = head;
        Node prev = null;

        while (p != null) {
            if (p.infor.age == xAge) {
                if (prev == null) {
                    head = p.next;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    prev.next = p.next;
                    if (p == tail) {
                        tail = prev;
                    }
                }
                return; // Dừng sau khi loại bỏ nút đầu tiên có tuổi bằng xAge.
            } else {
                prev = p;
                p = p.next;
            }
        }
    }

    // (9)
    public void removeAll(int xAge) {
        Node p = head;
        Node prev = null;
        while (p != null) {
            if (p.infor.age == xAge) {
                if (prev == null) {
                    head = p.next;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    prev.next = p.next;
                    if (p == tail) {
                        tail = prev;
                    }
                }
            } else {
                prev = p;
            }
            p = p.next;
        }
    }

    // (10)
    public Node pos(int k) {
        int index = 0;
        Node p = head;
        while (p != null) {
            if (index == k) {
                return p;
            }
            index++;
            p = p.next;
        }
        return null;
    }

    // (11)
    public void removePos(int k) {
        if (k < 0) {
            return;
        }
        if (k == 0) {
            if (head != null) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
            }
            return;
        }
        Node p = pos(k - 1);
        if (p != null && p.next != null) {
            p.next = p.next.next;
            if (p.next == null) {
                tail = p;
            }
        }
    }

    // (12)
    public void sortByName() {
        boolean swapped;
        Node ptr1;
        Node lptr = null;

        // Check if the list is empty
        if (head == null) {
            return;
        }

        do {
            swapped = false;
            ptr1 = head;

            while (ptr1.next != lptr) {
                // Compare names and swap if needed
                if (ptr1.infor.name.compareTo(ptr1.next.infor.name) > 0) {
                    // Swap the data in the nodes
                    Person temp = ptr1.infor;
                    ptr1.infor = ptr1.next.infor;
                    ptr1.next.infor = temp;

                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped);
    }

    // (13)
    public void sortByAge() {
        boolean swapped;
        Node ptr1;
        Node lptr = null;

        // Check if the list is empty
        if (head == null) {
            return;
        }

        do {
            swapped = false;
            ptr1 = head;

            while (ptr1.next != lptr) {
                // Compare ages and swap if needed
                if (ptr1.infor.age > ptr1.next.infor.age) {
                    // Swap the data in the nodes
                    Person temp = ptr1.infor;
                    ptr1.infor = ptr1.next.infor;
                    ptr1.next.infor = temp;

                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped);
    }

    // (14)
    public int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    // (15)
    public Person[] toArray() {
        int n = size();
        Person[] arr = new Person[n];
        Node p = head;
        int i = 0;
        while (p != null) {
            arr[i] = p.infor;
            i++;
            p = p.next;
        }
        return arr;
    }

    // (16)
    public void reverse() {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        tail = head;
        head = prev;
    }

    // (17) 
    public Node findMaxAge() {
        if (isEmpty()) {
            return null;
        }

        Node maxNode = head;
        Node p = head.next;

        while (p != null) {
            if (p.infor.age > maxNode.infor.age) {
                maxNode = p;
            }
            p = p.next;
        }

        return maxNode;
    }

    // (18) 
    public Node findMinAge() {
        if (isEmpty()) {
            return null;
        }

        Node minNode = head;
        Node p = head.next;

        while (p != null) {
            if (p.infor.age < minNode.infor.age) {
                minNode = p;
            }
            p = p.next;
        }

        return minNode;
    }

    // (19) 
    public void setData(Node p, Person x) {
        if (p != null) {
            p.infor = x;
        }
    }

    // (20) 
    public void sortByAge(int start, int end) {
        
        if (head == null || start >= end || end >= size()) {
            return; // Không cần sắp xếp nếu danh sách rỗng hoặc vị trí không hợp lệ.
        }
//        
        Node headClone = head;
        Node current = headClone;
        Node prev = null;
        Node prevEnd = null; // Node trước nút cuối của phạm vi sắp xếp

        // Đưa con trỏ current đến vị trí start
        for (int i = 0; i < start; i++) {
            prev = current;
            current = current.next;
        }

        for (int i = start; i < end; i++) {
            Node innerCurrent = current;
            Node innerPrev = prev;

            for (int j = i + 1; j <= end; j++) {
                if (innerCurrent.infor.age > innerCurrent.next.infor.age) {
                    // Swap data of innerCurrent and innerCurrent.next
                    Person temp = innerCurrent.infor;
                    innerCurrent.infor = innerCurrent.next.infor;
                    innerCurrent.next.infor = temp;
                    
                    if (innerPrev != null) {
                        innerPrev.next = innerCurrent.next;
                    } else {
                        headClone = innerCurrent.next;
                    }

                    innerCurrent.next = innerCurrent.next.next;
                    if (innerCurrent.next == null) {
                        tail = innerCurrent;
                    } else if (prevEnd != null) {
                        prevEnd.next = innerCurrent;
                    } else {
                        headClone = innerCurrent;
                    }

                    innerPrev = innerCurrent;
                } else {
                    innerPrev = innerCurrent;
                    innerCurrent = innerCurrent.next;
                }
            }
            end--;
            prevEnd = innerPrev;
            prev = current;
            current = current.next;
        }
        this.traverse();
    }

}
