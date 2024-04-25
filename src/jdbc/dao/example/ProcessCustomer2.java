package jdbc.dao.example;

import jdbc.dao.core.ConnectionFactory;
import jdbc.dao.core.DBConn;

public class ProcessCustomer2 {

    public static void main(String[] args) {

        try (DBConn conn = ConnectionFactory.getConnection()) {
            CustomerDAO customerDAO = new CustomerDAO(conn);

            customerDAO.list().forEach(System.out::println);
        }
    }
}
