import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
    // 编写 connectOracle 函数实现连接 Oracle 数据库
    public static Connection connectOracle() {
        // 定义数据库连接信息
        String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 数据库地址和实例名
        String user = "system"; // 替换为你的数据库用户名
        String password = "1223"; // 替换为你的数据库密码

        Connection connection = null;

        try {
            // 加载 Oracle JDBC 驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立连接
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("连接成功！");
        } catch (ClassNotFoundException e) {
            System.err.println("Oracle JDBC 驱动未找到！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("连接失败！");
            e.printStackTrace();
        }

        return connection;
    }

    // 测试连接
    public static void main(String[] args) {
        Connection connection = connectOracle();
        if (connection != null) {
            try {
                connection.close();
                System.out.println("连接已关闭！");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
