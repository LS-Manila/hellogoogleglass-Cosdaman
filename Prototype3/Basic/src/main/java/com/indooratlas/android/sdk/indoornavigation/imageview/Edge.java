package com.indooratlas.android.sdk.indoornavigation.imageview;

public class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argSource,Vertex argTarget)
    {
        target = argTarget;
        double a= argTarget.coordinate.x-argSource.coordinate.x;
        double b=argTarget.coordinate.y-argSource.coordinate.y;


        weight =Math.sqrt( (a*a) + (b*b) );
    }
}