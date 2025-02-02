package org.waruna.compiler.parse;
import org.waruna.compiler.model.Node;
import org.waruna.compiler.model.Token;
import java.util.List;
import java.util.Stack;

public class Parser {

    public Node parse(List<Token> tokens) {
        
        
        Stack<Node> values = new Stack<>();
        Stack<Token> operators = new Stack<>();
        for (Token token : tokens) {
            if (token.type.equals("NUMBER")) {
                values.push(new Node(token.value, null, null));
            } else {
                while (!operators.isEmpty() && precedence(operators.peek().value) >= precedence(token.value)) {
                    addNode(values, operators);
                }
                operators.push(token);
            }
        }
        while (!operators.isEmpty()) {
            addNode(values, operators);
        }
        return values.pop();
    }
    
    private int precedence(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } 
        return 2;
    }
    private void addNode(Stack<Node> values, Stack<Token> operators) {
        Node right = values.pop();
        Node left = values.pop();
        Token operator = operators.pop();
        values.push(new Node(operator.value, left, right));
        
    }
}
