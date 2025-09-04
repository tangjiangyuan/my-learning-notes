import java.sql.*;
import oracle.jdbc.OracleTypes;

public class executeProQuery {
    // 数据库连接信息
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl?" +
            "useUnicode=true&characterEncoding=ZHS16GBK";
    private static final String USER = "hr";
    private static final String PASSWORD = "yy1223";

    // 获取数据库连接
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 调用存储过程 ProQueryEmployByDeptno
    public static void executeProcedete(int departmentId) {
        String sql = "{CALL ProQueryEmployByDeptno(?, ?)}";
        try (Connection conn = getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            // 设置输入参数
            cstmt.setInt(1, departmentId);

            // 注册输出参数
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);

            // 执行存储过程
            cstmt.execute();

            // 获取游标结果
            ResultSet rs = (ResultSet) cstmt.getObject(2);

            // 输出结果
            while (rs.next()) {
                System.out.println("员工编号: " + rs.getInt("EMPLOYEE_ID") +
                        ", 姓名: " + rs.getString("EMPLOYEE_NAME") +
                        ", 职位: " + rs.getString("JOB_ID") +
                        ", 部门编号: " + rs.getInt("DEPARTMENT_ID"));
            }
        } catch (SQLException e) {
            System.err.println("调用存储过程失败：" + e.getMessage());
        }
    }

    // 测试方法
    public static void main(String[] args) {
        // 测试调用存储过程
        System.out.println("查询部门编号为 60 的雇员信息：");
        executeProcedete(60);
    }
}
