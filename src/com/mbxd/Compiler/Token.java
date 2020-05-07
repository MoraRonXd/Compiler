package com.mbxd.Compiler;

public class Token {
	
	public static final int EPSILON = 0;
	public static final int PLUSMINUS = 1;
	public static final int MULTDIV = 2;
	public static final int RAISED = 3;
	public static final int FUNCTION = 4;
	public static final int OPEN_BRACKET = 5;
	public static final int CLOSE_BRACKET = 6;
	public static final int NUMBER = 7;
	public static final int DECLARATIONWRD = 8;
	public static final int VARIABLE = 9;
	public static final int ASSIGN = 10;
	public static final int EOL = 11;

	public final int token;
	public final String sequence;
	
	public Token(int token, String sequence) {
		super();
		this.token = token;
		this.sequence = sequence;
	}

}
