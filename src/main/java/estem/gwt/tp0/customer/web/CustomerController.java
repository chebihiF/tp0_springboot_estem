package estem.gwt.tp0.customer.web;

import estem.gwt.tp0.customer.service.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/app/customers/")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomers(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "20") int size){
        try {
            model.addAttribute("customers",customerService.getCustomers(PageRequest.of(page,size)));
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            e.printStackTrace();
        }
        return "customers";
    }
}
