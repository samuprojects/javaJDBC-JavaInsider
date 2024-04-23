package jdbc.dao;

import static jdbc.dao.ConnectionFactory.getConnection;

@SuppressWarnings("ALL")
public class TestDAOConn {

    public static void main(String[] args) throws Exception {

//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin");
//        System.out.println("Connected successfully!");
//        conn.close();

        try (DBConn dbConn = getConnection()) {
            System.out.println("Connected successfully!");
        }
    }
}
