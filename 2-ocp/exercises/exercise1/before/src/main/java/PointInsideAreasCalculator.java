import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PointInsideAreasCalculator {

    public Map<Shape, Boolean> isPointInsideAreas(int x, int y, Set<Shape> shapes) {
        Map<Shape, Boolean> shapeAreas = new HashMap<>(shapes.size());
        for (var s : shapes) {
            shapeAreas.put(s, s.isPointInsideArea(x, y));
        }
        return shapeAreas;
    }
}
