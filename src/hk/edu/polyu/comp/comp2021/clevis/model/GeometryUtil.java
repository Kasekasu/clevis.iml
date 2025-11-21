package hk.edu.polyu.comp.comp2021.clevis.model;

public class GeometryUtil {
    // px and py are (x,y) of point
    public static double pointToLineDistance(double px, double py, double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dpx = px - x1;
        double dpy = py - y1;

        double dotProduct = dpx * dx + dpy * dy;
        double segLengthSquared = dx * dx + dy * dy;

        if (segLengthSquared == 0) {
            return Math.hypot(px - x1, py - y1);
        }

        double Proj = dotProduct / (segLengthSquared);

        double closestX = x1 + Proj * dx;
        double closestY = y1 + Proj * dy;

        return Math.hypot(px - closestX, py - closestY);
    }

    public static double pointToCircleDistance(double px, double py, double cx, double cy, double r) {
        return Math.abs(Math.hypot(px - cx, py - cy) - r);
    }


}
