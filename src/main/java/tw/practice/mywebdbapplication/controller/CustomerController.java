package tw.practice.mywebdbapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tw.practice.mywebdbapplication.model.Customer;
import tw.practice.mywebdbapplication.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/customers")
    public String showCustomers(Model model){
        //CustomerService 要資料
        List<Customer> custs = customerService.getCustomerAll();
        //放入model
        model.addAttribute("custs", custs);
        return "customer_list";
    }
    @GetMapping("/customer/new")
    public String Customer_register(Model model){

        return "customer_create";
    }
    @PostMapping("/customer/registerWork")
    public String customerRegister(Model model){
        return "customer_reg_result";
    }

    //測試使用傳參數給瀏覽器 使用post方法insert一個名字 並顯示參數的值在網頁上
    @PostMapping("/testPost")
    public String testPostWeb(Model model, @RequestParam String name){
        model.addAttribute("param1", name);
        return "testPost";
    }

}
