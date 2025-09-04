package com.tjy;

import com.sun.jdi.connect.Connector;
import com.tjy.pojo.User;
import lombok.With;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/8/4 14:35
 */
@SuppressWarnings("all")
public class JDBCTest {

    /**
     * jdbc 入门程序
     */
    @Test
    public void testUpdate() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1223";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 获取SQL 语句执行对象
        Statement statement = connection.createStatement();
        // 4. 执行SQL
        // executeUpdate 用来执行 DML语句
        // executeQuery 用来执行 DQL语句
        int i = statement.executeUpdate("update user set age = 25 where id = 1;");
        System.out.println("SQL语句执行完毕影响的记录:" + i);
        // 5. 释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testInsert() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1223";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 获取SQL执行语句
        Statement statement = connection.createStatement();
        // 4. 执行SQL
        statement.executeUpdate("insert into user values(null, 'luban', '123456', '鲁班', 20);");
        System.out.println("更新成功！");
        // 5. 释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1223";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 获取SQL操作对象
        String sql = "select * from user where username = ? and password = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "daqiao");
        ps.setString(2, "123456");

        // 4. 执行SQL语句
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getInt("age"));
            System.out.println(user);
        }
        // 5. 释放资源
        connection.close();
    }

    @Test
    public void testSelectAI() {
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1223";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; //封装查询返回的结果

        try {
            // 1. 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 打开链接
            conn = DriverManager.getConnection(url, username, password);

            // 3. 执行查询
            String sql = "SELECT id, username, password, name, age FROM user WHERE username = ? AND password = ?"; //预编译SQL
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, "daqiao");
            stmt.setString(2, "123456");

            rs = stmt.executeQuery();

            // 4. 处理结果集
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
                System.out.println(user); // 使用 Lombok 的 @Data 自动生成的 toString 方法
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Test
    public void testUpdate01() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1223";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 创建SQL语句
        Statement statement = connection.createStatement();
        // 4. 执行SQL语句
        statement.executeUpdate("update user set age = 18 where id = 8");
        // 5. 释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testInsert01() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1223";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 创建SQL语句
        Statement statement = connection.createStatement();
        // 4. 执行SQL语句
        statement.executeUpdate("insert into user values (null, 'xialuote', '112233', '夏洛特', 18)");
        // 5. 释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testDelete01() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1223";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 创建SQL语句
        Statement statement = connection.createStatement();
        // 4. 执行SQL语句
        statement.executeUpdate("delete from user where id = 11");
        // 5. 释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testQuery01() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1223";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 创建SQL语句
        String sql = "select id, username, password, name, age from user where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, 1);
        // 4. 执行SQL语句
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getInt("age")
            );
            System.out.println(user);
        }
        // 5. 释放资源
        rs.close();
        ps.close();
        connection.close();
    }

    /**
     * 优化
     * 从JDBC 4.0开始，不再需要编写注册驱动的代码，采用自驱动方式，简化代码
     */
    @Test
    public void testQuery02() {
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1223";

        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement("select * from user where id = ?")
        ) { // conn、stmt、rs 都继承了 AutoCloseable，可以自动释放资源

            stmt.setInt(1, 7);
            try (
                    ResultSet rs = stmt.executeQuery()
            ) {
                while (rs.next()) {
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getInt("age")
                    );
                    System.out.println(user);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
