package jdbc.dao.example;

import jdbc.dao.core.ConnectionFactory;
import jdbc.dao.core.DBConn;

public class ProcessCustomer {

    public static void main(String[] args) {

        try (DBConn conn = ConnectionFactory.getConnection()) {
            Customer customer = new Customer("Pedro", "pedro@pedro.com", 35);

            CustomerDAO customerDAO = new CustomerDAO(conn);
            customerDAO.insert(customer);
        }
    }
}
