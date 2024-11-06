package UserMenu;
import java.sql.*;
import java.util.*;

public class userMenu {
    public static void startUserMenu(Connection conn, String userID){
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================사용자 메뉴====================");
        System.out.println("1. 검색\n2. 거래\n3. 문의\n4. 로그아웃");
        System.out.println("=================================================");
        System.out.print("선택 >> ");
        int userMenuNum = scanner.nextInt();
    }
    public static void menu(Connection conn){

    }
    public static void mail(Connection conn){

    }
    public static void search(Connection conn){

    }
    public static void trade(Connection conn){

    }
    public static void logout(Connection conn){

    }
}
