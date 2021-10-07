package e4;

import java.util.ArrayList;

public class Calculator {

    private Operation operation;
    ArrayList<Float> ValuesList = new ArrayList<>();
    ArrayList<String> OperationList = new ArrayList<>();

    private enum Operation{
        SUMA("+"){

            public float perform(float operand1, float operand2){
                return operand1 + operand2;
            }
        },
        RESTA("-"){

            public float perform(float operand1, float operand2){
                return operand1 - operand2;
            }
        },
        DIVISION("/"){

            public float perform(float operand1, float operand2){
                return operand1 / operand2;
            }
        },
        MULTIPLICACION("*"){

            public float perform(float operand1, float operand2){
                return operand1 * operand2;
            }
        };

        private final String operator;

        Operation(String operator){
            this.operator = operator;
        }

        public abstract float perform(float operand1, float operand2);
    }

    private float performOperation(float operand1, float operand2){
        return operation.perform(operand1, operand2);
    }

    public void setOperation(Operation operation){
        this.operation = operation;
    }

    public Calculator(){

    }

    public void cleanOperations () {
        ValuesList.clear();
        OperationList.clear();
    }

    public void addOperation ( String operation , float ... values ) {

        if (operation.equals("+") || operation.equals("-") || operation.equals("/") || operation.equals("*")) {
            OperationList.add(operation);
        } else {
            throw new IllegalArgumentException();
        }

        for (float value : values) {
            ValuesList.add(value);
        }

    }

    public float executeOperations () {

        float result = 0;

        if (OperationList.get(0).equals(Operation.SUMA.operator)){
            setOperation(Operation.SUMA);
            result = operation.perform(ValuesList.get(0), ValuesList.get(1));
        }
        if (OperationList.get(0).equals(Operation.RESTA.operator)){
            setOperation(Operation.RESTA);
            result = performOperation(ValuesList.get(0), ValuesList.get(1));
        }
        if (OperationList.get(0).equals(Operation.MULTIPLICACION.operator)){
            setOperation(Operation.MULTIPLICACION);
            result = performOperation(ValuesList.get(0), ValuesList.get(1));
        }
        if (OperationList.get(0).equals(Operation.DIVISION.operator)){
            setOperation(Operation.DIVISION);
            if (ValuesList.get(1) != 0) {
                result = performOperation(ValuesList.get(0), ValuesList.get(1));
            } else {
                cleanOperations();
                throw new ArithmeticException();
            }
        }

        for(int i=1, j=2;i < OperationList.size() && j <ValuesList.size();i++,j++){
            if (OperationList.get(i).equals(Operation.SUMA.operator)){
                setOperation(Operation.SUMA);
                result = operation.perform(result, ValuesList.get(j));
            }
            if (OperationList.get(i).equals(Operation.RESTA.operator)){
                setOperation(Operation.RESTA);
                result = performOperation(result, ValuesList.get(j));
            }
            if (OperationList.get(i).equals(Operation.MULTIPLICACION.operator)){
                setOperation(Operation.MULTIPLICACION);
                result = performOperation(result, ValuesList.get(j));
            }
            if (OperationList.get(i).equals(Operation.DIVISION.operator)){
                setOperation(Operation.DIVISION);
                if (ValuesList.get(j) != 0) {
                    result = performOperation(result, ValuesList.get(j));
                } else {
                    cleanOperations();
                    throw new ArithmeticException();
                }
            }
        }
        cleanOperations();
        return result;
    }

    @Override
    public String toString () {

        if(OperationList.isEmpty() && ValuesList.isEmpty()){
            return "[STATE:]";
        }
        else {
            String Operacion = "[STATE:[" + OperationList.get(0) + "]" + ValuesList.get(0) + "_" + ValuesList.get(1);
            for (int i = 1, j = 2; i < OperationList.size() && j < ValuesList.size(); i++, j++) {
                Operacion = Operacion + "[" + OperationList.get(i) + "]" + ValuesList.get(j);
            }
            Operacion = Operacion + "]";
            return Operacion.trim();
        }
    }



}
