import java.util.*;

public class ClosestPairOpt {

    public static void main(String[] args) {
        // Generate a large number of random points
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            points.add(new Point(Math.random() * 1000, Math.random() * 1000));
        }

        long startTime = System.nanoTime();
        Point[] closestPair = findClosestPair(points);
        long endTime = System.nanoTime();

        System.out.println("Closest Pair: " + closestPair[0] + " and " + closestPair[1]);
        System.out.println("Operation took " + (endTime - startTime) / 1000000.0 + " ms");
    }

    public static Point[] findClosestPair(List<Point> points) {
        // Sort points by x-coordinate
        List<Point> sortedPoints = new ArrayList<>(points);
        sortedPoints.sort(Comparator.comparingDouble(p -> p.x));

        // Divide and conquer
        return closestPairDivideAndConquer(sortedPoints);
    }

    private static Point[] closestPairDivideAndConquer(List<Point> points) {
        if (points.size() <= 3) {
            return findClosestPairBruteForce(points);
        }


        int mid = points.size() / 2;
        List<Point> left = points.subList(0, mid);
        List<Point> right = points.subList(mid, points.size());

        Point[] leftPair = closestPairDivideAndConquer(left);
        Point[] rightPair = closestPairDivideAndConquer(right);

        double leftDistance = calculateDistance(leftPair[0], leftPair[1]);
        double rightDistance = calculateDistance(rightPair[0], rightPair[1]);

        Point[] closestPair = (leftDistance < rightDistance) ? leftPair : rightPair;
        double minDistance = Math.min(leftDistance, rightDistance);

        // Create a combined list of points close to the center line (within minDistance)
        List<Point> strip = new ArrayList<>();
        for (Point p : points) {
            if (Math.abs(p.x - points.get(mid).x) < minDistance) {
                strip.add(p);
            }
        }

        // Find the closest pair in the strip
        Point[] stripPair = closestPairInStrip(strip, minDistance, closestPair);
        if (stripPair != null) {
            closestPair = stripPair;
        }

        return closestPair;
    }

    private static Point[] closestPairInStrip(List<Point> strip, double minDistance, Point[] closestPair) {
        double minDist = minDistance;
        Point[] result = closestPair;

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < minDist; j++) {
                double distance = calculateDistance(strip.get(i), strip.get(j));
                if (distance < minDist) {
                    minDist = distance;
                    result = new Point[]{strip.get(i), strip.get(j)};
                }
            }
        }

        return result;
    }

    private static Point[] findClosestPairBruteForce(List<Point> points) {
        double minDistance = Double.MAX_VALUE;
        Point[] closestPair = new Point[2];

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
