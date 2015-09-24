package com.jdw.doublylinkedlist;

import java.util.Scanner;


/**
 * DoublyLinkedList의 메인 클래스
 */
public class DoublyLinkedListMain {

    /**
     * DoublyLinkedList의 메인 메소드
     *
     * @param args 메인 메소드의 매개 변수
     */
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        
        do {
            int MenuNum = menu();

            switch (MenuNum) {
                case 1:
                    System.out.print("추가할 노드 값을 입력해 주세요 : ");
                    Object data = sc.next();
                    dll.add(data);
                    break;
                case 2:
                    System.out.print("삭제할 노드의 인덱스를 입력해주세요(첫번째 노드는 0) : ");
                    dll.remove(sc.nextInt());
                    break;
                case 3:
                    System.out.print("검색할 노드의 인덱스를 입력해주세요(첫번째 노드는 0) : ");
                    System.out.println("검색된 노드 값 : " + dll.get(sc.nextInt()));
                    break;
                case 4:
                    System.out.println("리스트 출력 결과 : " + dll.toString());
                    break;
                case 5:
                    System.exit(0);
            }
        } while(true);
    }

    /**
     * DoublyLinkedList의 제어 작업을 선택할 수 있는 메뉴 메소드
     *
     * @return 제어 작업의 선택된 정수형의 번호
     */
    public static int menu(){
        int num;
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("─────────────── DoublyLinkedList(정다운) ───────────────");
            System.out.println("1. 노드 추가 \t 2. 노드 삭제 \t 3. 노드 검색 \t 4. 리스트 출력 \t 5. 프로그램 종료");
            System.out.println("───────────────────────────────────────────");
            System.out.print("원하시는 작업의 번호를 입력해주세요 : ");
            num = sc.nextInt();

            if(num < 1 || num > 5) {
                System.out.println("번호는 1 ~ 5번 까지 입력해주세요 !");
                System.out.println();
            } else { break; }

        }
        return num;
    }
}