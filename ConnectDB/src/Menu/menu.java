package Menu;
import java.util.*;
import com.mysql.cj.xdevapi.Result;
import java.sql.*;
import connectDatabase.*;

public class menu {
    public static String login(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        String ResultuserID = null;
        System.out.print("ID >> ");
        String userID = scanner.nextLine();
        try{
            String checkSQL = "SELECT COUNT(*) FROM user WHERE userID = ?";
            PreparedStatement checkUserID = conn.prepareStatement(checkSQL);
            checkUserID.setString(1, userID);
            ResultSet rs = checkUserID.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.print("PassWord >> ");
                String passWord = scanner.nextLine();
                String checkPassWordSQL = "SELECT userPW FROM user where userID = ?";
                PreparedStatement checkUserPW = conn.prepareStatement(checkPassWordSQL);
                checkUserPW.setString(1, userID);
                ResultSet resultPW = checkUserPW.executeQuery();
                if (resultPW.next()) {
                    if (passWord.equals(resultPW.getString("userPW"))) {
                        System.out.println("Successfully Login!");
                        ResultuserID = userID;
                    }
                    else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                        ResultuserID = null;
                    }
                }
            }
            else {
                System.out.println("회원 등록이 되어있지 않으니 회원가입부터 해주시기 바랍니다.");
            }
        }
        catch (Exception e) {}
        return ResultuserID;
    }
    public static void register(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("주민번호(-사용) >> ");
            String SSN = scanner.nextLine();
            /* if문으로 중복 회원가입 방지 */
            System.out.print("할 ID >> ");
            String userID = scanner.nextLine();
            System.out.print("사용할 PassWord >> ");
            String passWord = scanner.nextLine();
            System.out.print("사용자 이름 >> ");
            String userName = scanner.nextLine();
            String SQL = "INSERT INTO user (userID, userPW, userName, SSN) VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            pstmt.setString(2, passWord);
            pstmt.setString(3, userName);
            pstmt.setString(4, SSN);
            int result = pstmt.executeUpdate();
            if (result > 0)
                System.out.println("회원가입이 완료되었습니다.");
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }
}
