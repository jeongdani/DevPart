package com.jdw.doublylinkedlist;


/**
 * Node 제너릭 클래스
 * @param <T> 임의의 타입을 받는 매개변수
 */
public class Node<T> {
    /**
     * 노드의 데이터 필드
     */
    private T data;
    /**
     * 다음 노드를 가르키는 필드
     */
    private Node<T> next;
    /**
     * 이전 노드를 가르키는 필드
     */
    private Node<T> prev;

    /**
     * Node 생성자
     *
     * @param data 임의의 타입 T형의 노드의 값을 받는 매개변수
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * 다음 노드를 지정하는 메소드
     *
     * @param next 다음 노드로 지정할 노드를 받는 매개변수
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * 이전 노드를 지정하는 메소드
     *
     * @param prev 이전 노드로 지정할 노드를 받는 매개변수
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * 다음 노드를 불러오는 메소드
     *
     * @return 다음 노드를 리턴
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * 이전 노드를 불러오는 메소드
     *
     * @return 이전 노드를 리턴
     */
    public Node<T> getPrev() {
        return this.prev;
    }

    /**
     * 노드 값을 불러오는 메소드
     *
     * @return 노드 값 리턴
     */
    public T getData() {
        return this.data;
    }

}
