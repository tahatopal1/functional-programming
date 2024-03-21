package com.project.functional.u8_functionalprogrammingindepth.s46_decomposition;

public class DecompositionDemo {

    // Decomposition is chaining the functions in the reverse order

    public static void main(String[] args) {

        // We'll find the length of one edge by using area

        IFunction<Square, Integer> getArea = Square::getArea;
        IFunction<Integer, Double> getEdgeLength = Math::sqrt;

        Square square = new Square(400);

        // Without composing
        Integer area = getArea.apply(square);
        Double edgeLength = getEdgeLength.apply(area);
        System.out.println("Edge length: " + edgeLength);

        // With composing
        IFunction<Square, Double> calculateEdgeLength = getEdgeLength.compose(getArea);
        calculateEdgeLength.apply(square);
        System.out.println("Edge length: " + edgeLength);
    }
}
