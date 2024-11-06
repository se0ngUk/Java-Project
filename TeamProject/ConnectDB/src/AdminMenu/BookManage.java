package AdminMenu;

import java.util.*;
import java.sql.*;

public class BookManage {
    public static void InsertBook(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }

    public static void DeleteBook(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }

    public static void FindBookID(Connection conn) {

    }

    public static void menu(Connection conn){
        Scanner scanner = new Scanner(System.in);
        try{
            while(true){
                System.out.println("====================재고 관리====================");
                System.out.println("1. 재고 추가\n2. 재고 삭제\n3. 메뉴로 이동");
                System.out.print("메뉴 선택 >> ");
                int menuNum = scanner.nextInt();
                scanner.nextLine();  // 숫자 뒤의 Enter를 처리하기 위해 사용
                switch(menuNum){
                    case 1:
                        // 도서 이름과 출판사 입력 받기
                        System.out.print("도서 이름 >> ");
                        String name = scanner.nextLine();
                        System.out.print("출판사 >> ");
                        String publisher = scanner.nextLine();
                        
                        // 입력받은 도서 이름과 출판사를 출력
                        System.out.println(name + publisher);
                        break;
                    case 2:
                        // 도서 삭제 처리 (추가 구현 필요)
                        break;
                    case 3:
                        // 관리자 메뉴로 이동 (Adminmenu는 구현되어 있어야 합니다.)
                        menu.Adminmenu(conn);
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                        break;
                }
            }
        } finally {
            scanner.close();  // while 루프가 끝나면 스캐너 닫기
        }
    }
}