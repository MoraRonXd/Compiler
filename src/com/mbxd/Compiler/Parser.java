package com.mbxd.Compiler;

import java.util.LinkedList;

import com.mbxd.Compiler.Exceptions.ParserException;
import com.mbxd.Compiler.Nodes.*;

public class Parser {
	LinkedList<Token> tokens;
	Token lookahead;

	@SuppressWarnings("unchecked")
	public ExpressionNode parse(LinkedList<Token> tokens) {
		this.tokens = (LinkedList<Token>) tokens.clone();
		this.lookahead = this.tokens.getFirst();
		
		ExpressionNode expr = expression();
		
		if (lookahead.token != Token.EPSILON) {
			throw new ParserException(String.format("Simbolo no esperado %s encontrado", lookahead.sequence));
		}
		
		return expr;
	}

	private void nextToken() {
		tokens.pop();
		System.out.println(lookahead.sequence);
		if (tokens.isEmpty())
			lookahead = new Token(Token.EPSILON, "");
		else
			lookahead = tokens.getFirst();
	}

	private ExpressionNode expression() {
		ExpressionNode expr = signedTerm();
		return sumOp(expr);
	}

	private ExpressionNode sumOp(ExpressionNode expression) {
		if (lookahead.token == Token.PLUSMINUS) {
			AdditionExpressionNode sum;
			if (expression.getType() == ExpressionNode.ADDITION_NODE) {
				sum = (AdditionExpressionNode) expression;
			} else {
				sum = new AdditionExpressionNode(expression, true);
			}
			boolean positive = lookahead.sequence.equals("+");
			nextToken();
			
			ExpressionNode t = term();
			sum.add(t, positive);
			
			return sumOp(sum);
		} 
		return expression;
	}

	private ExpressionNode signedTerm() {
		if (lookahead.token == Token.PLUSMINUS) {
			boolean positive = lookahead.sequence.equals("+");
			nextToken();
			ExpressionNode t = term();
			if (positive) {
				return t;
			} else {
				return new AdditionExpressionNode(t, false);
			}
		}
		return term();
	}

	private ExpressionNode term() {
		ExpressionNode f = factor();
		return termOp(f);
	}

	private ExpressionNode termOp(ExpressionNode expression) {
		if (lookahead.token == Token.MULTDIV) {
			MultiplicationExpressionNode prod;

			if (expression.getType() == ExpressionNode.MULTIPLICATION_NODE) {
				prod = (MultiplicationExpressionNode) expression;
			} else {
				prod = new MultiplicationExpressionNode(expression, true);
			}
			boolean positive = lookahead.sequence.equals("*");

			nextToken();
			ExpressionNode f = signedFactor();
			prod.add(f, positive);
			return termOp(prod);
		}
		return expression;
	}

	private ExpressionNode signedFactor() {
		if (lookahead.token == Token.PLUSMINUS) {
			boolean positive = lookahead.sequence.equals("+");
			nextToken();
			ExpressionNode t = factor();

			if (positive) {
				return t;
			} else {
				return new AdditionExpressionNode(t, false);
			}
		}
		return factor();
	}

	private ExpressionNode factor() {

		ExpressionNode expr = argument();
		return factorOp(expr);
	}

	private ExpressionNode factorOp(ExpressionNode expression) {
		if (lookahead.token == Token.RAISED) {
			nextToken();
			ExpressionNode exponent = signedFactor();
			return new ExponentiationExpressionNode(expression, exponent);
		}
		return expression;
	}

	private ExpressionNode argument() {
		if (lookahead.token == Token.FUNCTION) {
			int function = FunctionExpressionNode.stringToFunction(lookahead.sequence);
			nextToken();
			ExpressionNode expr = argument();
			return new FunctionExpressionNode(function, expr);
		} else if (lookahead.token == Token.OPEN_BRACKET) {
			nextToken();
			ExpressionNode expr = expression();
			if (lookahead.token != Token.CLOSE_BRACKET)
				throw new ParserException(
						"Parentesis cerrante esperado y se encontró " + lookahead.sequence + " en su lugar.");

			nextToken();
			return expr;
		}

		return value();
	}

	private ExpressionNode value() {

		if (lookahead.token == Token.NUMBER) {
			ExpressionNode expr = new ConstantExpressionNode(lookahead.sequence);
			nextToken();
			return expr;
		}

		if (lookahead.token == Token.VARIABLE) {
			ExpressionNode expr = new VariableExpressionNode(lookahead.sequence);
			nextToken();
			return expr;
		}
		if (lookahead.token == Token.DECLARATIONWRD) {
			nextToken();
			if (lookahead.token == Token.VARIABLE) {
				String varName = lookahead.sequence;
				nextToken();
				if (lookahead.token == Token.ASSIGN) {
					nextToken();
					ExpressionNode value = value();
					value.accept(new SetVariable(varName, value.getValue()));
					return value;
				} else {
					throw new ParserException("Syntax error");
				}
			} else{
				throw new ParserException("Syntax error");
			}
		}
		
		if (lookahead.token == Token.EOL) {
			nextToken();
			return expression();
		}
		
		if (lookahead.token == Token.EPSILON)
			throw new ParserException("Fin de entrada inesperado.");
		else
			throw new ParserException(String.format("Simbolo inesperado %s encontrado", lookahead.sequence));
	}
}
