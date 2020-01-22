package com.mbxd.Compiler;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compiler compiler = new Compiler("source.Geng.txt");
		try {
			compiler.tokenize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
