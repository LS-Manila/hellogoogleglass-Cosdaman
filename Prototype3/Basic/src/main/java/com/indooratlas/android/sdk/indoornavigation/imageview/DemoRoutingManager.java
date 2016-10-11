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
	
	private static ArrayList<Vertex> getVelascoThirdRoute(int areaCode) {
	
	Vertex v31 = new Vertex("V3-1", new Point(1,1));
        Vertex v32 = new Vertex("V3-2", new Point(2,2));
        Vertex v33 = new Vertex("V3-3", new Point(3,3));
        Vertex v34 = new Vertex("V3-4", new Point(4,4));
        Vertex v35 = new Vertex("V3-8", new Point(5,5));
        Vertex v36 = new Vertex("L306", new Point(6,6));
        Vertex v37 = new Vertex("L301", new Point(7,7));
        Vertex v38 = new Vertex("L305-L302", new Point(8,8));
        Vertex v39 = new Vertex("L303A", new Point(9,9));
        Vertex v40 = new Vertex("L304", new Point(11,11));
        Vertex v41 = new Vertex("L303B", new Point(12,12));
        Vertex v42 = new Vertex("V3-5", new Point(13,13));
        Vertex v43 = new Vertex("V3-6", new Point(14,14));
        Vertex v44 = new Vertex("L307", new Point(15,15));
        Vertex v45 = new Vertex("L308", new Point(16,16));
        Vertex v46 = new Vertex("L309", new Point(17,17));
        Vertex v47 = new Vertex("L314", new Point(21,21));
        Vertex v48 = new Vertex("V3-7", new Point(22,22));
        Vertex v49 = new Vertex("L313", new Point(23,23));
        Vertex v50 = new Vertex("L312", new Point(24,24));
        Vertex v51 = new Vertex("L311", new Point(25,25));
        Vertex v52 = new Vertex("L310", new Point(26,26));

        v31.adjacencies = new Edge[]{new Edge(v31,v32)};
        v32.adjacencies = new Edge[]{new Edge(v32,v33),new Edge(v32,v31)};
        v33.adjacencies = new Edge[]{new Edge(v33,v32),new Edge(v33,v36),new Edge(v33,v34),new Edge(v33,v47)};
        v34.adjacencies = new Edge[]{new Edge(v34,v33),new Edge(v34,v35),new Edge(v34,v42)};
        v35.adjacencies = new Edge[]{new Edge(v35,v34)};
        v36.adjacencies = new Edge[]{new Edge(v36,v37),new Edge(v36,v33)};
        v37.adjacencies = new Edge[]{new Edge(v37,v36),new Edge(v37,v38)};
        v38.adjacencies = new Edge[]{new Edge(v38,v37),new Edge(v38,v39)};
        v39.adjacencies = new Edge[]{new Edge(v39,v38),new Edge(v39,v40)};
        v40.adjacencies = new Edge[]{new Edge(v40,v39),new Edge(v40,v41)};
        v41.adjacencies = new Edge[]{new Edge(v41,v40)};
        v42.adjacencies = new Edge[]{new Edge(v42,v34),new Edge(v42,v43)};
        v43.adjacencies = new Edge[]{new Edge(v43,v42),new Edge(v43,v44)};
        v44.adjacencies = new Edge[]{new Edge(v44,v45),new Edge(v44,v43)};
        v45.adjacencies = new Edge[]{new Edge(v45,v46),new Edge(v45,v44)};
        v46.adjacencies = new Edge[]{new Edge(v46,v45)};
        v47.adjacencies = new Edge[]{new Edge(v47,v34),new Edge(v47,v48)};
        v48.adjacencies = new Edge[]{new Edge(v48,v47),new Edge(v48,v49)};
        v49.adjacencies = new Edge[]{new Edge(v49,v48),new Edge(v49,v50)};
        v50.adjacencies = new Edge[]{new Edge(v50,v49),new Edge(v50,v51)};
        v51.adjacencies = new Edge[]{new Edge(v51,v50),new Edge(v51,v52)};
        v52.adjacencies = new Edge[]{new Edge(v52,v51)};

        computePaths(v31);

        if(targetAreaNumber ==areaCode)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <areaCode)
            return null;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v36);
            case 1:
                return getShortestPathTo(v37);
            case 2:
                return getShortestPathTo(v38);
            case 3:
                return getShortestPathTo(v39);
            case 4:
                return getShortestPathTo(v40);
            case 5:
                return getShortestPathTo(v41);
            case 6:
                return getShortestPathTo(v44);
            case 7:
                return getShortestPathTo(v45);
            case 8:
                return getShortestPathTo(v46);
            default:
                return getShortestPathTo(v35);
        }
		
	}

    private static ArrayList<Vertex> getVelascoFourthRoute(int areaCode) {
        Vertex v53 = new Vertex("V4-1", new Point(350,270));
        Vertex v54 = new Vertex("V4-2", new Point(378,270));
        Vertex v55 = new Vertex("V4-3", new Point(378,218));
        Vertex v56 = new Vertex("V4-4", new Point(350,218));
        Vertex v57 = new Vertex("L4-5", new Point(350,242));
        Vertex v58 = new Vertex("L415", new Point(277,212));
        Vertex v59 = new Vertex("L414", new Point(249,212));
        Vertex v60 = new Vertex("L409-L410A-L413", new Point(173,212));
        Vertex v61 = new Vertex("L410B-L411-L412", new Point(93,212));
        Vertex v62 = new Vertex("L407-L401", new Point(398,212));
        Vertex v63 = new Vertex("L402", new Point(429,212));
        Vertex v64 = new Vertex("L406", new Point(460,212));
        Vertex v65 = new Vertex("L403", new Point(494,212));
        Vertex v66 = new Vertex("L405", new Point(533,212));
        Vertex v67 = new Vertex("L404", new Point(547,212));

        v53.adjacencies = new Edge[]{new Edge(v53, v54)};
        v54.adjacencies = new Edge[]{new Edge(v54, v53), new Edge(v54, v55)};
        v55.adjacencies = new Edge[]{new Edge(v55, v54), new Edge(v55, v56), new Edge(v55, v62)};
        v56.adjacencies = new Edge[]{new Edge(v56, v55), new Edge(v57, v57), new Edge(v57, v58)};
        v57.adjacencies = new Edge[]{new Edge(v57, v56)};
        v60.adjacencies = new Edge[]{new Edge(v60, v59), new Edge(v60, v61)};
        v58.adjacencies = new Edge[]{new Edge(v58, v59), new Edge(v58, v56)};
        v59.adjacencies = new Edge[]{new Edge(v59, v58), new Edge(v59, v60)};
        v61.adjacencies = new Edge[]{new Edge(v61, v60)};
        v62.adjacencies = new Edge[]{new Edge(v62, v55), new Edge(v62, v63)};
        v63.adjacencies = new Edge[]{new Edge(v63, v64), new Edge(v63, v62)};
        v64.adjacencies = new Edge[]{new Edge(v64, v65), new Edge(v64, v63)};
        v65.adjacencies = new Edge[]{new Edge(v65, v66), new Edge(v65, v64)};
        v66.adjacencies = new Edge[]{new Edge(v66, v67), new Edge(v66, v65)};
        v67.adjacencies = new Edge[]{new Edge(v67, v66)};

        computePaths(v53);

        if(targetAreaNumber ==areaCode)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <areaCode)
            return null;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v58);
            case 1:
                return getShortestPathTo(v59);
            case 2:
                return getShortestPathTo(v60);
            case 3:
                return getShortestPathTo(v61);
            case 4:
                return getShortestPathTo(v62);
            case 5:
                return getShortestPathTo(v63);
            case 6:
                return getShortestPathTo(v64);
            case 7:
                return getShortestPathTo(v65);
            case 8:
                return getShortestPathTo(v66);
            default:
                return getShortestPathTo(v57);
        }
    }

    private static ArrayList<Vertex> getVelascoFifthRoute(int areaCode) {
        Vertex v68 = new Vertex("V5-1", new Point(1,1));
        Vertex v69 = new Vertex("V5-2", new Point(1,1));
        Vertex v70 = new Vertex("V5-3", new Point(1,1));
        Vertex v71 = new Vertex("L501-L506", new Point(1,1));
        Vertex v72 = new Vertex("V502-L505", new Point(1,1));
        Vertex v73 = new Vertex("V503-L504", new Point(1,1));
        Vertex v74 = new Vertex("V5-4", new Point(1,1));
        Vertex v75 = new Vertex("V5-5", new Point(1,1));
        Vertex v76 = new Vertex("L507", new Point(1,1));
        Vertex v77 = new Vertex("V508", new Point(1,1));
        Vertex v78 = new Vertex("V509", new Point(1,1));
        Vertex v79 = new Vertex("V513", new Point(1,1));
        Vertex v80 = new Vertex("V5-6", new Point(1,1));
        Vertex v81 = new Vertex("V512", new Point(1,1));
        Vertex v82 = new Vertex("V511", new Point(1,1));
        Vertex v83 = new Vertex("V510", new Point(1,1));


        v68.adjacencies = new Edge[]{new Edge(v68,v69)};
        v69.adjacencies = new Edge[]{new Edge(v69,v68),new Edge(v69,v70)};
        v70.adjacencies = new Edge[]{new Edge(v70,v69),new Edge(v70,v71),new Edge(v70,v74),new Edge(v70,v79)};
        v71.adjacencies = new Edge[]{new Edge(v71,v69),new Edge(v71,v72)};
        v72.adjacencies = new Edge[]{new Edge(v72,v71),new Edge(v72,v73)};
        v73.adjacencies = new Edge[]{new Edge(v73,v72)};
        v74.adjacencies = new Edge[]{new Edge(v74,v70),new Edge(v74,v75)};
        v75.adjacencies = new Edge[]{new Edge(v75,v74),new Edge(v76,v76)};
        v76.adjacencies = new Edge[]{new Edge(v76,v75),new Edge(v76,v77)};
        v77.adjacencies = new Edge[]{new Edge(v77,v76),new Edge(v77,v78)};
        v78.adjacencies = new Edge[]{new Edge(v78,v77)};
        v79.adjacencies = new Edge[]{new Edge(v79,v70),new Edge(v79,v80)};
        v80.adjacencies = new Edge[]{new Edge(v80,v81),new Edge(v80,v79)};
        v81.adjacencies = new Edge[]{new Edge(v81,v80),new Edge(v81,v82)};
        v82.adjacencies = new Edge[]{new Edge(v82,v81),new Edge(v82,v83)};
        v83.adjacencies = new Edge[]{new Edge(v83,v82)};

        computePaths(v68);

        if(targetAreaNumber ==areaCode)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <areaCode)
            return null;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v71);
            case 1:
                return getShortestPathTo(v72);
            case 2:
                return getShortestPathTo(v73);
            case 3:
                return getShortestPathTo(v71);
            case 4:
                return getShortestPathTo(v73);
            case 5:
                return getShortestPathTo(v72);
            case 6:
                return getShortestPathTo(v76);
            case 7:
                return getShortestPathTo(v77);
            case 8:
                return getShortestPathTo(v78);
            default:
                return getShortestPathTo(v68);
        }
    }
		

}