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
            case 1:
                return  getVelascoFirstRoute(areaCode);
            case 2:
                return getVelascoSecondRoute(areaCode);
            case 3:
                return  getVelascoThirdRoute(areaCode);
            case 4:
                return getVelascoFourthRoute(areaCode);
            case 5:
                return  getVelascoFifthRoute(areaCode);
            default:
                return  getVelascoFirstRoute(areaCode);
        }
    }

    private static ArrayList<Vertex> getVelascoFirstRoute(int areaCode) {

        Vertex v1 = new Vertex("JL1", new Point(378,267));
		Vertex v2 = new Vertex("JL2", new Point(378,205));
		Vertex v3 = new Vertex("JL3", new Point(353,205));
		Vertex v4 = new Vertex("JL4", new Point(353,260));
		Vertex v5 = new Vertex("L105", new Point(244,205));
		Vertex v6 = new Vertex("L102", new Point(437,206));

		v1.adjacencies = new Edge[]{new Edge(v1, v2)};
		v2.adjacencies = new Edge[]{new Edge(v2, v1), new Edge(v2,v6), new Edge(v2,v3)};
		v3.adjacencies = new Edge[]{new Edge(v3, v2), new Edge(v3,v4), new Edge(v3,v6)};
		v4.adjacencies = new Edge[]{new Edge(v4, v3)};
		v5.adjacencies = new Edge[]{new Edge(v5, v3)};
		v6.adjacencies = new Edge[]{new Edge(v6, v2)};	

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
                return getShortestPathTo(v5);
            case 1:
                return getShortestPathTo(v6);
            default:
                return getShortestPathTo(v4);
        }
    }

    private static ArrayList<Vertex> getVelascoSecondRoute(int areaCode) {

		Vertex v11 = new Vertex("JL11", new Point(353,264));
		Vertex v12 = new Vertex("JL12", new Point(378,264));
		Vertex v13 = new Vertex("JL13", new Point(378,205));
		Vertex v14 = new Vertex("JL14", new Point(353,205));
		Vertex v15 = new Vertex("JL15", new Point(353,242));
		Vertex v16 = new Vertex("JL16", new Point(272,205));
		Vertex v17 = new Vertex("JL17", new Point(272,262));
		Vertex v18 = new Vertex("L207", new Point(98,262));
		Vertex v19 = new Vertex("L202", new Point(547,205));

		v11.adjacencies = new Edge[]{new Edge(v11, v12)};
		v12.adjacencies = new Edge[]{new Edge(v12, v11), new Edge(v12, v13)};
		v13.adjacencies = new Edge[]{new Edge(v13, v12), new Edge(v13, v14), new Edge(v13, v19)};
		v14.adjacencies = new Edge[]{new Edge(v14, v13), new Edge(v14, v15), new Edge(v14, v16)};
		v15.adjacencies = new Edge[]{new Edge(v15, v14)};
		v16.adjacencies = new Edge[]{new Edge(v16, v14), new Edge(v16, v17)};
		v17.adjacencies = new Edge[]{new Edge(v17, v16), new Edge(v17, v18)};
        v18.adjacencies = new Edge[]{new Edge(v18, v17)};
		v19.adjacencies = new Edge[]{new Edge(v19, v13)};

        computePaths(v11);
        if(targetAreaNumber ==areaCode)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <areaCode)
            return null;
        else
            routeNumber = -1;
		
        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v18);
            case 1:
                return getShortestPathTo(v19);
            default:
                return getShortestPathTo(v15);
        }
    }
	
	private static ArrayList<Vertex> getVelascoThirdRoute(int areaCode) {
	
	  	Vertex v21 = new Vertex("JL21", new Point(353,264));
		Vertex v22 = new Vertex("JL22", new Point(378,264));
		Vertex v23 = new Vertex("JL23", new Point(378,205));
		Vertex v24 = new Vertex("JL24", new Point(353,205));
		Vertex v25 = new Vertex("JL25", new Point(353,242));
		Vertex v26 = new Vertex("JL26", new Point(378,126));
		Vertex v27 = new Vertex("L312", new Point(252,123));
		Vertex v28 = new Vertex("L306", new Point(396,205));
		
		v21.adjacencies = new Edge[]{new Edge(v21, v22)};
		v22.adjacencies = new Edge[]{new Edge(v22, v21), new Edge(v22, v23)};
		v23.adjacencies = new Edge[]{new Edge(v23, v22), new Edge(v23, v24), new Edge(v23, v26), new Edge(v23, v28)};
		v24.adjacencies = new Edge[]{new Edge(v24, v23), new Edge(v24, v25)};
		v25.adjacencies = new Edge[]{new Edge(v25, v24)};
		v26.adjacencies = new Edge[]{new Edge(v26, v23), new Edge(v26, v27)};
		v27.adjacencies = new Edge[]{new Edge(v27, v26)};
		v28.adjacencies = new Edge[]{new Edge(v28, v23)};

        computePaths(v21);

        if(targetAreaNumber ==areaCode)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <areaCode)
            return null;
		else
			routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v27);
            case 1:
                return getShortestPathTo(v28);
            default:
                return getShortestPathTo(v25);
        }
	}

    private static ArrayList<Vertex> getVelascoFourthRoute(int areaCode) {
		Vertex v31 = new Vertex("JL31", new Point(353,264));
		Vertex v32 = new Vertex("JL32", new Point(378,264));
		Vertex v33 = new Vertex("JL33", new Point(378,205));
		Vertex v34 = new Vertex("JL34", new Point(353,205));
		Vertex v35 = new Vertex("JL35", new Point(353,242));
		Vertex v36 = new Vertex("L415", new Point(266,205));
		Vertex v37 = new Vertex("L406", new Point(469,205));
		
		v31.adjacencies = new Edge[]{new Edge(v31, v32)};
		v32.adjacencies = new Edge[]{new Edge(v32, v31), new Edge(v32, v33)};
		v33.adjacencies = new Edge[]{new Edge(v33, v32), new Edge(v33, v34), new Edge(v33, v37)};
		v34.adjacencies = new Edge[]{new Edge(v34, v33), new Edge(v34, v35), new Edge(v34, v36)};
		v35.adjacencies = new Edge[]{new Edge(v35, v34)};
		v36.adjacencies = new Edge[]{new Edge(v36, v34)};
		v37.adjacencies = new Edge[]{new Edge(v37, v33)};

        computePaths(v31);

		if(targetAreaNumber ==areaCode)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <areaCode)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v36);
            case 1:
                return getShortestPathTo(v37);
            default:
                return getShortestPathTo(v35);
        }
    }

    private static ArrayList<Vertex> getVelascoFifthRoute(int areaCode) {
		Vertex v41 = new Vertex("JL41", new Point(353,264));
		Vertex v42 = new Vertex("JL42", new Point(378,264));
		Vertex v43 = new Vertex("JL43", new Point(378,205));
		Vertex v44 = new Vertex("JL44", new Point(353,205));
		Vertex v46 = new Vertex("L504", new Point(567,205));
		Vertex v47 = new Vertex("JL47", new Point(272,205));
		Vertex v48 = new Vertex("JL48", new Point(272,262));
		Vertex v49 = new Vertex("L507", new Point(252,262	));
		
		v41.adjacencies = new Edge[]{new Edge(v41, v42)};
		v42.adjacencies = new Edge[]{new Edge(v42, v41), new Edge(v42, v43)};
		v43.adjacencies = new Edge[]{new Edge(v43, v42), new Edge(v43, v44), new Edge(v43, v46)};
		v44.adjacencies = new Edge[]{new Edge(v44, v43), new Edge(v44, v47),};
		v46.adjacencies = new Edge[]{new Edge(v46, v43)};
		v47.adjacencies = new Edge[]{new Edge(v47, v44), new Edge(v47, v48)};
		v48.adjacencies = new Edge[]{new Edge(v48, v47), new Edge(v48, v49)};
		v49.adjacencies = new Edge[]{new Edge(v49, v48)};
        computePaths(v41);

        if(targetAreaNumber ==areaCode)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <areaCode)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v46);
            case 1:
                return getShortestPathTo(v49);
            default:
                return getShortestPathTo(v41);
        }
    }
}