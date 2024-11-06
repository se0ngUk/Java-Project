import java.util.*;
import java.sql.*;

public class Database {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/madangdb";
        String user = "root";
        String password = "root";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String SQL = null;
            System.out.println("MySQL Successfully Connected!"); // 데이터베이스 연결
            String SSN, userID, passWord, userName = null;
            SQL = "SELECT * FROM book";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                String bookid = rs.getString("bookname");
                System.out.println("bookname = " + bookid);
            }
            /*System.out.println("=========================메뉴 목록=========================");
            System.out.println("1 : 회원가입\n2 : 로그인\n3 : 회원탈퇴\n4 : 종료");
            System.out.print("실행할 메뉴 선택 >> ");
            String menu = scanner.nextLine();
            while(!menu.equals("3")){
                switch(menu){
                    case "1": 
                    System.out.print("주민번호(-사용) >> ");
                    SSN = scanner.nextLine();
                    if문으로 중복 회원가입 방지
                    System.out.print("할 ID >> ");
                    userID = scanner.nextLine();
                    System.out.print("사용할 PassWord >> ");
                    passWord = scanner.nextLine();
                    System.out.print("사용자 이름 >> ");
                    userName = scanner.nextLine();
                    SQL = "INSERT INTO user (userID, userPW, userName, SSN) VALUES(?, ?, ?, ?)"; 
                    PreparedStatement pstmt = conn.prepareStatement(SQL);
                    pstmt.setString(1, userID);
                    pstmt.setString(2, passWord);
                    pstmt.setString(3, userName);
                    pstmt.setString(4, SSN);
                    int result = pstmt.executeUpdate();
                    if(result > 0) System.out.println("회원가입이 완료되었습니다.");
                    break;
                    case "2":
                    System.out.print("ID >> ");
                    userID = scanner.nextLine();
                    String checkSQL = "SELECT COUNT(*) FROM user WHERE userID = ?";
                    PreparedStatement checkUserID = conn.prepareStatement(checkSQL);
                    checkUserID.setString(1, userID);
                    ResultSet rs = checkUserID.executeQuery();
                    if(rs.next() && rs.getInt(1) > 0){
                        System.out.print("PassWord >> ");
                        passWord = scanner.nextLine();
                        String checkPassWordSQL = "SELECT userPW FROM user where userID = ?";
                        PreparedStatement checkUserPW = conn.prepareStatement(checkPassWordSQL);
                        checkUserPW.setString(1, userID);
                        ResultSet resultPW = checkUserPW.executeQuery();
                        if(resultPW.next()){
                            if(passWord.equals(resultPW.getString("userPW"))){
                                System.out.println("Successfully Login!");
                            }
                            else {
                                System.out.println("비밀번호가 일치하지 않습니다.");
                            }
                        }
                    }
                    else {
                        System.out.println("회원 등록이 되어있지 않으니 회원가입부터 해주시기 바랍니다.");
                    }
                    break;
                }
            }*/
        }
        catch(Exception e){System.out.println(e.toString());}
        scanner.close();
    }
}
