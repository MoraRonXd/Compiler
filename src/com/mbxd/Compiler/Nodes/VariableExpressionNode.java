package com.mbxd.Compiler.Nodes;

import com.mbxd.Compiler.Exceptions.EvaluationException;

public class VariableExpressionNode implements ExpressionNode {
	  private String name;
	  private double value;
	  private boolean valueSet;

	  public VariableExpressionNode(String name) {
	    this.name = name;
	    valueSet = false;
	  }

	  public int getType() {
	    return ExpressionNode.VARIABLE_NODE;
	  }

	  public void setValue(double value) {
	    this.value = value;
	    this.valueSet = true;
	  }
	  
	  public String getName() {
		  return this.name;
	  }

	  public double getValue() {
	    if (valueSet)
	      return value;
	    else
	      throw new EvaluationException("Variable '" 
	        + name + "' was not initialized.");
	  }

	@Override
	public void accept(ExpressionNodeVisitor visitor) {
		visitor.visit(this);
	}
}