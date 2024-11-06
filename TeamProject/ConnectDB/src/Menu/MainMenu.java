package Menu;
import UserMenu.*;
import java.util.*;
import java.sql.*;

public class MainMenu {
    public static void startMenu(Connection conn){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("====================메뉴 선택====================");
            System.out.println("1. 회원가입\n2. 로그인\n3. 종료");
            System.out.println("=================================================");
            System.out.print("선택 >> ");
            int menuNum = scanner.nextInt();
            switch(menuNum){
                case 1:
                menu.register(conn);
                break;
                case 2:
                String userID = menu.login(conn);
                if(userID != null){
                    userMenu.startUserMenu(conn, userID);
                }
                else {
                    startMenu(conn);
                }
                break;
                case 3:
                System.out.println("프로그램을 종료합니다.");
                scanner.close();
                return;
            }
        }
    }
}
