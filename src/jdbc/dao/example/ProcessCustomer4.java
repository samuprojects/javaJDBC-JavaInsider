package jdbc.dao.example;

import jdbc.dao.core.ConnectionFactory;
import jdbc.dao.core.DBConn;

public class ProcessCustomer4 {

    public static void main(String[] args) {

        try (DBConn conn = ConnectionFactory.getConnection()) {
            CustomerDAO customerDAO = new CustomerDAO(conn);

            Customer customer = new Customer("Maria", "a@a.com", 54);
            Integer customerId = customerDAO.insert(customer);

            PhoneDAO phoneDAO = new PhoneDAO(conn);
            Phone phone = new Phone(customerId, "Celular", "1234567");
            phoneDAO.insert(phone);
        }
    }
}
