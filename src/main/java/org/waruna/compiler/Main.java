package org.waruna.compiler;

import java.util.List;

import org.waruna.compiler.parse.Lexer;
import org.waruna.compiler.model.Token;

public class Main {

    public static void main(String[] args) throws Exception {
        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.tokenize(args[0]);
        for (Token token : tokens){
            System.out.println(token.type + " : " + token.value);
        }
        System.out.println("This is simple arithmetic compiler");
    }
}
