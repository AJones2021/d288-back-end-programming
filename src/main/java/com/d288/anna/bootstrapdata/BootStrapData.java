package com.d288.anna.bootstrapdata;


import com.d288.anna.dao.CustomerRepository;
import com.d288.anna.dao.DivisionRepository;
import com.d288.anna.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {
    private final DivisionRepository divisionRepository;
    private final CustomerRepository customerRepository;

    public BootStrapData(DivisionRepository divisionRepository,CustomerRepository customerRepository){
        this.divisionRepository = divisionRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public void run(String... agrs) throws Exception {

        if(customerRepository.count() == 1) {

            Customer jessica = new Customer();
            jessica.setFirstName("Jessica");
            jessica.setLastName("Bennet");
            jessica.setAddress("125 Yellow Brick Rd");
            jessica.setPostal_code("15567");
            jessica.setPhone("(252) 767-8987");
            jessica.setDivision(divisionRepository.findAll().get(3));
            jessica.setCreate_date(new Date());
            jessica.setLast_update(new Date());

            Customer josh = new Customer();
            josh.setFirstName("Josh");
            josh.setLastName("Ipock");
            josh.setAddress("447 Hollow Creak Rd");
            josh.setPostal_code("21245");
            josh.setPhone("(555) 375-4271");
            josh.setDivision(divisionRepository.findAll().get(7));
            josh.setCreate_date(new Date());
            josh.setLast_update(new Date());

            Customer anaya = new Customer();
            anaya.setFirstName("Anaya");
            anaya.setLastName("Smith");
            anaya.setAddress("733 Rainbow Rd");
            anaya.setPostal_code("54567");
            anaya.setPhone("(252) 355-8910");
            anaya.setDivision(divisionRepository.findAll().get(2));
            anaya.setCreate_date(new Date());
            anaya.setLast_update(new Date());

            Customer willy = new Customer();
            willy.setFirstName("Willy");
            willy.setLastName("Wonka");
            willy.setAddress("831 Railway Rd");
            willy.setPostal_code("12347");
            willy.setPhone("(252) 322-2797");
            willy.setDivision(divisionRepository.findAll().get(7));
            willy.setCreate_date(new Date());
            willy.setLast_update(new Date());

            Customer amber = new Customer();
            amber.setFirstName("Amber");
            amber.setLastName("Kirby");
            amber.setAddress("555 Flower Rd");
            amber.setPostal_code("76785");
            amber.setPhone("(555)733-9999");
            amber.setDivision(divisionRepository.findAll().get(3));
            amber.setCreate_date(new Date());
            amber.setLast_update(new Date());

            customerRepository.save(jessica);
            customerRepository.save(josh);
            customerRepository.save(anaya);
            customerRepository.save(willy);
            customerRepository.save(amber);

            System.out.println("Customers Added");
            System.out.println("Number of Customers: " + customerRepository.count());
        }
        else{
            System.out.println("Customers already exist");

        }

    }
}
