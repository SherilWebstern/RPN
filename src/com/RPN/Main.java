package com.RPN;


import java.util.*;
import  java.util.Stack;
class Main {
    public static void main(String[] args)
    {
        System.out.println("RPN with a stack");
        Stack<String> stack = new Stack<String>();
        Scanner c = new Scanner(System.in);


        System.out.println("Enter RPN");
        String input = c.nextLine();



        String[] list = input.split(" ");
        //System.out.println(Arrays.toString(list));
        String[] punkt = {"+", "-", "*", "/"};

        int i2 = 0;
        for (int i=0; i< list.length; i++)
        {
            if (!list[i].equals(punkt[0]) && !list[i].equals(punkt[1])  && !list[i].equals(punkt[2]) && !list[i].equals(punkt[3]))
            {
                stack.push(String.valueOf(list[i]));
            }
            else
            {
                i2=i;
                break;
            }

        }
        String result = "";
        String k = "";

        //System.out.println(Arrays.toString(stack.toArray()));
        while (i2 < list.length)
        {
            // System.out.println(Arrays.toString(stack.toArray()));
            String  operand1 = stack.pop() ;
            String operand2 = stack.pop() ;
            if ( list[i2].equals("+"))
            {
                int newV = Integer.parseInt(operand1)  + Integer.parseInt(operand2);
                result = k+newV;
                stack.push(result);
            }
            else if (list[i2].equals("-"))
            {
                int newV = Integer.parseInt(operand1)  - Integer.parseInt(operand2);
                result = k+newV;
                stack.push(result);
            }
            else if (list[i2].equals("*"))
            {
                int newV = Integer.parseInt(operand1)  * Integer.parseInt(operand2);
                result = k+newV;
                stack.push(result);

            }
            else if (list[i2].equals("/"))
            {
                int newV = Integer.parseInt(operand1)  / Integer.parseInt(operand2);
                result = k+newV;
                stack.push(result);

            }
            i2+=1;
        }


        result = stack.pop();
        System.out.print("The result is: "+ result);
        //10 6 9 3 + -11 * / * 17 + 5 +
    }
}