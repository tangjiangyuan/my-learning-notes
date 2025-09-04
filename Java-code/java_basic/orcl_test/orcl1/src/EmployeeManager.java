import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeManager {
    // 数据库连接信息
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "hr";
    private static final String PASSWORD = "yy1223";

    // 获取数据库连接
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 插入雇员信息
    public static void insertEmp(int employeeId, String firstName, String lastName,
                                 String email, String phoneNumber, String job, int departmentId) {
        String sql = "INSERT INTO employees (employee_id, first_name, last_name, email, " +
                "phone_number, job_id, department_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, email);
            pstmt.setString(5, phoneNumber);
            pstmt.setString(6, job);
            pstmt.setInt(7, departmentId);
            pstmt.executeUpdate();
            System.out.println("雇员信息插入成功！");
        } catch (SQLException e) {
            System.err.println("插入失败：" + e.getMessage());
        }
    }

    // 删除指定部门编号的雇员
    public static void deleteEmp(int departmentId) {
        String sql = "DELETE FROM employees WHERE department_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, departmentId);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("删除了 " + rowsAffected + " 条记录。");
        } catch (SQLException e) {
            System.err.println("删除失败：" + e.getMessage());
        }
    }

    // 修改某一编号的雇员信息
    public static void updateEmp(int employeeId, String newEmail) {
        String sql = "UPDATE employees SET email = ? WHERE employee_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, employeeId);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("更新了 " + rowsAffected + " 条记录。");
        } catch (SQLException e) {
            System.err.println("更新失败：" + e.getMessage());
        }
    }

    // 查询给定部门编号的雇员信息
    public static void getEmp(int departmentId) {
        String sql = "SELECT employee_id, first_name, last_name, email, job_id " +
                "FROM employees WHERE department_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, departmentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("员工编号: " + rs.getInt("employee_id") +
                        ", 姓名: " + rs.getString("first_name") + " " +
                        rs.getString("last_name") +
                        ", 邮箱: " + rs.getString("email") +
                        ", 职位: " + rs.getString("job_id"));
            }
        } catch (SQLException e) {
            System.err.println("查询失败：" + e.getMessage());
        }
    }

    // 测试方法
    public static void main(String[] args) {
        // 测试插入
        insertEmp(999, "John", "Doe", "johndoe@example.com",
                "1234567890", "IT_PROG", 60);

        // 测试查询
        System.out.println("查询部门编号为 60 的雇员信息：");
        getEmp(60);

        // 测试更新
        updateEmp(999, "john.doe@example.com");

        // 测试删除
        deleteEmp(60);
    }
}
