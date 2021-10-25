package main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.logging.Logger;

public class  BracketFinder {
    public static void main(String[] args) throws Exception {

        String brackets = new String(Files.readAllBytes(Paths.get("test.txt")));
        BracketFinder.bracketsClosed(brackets);

    }


    private static final Logger logger = Logger.getLogger(BracketFinder.class.getName());

    public static boolean bracketsClosed(String bracketString){

        if(bracketString== null || bracketString.length() <= 1){
            return false;
        }

        Stack<Character> leftBrackets = new Stack<>();

        for (char current: bracketString.toCharArray()){

            if(current == '(' || current == '{' || current == '['){
                leftBrackets.push(current);
            }
            else if (current == ')' && !leftBrackets.isEmpty() && leftBrackets.peek()=='('){
                logger.info("We have a match: " + leftBrackets.peek() + current );
                leftBrackets.pop();


            }
            else if (current == '}' && !leftBrackets.isEmpty() && leftBrackets.peek()=='{'){
                logger.info("We have a match: " + leftBrackets.peek() + current );
                leftBrackets.pop();

            }
            else if (current == ']' && !leftBrackets.isEmpty() && leftBrackets.peek()=='['){
                logger.info("We have a match: " + leftBrackets.peek() + current );
                leftBrackets.pop();

            }
            else {
                logger.severe("False");
                return false;
            }
        }

        logger.severe("True");
        return true;

    }


}
