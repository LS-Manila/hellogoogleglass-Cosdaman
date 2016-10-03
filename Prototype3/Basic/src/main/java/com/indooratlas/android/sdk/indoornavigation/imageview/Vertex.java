package com.indooratlas.android.sdk.indoornavigation.imageview;

import android.graphics.Point;

public class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public final Point coordinate = new Point();
    public Vertex(String argName,Point coords) {
        name = argName;
        coordinate.set(coords.x, coords.y);
    }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}