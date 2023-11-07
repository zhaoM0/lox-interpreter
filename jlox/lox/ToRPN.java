package jlox.lox;

import jlox.lox.Expr.Visitor;
import jlox.lox.Expr.Binary;
import jlox.lox.Expr.Grouping;
import jlox.lox.Expr.Literal;
import jlox.lox.Expr.Unary;

class ToRPN implements Visitor<String> {

  String toRPN(Expr expr) {
    return expr.accept(this);
  }

  @Override
  public String visitBinaryExpr(Binary expr) {
    return OneLevelTransformRPN(expr.operator.lexeme, expr.left, expr.right);
  }

  @Override
  public String visitGroupingExpr(Grouping expr) {
    return expr.expression.accept(this);
  }

  @Override
  public String visitLiteralExpr(Literal expr) {
    return expr.value.toString();
  }

  @Override
  public String visitUnaryExpr(Unary expr) {
    StringBuilder builder = new StringBuilder();

    builder.append("(" + expr.operator.lexeme);
    builder.append(expr.right.accept(this));
    builder.append(")");

    return builder.toString();
  }

  private String OneLevelTransformRPN(String ops, Expr... exprs) {
    StringBuilder builder = new StringBuilder();
    
    for (Expr expr : exprs) {
      builder.append(expr.accept(this));
      builder.append(" ");
    }
    builder.append(ops);

    return builder.toString();
  }

  public static void main(String[] args) {
    Expr expression = new Expr.Binary(
        new Expr.Unary(
            new Token(TokenType.MINUS, "-", null, 1),
            new Expr.Literal(123)),
        new Token(TokenType.STAR, "*", null, 1),
        new Expr.Grouping(
            new Expr.Literal(45.67)));

    // Expr expr2 = new Expr.Binary(
    //   new Expr.Grouping(
    //     new Binary(
    //       new Expr.Literal(11), 
    //       new Token(TokenType.PLUS, "+", null, 1), 
    //       new Expr.Literal(211))
    //   ), 
    //   new Token(TokenType.STAR, "*", null, 1), 
    //   new Expr.Grouping(
    //     new Binary(
    //       new Expr.Literal(98), 
    //       new Token(TokenType.PLUS, "+", null, 1), 
    //       new Expr.Literal(985))
    //   )
    // );

    System.out.println(new ToRPN().toRPN(expression));
  }
}
