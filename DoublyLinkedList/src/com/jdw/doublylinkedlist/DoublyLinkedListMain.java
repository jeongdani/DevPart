package com.jdw.doublylinkedlist;

import java.util.Scanner;


/**
 * DoublyLinkedList의 메인 클래스
 */
public class DoublyLinkedListMain {

    /**
     * DoublyLinkedList의 메인 메소드
     *
     * @param args 매개 변수
     */
    public static void main(String[] args) {
        // DoublyLinkedList 객체 생성
        DoublyLinkedList dll = new DoublyLinkedList();
        // 스캐너 객세 생성
        Scanner sc = new Scanner(System.in);

        do {
            // 먼저 MenuNum 이라는 정수형 변수 안에 menu() 메소드의 리턴 값을 넣음
            int MenuNum = menu();

            switch (MenuNum) {
                // 사용자가 입력한 정수가 1이라면, 인덱스와 값을 입력받게 하고 dll.add(int k, Object input)메소드 실행
                case 1:
                    System.out.print("추가할 노드의 인덱스와 값을 입력해 주세요(인덱스 0에 값 10 추가 입력 예> 0 10) : ");
                    int index = sc.nextInt();
                    Object data = sc.next();
                    dll.add(index, data);
                    break;
                // 사용자가 입력한 정수가 2라면, 인덱스를 입력받게 하고 dll.remove(int k)메소드 실행
                case 2:
                    System.out.print("삭제할 노드의 인덱스를 입력해주세요(첫번째 노드는 0) : ");
                    dll.remove(sc.nextInt());
                    break;
                // 사용자가 입력한 정수가 3이라면, 인덱스를 입력받게 하고 dll.findNode(int k)메소드 실행
                case 3:
                    System.out.print("검색할 노드의 인덱스를 입력해주세요(첫번째 노드는 0) : ");
                    dll.findNode(sc.nextInt());
                    break;
                // 사용자가 입력한 정수가 4라면, dll.print()메소드 실행
                case 4:
                    dll.print();
                    break;
                // 사용자가 입력한 정수가 5라면, 프로그램 종료
                case 5:
                    System.exit(0);
            }
        } while(true);  // 작업을 실행한 후 다시 메뉴로 돌아올 수 있게 함
    }

    /**
     * DoublyLinkedList 제어 메뉴 메소드
     *
     * @return 정수형의 선택된 번호 값
     */
    public static int menu(){
        // 선택할 번호의 정수형 변수 선언
        int num;
        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        while(true) {

            // DoublyLinkedList 제어 메뉴
            System.out.println("─────────────── DoublyLinkedList(정다운) ───────────────");
            System.out.println("1. 노드 추가 \t 2. 노드 삭제 \t 3. 노드 검색 \t 4. 리스트 출력 \t 5. 프로그램 종료");
            System.out.println("───────────────────────────────────────────");
            System.out.print("원하시는 작업의 번호를 입력해주세요 : "); // 사용자 입력
            // num 변수에 사용자가 입력한 번호 넣음
            num = sc.nextInt();

            // 1 ~ 5 의 값을 입력하지 않을 시에 알림 메시지 출력
            if(num < 1 || num > 5) {
                System.out.println("번호는 1 ~ 5번 까지 입력해주세요 !");
                System.out.println();
            } else { break; }

        }
        // 사용자가 입력한 번호 리턴
        return num;
    }

}