package com.mbxd.Compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RpnParser {

	private static final int LEFT_ASSOC  = 0;
    private static final int RIGHT_ASSOC = 1;
  
    private static final Map<String, int[]> OPERATORS = new HashMap<String, int[]>();
    static
    {
        OPERATORS.put("+", new int[] { 0, LEFT_ASSOC });
        OPERATORS.put("-", new int[] { 0, LEFT_ASSOC });
        OPERATORS.put("*", new int[] { 5, LEFT_ASSOC });
        OPERATORS.put("/", new int[] { 5, LEFT_ASSOC });        
    }
  
    private static boolean isOperator(String token) 
    {
        return OPERATORS.containsKey(token);
    }
  
    private static boolean isAssociative(String token, int type) 
    {
        if (!isOperator(token)) 
        {
            throw new IllegalArgumentException("Invalid token: " + token);
        }
         
        if (OPERATORS.get(token)[1] == type) {
            return true;
        }
        return false;
    }
    
    private static final int cmpPrecedence(String token1, String token2) 
    {
        if (!isOperator(token1) || !isOperator(token2)) 
        {
            throw new IllegalArgumentException("Invalid tokens: " + token1
                    + " " + token2);
        }
        return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
    }
  
    public static String[] infixToRPN(List<Token> inputTokens) 
    {
        ArrayList<String> out = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
         
        // For each token
        for (Token token : inputTokens) 
        {
            // If token is an operator
            if (isOperator(token.sequence)) 
            {  
                // While stack not empty AND stack top element 
                // is an operator
                while (!stack.empty() && isOperator(stack.peek())) 
                {                    
                    if ((isAssociative(token.sequence, LEFT_ASSOC)         && 
                         cmpPrecedence(token.sequence, stack.peek()) <= 0) || 
                        (isAssociative(token.sequence, RIGHT_ASSOC)        && 
                         cmpPrecedence(token.sequence, stack.peek()) < 0)) 
                    {
                        out.add(stack.pop());   
                        continue;
                    }
                    break;
                }
                stack.push(token.sequence);
            } 
            else if (token.sequence.equals("(")) 
            {
                stack.push(token.sequence);  // 
            } 
            else if (token.sequence.equals(")")) 
            {                
                while (!stack.empty() && !stack.peek().equals("(")) 
                {
                    out.add(stack.pop()); 
                }
                stack.pop(); 
            } 
            else
            {
                out.add(token.sequence); 
            }
        }
        while (!stack.empty())
        {
            out.add(stack.pop()); 
        }
        String[] output = new String[out.size()];
        return out.toArray(output);
    }
     
    public static double RPNtoDouble(String[] tokens)
    {        
        Stack<String> stack = new Stack<String>();
         
        for (String token : tokens) 
        {
            if (!isOperator(token)) 
            {
                stack.push(token);                
            }
            else
            {
                Double d2 = Double.valueOf( stack.pop() );
                Double d1 = Double.valueOf( stack.pop() );
                 
                Double result = token.compareTo("+") == 0 ? d1 + d2 : 
                                token.compareTo("-") == 0 ? d1 - d2 :
                                token.compareTo("*") == 0 ? d1 * d2 :
                                                            d1 / d2;               
                                 
                stack.push( String.valueOf( result ));                                                
            }                        
        }        
         
        return Double.valueOf(stack.pop());
    }
  
}
