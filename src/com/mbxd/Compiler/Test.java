package com.mbxd.Compiler;

import java.util.EmptyStackException;
import java.util.Scanner;

import com.mbxd.Compiler.Exceptions.EvaluationException;
import com.mbxd.Compiler.Exceptions.ParserException;
import com.mbxd.Compiler.Nodes.ExpressionNode;
import com.mbxd.Compiler.Nodes.SetVariable;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tokenizer tokenizer = new Tokenizer();
		tokenizer.add("\\+|-", 1);
		tokenizer.add("\\*|/", 2);
		tokenizer.add("\\^", 3);
		tokenizer.add("sin|cos|exp|ln|sqrt", 4);
		tokenizer.add("\\(", 5);
		tokenizer.add("\\)", 6);
		tokenizer.add("[0-9]+", 7);
		tokenizer.add("let|const|var", 8);
		tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", 9);
		tokenizer.add("\\:", 10);
		tokenizer.add("\\$", 11);
//    try
//    {
//      
//    	String sourceCode = new String(Files.readAllBytes(Paths.get("source.Geng.txt")));
//      tokenizer.tokenize(sourceCode);
//      for (Tokenizer.Token tok : tokenizer.getTokens())
//      {
//        System.out.println("" + tok.token + " " + tok.sequence);
//      }
//    }
//    catch (ParserException e)
//    {
//      System.out.println(e.getMessage());
//    } 
//    catch (IOException e) 
//    {
//		e.printStackTrace();
//	}

		String input = null;

		try (Scanner sn = new Scanner(System.in);) {
			do {
				try {
					RpnParser parser = new RpnParser();
					System.out.println("Ingrese una expresion a evaluar");
					input = sn.nextLine();
					tokenizer.tokenize(input);
					if (!input.equals("exit")) {
						//ExpressionNode expression = parser.parse(tokenizer.getTokens());
						//expression.accept(new SetVariable("pi", Math.PI));
						//expression.accept(new SetVariable("e", Math.E));
						//System.out.println("El valor de la expresion es " + expression.getValue());
						String[] output = parser.infixToRPN(tokenizer.getTokens());
				         
				         for (String token : output) {
				            System.out.print(token + " ");
				        }
				        System.out.println(""); 
				        Double result = parser.RPNtoDouble( output ); 
				        System.out.println(result);
					}
				} catch (ParserException e) {
					System.out.println(e.getMessage());
				} catch (EvaluationException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Ocurrio un error: " + e.getMessage());
				}

			} while (!input.equals("exit"));
		}
	}
}
