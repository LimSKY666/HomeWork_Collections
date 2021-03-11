package tasks.first;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FirstTaskSolution implements FirstTask {
    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        ArrayList<Vertex> vertexArrayList = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            vertexArrayList.add(new Vertex(i));
        }
        ArrayDeque<Vertex> queue = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        queue.addLast(vertexArrayList.get(startIndex));
        queue.getFirst().setVisited(true);
        while (!queue.isEmpty()) {
            int thisVertexIndex = queue.removeFirst().getNumber();
            result.append(thisVertexIndex).append(", ");
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[thisVertexIndex][j]) {
                    Vertex neighbour = vertexArrayList.get(j);
                    if (!neighbour.isVisited()) {
                        queue.addLast(neighbour);
                        neighbour.setVisited(true);
                    }
                }
            }
        }
        return result.toString();
    }

    @Override
    public Boolean validateBrackets(String s) {
        if (s == null)
            throw new IllegalArgumentException("Invalid argument");
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String openBrackets = "([{";
        String closedBrackets = ")]}";
        for (Character c : s.toCharArray()) {
            if (openBrackets.indexOf(c) != -1) {
                stack.addLast(c);
            }
            if (closedBrackets.indexOf(c) != -1) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (closedBrackets.indexOf(c) == openBrackets.indexOf(stack.getLast())) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Override
    public Long polishCalculation(String s) {
        ArrayDeque<Long> stack = new ArrayDeque<>();
        String[] elements = s.split(" ");
        boolean flag;

        long number1, number2, parsNumber;
        long result = 0;
        for (String element : elements) {
            flag = true;
            if (element.length() == 1) {
                flag = false;
                switch (element.charAt(0)) {
                    case '+': {
                        number1 = stack.removeLast();
                        number2 = stack.removeLast();
                        result = number1 + number2;
                        stack.addLast(result);
                        break;
                    }
                    case '-': {
                        number1 = stack.removeLast();
                        number2 = stack.removeLast();
                        result = number1 - number2;
                        stack.addLast(result);
                        break;
                    }
                    case '*': {
                        number1 = stack.removeLast();
                        number2 = stack.removeLast();
                        result = number1 * number2;
                        stack.addLast(result);
                        break;
                    }
                    case '/': {
                        number1 = stack.removeLast();
                        number2 = stack.removeLast();
                        result = number1 / number2;
                        stack.addLast(result);
                        break;
                    }
                    default:
                        flag = true;
                        break;
                }
            }
            if (flag) {
                parsNumber = Long.parseLong(element);
                stack.addLast(parsNumber);
            }
        }
        return result;
    }
}