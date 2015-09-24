package com.jdw.doublylinkedlist;


/**
 * DoublyLinkedList 제너릭 클래스
 * @param <T> 임의의 타입을 받는 매개변수
 */
public class DoublyLinkedList<T> {
    /**
     * 첫 노드를 가리키는 필드
     */
    private Node<T> head;

    /**
     * 마지막 노드를 가리키는 필드
     */
    private Node<T> tail;

    /**
     * 리스트의 사이즈 필드
     */
    private int nSize = 0;

    public DoublyLinkedList() {}

    /**
     * 노드 값 추가 메소드
     *
     * @param data 임의의 타입 T형의 추가할 노드의 값을 받는 매개변수
     */
    public void add(T data) {
        Node<T> dllAdd = new Node<T>(data);
        if (tail == null) {
            tail = dllAdd;
            head = tail;
        } else {
            dllAdd.setPrev(tail);
            tail.setNext(dllAdd);
            tail = dllAdd;
        }
        nSize++;
    }

    /**
     * 노드 삭제 메소드
     *
     * @param index 삭제할 노드의 인덱스를 받는 매개변수
     */
    public void remove(int index) {

        if (index < 0 || index >= nSize) {
            System.out.println("노드를 삭제할 수 있는 인덱스의 범위를 벗어났습니다");
        } else {
            Node dllRemove = get(index);
            dllRemove.getPrev().setNext(dllRemove.getNext());
            dllRemove.getNext().setPrev(dllRemove.getPrev());
            nSize--;
        }
    }

    /**
     * 노드 검색 메소드
     *
     * @param index 정수형의 노드 인덱스
     * @return 임의의 타입 <T>로 노드 값을 리턴
     */
    public Node get(int index) {

        if (index < 0 || index >= nSize)
            System.out.println("노드를 검색할 수 있는 인덱스의 범위를 벗어났습니다");

        if (index < nSize / 2) {
            Node dllNode = head;

            for (int i = 0; i < index; i++)
                dllNode = dllNode.getNext();

            return dllNode;
        } else {
            Node dllNode = tail;

            for (int i = nSize - 1; i > index; i--)
                dllNode = dllNode.getPrev();

            return dllNode;
        }
    }

    /**
     * 리스트 전체를 출력하는 메소드
     *
     * @return String형으로 리스트 전체 값을 리턴
     */
    public String toString() {

        if (nSize == 0) {
            return "비어 있음";
        } else {
            Node<T> dllNode = head;
            StringBuffer sb = new StringBuffer();
            sb.append("[ ");

            for (int i = 0; i < nSize; i++) {

                if (i != nSize - 1){
                    sb.append(dllNode.getData() + ", ");
                } else {
                    sb.append(dllNode.getData());
                }
                dllNode = dllNode.getNext();
            }

            return sb + " ] / 리스트 크기 : " + nSize;
        }
    }

}