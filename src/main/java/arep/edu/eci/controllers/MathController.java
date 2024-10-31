package arep.edu.eci.controllers;

import arep.edu.eci.model.Response;
import arep.edu.eci.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class MathController {

    private final MathService mathService;

    @Autowired
    public MathController( MathService mathService){
        this.mathService = mathService;
    }


    @GetMapping("/LinearSearch")
    public ResponseEntity<Response> linearSearch(@RequestParam List<String> values, @RequestParam String value){
        List<Integer> integerValues = new ArrayList<>();
        for(String s : values){
            integerValues.add(Integer.parseInt(s));
        }
        Response response = mathService.linearSearch(integerValues,Integer.parseInt(value));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/BinarySearch")
    public ResponseEntity<Response> binarySearch(@RequestParam List<String> values, @RequestParam String value){
        List<Integer> integerValues = new ArrayList<>();
        for(String s : values){
            integerValues.add(Integer.parseInt(s));
        }
        Response response = mathService.binarySearch(integerValues,Integer.parseInt(value));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
