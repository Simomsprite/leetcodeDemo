/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PolandNotation
 * Author:   王小手
 * Date:     2019/6/30 16:19
 * Description: 逆波兰表达式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sh.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 〈一句话功能简述〉<br> 
 * 〈逆波兰表达式〉
 *
 * @author wxs
 * @create 2019/6/30
 * @since 1.0.0
 */
public class PolandNotation  {
    public static void main(String[] args) {
//        String suffixExpression="3 4 + 5 * 6 -";
//        List<String> rpanList=getListString(suffixExpression);
//        System.out.println("rpanList="+rpanList );
//
//        int res=calculate(rpanList);
//        System.out.println("计算的结果是="+res);

        String expression="1+((2+3)*4)-5";
        List<String> acfun= toInfixExpressionList(expression);
//        System.out.println(toInfixExpressionList(expression));
        System.out.println("后缀表达式="+parseSuffixExpresionList(acfun));
        System.out.println("计算结果是："+calculate(parseSuffixExpresionList(acfun)));
    }

    public static List<String> parseSuffixExpresionList(List<String> ls){
        Stack<String> s1=new Stack<>();
        List<String> s2=new ArrayList<>();
        for(String item:ls){
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else{
                while(s1.size()!=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while(s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

    public static List<String> toInfixExpressionList(String s){
        List<String> ls=new ArrayList<>();
        int i=0;
        String str;
        char c;
        do{
            if((c=s.charAt(i))<48 || (c=s.charAt(i))>57){
                ls.add(""+c);
                i++;
            }else{
                str="";
                while(i<s.length()&&(c=s.charAt(i))>=48 && (c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while(i<s.length());
        return ls;
    }

    public static List<String> getListString(String suffixExpression) {
        String[] spilt = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : spilt) {
            list.add(ele);
        }
        return list;
    }

    public static  int calculate(List<String> ls){
        Stack<String> stack =new Stack<>();
        for(String item:ls){
            if(item.matches("\\d+")){
               stack.push(item);
            }else{
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if(item.equals("/")){
                    res=num1/num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}

//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

}