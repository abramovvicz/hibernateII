package service;

import dao.CustomerDao;
import model.Customer;

public class CustomerServiceImp  implements  CustomerService {

    private CustomerDao customerDao;


    public CustomerServiceImp(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.insert(customer);
    }
}
