package com.RPN;




import java.util.*;
import  java.util.Stack;
import java.util.Arrays;
class Main {
    public static void main(String[] args)
    {
        System.out.println("RPN with a stack");
        Stack<String> stack = new Stack< >();
        Scanner c = new Scanner(System.in);


        System.out.println("Enter operands and operant with spaces in between");
        String input = c.nextLine();


        String result;
        String k = "";
        String[] list = input.split(" ");
        //System.out.println(Arrays.toString(list));
        String[] punkt = {"+", "-", "*", "/"};
        ArrayList<String> peeking = new ArrayList< >();
        System.out.println(Arrays.toString(list));
        int i=0;

        while ( i< list.length)
        {
            if (!list[i].equals(punkt[0]) && !list[i].equals(punkt[1])  && !list[i].equals(punkt[2]) && !list[i].equals(punkt[3]))
            {
                stack.push(String.valueOf(list[i]));
                System.out.println(Arrays.toString(stack.toArray()));
            }
            else
            {
                peeking.add(list[i]);
                for(int j = 0 ; j< peeking.size(); j++)
                {

                    // System.out.println(Arrays.toString(stack.toArray()));
                    String  operand1 = stack.pop() ;
                    String operand2 = stack.pop() ;
                    System.out.print(operand1 + "    " + operand2 + "\n");
                    if ( peeking.get(j).equals("+"))
                    {
                        int newV = Integer.parseInt(operand1)  + Integer.parseInt(operand2);
                        result = k+newV;
                        stack.push(result);
                    }
                    else if (peeking.get(j).equals("-"))
                    {
                        int newV = Integer.parseInt(operand1)  - Integer.parseInt(operand2);
                        result = k+newV;
                        stack.push(result);
                    }
                    else if (peeking.get(j).equals("*"))
                    {
                        int newV = Integer.parseInt(operand1)  * Integer.parseInt(operand2);
                        result = k+newV;
                        stack.push(result);

                    }
                    else if (peeking.get(j).equals("/"))
                    {
                        if( Integer.parseInt(operand1) == 0)
                        {
                            System.out.println("Error");
                            break;
                        }
                        int newV = Integer.parseInt(operand1)  / Integer.parseInt(operand2);
                        result = k+newV;
                        stack.push(result);


                    }
                    System.out.println(Arrays.toString(stack.toArray()));
                    peeking.remove(peeking.size()-1);
                }


            }
            i+=1;

        }


        //System.out.println(Arrays.toString(stack.toArray()));

        //result = stack.pop();
        Object[] vals = stack.toArray();
        System.out.print("The result is: ");
        for (Object obj : vals) {
            System.out.print(obj + " ");
        }
        //10 6 9 3 + -11 * / * 17 + 5 +
    }



}