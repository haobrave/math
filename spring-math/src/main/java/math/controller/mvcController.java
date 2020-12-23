package math.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@Slf4j
public class mvcController {

    private static int total = 0;

    @RequestMapping(value="/")
    public Object index(){
        return "index.html";
    }

    @RequestMapping(value="/math")
    public Object math(@RequestParam(value = "num", defaultValue = "50") int num,  Model model){
        total++;
        log.info("总计访问次数：" + total);
        if (num < 1){
            model.addAttribute("result", "");
            model.addAttribute("msg",  "班级: ________  姓名: ________  学号: ________");
            return "math";
        }
        ArrayList<String> list = pro(num);
        String result = "";
        for (int i =0; i< list.size(); i++){
            if(i%4 == 0){
                result = result + "\r\n";
            }
            result = result + list.get(i);
        }

        model.addAttribute("result", result);

        model.addAttribute("msg",  "班级: ________  姓名: ________  学号: ________");
        return "math";
    }


    private ArrayList<String> pro(int num){
        int[] indivs = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        char[] signs = {'+', '-'};


        int count = num;
        ArrayList<String> list = new ArrayList<String>();
        while(true){
            if(count <= 0){
                break;
            }
            long firstSign = Math.round(Math.floor(indivs.length * Math.random()));
            int first = indivs[(int)firstSign];

            long secondSign = Math.round(Math.floor(indivs.length * Math.random()));
            int second = indivs[(int)secondSign];

            long signChar = Math.round(Math.floor(signs.length * Math.random()));
            char sign = signs[(int)signChar];

            //String exam = first + " " + sign + " " + second + " " + "=    ";
            if (sign == '+'){
                int result =  first + second;
                if(result >= 20){
                    continue;
                }
                String exam = "" +  rightAddSpace(first) + sign + leftAddSpace(second) + " =        ";
                list.add(exam);
                count--;
            } else if(sign == '-'){
                int result =  first - second;
                if(result < 0){
                    continue;
                }
                String exam = "" +  rightAddSpace(first) + sign + leftAddSpace(second) + " =        ";
                list.add(exam);
                count--;
            }else {
                break;
            }
        }
        return list;
    }

    private String rightAddSpace(int a){

        String b = String.valueOf(a);
        int count= b.length();
        for(int i = 0; i < 4 - count; i++ ){
            b = b + " ";
        }
        return b;
    }

    private String leftAddSpace(int a){

        String b = String.valueOf(a);
        int count= b.length();
        for(int i = 0; i < 4 - count; i++ ){
            b =  " " + b;
        }
        return b;
    }

}
