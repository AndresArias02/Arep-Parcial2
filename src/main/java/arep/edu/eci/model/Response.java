package arep.edu.eci.model;

import java.util.List;

public class Response {
    private String Operation;
    private List<String> inputList;
    private String Value;
    private String Output;

    public Response() {
    }

    public Response(String operation, List<String> inputList, String value, String output) {
        Operation = operation;
        this.inputList = inputList;
        Value = value;
        Output = output;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public List<String> getInputList() {
        return inputList;
    }

    public void setInputList(List<String> inputList) {
        this.inputList = inputList;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getOutput() {
        return Output;
    }

    public void setOutput(String output) {
        Output = output;
    }
}
