/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author L
 */
public class CalculatorTest {

    /**
     * @param args the command line arguments
     */
    public static CalculatorForm calculatorForm;
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Start:");
        calculatorForm = new CalculatorForm();
        calculatorForm.setVisible(true);
        try{
            divide(26, 5, 5.2);
            add(1, 2, 3);
            substract(10, 5, 5);
            multiply(4, 5, 20);
            divide(25, 0, 0);
            
        } catch (Exception ex){
            
        }
    }
    public static void add(double nymber1, double number2, double solution) throws Exception{
        //okno.setVal1(a);
        calculatorForm.getjTextFieldNumber1().setText(Double.toString(nymber1));
        calculatorForm.getjTextFieldNumber2().setText(Double.toString(number2));
        calculatorForm.getjCheckBoxAdd().doClick();
        calculatorForm.getjButtonCalculate().doClick();
        if(calculatorForm.getjTextFieldSolution().getText().equalsIgnoreCase(String.valueOf(solution))){}
        else{ 
            System.err.println("AddError: " + nymber1 + " i " + number2 + " should be: " + solution + " but is: " + calculatorForm.getjTextFieldSolution());
            throw new Exception();
        }
        Thread.sleep(2000);
    }
    
    public static void substract(double number1, double number2, double solution) throws Exception{
        calculatorForm.getjTextFieldNumber1().setText(Double.toString(number1));
        calculatorForm.getjTextFieldNumber2().setText(Double.toString(number2));
        calculatorForm.getjCheckBoxSubstract().doClick();
        calculatorForm.getjButtonCalculate().doClick();
        if(calculatorForm.getjTextFieldSolution().getText().equalsIgnoreCase(String.valueOf(solution))){}
        else{
            System.err.println("SubstractError: " + number1 + " i " + number2 + " should be: " + solution + " but is: " + calculatorForm.getjTextFieldSolution());
            throw new Exception();
        }
        Thread.sleep(2000);
    }
    
    public static void multiply(double number1, double number2, double solution) throws Exception{
        calculatorForm.getjTextFieldNumber1().setText(Double.toString(number1));
        calculatorForm.getjTextFieldNumber2().setText(Double.toString(number2));
        calculatorForm.getjCheckBoxMultiply().doClick();
        calculatorForm.getjButtonCalculate().doClick();
        
        if(calculatorForm.getjTextFieldSolution().getText().equalsIgnoreCase(String.valueOf(solution))){}
        else {
            System.err.println("MultiplyError: " + number1 + " i " + number2 + " sholud be: " + solution + " but is: " + calculatorForm.getjTextFieldSolution());
            throw new Exception();
        }
        Thread.sleep(2000);
    }
    
    public static void divide(double number1, double number2, double solution) throws Exception{
        calculatorForm.getjTextFieldNumber1().setText(String.valueOf(number1));
        calculatorForm.getjTextFieldNumber2().setText(String.valueOf(number2));
        calculatorForm.getjCheckBoxDivide().doClick();
        calculatorForm.getjButtonCalculate().doClick();
        if(calculatorForm.getjTextFieldSolution().getText().equalsIgnoreCase(String.valueOf(solution))){}
        else { 
            System.err.println("DivideError: " + number1 + " i " + number2 + " sholud be: " + solution + "but is : " + calculatorForm.getjTextFieldSolution());
            throw new Exception();
        }
        Thread.sleep(2000);
    }
    
}
