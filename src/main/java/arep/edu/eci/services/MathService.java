package arep.edu.eci.services;

import arep.edu.eci.model.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class MathService {

    public Response linearSearch(List<Integer> values, Integer value) {
        int output = -1;
        List<String> stringValues = convertListToString(values);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(value)) {
                output = i;
                break;
            }
        }
        return new Response("linearSearch", stringValues, String.valueOf(value), String.valueOf(output));
    }

    public Response binarySearch(List<Integer> values, Integer value) {
        Collections.sort(values);
        int output = binary(values, value, 0);
        List<String> stringValues = convertListToString(values);
        return new Response("binarySearch", stringValues, String.valueOf(value), String.valueOf(output));
    }

    private int binary(List<Integer> values, Integer value, int offset) {
        if (values.isEmpty()) return -1;
        int mediumIndex = values.size() / 2;
        if (Objects.equals(values.get(mediumIndex), value)) {
            return offset + mediumIndex;
        }
        if (value < values.get(mediumIndex)) {
            return binary(values.subList(0, mediumIndex), value, offset);
        } else {
            return binary(values.subList(mediumIndex + 1, values.size()), value, offset + mediumIndex + 1);
        }
    }

    private List<String> convertListToString(List<Integer> values) {
        List<String> stringValues = new ArrayList<>();
        for (Integer value : values) {
            stringValues.add(String.valueOf(value));
        }
        return stringValues;
    }
}

