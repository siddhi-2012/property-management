package com.project.property.management.controller;

import com.project.property.management.dto.CalculatorDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") // class level mapping of url to controller class
public class CalculatorController {

    //http://localhost:8080/api/v1/calculator/add?num1=6.7&num2=1.3
    @GetMapping("/add") //method level mapping of url to controller function
        public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){
            return num1+num2;
        }

      @GetMapping("/sub/{num1}/{num2}") // map the values of url to java variables by path variable method
        public Double subtract(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){

             Double result = null;
             if(num1>num2){
                 result = num1-num2;
             }
             else{
                 result =num2-num1;
             }
             return result;

      }

      @PostMapping("/mul")
      public Double multiply(@RequestBody CalculatorDTO calculatorDTO){

        //Double result =null;
        //result=calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        return null;
      }
}
