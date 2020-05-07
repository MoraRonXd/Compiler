package com.mbxd.Compiler.Nodes;

public class ConstantExpressionNode implements ExpressionNode {
	
	 private double value;

	 public ConstantExpressionNode(double value) {
	   this.value = value;
	 }

	 public ConstantExpressionNode(String value) {
	   this.value = Double.valueOf(value);
	 }


	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return ExpressionNode.CONSTANT_NODE;
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void accept(ExpressionNodeVisitor visitor) {
		visitor.visit(this);
	}

}
