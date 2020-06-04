package DataBase;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 这个类用于访问数据库
 * @version 1.0
 * @author haveadate
 */
public class DBtest {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public DBtest() {
//        try {
//            // 注册驱动程序
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            this.conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=NEWS_SYSTEM",
//                    "test", "123456");
//        } catch (Exception e) {
//            System.out.println(getCurrentTime() + "，构造函数处引发了异常:\n" + e.getMessage());
//        }
    }

    /***
     * 判断登录是否成功
     * @param account 用户名
     * @param password 密码
     * @return 数据库查找结果
     */
    public boolean login(String account, String password) {
        String sql = "select * from users where id=? and pwd=?";
        boolean exists = false;

        try {
            this.pstmt = conn.prepareStatement(sql);
            this.pstmt.setString(1, account);
            this.pstmt.setString(2, password);
            this.rs = this.pstmt.executeQuery();

            if (this.rs.next()) {
                exists = true;
            }
        } catch (Exception e) {
            System.out.println(getCurrentTime() + "，登录校验处引发了异常:\n" + e.getMessage());
        }

        return exists;
    }

    /***
     * 更改数据库
     * @param database 数据库名称
     * @param user 用户名
     * @param password  密码
     */
    public void updateDatabase(String database, String user, String password) {
        try {
            this.conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=" + database,
                    user, password);
        } catch (Exception e) {
            System.out.println(getCurrentTime() + "，更新数据库信息处引发了异常:\n" + e.getMessage());
        }
    }

    /***
     * 关闭数据库所有相关连接
     */
    public void closeConnection() {
        try {
            if (this.conn != null) {
                this.conn.close();
            }
            if (this.pstmt != null) {
                this.pstmt.close();
            }
            if (this.rs != null) {
                this.rs.close();
            }
        } catch (Exception e) {
            System.out.println(getCurrentTime() + "，关闭数据库连接处引发了异常:\n" + e.getMessage());
        }
    }

    /***
     * 获取当前时间
     * @return 当前时间
     */
    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return sdf.format(date);
    }
}
