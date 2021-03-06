package com.mbxd.Compiler;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mbxd.Compiler.Exceptions.ParserException;

public class Tokenizer
{
  private class TokenInfo
  {
    public final Pattern regex;
    public final int token;

    public TokenInfo(Pattern regex, int token)
    {
      super();
      this.regex = regex;
      this.token = token;
    }
  }
  

  private LinkedList<TokenInfo> tokenInfos;
  private LinkedList<Token> tokens;
  
  public Tokenizer()
  {
    tokenInfos = new LinkedList<TokenInfo>();
    tokens = new LinkedList<Token>();
  }
  
  public void add(String regex, int token)
  {
    tokenInfos.add(new TokenInfo(Pattern.compile("^("+regex+")"), token));
  }
  
  public void tokenize(String str)
  {
    String s = str.trim();
    tokens.clear();
    while (!s.equals(""))
    {
      boolean match = false;
      for (TokenInfo info : tokenInfos)
      {
        Matcher m = info.regex.matcher(s);
        if (m.find())
        {
          match = true;
          String tok = m.group().trim();
          s = m.replaceFirst("").trim();
          tokens.add(new Token(info.token, tok));
          break;
        }
      }
      if (!match) throw new ParserException("Unexpected character in input: "+s);
    }
  }
  
  public LinkedList<Token> getTokens()
  {
    return tokens;
  }
  
}
