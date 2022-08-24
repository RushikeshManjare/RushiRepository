package com.csi.controller;

import com.csi.exception.ExceptionNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerServiceImpl;
    @PostMapping("/saveData")
    public ResponseEntity<Customer>saveData(@RequestBody Customer customer){
        return ResponseEntity.ok(customerServiceImpl.saveData(customer));
    }
    @GetMapping("/getAllData")
    public ResponseEntity<List<Customer>>getAllData(){
        return ResponseEntity.ok(customerServiceImpl.getAllData());

    }
    @GetMapping("/getDataById/{custId}")
    public ResponseEntity<Optional<Customer>> getDataById(@PathVariable int custId){
        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }
    @PutMapping("/updateData")
    public ResponseEntity<Customer>updateData(@PathVariable int custId,@RequestBody Customer customer) throws ExceptionNotFoundException {
        Customer customer1=customerServiceImpl.getDataById(custId).orElseThrow(()->new ExceptionNotFoundException("Id Does not Exits"));
        customer1.setCustName(customer.getCustName());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustAccountBalance(customer.getCustAccountBalance());
        customer1.setCustDob(customer.getCustDob());
        return ResponseEntity.ok(customerServiceImpl.updateData(customer1));
    }
    @DeleteMapping("/deleteData/{custId}")
    public  ResponseEntity<String>deleteData(@PathVariable int custId){
        customerServiceImpl.deleteData(custId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @GetMapping
    public String sayHello(){
        return "WELCOME TO FULL STACK JAVA DEVLOPER";
    }
}

