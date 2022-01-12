package app.service;

import app.reponsitory.ICalculatorReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorSerciceImpl implements  ICalculatorService {

    @Autowired
    ICalculatorReponsitory iCalculatorReponsitory;
    @Override
    public String calculate(String num1, String num2, String operator) {
        return iCalculatorReponsitory.calculate(num1,num2,operator);
    }
}
