import java.util.*;

public class ClosestPair {

    public static void main(String[] args) {
        // Generate a large number of random points
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            points.add(new Point(Math.random() * 1000, Math.random() * 1000));
        }

        // Find the closest pair
        long startTime = System.nanoTime();
        Point[] closestPair = findClosestPair(points);
        long endTime = System.nanoTime();

        System.out.println("Closest Pair: " + closestPair[0] + " and " + closestPair[1]);
        System.out.println("Operation took " + (endTime - startTime) / 1000000.0 + " ms");
    }

    public static Point[] findClosestPair(List<Point> points) {
        double minDistance = Double.MAX_VALUE;
        Point[] closestPair = new Point[2];

        // Brute force approach: check every pair of points
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                double distance = calculateDistance(points.get(i), points.get(j));
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPair[0] = points.get(i);
                    closestPair[1] = points.get(j);
                }
            }
        }

        return closestPair;
    }

    public static double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
