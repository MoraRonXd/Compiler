package com.mbxd.Compiler;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Compiler {
	File file;
	String source;
	boolean isString;
	public static final int WHITESPACE_ASCII = 10;

	public Compiler(File file) {
		this.file = file;
	}

	public Compiler(String file) {
		this.file = new File(file);
	}
	
	public Compiler(String source, boolean isString) {
		this.source = source;
		this.isString=isString;
	}

	public void tokenize() throws IOException {
		BufferedReader br;
		if (this.isString) {
			br = new BufferedReader(new StringReader(this.source));
		} else {
			br = new BufferedReader(new FileReader(this.file));
		}
		StreamTokenizer tokenizer = new StreamTokenizer(br);
		tokenizer.eolIsSignificant(true);
		int t;
		String tokensOutput = "";
		while ((t = tokenizer.nextToken()) != StreamTokenizer.TT_EOF) {
			switch (t) {
			case StreamTokenizer.TT_NUMBER:
				tokensOutput += "Number: " + tokenizer.nval;
				break;
			case StreamTokenizer.TT_WORD:
				tokensOutput += "Word: " + tokenizer.sval;
				break;
			case Compiler.WHITESPACE_ASCII:
				break;
			default:
				tokensOutput += "Character: " + Character.toString((char) t);
				break;
			}
			if (t == Compiler.WHITESPACE_ASCII) continue;
			tokensOutput += "\n";
		}
		try (FileWriter writer = new FileWriter("tokens.txt")) {
			writer.write(tokensOutput);
		}
		System.out.println(tokensOutput);
		

	}

}
