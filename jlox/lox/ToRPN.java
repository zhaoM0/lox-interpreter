package jlox.lox;

import jlox.lox.Expr.Visitor;
import jlox.lox.Expr.Binary;
import jlox.lox.Expr.Grouping;
import jlox.lox.Expr.Literal;
import jlox.lox.Expr.Unary;

class ToRPN implements Visitor<String> {

  @Override
  public String visitBinaryExpr(Binary expr) {

  }

  @Override
  public String visitGroupingExpr(Grouping expr) {

  }

  @Override
  public String visitLiteralExpr(Literal expr) {

  }

  @Override
  public String visitUnaryExpr(Unary expr) {

  }
}
