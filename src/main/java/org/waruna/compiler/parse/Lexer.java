package org.waruna.compiler.parse;

import org.waruna.compiler.model.Token;
import java.util.List;
import java.util.ArrayList;

public class Lexer {
    public List<Token> tokenize(String expression){
        List<Token> tokens = new ArrayList<>();
        for (char c : expression.toCharArray()){
            if (Character.isDigit(c)){
                tokens.add(new Token("NUMBER", String.valueOf(c)));
            }else if(c=='+' || c=='-' || c=='*' || c=='/'){
                tokens.add(new Token("OPERATOR", String.valueOf(c)));

            } else {
                throw new RuntimeException("Unknown character: " + c);
            }
           
        
        }
        return tokens;
    }
    


}
