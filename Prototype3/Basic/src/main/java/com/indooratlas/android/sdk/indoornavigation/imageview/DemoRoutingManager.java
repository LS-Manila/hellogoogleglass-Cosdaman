package com.indooratlas.android.sdk.indoornavigation.imageview;

import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class DemoRoutingManager {

    private static int targetAreaNumber;
    private static int targetRoomNumber;
    private static int routeNumber;
    public static void setArea(int newAreaNumber) {
        targetAreaNumber = newAreaNumber;
    }
    public static void setRoom(int newRoomNumber){
        targetRoomNumber = newRoomNumber;
    }

    public static int  getArea() {
        return targetAreaNumber;
    }



    private static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    private static ArrayList<Vertex> getShortestPathTo(Vertex target) {
        ArrayList<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static ArrayList<Vertex> getPath(int areaCode) {

        switch(areaCode)
        {
            //targetroomnumber or areacode
            case 1:
              return  getVelascoFirstRoute(areaCode);
            case 2:
                return getVelascoSecondRoute(areaCode);
            case 99:
                Log.d("area code", "area: " +  areaCode);
                Log.d("room", "room: " +  targetRoomNumber);
                return getTestRoute(areaCode);
            default:
                return  getVelascoFirstRoute(areaCode);
        }

    }

    //switch case default is stairs, the if statements check for validity of floor.
    //route to default if current floor is not floor

    private static ArrayList<Vertex> getVelascoFirstRoute(int areaCode) {

        Vertex v1 = new Vertex("V1-1", new Point(524,15));
        Vertex v2 = new Vertex("V1-2", new Point(524,290));
        Vertex v3 = new Vertex("V1-3", new Point(524,370));
        Vertex v4 = new Vertex("V1-4", new Point(524,632));
        Vertex v5 = new Vertex("V1-5", new Point(575,290));
        Vertex v6 = new Vertex("L109", new Point(575,370));
        Vertex v7 = new Vertex("V1-7", new Point(575,537));
        Vertex v8 = new Vertex("L101", new Point(450,290));
        Vertex v9 = new Vertex("L103", new Point(414,290));
        Vertex v10 = new Vertex("L101D-L102A", new Point(338,290));
        Vertex v11 = new Vertex("V1-11", new Point(745,290));
        Vertex v12 = new Vertex("L104-L105-L106", new Point(838,290));
        Vertex v13 = new Vertex("L107-L108", new Point(838,407));
        Vertex v14 = new Vertex("V1-14", new Point(575,64));

        v1.adjacencies = new Edge[]{new Edge(v1, v2)};
        v2.adjacencies = new Edge[]{new Edge(v2, v1), new Edge(v2, v5), new Edge(v2, v8), new Edge(v2, v3)};
        v3.adjacencies = new Edge[]{new Edge(v3, v2), new Edge(v3, v6), new Edge(v3, v4)};
        v4.adjacencies = new Edge[]{new Edge(v4, v5)};
        v5.adjacencies = new Edge[]{new Edge(v5, v2), new Edge(v5, v6), new Edge(v5, v11), new Edge(v5, v14)};
        v6.adjacencies = new Edge[]{new Edge(v6, v3), new Edge(v6, v5), new Edge(v6, v7)};
        v7.adjacencies = new Edge[]{new Edge(v7, v6)};
        v8.adjacencies = new Edge[]{new Edge(v8, v2), new Edge(v8, v9)};
        v9.adjacencies = new Edge[]{new Edge(v9, v8), new Edge(v9, v10)};
        v10.adjacencies = new Edge[]{new Edge(v10, v9)};
        v11.adjacencies = new Edge[]{new Edge(v11, v5), new Edge(v11, v12)};
        v12.adjacencies = new Edge[]{new Edge(v12, v11), new Edge(v12, v13)};
        v13.adjacencies = new Edge[]{new Edge(v13, v12)};
        v14.adjacencies = new Edge[]{new Edge(v14, v5)};

        computePaths(v1);

        Log.d("Areas", "Current is Velasco 1 Area Code = " + Integer.toString(areaCode));
        if(targetAreaNumber ==areaCode)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <areaCode)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v8);
            case 1:
                return getShortestPathTo(v10);
            case 2:
                return getShortestPathTo(v9);
            case 3:
                return getShortestPathTo(v12);
            case 4:
                return getShortestPathTo(v12);
            case 5:
                return getShortestPathTo(v12);
            case 6:
                return getShortestPathTo(v13);
            case 7:
                return getShortestPathTo(v13);
            case 8:
                return getShortestPathTo(v6);
            default:
                return getShortestPathTo(v14);
        }

    }

    private static ArrayList<Vertex> getVelascoSecondRoute(int areaCode) {
        Vertex v15 = new Vertex("V2-1", new Point(575,40));
        Vertex v16 = new Vertex("V2-2", new Point(534,40));
        Vertex v17 = new Vertex("V2-3", new Point(534,268));
        Vertex v18 = new Vertex("L201", new Point(575,268));
        Vertex v19 = new Vertex("V2-5", new Point(575,132));
        Vertex v20 = new Vertex("L202", new Point(477,268));
        Vertex v21 = new Vertex("L203", new Point(324,268));
        Vertex v22 = new Vertex("L204", new Point(172,268));
        Vertex v23 = new Vertex("V2-4", new Point(737,268));
        Vertex v24 = new Vertex("V2-5", new Point(737,38));
        Vertex v25 = new Vertex("L205", new Point(771,38));
        Vertex v26 = new Vertex("L206", new Point(932,38));
        Vertex v27 = new Vertex("L207", new Point(1095,38));
        Vertex v28 = new Vertex("V2-6", new Point(737,575));
        Vertex v29 = new Vertex("L208A", new Point(737,575));
        Vertex v30 = new Vertex("L208B", new Point(771,575));

        v15.adjacencies = new Edge[]{new Edge(v15,v16)};
        v16.adjacencies = new Edge[]{new Edge(v16,v17),new Edge(v16,v15)};
        v17.adjacencies = new Edge[]{new Edge(v17,v16),new Edge(v17,v18),new Edge(v17,v20)};
        v18.adjacencies = new Edge[]{new Edge(v18,v17),new Edge(v18,v19),new Edge(v18,v23)};
        v19.adjacencies = new Edge[]{new Edge(v19,v18)};
        v20.adjacencies = new Edge[]{new Edge(v20,v17),new Edge(v20,v21)};
        v21.adjacencies = new Edge[]{new Edge(v21,v20),new Edge(v21,v22)};
        v22.adjacencies = new Edge[]{new Edge(v22,v21)};
        v23.adjacencies = new Edge[]{new Edge(v23,v18),new Edge(v23,v24),new Edge(v23,v28)};
        v24.adjacencies = new Edge[]{new Edge(v24,v23),new Edge(v24,v25)};
        v25.adjacencies = new Edge[]{new Edge(v25,v26),new Edge(v25,v24)};
        v26.adjacencies = new Edge[]{new Edge(v26,v27),new Edge(v26,v25)};
        v27.adjacencies = new Edge[]{new Edge(v27,v26)};
        v28.adjacencies = new Edge[]{new Edge(v28,v29),new Edge(v28,v23)};
        v29.adjacencies = new Edge[]{new Edge(v29,v28),new Edge(v29,v30)};
        v30.adjacencies = new Edge[]{new Edge(v30,v29)};


        computePaths(v15);

        if(targetAreaNumber ==areaCode)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <areaCode)
            return null;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v18);
            case 1:
                return getShortestPathTo(v20);
            case 2:
                return getShortestPathTo(v21);
            case 3:
                return getShortestPathTo(v22);
            case 4:
                return getShortestPathTo(v25);
            case 5:
                return getShortestPathTo(v26);
            case 6:
                return getShortestPathTo(v27);
            case 7:
                return getShortestPathTo(v29);
            case 8:
                return getShortestPathTo(v30);
            default:
                return getShortestPathTo(v18);
        }
    }

    private static ArrayList<Vertex> getTestRoute(int areaCode) {

       /* Vertex v9 = new Vertex("T-9", new Point(924, 283));
        Vertex v8 = new Vertex("T-8", new Point(815, 287));
        Vertex v7 = new Vertex("T-7", new Point(676, 283));
        Vertex v6 = new Vertex("T-6", new Point(554, 415));
        Vertex v5 = new Vertex("T-5", new Point(562, 278));
        Vertex v4 = new Vertex("T-4", new Point(554, 132));
        Vertex v3 = new Vertex("T-3", new Point(429, 410));
        Vertex v2 = new Vertex("T-2", new Point(420, 283));
        Vertex v1 = new Vertex("T-1", new Point(425, 136));*/

        Vertex v9 = new Vertex("T-9", new Point(424, 183));
        Vertex v8 = new Vertex("T-8", new Point(315, 187));
        Vertex v7 = new Vertex("T-7", new Point(276, 183));
        Vertex v6 = new Vertex("T-6", new Point(154, 115));
        Vertex v5 = new Vertex("T-5", new Point(162, 178));
        Vertex v4 = new Vertex("T-4", new Point(154, 132));
        Vertex v3 = new Vertex("T-3", new Point(29, 10));
        Vertex v2 = new Vertex("T-2", new Point(20, 283));
        Vertex v1 = new Vertex("T-1", new Point(25, 36));

        v1.adjacencies = new Edge[]{new Edge(v1, v2), new Edge(v1, v4)};
        v2.adjacencies = new Edge[]{new Edge(v2, v1), new Edge(v2, v3)};
        v3.adjacencies = new Edge[]{new Edge(v3, v2), new Edge(v3, v6)};
        v4.adjacencies = new Edge[]{new Edge(v4, v5), new Edge(v4, v1)};
        v5.adjacencies = new Edge[]{new Edge(v5, v4), new Edge(v5, v6), new Edge(v5, v7)};
        v6.adjacencies = new Edge[]{new Edge(v6, v3), new Edge(v6, v5)};
        v7.adjacencies = new Edge[]{new Edge(v7, v5), new Edge(v7, v8)};
        v8.adjacencies = new Edge[]{new Edge(v8, v7), new Edge(v8, v9)};

        computePaths(v9);

        if(targetAreaNumber == areaCode)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber < areaCode)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v1);
            case 1:
                return getShortestPathTo(v1);
            case 2:
                return getShortestPathTo(v2);
            case 3:
                return getShortestPathTo(v3);
            case 4:
                return getShortestPathTo(v4);
            case 5:
                return getShortestPathTo(v5);
            case 6:
                return getShortestPathTo(v6);
            case 7:
                return getShortestPathTo(v7);
            case 8:
                return getShortestPathTo(v8);
            case 9:
                return getShortestPathTo(v9);
            default:
                return getShortestPathTo(v9);
        }

    }



}