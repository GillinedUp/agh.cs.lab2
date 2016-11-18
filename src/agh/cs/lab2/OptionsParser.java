package agh.cs.lab2;

/**
 * Created by yurii on 10/28/16.
 */
public class OptionsParser {
    public MoveDirection[] parse(String[] inString) {
        MoveDirection[] directions = new MoveDirection[inString.length];
        for (int i = 0; i < inString.length; i++) {
            if (inString[i].equals("f") || inString[i].equals("forward")) {
                directions[i] = MoveDirection.Forward;
            } else if (inString[i].equals("b") || inString[i].equals("backward")) {
                directions[i] = MoveDirection.Backward;
            } else if (inString[i].equals("r") || inString[i].equals("right")) {
                directions[i] = MoveDirection.Right;
            } else if (inString[i].equals("l") || inString[i].equals("left")) {
                directions[i] = MoveDirection.Left;
            } else throw new IllegalArgumentException(directions[i] + " is not legal move specification");
        }
        return directions;
    }
}