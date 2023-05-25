package leetcode;

import java.util.Scanner;

//查表法/switch-case(类似hash的思想)：数字与value的对应
//字符'0'的ASCII码是48，所以字符’1‘-’9‘减去48可以得到对应int的ASCII码，直接完成Sting2Int转换

public class Number2Roman {
    public  void number2Roman(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num;
        StringBuilder res = new StringBuilder();
        while (true){
            System.out.println("please type your number");
            num = sc.next();
            if (num.length()>9){
                System.out.println("wrong");
            }else {
                break;
            }
        }
        char[] roman = {' ','Ⅰ','Ⅱ','Ⅲ','Ⅳ','Ⅴ','Ⅵ','Ⅶ','Ⅷ','Ⅸ'};
        for (int i = 0; i < num.length(); i++) {
            if(num.charAt(i) != '0'){
                res.append(roman[num.charAt(i)-48]);
            }
        }
        System.out.println(res.toString());
    }

}
