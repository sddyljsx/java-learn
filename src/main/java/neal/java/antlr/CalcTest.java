package neal.java.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


//antlr4 -no-listener -visitor Calc.g4
//javac *.java
//java Calc 或 java Calc calc.txt
//grun Calc prog -gui calc.txt #可看生成树
public class CalcTest {

    public static void main(String[] args) {

        String expr = "(2+2)*3+1*3";
        //对每一个输入的字符串，构造一个 ANTLRStringStream 流 in
        ANTLRInputStream in = new ANTLRInputStream(expr);
        CalcLexer lexer = new CalcLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        ParseTree tree = parser.prog();
        EvalVisitor eval = new EvalVisitor();
        System.out.println(eval.visit(tree));
        System.out.println(tree.toStringTree(parser));

        System.out.println(eval instanceof CalcVisitor);

    }
}
