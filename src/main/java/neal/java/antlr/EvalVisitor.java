package neal.java.antlr;

import com.sun.org.apache.regexp.internal.RE;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends CalcBaseVisitor<Double> {

    Map<String, Double> memory = new HashMap<>();

    //id = expr
    @Override
    public Double visitAssign(CalcParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Double value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    // expr
    @Override
    public Double visitPrintExpr(CalcParser.PrintExprContext ctx) {
        System.out.println("visitor expr");
        Double value = visit(ctx.expr());
        //保留两位有数字的方法
        DecimalFormat df = new DecimalFormat("#.##");
        String s_value = df.format(value);
        System.out.println(s_value);
        return 0.0;
    }

    // print
    @Override
    public Double visitPrint(CalcParser.PrintContext ctx) {
        String id = ctx.ID().getText();
        Double value = memory.getOrDefault(id, 0.0);
        //保留两位有数字的方法
        DecimalFormat df = new DecimalFormat("#.##");
        String s_value = df.format(value);
        System.out.println(s_value);
        return value;
    }

    @Override
    public Double visitProg(CalcParser.ProgContext ctx) {
        System.out.println("visitor prog");
        //return super.visit(ctx.stat().get(0));
        return super.visitProg(ctx);
    }

    //Number
    @Override
    public Double visitNumber(CalcParser.NumberContext ctx) {
        System.out.println("visitor number");

        int size = ctx.getChildCount();
        if (size == 2) {
            if (ctx.sign.getType() == CalcParser.SUB) {
                return -1 * Double.valueOf(ctx.getChild(1).getText());
            } else {
                return Double.valueOf(ctx.getChild(1).getText());
            }
        } else {
            return Double.valueOf(ctx.getChild(0).getText());
        }
    }

    @Override
    public Double visitParens(CalcParser.ParensContext ctx) {
        System.out.println("visitor parens");
        return visit(ctx.expr());

    }

    //expr op=('*'|'/') expr
    @Override
    public Double visitMulDiv(CalcParser.MulDivContext ctx) {
        System.out.println("visitor multi div");

        Double left = visit(ctx.expr().get(0));
        Double right = visit(ctx.expr().get(1));
        if (ctx.op.getType() == CalcParser.MUL) {
            return left * right;
        } else if (ctx.op.getType() == CalcParser.SUB) {
            if (right == 0 || right == 0.0) {
                return 0.0;
            }
            return left / right;
        }

        return 0.0;

    }

    @Override
    public Double visitAddSub(CalcParser.AddSubContext ctx) {
        System.out.println("visitor add sub");

        Double left = visit(ctx.expr().get(0));
        Double right = visit(ctx.expr().get(1));
        if (ctx.op.getType() == CalcParser.ADD) {
            return left + right;
        } else if (ctx.op.getType() == CalcParser.SUB) {
            return left - right;
        }
        return 0.0;
    }

    // ID
    @Override
    public Double visitId(CalcParser.IdContext ctx) {
        String id = ctx.ID().getText();
        return memory.getOrDefault(id, 0.0);
    }

    @Override
    public Double visitPower(CalcParser.PowerContext ctx) {
        Double left = visit(ctx.expr().get(0));
        Double right = visit(ctx.expr().get(1));
        if (left == 0 || left == 0.0) {
            return 0.0;
        }
        return Math.pow(left, right);
    }
}
