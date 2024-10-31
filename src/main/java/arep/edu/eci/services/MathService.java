package arep.edu.eci.services;

import arep.edu.eci.model.Response;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class MathService {

    public Response linearSearch(List<Integer> values, Integer value) {
        int output = -1;
        List<String> stringValues = Collections.singletonList(values.toString());
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(value)) {
                output = i;
            }
        }
        return new Response("linearSearch", stringValues, String.valueOf(value), String.valueOf(output));
    }

    public Response binarySearch(List<Integer> values, Integer value) {
        int output = binary(values,value);
        List<String> stringValues = Collections.singletonList(values.toString());
        return new Response("binarySearch", stringValues, String.valueOf(value), String.valueOf(output));
    }
    private int binary(List<Integer> values, Integer value){
        int output = -1;
        int lastIndex = values.size();
        int mediumIndex = lastIndex / 2;
        if(Objects.equals(values.get(mediumIndex), value)){
            return output = mediumIndex;
        }
        if(value < values.get(mediumIndex)){
            return binary(values.subList(0,mediumIndex), value);
        }
        if(value > values.get(mediumIndex)){
            return binary(values.subList(mediumIndex,values.size() - 1), value);
        }
        return output;
    }
}
