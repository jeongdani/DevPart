package com.jdw.doublylinkedlist;


/**
 * DoublyLinkedList 클래스
 */
public class DoublyLinkedList {

    /**
     * 첫번째 노드를 가리키는 필드
     */
    private Node head;
    /**
     * 마지막 노드를 가리키는 필드
     */
    private Node tail;
    /**
     * 사이즈 변수, 초기 사이즈는 0으로 초기화
     */
    private int size = 0;

    /**
     * Node를 컨트롤 할 수 있는 클래스
     */
    public class Node {

        /**
         * 데이터가 저장될 필드
         */
        private Object data;
        /**
         * 다음 노드를 가리키는 필드
         */
        private Node next;
        /**
         * 이전 노드를 가르키는 필드
         */
        private Node prev;

        /**
         * Node 초기화
         *
         * @param input 노드 값
         */
        public Node(Object input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }

    }

    /**
     * 첫번째 노드인 헤드에 값을 삽입하는 메소
     *
     * @param input 첫번째 노드인 헤드 값
     */
    public void addHead(Object input) {

        // 새 노드 생성
        Node newNode = new Node(input);
        // 새 노드 다음을 헤드 값으로 지정
        newNode.next = head;

        // 기존 노드가 존재하면 현재 헤드의 이전 노드를 새로운 노드를 지정
        if (head != null)
            head.prev = newNode;

        // 새 노드를 헤드로 지정
        head = newNode;
        // 새 노드가 삽입되었기 때문에 size를 증가시킴
        size++;

        // 헤드로 삽입된 새 노드의 다음 노드가 없다면 헤드를 마지막 노드 지정
        if (head.next == null) {
            tail = head;
        }
    }

    /**
     * 노드를 탐색해 값을 전달하는 메소드
     *
     * @param index 인덱스
     * @return 노드 값
     */
    Node node(int index) {
        // 찾으려는 노드의 인덱스가 전체 노드 수의 반보다 작은지 큰지 계산
        if (index < size / 2) {
            // 헤드부터 next를 이용해 인덱스에 해당하는 노드 탐색
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            // tail부터 prev를 이용해 인덱스에 해당하는 노드 탐색
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    /**
     * 노드 탐색 후 값을 출력하는 메소드
     *
     * @param index 탐색할 노드의 인덱스 값
     */
    public void findNode(int index) {
        // 찾으려는 노드의 인덱스가 전체 노드 수의 반보다 작은지 큰지 계산
        if (index < size / 2) {
            // 헤드부터 next를 이용해 인덱스에 해당하는 노드 탐색
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            System.out.println(x);
        } else {
            // tail부터 prev를 이용해 인덱스에 해당하는 노드 탐색
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            System.out.println("해당 노드의 값 : " + x.data);
        }
    }

    /**
     * 노드 추가 메소드
     *
     * @param k 추가할 노드의 인덱스 값
     * @param input 추가할 노드의 값
     */
    public void add(int k, Object input) {
        // 인덱스 k가 0이면 헤드(첫번째 노드)에 매개 변수 input 값 추가
        if (k == 0) {
            addHead(input);
        } else {
            // 새 노드를 추가 하기 위해 prevNode를 k 번째 이전 노드로 지정
            Node prevNode = node(k - 1);
            // k 번째 노드를 nextNode로 지정
            Node nextNode = prevNode.next;
            // 새 노드 생성
            Node newNode = new Node(input);
            // prevNode의 다음 노드로 새 노드를 지정
            prevNode.next = newNode;
            // 새로운 노드의 다음 노드로 nextNode를 지정
            newNode.next = nextNode;
            // nextNode의 이전 노드로 새로운 노드를 지정
            if (nextNode != null)
                nextNode.prev = newNode;
            // 새로운 노드의 이전 노드로 prevNode를 지정합니다.
            newNode.prev = prevNode;
            // 새 노드 추가로 사이즈 증가 시킴
            size++;
            // 새 노드의 다음 노드가 없으면 새로운 노드가 마지막 노드이기 때문에 tail로 지정
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    /**
     * 첫번째 노드인 헤드 삭제 메소드
     * @return Object형 returnData 변수
     */
    public Object removeHead() {

        // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
        Node temp = head;
        head = temp.next;
        // 삭제될 데이터 값을 변수에 담음
        Object returnData = temp.data;
        temp = null;
        // 리스트 내 노드가 있다면 head의 이전 노드를 null로 지정
        if (head != null)
            head.prev = null;
        // 헤드가 삭제되었기 때문에 사이즈 감소 시킴
        size--;
        return returnData;
    }

    /**
     * 노드 삭제 메소드
     *
     * @param k 삭제할 노드 인덱스 값
     * @return Object 형 returnData 변수
     */
    public Object remove(int k) {
        // 인덱스인 매개변수 k가 0이라면 첫번째 노드인 헤드 값을 제거하는 것이기 때문에 removeHead()메소드 사용
        if (k == 0)
            return removeHead();
        // k-1번째 노드를 임시 변수로 지정
        Node temp = node(k - 1);
        // 노드를 삭제하기 전에 todoDeleted 변수에 보관
        Node todoDeleted = temp.next;
        // 삭제 대상 노드를 분리
        temp.next = temp.next.next;

        // 삭제 대상 노드 값이 null이 아니라면 삭제할 전 후 노드 연결
        if (temp.next != null) {
            temp.next.prev = temp;
        }

        // 삭제된 노드의 데이터를 리턴하기 위해 returnData에 데이터를 저장
        Object returnData = todoDeleted.data;
        // 삭제된 노드가 tail이었다면 tail 이전 노드를 tail로 지정
        if (todoDeleted == tail) {
            tail = temp;
        }
        // 노드 삭제
        todoDeleted = null;
        // 노드가 삭제 되었기 때문에 사이즈 감소 시킴
        size--;
        return returnData;
    }

    /**
     * 사이즈 값을 리턴하는 메소드
     *
     * @return 정수형 사이즈 값
     */
    public int size() {
        return size;
    }

    /**
     * 리스트 전체 출력 메소드
     */
    public void print() {
        // 첫번째 노드인 헤드 값이 null이라면 리스트 부재 출력
        if (head == null) {
            System.out.println("리스트가 없습니다.");
        } else {
            // head 부터 next를 돌려가며 값을 출력할 것이기 때문에 head를 Node 변수 nodeData에 지정
            Node nodeData = head;
            // [ 노드값, 노드값, ... 형태로 출력하기 위한 변수
            String str = "[ ";
            // 리스트 사이즈 내에 있는 모든 노드 출력
            for (int i = 0; i < size(); i++) {
                str += nodeData.data + ", ";
                nodeData = head.next;
            }
            System.out.println(str + " ]");
        }
    }
}