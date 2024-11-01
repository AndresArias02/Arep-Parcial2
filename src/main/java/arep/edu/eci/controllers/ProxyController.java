package arep.edu.eci.controllers;

import arep.edu.eci.services.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    private final ProxyService proxyService;

    @Autowired
    public ProxyController(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @GetMapping("/LinearSearch")
    public String linearSearch(@RequestParam String list, @RequestParam String value){
        String path = "LinearSearch?list="+list+"&value="+value;
        try {
            return proxyService.sendGetRequest(path);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/BinarySearch")
    public String binarySearch(@RequestParam String list, @RequestParam String value){
        String path = "LinearSearch?list="+list+"&value="+value;
        try {
            return proxyService.sendGetRequest(path);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
