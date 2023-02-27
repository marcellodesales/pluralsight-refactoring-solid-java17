import org.junit.jupiter.api.Test;

import java.util.Map;

public class PointInsideAreasCalculatorTests {

    public static void assertResults(Map<Shape, Boolean> shapesExpectedResults,  Map<Shape, Boolean> shapesInput) {
        for (Map.Entry<Shape,Boolean> entry : shapesInput.entrySet()) {
            assert shapesExpectedResults.get(entry.getKey()).equals(entry.getValue());
        }
    }

    @Test
    public void calculateMethodShouldReturnTrueIfPointInCircle() {
        Map<Shape, Boolean> shapesExpectedResults = Map.of(
                new Circle(0,0,10), true
        );
        var calc = new PointInsideAreasCalculator();

        var results = calc.isPointInsideAreas(2,2, shapesExpectedResults.keySet());
        assertResults(shapesExpectedResults, results);
    }

    @Test
    public void calculateMethodShouldReturnFalseIfPointOutsideCircle() {
        Map<Shape, Boolean> shapesExpectedResults = Map.of(
                new Circle(0,0,10), false
        );
        var calc = new PointInsideAreasCalculator();

        var results = calc.isPointInsideAreas(11,11, shapesExpectedResults.keySet());
        assertResults(shapesExpectedResults, results);
    }

    @Test
    public void calculateMethodShouldReturnTrueIfPointInRectangle() {
        Map<Shape, Boolean> shapesExpectedResults = Map.of(
                new Rectangle(0,0,4,4), true
        );
        var calc = new PointInsideAreasCalculator();

        var results = calc.isPointInsideAreas(3,3, shapesExpectedResults.keySet());
        assertResults(shapesExpectedResults, results);
    }

    @Test
    public void calculateMethodShouldReturnFalseIfPointOutsideRectangle() {
        Map<Shape, Boolean> shapesExpectedResults = Map.of(
                new Rectangle(0,0,4,4), false
        );
        var calc = new PointInsideAreasCalculator();

        var results = calc.isPointInsideAreas(4,5, shapesExpectedResults.keySet());
        assertResults(shapesExpectedResults, results);
    }

    @Test
    public void calculateMethodShouldReturnTrueIfPointInShapes() {
        Map<Shape, Boolean> shapesExpectedResults = Map.of(
                new Rectangle(0,0,4,4), false,
                new Circle(10,10, 7), true
        );

        var calc = new PointInsideAreasCalculator();
        var results = calc.isPointInsideAreas(6, 6, shapesExpectedResults.keySet());
        assertResults(shapesExpectedResults, results);
    }
}
