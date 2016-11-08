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
    private static int currentArea;
    public static void setArea(int newAreaNumber) {
        targetAreaNumber = newAreaNumber;
    }
    public static void setRoom(int newRoomNumber){
        targetRoomNumber = newRoomNumber;
    }
    public static int buildingNumber;


    public static int  getArea() {
        return currentArea;
    }


    private static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
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
        ArrayList<Vertex> path = new ArrayList<>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static int getTargetAreaNumber() {

        if(targetAreaNumber > 0 && targetAreaNumber < 6){
            buildingNumber = 1; //velasco

        }else if (targetAreaNumber > 5 && targetAreaNumber < 10) {
            buildingNumber = 2; //faculty

        }else if (targetAreaNumber > 9 && targetAreaNumber < 14) {
            buildingNumber = 3; //gox

        }else if (targetAreaNumber > 13 && targetAreaNumber < 18) {
            buildingNumber = 4; //miguel

        }else if (targetAreaNumber > 17 && targetAreaNumber <23) {
            buildingNumber = 5; //henry

        }else if (targetAreaNumber > 22 && targetAreaNumber < 29) {
            buildingNumber = 6; //sj

        }else if (targetAreaNumber > 28 && targetAreaNumber < 33) {
            buildingNumber = 7; //strc

        }else if (targetAreaNumber > 32 && targetAreaNumber < 37) {
            buildingNumber = 8; //yuch

        }else if (targetAreaNumber > 36 && targetAreaNumber < 40) {
            buildingNumber = 9; //andrew

        }else if (targetAreaNumber > 39 && targetAreaNumber < 43) {
            buildingNumber = 10; //william

        }else if (targetAreaNumber > 42 && targetAreaNumber < 45) {
            buildingNumber = 11; //Beta

        }else if (targetAreaNumber > 44 && targetAreaNumber < 47) {
            buildingNumber = 12; //Alpha

        }else if (targetAreaNumber > 46 && targetAreaNumber < 49) {
            buildingNumber = 13; //Pi

        }
        /*
        if(targetAreaNumber >0) {

            if (targetAreaNumber < 6) {
                buildingNumber = 1; //velasco

            } else if (targetAreaNumber <= 9) {
                buildingNumber = 2; //faculty

            } else if (targetAreaNumber <= 13) {
                buildingNumber = 3; //gox

            } else if (targetAreaNumber <= 17) {
                buildingNumber = 4; //miguel

            } else if (targetAreaNumber <= 22) {
                buildingNumber = 5; //henry

            } else if (targetAreaNumber <= 28) {
                buildingNumber = 6; //sj

            } else if (targetAreaNumber <= 32) {
                buildingNumber = 7; //strc

            } else if (targetAreaNumber <= 36) {
                buildingNumber = 8; //yuch

            } else if (targetAreaNumber <= 39) {
                buildingNumber = 9; //andrew

            } else if (targetAreaNumber <= 42) {
                buildingNumber = 10; //william

            }
        }

        else{
            buildingNumber = 0;
        }*/
        return buildingNumber;
    }

    public void init(String string) {

        switch(string){

            //Velasco
            case "map_2379":
                currentArea = 1;

            case "map_44d0":
                currentArea = 2;

            case "map_e287":
                currentArea = 3;

            case "map_70dc":
                currentArea = 4;

            case "map_9ce6":
                currentArea = 5;

            case "map_a0b4":
                //Faculty Center
                currentArea = 6;

            case "map_3b22":
                currentArea = 7;

            case "map_f94a":
                currentArea = 8;

            case "map_6779":
                currentArea = 9;

            case "map_d48a":
                //Gokongwei
                currentArea = 10;

            case "map_0868":
                currentArea = 11;

            case "map_0820":
                currentArea = 12;

            case "map_1401":
                currentArea = 13;

            case "map_e47f":
                //Miguel
                currentArea = 14;

            case "map_564d":
                currentArea = 15;

            case "map_ef16":
                currentArea = 16;

            case "map_3fd0":
                currentArea = 17;

            case "map_6910":
                //Henry Sy
                currentArea = 18;

            case "map_d493":
                currentArea = 19;

            case "map_3a39":
                currentArea = 20;

            case "map_20d5":
                currentArea = 21;

            case "map_8924":
            currentArea = 22;

            case "map_718b":
                //Sj
                currentArea = 23;

            case "map_94ee":
                currentArea = 24;

            //case "map_d01a":
            //    currentArea = 25;

            //case "map_d01a":
            //    currentArea = 26;

            case "map_8f49":
                currentArea = 27;

            case "map_10f7":
                currentArea = 28;

            case "map_c276":
                //Strc
                currentArea = 29;

            case "map_8a39":
                currentArea = 30;

            case "map_c678":
                currentArea = 31;

            case "map_c974":
                currentArea = 32;

            case "map_eb14":
                //Yuchenco
                currentArea = 33;

            case "map_e224":
                currentArea = 34;

            case "map_ff20":
                currentArea = 35;

            case "map_70c2":
                currentArea = 36;

            case "map_00f3":
                //Anderew
                currentArea = 37;

            case "map_978e":
                currentArea = 38;

            case "map_bdb7":
                currentArea = 39;

            case "map_9ee9":
                //William
                currentArea = 40;

            case "map_d8df":
                currentArea = 41;

            //case "map_a0b4":
            //currentArea = 42;

            case "map_db78":
                //Beta
                currentArea = 43;

            case "map_3366":
                currentArea = 44;

            case "map_f3c8":
                //Alpha
                currentArea = 45;

            //case "map_5bc0":
            //    currentArea = 46;

            case "map_473d":
                //Pi
                currentArea = 47;

            case "map_5bc0":
                currentArea = 48;
        }
    }

    public static ArrayList<Vertex> getPath(int currentArea) {


        switch(currentArea)
        {
            case 1:
                return  getVelascoFirstRoute(currentArea);
            case 2:
                return getVelascoSecondRoute(currentArea);
            case 3:
                return  getVelascoThirdRoute(currentArea);
            case 4:
                return  getVelascoFourthRoute(currentArea);
            case 5:
                return  getVelascoFifthRoute(currentArea);
            case 6:
                return  getFacultyFirstRoute(currentArea);
            case 7:
                return  getFacultySecondRoute(currentArea);
            case 8:
                return  getFacultyThirdRoute(currentArea);
            case 9:
                return  getFacultyFourthRoute(currentArea);
            case 10:
                return getGongweiFirstRoute(currentArea);
            case 11:
                return getGokongweiSecondRoute(currentArea);
            case 12:
                return getGokongweiThirdRoute(currentArea);
            case 13:
                return getGokongweiFourthRoute(currentArea);
            case 14:
                return getMiguelFirstRoute(currentArea);
            case 15:
                return getMiguelSecondRoute(currentArea);
            case 16:
                return getMiguelThirdRoute(currentArea);
            case 17:
                return getMiguelFourthRoute(currentArea);
            case 18:
                return getHenrySecondRoute(currentArea);
            case 19:
                return getHenryThirdRoute(currentArea);
            case 20:
                return getHenryFourthRoute(currentArea);
            case 21:
                return getHenryFifthRoute(currentArea);
            case 22:
                return getHenryFourteenthRoute(currentArea);
            case 23:
                return getSjFirstRoute(currentArea);
            case 24:
                return getSjSecondRoute(currentArea);
            case 25:
                return getSjThirdRoute(currentArea);
            case 26:
                return getSjFourthRoute(currentArea);
            case 27:
                return getSjFifthRoute(currentArea);
            case 28:
                return getSjSixthRoute(currentArea);
           case 29:
                return getStrcFirstRoute(currentArea);
            /* case 30:
                return getStrcSecondRoute(currentArea);
            case 31:
                return getStrcThirdRoute(currentArea);
            case 32:
                return getStrcFourthRoute(currentArea);*/
            case 33:
                return getYuchThirdRoute(currentArea);
            case 34:
                return getYuchFourthRoute(currentArea);
            case 35:
                return getYuchFifthRoute(currentArea);
            case 36:
                return getYuchSixthRoute(currentArea);
            case 37:
                return getAndrewFirstRoute(currentArea);
            case 38:
                return getAndrewEightRoute(currentArea);
            case 39:
                return getAndrewNinthRoute(currentArea);
            case 40:
                return getWilliamFirstRoute(currentArea);
            case 41:
                return getWilliamSecondRoute(currentArea);
            case 42:
                return getWilliamThirdRoute(currentArea);
            case 43:
                return getJohnSecondRoute(currentArea);
            case 44:
                return getJohnThirdRoute(currentArea);
            case 45:
                return getLSFirstRoute(currentArea);
            case 46:
                return getLSSecondRoute(currentArea);
            case 47:
                return getRazonFirstRoute(currentArea);
            case 48:
                return getRazonSeventhRoute(currentArea);

            default:
                return  getVelascoFirstRoute(currentArea);
        }
    }

    private static ArrayList<Vertex> getVelascoFirstRoute(int currentArea) {

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
        Log.d("Areas", "Current is Velasco 1 Area Code = " + Integer.toString(currentArea));



        if(targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber < currentArea)
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

    private static ArrayList<Vertex> getVelascoSecondRoute(int currentArea) {
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

        if(targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
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

    private static ArrayList<Vertex> getVelascoThirdRoute(int currentArea) {
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

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
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

    private static ArrayList<Vertex> getVelascoFourthRoute(int currentArea) {
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

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
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

    private static ArrayList<Vertex> getVelascoFifthRoute(int currentArea) {
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

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
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

    private static ArrayList<Vertex> getFacultyFirstRoute(int currentArea){

        Vertex v301 = new Vertex("JFC1", new Point(90, 180));
        Vertex v302 = new Vertex("JFC2", new Point(130, 180));
        Vertex v303 = new Vertex("JFC3", new Point(185, 180));
        Vertex v304 = new Vertex("JFC4", new Point(130, 133));
        Vertex v305 = new Vertex("ACCOUNTING", new Point(400,133));
        Vertex v306 = new Vertex("JFC6", new Point(130,227));
        Vertex v307 = new Vertex("COB ADMIN", new Point(176,227));

        v301.adjacencies = new Edge[]{new Edge(v301, v302)};
        v302.adjacencies = new Edge[]{new Edge(v302, v301), new Edge(v302, v303), new Edge(v302, v304), new Edge(v302, v306)};
        v303.adjacencies = new Edge[]{new Edge(v303, v302)};
        v304.adjacencies = new Edge[]{new Edge(v304, v302), new Edge(v304, v305)};
        v305.adjacencies = new Edge[]{new Edge(v305, v304)};
        v306.adjacencies = new Edge[]{new Edge(v306, v302), new Edge(v306, v307)};
        v307.adjacencies = new Edge[]{new Edge(v307, v306)};

        computePaths(v301);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v305);
            case 1:
                return getShortestPathTo(v307);
            default:
                return getShortestPathTo(v303);
        }

    }

    private static ArrayList<Vertex> getFacultySecondRoute(int currentArea){

        Vertex v311 = new Vertex("JFC11", new Point(210,160));
        Vertex v312 = new Vertex("JFC12", new Point(210,133));
        Vertex v313 = new Vertex("JFC13", new Point(170,133));
        Vertex v314 = new Vertex("JFC14", new Point(170,160));
        Vertex v315 = new Vertex("FINANCIAL MANAGEMENT", new Point(268,133));
        Vertex v316 = new Vertex("JFC16", new Point(141,133));
        Vertex v317 = new Vertex("JFC17", new Point(141,130));
        Vertex v318 = new Vertex("MARKETING AND ADVERTISING", new Point(214,130));

        v311.adjacencies = new Edge[]{new Edge(v311, v312)};
        v312.adjacencies = new Edge[]{new Edge(v312, v311), new Edge(v312, v313), new Edge(v312, v315)};
        v313.adjacencies = new Edge[]{new Edge(v313, v312), new Edge(v313, v314), new Edge(v313, v316)};
        v314.adjacencies = new Edge[]{new Edge(v314, v313)};
        v315.adjacencies = new Edge[]{new Edge(v315, v312)};
        v316.adjacencies = new Edge[]{new Edge(v316, v313), new Edge(v316, v317)};
        v317.adjacencies = new Edge[]{new Edge(v317, v316), new Edge(v317, v318)};
        v318.adjacencies = new Edge[]{new Edge(v318, v317)};

        computePaths(v311);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v315);
            case 1:
                return getShortestPathTo(v318);
            default:
                return getShortestPathTo(v314);
        }

    }

    private static ArrayList<Vertex> getFacultyThirdRoute(int currentArea){

        Vertex v321 = new Vertex("JFC21", new Point(210,200));
        Vertex v322 = new Vertex("JFC22", new Point(210,227));
        Vertex v323 = new Vertex("JFC23", new Point(165,227));
        Vertex v324 = new Vertex("JFC24", new Point(165,200));
        Vertex v325 = new Vertex("HISTORY", new Point(132,227));
        Vertex v326 = new Vertex("THEOLOGY", new Point(332,227));

        v321.adjacencies = new Edge[]{new Edge(v321, v322)};
        v322.adjacencies = new Edge[]{new Edge(v322, v321), new Edge(v322, v323), new Edge(v322, v326),};
        v323.adjacencies = new Edge[]{new Edge(v323, v322), new Edge(v323, v324), new Edge(v323, v325)};
        v324.adjacencies = new Edge[]{new Edge(v324, v323)};
        v325.adjacencies = new Edge[]{new Edge(v325, v323)};
        v326.adjacencies = new Edge[]{new Edge(v326, v322)};

        computePaths(v321);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v325);
            case 1:
                return getShortestPathTo(v326);
            default:
                return getShortestPathTo(v324);
        }

    }

    private static ArrayList<Vertex> getFacultyFourthRoute(int currentArea){

        Vertex v331 = new Vertex("JFC31", new Point(210,160));
        Vertex v332 = new Vertex("JFC32", new Point(210,133));
        Vertex v333 = new Vertex("INTERNATIONAL STUDIES", new Point(136,133));
        Vertex v334 = new Vertex("PHILOSOPHY", new Point(397,133));

        v331.adjacencies = new Edge[]{new Edge(v331, v332)};
        v332.adjacencies = new Edge[]{new Edge(v332, v331), new Edge(v332, v333), new Edge(v332, v334)};
        v333.adjacencies = new Edge[]{new Edge(v333, v332)};
        v334.adjacencies = new Edge[]{new Edge(v334, v332)};

        computePaths(v331);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v333);
            case 1:
                return getShortestPathTo(v334);
            default:
                return getShortestPathTo(v331);
        }

    }

    private static ArrayList<Vertex> getGongweiFirstRoute(int currentArea){

        Vertex v1101 = new Vertex("JX", new Point(20,262));
        Vertex v1102 = new Vertex("JX", new Point(109,262));
        Vertex v1103 = new Vertex("JX", new Point(109,307));
        Vertex v1104 = new Vertex("JX", new Point(54,307));
        Vertex v1105 = new Vertex("X101", new Point(109,226));
        Vertex v1106 = new Vertex("X103", new Point(510,226));


        v1101.adjacencies = new Edge[]{new Edge(v1101, v1102)};
        v1102.adjacencies = new Edge[]{new Edge(v1102, v1101), new Edge(v1102, v1104), new Edge(v1102, v1105), new Edge(v1102, v1106)};
        v1103.adjacencies = new Edge[]{new Edge(v1103, v1102), new Edge(v1103, v1104)};
        v1104.adjacencies = new Edge[]{new Edge(v1104, v1103)};
        v1105.adjacencies = new Edge[]{new Edge(v1105, v1102)};
        v1106.adjacencies = new Edge[]{new Edge(v1106, v1102)};

        computePaths(v1101);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v1105);
            case 1:
                return getShortestPathTo(v1106);
            default:
                return getShortestPathTo(v1104);
        }
    }

    private static ArrayList<Vertex> getGokongweiSecondRoute (int currentArea){

        Vertex v1111 = new Vertex("JX11", new Point(15,305));
        Vertex v1112 = new Vertex("JX12", new Point(15,270));
        Vertex v1113 = new Vertex("JX13", new Point(110,270));
        Vertex v1114 = new Vertex("JX14", new Point(110,305));
        Vertex v1115 = new Vertex("JX15", new Point(63,305));
        Vertex v1116 = new Vertex("JX16", new Point(15,146));
        Vertex v1117 = new Vertex("X204", new Point(130,146));
        Vertex v1118 = new Vertex("X210", new Point(395,146));

        v1111.adjacencies = new Edge[]{new Edge(v1111, v1112)};
        v1112.adjacencies = new Edge[]{new Edge(v1112, v1111), new Edge(v1112, v1113), new Edge(v1112, v1116)};
        v1113.adjacencies = new Edge[]{new Edge(v1113, v1112), new Edge(v1113, v1114)};
        v1114.adjacencies = new Edge[]{new Edge(v1114, v1113), new Edge(v1114, v1115)};
        v1115.adjacencies = new Edge[]{new Edge(v1115, v1114)};
        v1116.adjacencies = new Edge[]{new Edge(v1116, v1112), new Edge(v1116, v1117)};
        v1117.adjacencies = new Edge[]{new Edge(v1117, v1116), new Edge(v1117, v1118)};
        v1118.adjacencies = new Edge[]{new Edge(v1118, v1117)};

        computePaths(v1111);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v1117);
            case 1:
                return getShortestPathTo(v1118);
            default:
                return getShortestPathTo(v1115);
        }
    }

    private static ArrayList<Vertex> getGokongweiThirdRoute (int currentArea){

        Vertex v1121 = new Vertex("JX21", new Point(15,305));
        Vertex v1122 = new Vertex("JX22", new Point(15,270));
        Vertex v1123 = new Vertex("JX23", new Point(110,270));
        Vertex v1124 = new Vertex("JX24", new Point(110,305));
        Vertex v1125 = new Vertex("JX25", new Point(63,305));
        Vertex v1126 = new Vertex("JX26", new Point(15,146));
        Vertex v1127 = new Vertex("X301", new Point(44,146));
        Vertex v1128 = new Vertex("X305", new Point(368,146));

        v1121.adjacencies = new Edge[]{new Edge(v1121, v1122)};
        v1122.adjacencies = new Edge[]{new Edge(v1122, v1121), new Edge(v1122, v1123), new Edge(v1122, v1126)};
        v1123.adjacencies = new Edge[]{new Edge(v1123, v1122), new Edge(v1123, v1124)};
        v1124.adjacencies = new Edge[]{new Edge(v1124, v1123), new Edge(v1124, v1125)};
        v1125.adjacencies = new Edge[]{new Edge(v1125, v1124)};
        v1126.adjacencies = new Edge[]{new Edge(v1126, v1122), new Edge(v1126, v1127)};
        v1127.adjacencies = new Edge[]{new Edge(v1127, v1126), new Edge(v1127, v1128)};
        v1128.adjacencies = new Edge[]{new Edge(v1128, v1127)};

        computePaths(v1121);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v1127);
            case 1:
                return getShortestPathTo(v1128);
            default:
                return getShortestPathTo(v1125);
        }
    }

    private static ArrayList<Vertex> getGokongweiFourthRoute (int currentArea){

        Vertex v1131 = new Vertex("JX31", new Point(15,305));
        Vertex v1132 = new Vertex("JX32", new Point(15,270));
        Vertex v1133 = new Vertex("JX33", new Point(110,270));
        Vertex v1134 = new Vertex("JX34", new Point(110,305));
        Vertex v1135 = new Vertex("JX35", new Point(63,305));
        Vertex v1136 = new Vertex("JX36", new Point(15,146));
        Vertex v1137 = new Vertex("X404", new Point(134,146));
        Vertex v1138 = new Vertex("X409", new Point(520,146));

        v1131.adjacencies = new Edge[]{new Edge(v1131, v1132)};
        v1132.adjacencies = new Edge[]{new Edge(v1132, v1131), new Edge(v1132, v1133), new Edge(v1132, v1136)};
        v1133.adjacencies = new Edge[]{new Edge(v1133, v1132), new Edge(v1133, v1134)};
        v1134.adjacencies = new Edge[]{new Edge(v1134, v1133), new Edge(v1134, v1135)};
        v1135.adjacencies = new Edge[]{new Edge(v1135, v1134)};
        v1136.adjacencies = new Edge[]{new Edge(v1136, v1132), new Edge(v1136, v1137)};
        v1137.adjacencies = new Edge[]{new Edge(v1137, v1136), new Edge(v1137, v1138)};
        v1138.adjacencies = new Edge[]{new Edge(v1138, v1137)};

        computePaths(v1131);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v1137);
            case 1:
                return getShortestPathTo(v1138);
            default:
                return getShortestPathTo(v1131);
        }
    }

    private static ArrayList<Vertex> getMiguelFirstRoute (int currentArea){
        Vertex v701 = new Vertex("JM1", new Point(514,344));
        Vertex v702 = new Vertex("JM2", new Point(616,344));
        Vertex v703 = new Vertex("M104", new Point(514,146));
        Vertex v704 = new Vertex("M116", new Point(432,344));

        v701.adjacencies = new Edge[]{new Edge(v701, v702), new Edge (v701, v703), new Edge(v701, v704)};
        v702.adjacencies = new Edge[]{new Edge(v702, v701)};
        v703.adjacencies = new Edge[]{new Edge(v703, v701)};
        v704.adjacencies = new Edge[]{new Edge(v703, v701)};
        computePaths(v701);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v703);
            case 1:
                return getShortestPathTo(v704);
            default:
                return getShortestPathTo(v702);
        }
    }

    private static ArrayList<Vertex> getMiguelSecondRoute (int currentArea){

        Vertex v711 = new Vertex("JM11", new Point(616,344));
        Vertex v712 = new Vertex("JM12", new Point(514,344));
        Vertex v713 = new Vertex("JM13", new Point(514,300));
        Vertex v714 = new Vertex("JM14", new Point(616,300));
        Vertex v715 = new Vertex("JM15", new Point(514,230));
        Vertex v716 = new Vertex("M209", new Point(514,111));
        Vertex v717 = new Vertex("M213", new Point(346,230));

        v711.adjacencies = new Edge[]{new Edge(v711, v712)};
        v712.adjacencies = new Edge[]{new Edge(v712, v711), new Edge(v712, v713)};
        v713.adjacencies = new Edge[]{new Edge(v713, v712), new Edge(v713, v714), new Edge(v713, v715)};
        v714.adjacencies = new Edge[]{new Edge(v714, v713)};
        v715.adjacencies = new Edge[]{new Edge(v715, v713), new Edge(v715, v716), new Edge(v715, v717)};
        v716.adjacencies = new Edge[]{new Edge(v716, v715)};
        v717.adjacencies = new Edge[]{new Edge(v717, v715)};

        computePaths(v711);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v716);
            case 1:
                return getShortestPathTo(v717);
            default:
                return getShortestPathTo(v714);
        }
    }

    private static ArrayList<Vertex> getMiguelThirdRoute (int currentArea){

        Vertex v721 = new Vertex("JM21", new Point(616,344));
        Vertex v722 = new Vertex("JM22", new Point(514,344));
        Vertex v723 = new Vertex("JM23", new Point(514,300));
        Vertex v724 = new Vertex("JM24", new Point(616,300));
        Vertex v725 = new Vertex("JM25", new Point(514,230));
        Vertex v726 = new Vertex("M314", new Point(514,111));
        Vertex v727 = new Vertex("M310", new Point(346,230));


        v721.adjacencies = new Edge[]{new Edge(v721, v722)};
        v722.adjacencies = new Edge[]{new Edge(v722, v721), new Edge(v722, v723)};
        v723.adjacencies = new Edge[]{new Edge(v723, v722), new Edge(v723, v724), new Edge(v723, v725)};
        v724.adjacencies = new Edge[]{new Edge(v724, v723)};
        v725.adjacencies = new Edge[]{new Edge(v725, v723), new Edge(v725, v726), new Edge(v725, v727)};
        v726.adjacencies = new Edge[]{new Edge(v726, v725)};
        v727.adjacencies = new Edge[]{new Edge(v727, v725)};

        computePaths(v721);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v726);
            case 1:
                return getShortestPathTo(v727);
            default:
                return getShortestPathTo(v724);
        }
    }

    private static ArrayList<Vertex> getMiguelFourthRoute (int currentArea){

        Vertex v731 = new Vertex("JM31", new Point(616,344));
        Vertex v732 = new Vertex("JM32", new Point(514,344));
        Vertex v733 = new Vertex("JM33", new Point(514,300));
        Vertex v734 = new Vertex("JM34", new Point(616,300));
        Vertex v735 = new Vertex("JM35", new Point(514,230));
        Vertex v736 = new Vertex("M404", new Point(514,111));
        Vertex v737 = new Vertex("M408", new Point(346,230));


        v731.adjacencies = new Edge[]{new Edge(v731, v732)};
        v732.adjacencies = new Edge[]{new Edge(v732, v731), new Edge(v732, v733)};
        v733.adjacencies = new Edge[]{new Edge(v733, v732), new Edge(v733, v734), new Edge(v733, v735)};
        v734.adjacencies = new Edge[]{new Edge(v734, v733)};
        v735.adjacencies = new Edge[]{new Edge(v735, v733), new Edge(v735, v736), new Edge(v735, v737)};
        v736.adjacencies = new Edge[]{new Edge(v736, v735)};
        v737.adjacencies = new Edge[]{new Edge(v737, v735)};

        computePaths(v731);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v736);
            case 1:
                return getShortestPathTo(v737);
            default:
                return getShortestPathTo(v734);
        }

    }

    private static ArrayList<Vertex> getHenrySecondRoute (int currentArea){

        Vertex v601 = new Vertex("JI", new Point(267,39));
        Vertex v602 = new Vertex("JI", new Point(307,39));
        Vertex v603 = new Vertex("JI", new Point(267,34));
        Vertex v604 = new Vertex("JI", new Point(225,64));
        Vertex v605 = new Vertex("JI", new Point(225,145));
        Vertex v606 = new Vertex("ACADEMIC SERVICE HUB", new Point(251,154));

        v601.adjacencies = new Edge[]{new Edge(v601, v602), new Edge(v601, v603)};
        v602.adjacencies = new Edge[]{new Edge(v602, v601),};
        v603.adjacencies = new Edge[]{new Edge(v603, v601), new Edge(v603, v604)};
        v604.adjacencies = new Edge[]{new Edge(v604, v603), new Edge(v604, v605)};
        v605.adjacencies = new Edge[]{new Edge(v605, v604), new Edge(v605, v606)};
        v606.adjacencies = new Edge[]{new Edge(v606, v605)};

        computePaths(v601);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v606);
            default:
                return getShortestPathTo(v602);
        }
    }

    private static ArrayList<Vertex> getHenryThirdRoute (int currentArea){

        Vertex v611 = new Vertex("JI", new Point(336,38));
        Vertex v612 = new Vertex("JI", new Point(371,38));
        Vertex v613 = new Vertex("JI", new Point(371,19));
        Vertex v614 = new Vertex("JI", new Point(336,19));
        Vertex v615 = new Vertex("JI", new Point(371,66));
        Vertex v616 = new Vertex("JI", new Point(222,66));
        Vertex v617 = new Vertex("I301", new Point(222,105));

        v611.adjacencies = new Edge[]{new Edge(v611, v612)};
        v612.adjacencies = new Edge[]{new Edge(v612, v611), new Edge(v612, v613), new Edge(v612, v615)};
        v613.adjacencies = new Edge[]{new Edge(v613, v612), new Edge(v613, v614)};
        v614.adjacencies = new Edge[]{new Edge(v614, v613)};
        v615.adjacencies = new Edge[]{new Edge(v615, v612), new Edge(v615, v616)};
        v616.adjacencies = new Edge[]{new Edge(v616, v615), new Edge(v616, v617)};
        v617.adjacencies = new Edge[]{new Edge(v617, v616)};

        computePaths(v611);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v617);
            default:
                return getShortestPathTo(v614);
        }
    }

    private static ArrayList<Vertex> getHenryFourthRoute (int currentArea){

        Vertex v621 = new Vertex("JI", new Point(321,24));
        Vertex v622 = new Vertex("JI", new Point(252,24));
        Vertex v623 = new Vertex("JI", new Point(252,38));
        Vertex v624 = new Vertex("JI", new Point(321,28));
        Vertex v625 = new Vertex("JI", new Point(225,28));
        Vertex v626 = new Vertex("JI", new Point(225,97));
        Vertex v627 = new Vertex("I401", new Point(270,97));

        v621.adjacencies = new Edge[]{new Edge(v621, v622)};
        v622.adjacencies = new Edge[]{new Edge(v622, v621), new Edge(v622, v623)};
        v623.adjacencies = new Edge[]{new Edge(v623, v622), new Edge(v623, v624), new Edge(v623, v625)};
        v624.adjacencies = new Edge[]{new Edge(v624, v623)};
        v625.adjacencies = new Edge[]{new Edge(v625, v623), new Edge(v625, v626)};
        v626.adjacencies = new Edge[]{new Edge(v626, v625), new Edge(v626, v627),};
        v627.adjacencies = new Edge[]{new Edge(v627, v626)};

        computePaths(v621);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v627);
            default:
                return getShortestPathTo(v624);
        }
    }

    private static ArrayList<Vertex> getHenryFifthRoute (int currentArea){

        Vertex v631 = new Vertex("JI", new Point(322,40));
        Vertex v632 = new Vertex("JI", new Point(380,40));
        Vertex v633 = new Vertex("JI", new Point(380,22));
        Vertex v634 = new Vertex("JI", new Point(322,22));
        Vertex v635 = new Vertex("JI", new Point(413,40));
        Vertex v636 = new Vertex("JI", new Point(413,99));
        Vertex v637 = new Vertex("I501", new Point(374,99));

        v631.adjacencies = new Edge[]{new Edge(v631, v632),};
        v632.adjacencies = new Edge[]{new Edge(v632, v631), new Edge(v632, v633), new Edge(v632, v635)};
        v633.adjacencies = new Edge[]{new Edge(v633, v632), new Edge(v633, v634)};
        v634.adjacencies = new Edge[]{new Edge(v634, v633)};
        v635.adjacencies = new Edge[]{new Edge(v635, v632), new Edge(v635, v636),};
        v636.adjacencies = new Edge[]{new Edge(v636, v635), new Edge(v636, v637),};
        v637.adjacencies = new Edge[]{new Edge(v637, v636)};
        computePaths(v631);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v637);
            default:
                return getShortestPathTo(v634);
        }
    }

    private static ArrayList<Vertex> getHenryFourteenthRoute (int currentArea){

        Vertex v641 = new Vertex("JI", new Point(200,162));
        Vertex v642 = new Vertex("JI", new Point(210,162));
        Vertex v643 = new Vertex("I1401", new Point(210,65));
        Vertex v644 = new Vertex("1413", new Point(240,162));

        v641.adjacencies = new Edge[]{new Edge(v641, v642),};
        v642.adjacencies = new Edge[]{new Edge(v642, v641), new Edge(v642, v643), new Edge(v642, v644)};
        v643.adjacencies = new Edge[]{new Edge(v643, v642)};
        v644.adjacencies = new Edge[]{new Edge(v644, v642),};

        computePaths(v641);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v643);
            case 1:
                return getShortestPathTo(v644);
            default:
                return getShortestPathTo(v641);
        }
    }

    private static ArrayList<Vertex> getSjFirstRoute (int currentArea){

        Vertex v501 = new Vertex("JT1", new Point());
        Vertex v502 = new Vertex("JT2", new Point());
        Vertex v503 = new Vertex("JT3", new Point());
        Vertex v504 = new Vertex("JT4", new Point());
        Vertex v505 = new Vertex("", new Point());
        Vertex v506 = new Vertex("", new Point());

        v501.adjacencies = new Edge[]{new Edge(v501, v502)};
        v502.adjacencies = new Edge[]{new Edge(v502, v501), new Edge(v502, v506), new Edge(v502, v503), new Edge(v502, v505)};
        v503.adjacencies = new Edge[]{new Edge(v503, v502), new Edge(v503, v504)};
        v504.adjacencies = new Edge[]{new Edge(v504, v503)};
        v505.adjacencies = new Edge[]{new Edge(v505, v502)};
        v506.adjacencies = new Edge[]{new Edge(v506, v502)};

        computePaths(v501);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v505);
            case 1:
                return getShortestPathTo(v506);
            default:
                return getShortestPathTo(v504);
        }

    }

    private static ArrayList<Vertex> getSjSecondRoute (int currentArea){

        Vertex v511 = new Vertex("JT11", new Point(290,133));
        Vertex v512 = new Vertex("JT12", new Point(322,133));
        Vertex v513 = new Vertex("JT13", new Point(322,150));
        Vertex v514 = new Vertex("T204", new Point(265,150));
        Vertex v515 = new Vertex("T211", new Point(538,150));
        Vertex v516 = new Vertex("JT16", new Point(627,150));
        Vertex v517 = new Vertex("JT17", new Point(627,133));

        v511.adjacencies = new Edge[]{new Edge(v511, v512)};
        v512.adjacencies = new Edge[]{new Edge(v512, v511), new Edge(v512, v513)};
        v513.adjacencies = new Edge[]{new Edge(v513, v512), new Edge(v513, v514), new Edge(v513, v515)};
        v514.adjacencies = new Edge[]{new Edge(v514, v513)};
        v515.adjacencies = new Edge[]{new Edge(v515, v513), new Edge(v515, v516)};
        v516.adjacencies = new Edge[]{new Edge(v516, v515), new Edge(v516, v517)};
        v517.adjacencies = new Edge[]{new Edge(v517, v516)};

        computePaths(v511);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v514);
            case 1:
                return getShortestPathTo(v515);
            default:
                return getShortestPathTo(v517);
        }
    }

    private static ArrayList<Vertex> getSjThirdRoute (int currentArea) {

        Vertex v521 = new Vertex("JT21", new Point(636,147));
        Vertex v522 = new Vertex("JT22", new Point(600,147));
        Vertex v523 = new Vertex("JT23", new Point(600,159));
        Vertex v524 = new Vertex("JT24", new Point(636,159));
        Vertex v525 = new Vertex("JT25", new Point(589,167));
        Vertex v526 = new Vertex("T310", new Point(640,167));
        Vertex v527 = new Vertex("T306", new Point(258,167));

        v521.adjacencies = new Edge[]{new Edge(v521, v522)};
        v522.adjacencies = new Edge[]{new Edge(v522, v521), new Edge(v522, v523)};
        v523.adjacencies = new Edge[]{new Edge(v523, v522), new Edge(v523, v525), new Edge(v523, v524)};
        v524.adjacencies = new Edge[]{new Edge(v524, v523)};
        v525.adjacencies = new Edge[]{new Edge(v525, v523), new Edge(v525, v526)};
        v526.adjacencies = new Edge[]{new Edge(v526, v525), new Edge(v526, v527)};
        v527.adjacencies = new Edge[]{new Edge(v527, v526)};

        computePaths(v521);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v526);
            case 1:
                return getShortestPathTo(v527);
            default:
                return getShortestPathTo(v524);
        }

    }

    private static ArrayList<Vertex> getSjFourthRoute (int currentArea){

        Vertex v531 = new Vertex("JT31", new Point(636,147));
        Vertex v532 = new Vertex("JT32", new Point(600,147));
        Vertex v533 = new Vertex("JT33", new Point(600,159));
        Vertex v534 = new Vertex("JT34", new Point(636,159));
        Vertex v535 = new Vertex("JT35", new Point(589,167));
        Vertex v536 = new Vertex("T412", new Point(545,167));
        Vertex v537 = new Vertex("T408", new Point(317,167));

        v531.adjacencies = new Edge[]{new Edge(v531, v532)};
        v532.adjacencies = new Edge[]{new Edge(v532, v531), new Edge(v532, v533)};
        v533.adjacencies = new Edge[]{new Edge(v533, v532), new Edge(v533, v535), new Edge(v533, v534)};
        v534.adjacencies = new Edge[]{new Edge(v534, v533)};
        v535.adjacencies = new Edge[]{new Edge(v535, v533), new Edge(v535, v536)};
        v536.adjacencies = new Edge[]{new Edge(v536, v535), new Edge(v536, v537)};
        v537.adjacencies = new Edge[]{new Edge(v537, v536)};

        computePaths(v531);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v536);
            case 1:
                return getShortestPathTo(v537);
            default:
                return getShortestPathTo(v534);
        }
    }

    private static ArrayList<Vertex> getSjFifthRoute (int currentArea){

        Vertex v541 = new Vertex("JT41", new Point(636,147));
        Vertex v542 = new Vertex("JT42", new Point(600,147));
        Vertex v543 = new Vertex("JT43", new Point(600,159));
        Vertex v544 = new Vertex("JT44", new Point(636,159));
        Vertex v545 = new Vertex("JT45", new Point(589,167));
        Vertex v546 = new Vertex("T510", new Point(538,167));
        Vertex v547 = new Vertex("T508", new Point(404,167));

        v541.adjacencies = new Edge[]{new Edge(v541, v542)};
        v542.adjacencies = new Edge[]{new Edge(v542, v541), new Edge(v542, v543)};
        v543.adjacencies = new Edge[]{new Edge(v543, v542), new Edge(v543, v545), new Edge(v543, v544)};
        v544.adjacencies = new Edge[]{new Edge(v544, v543)};
        v545.adjacencies = new Edge[]{new Edge(v545, v543), new Edge(v545, v546)};
        v546.adjacencies = new Edge[]{new Edge(v546, v545), new Edge(v546, v547)};
        v547.adjacencies = new Edge[]{new Edge(v547, v546)};

        computePaths(v541);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v546);
            case 1:
                return getShortestPathTo(v547);
            default:
                return getShortestPathTo(v544);
        }
    }

    private static ArrayList<Vertex> getSjSixthRoute (int currentArea) {

        Vertex v551 = new Vertex("JT51", new Point(636,147));
        Vertex v552 = new Vertex("JT52", new Point(600,147));
        Vertex v553 = new Vertex("JT53", new Point(600,159));
        Vertex v554 = new Vertex("JT54", new Point(636,159));
        Vertex v555 = new Vertex("JT55", new Point(589,167));
        Vertex v556 = new Vertex("T612", new Point(483,167));
        Vertex v557 = new Vertex("T609", new Point(330,167));

        v551.adjacencies = new Edge[]{new Edge(v551, v552)};
        v552.adjacencies = new Edge[]{new Edge(v552, v551), new Edge(v552, v553)};
        v553.adjacencies = new Edge[]{new Edge(v553, v552), new Edge(v553, v555), new Edge(v553, v554)};
        v554.adjacencies = new Edge[]{new Edge(v554, v553)};
        v555.adjacencies = new Edge[]{new Edge(v555, v553), new Edge(v555, v556)};
        v556.adjacencies = new Edge[]{new Edge(v556, v555), new Edge(v556, v557)};
        v557.adjacencies = new Edge[]{new Edge(v557, v556)};

        computePaths(v551);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v556);
            case 1:
                return getShortestPathTo(v557);
            default:
                return getShortestPathTo(v551);
        }
    }

    private static ArrayList<Vertex> getStrcFirstRoute (int currentArea){

        Vertex v901 = new Vertex("JO01", new Point(27,301));
        Vertex v902 = new Vertex("JO02", new Point(27,155));
        Vertex v903 = new Vertex("O108", new Point(317,155));
        Vertex v904 = new Vertex("O116", new Point(531,155));

        v901.adjacencies = new Edge[]{new Edge(v901, v902),};
        v902.adjacencies = new Edge[]{new Edge(v902, v901), new Edge(v902, v903)};
        v903.adjacencies = new Edge[]{new Edge(v903, v902), new Edge(v903, v904)};
        v904.adjacencies = new Edge[]{new Edge(v904, v903)};

        computePaths(v901);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v903);
            case 1:
                return getShortestPathTo(v904);
            default:
                return getShortestPathTo(v901);
        }

    }

    /*private static ArrayList<Vertex> getStrcSecondRoute (int currentArea){

    }

    private static ArrayList<Vertex> getStrcThirdRoute (int currentArea){

    }

    private static ArrayList<Vertex> getStrcFourthRoute (int currentArea){

    }*/

    private static ArrayList<Vertex> getYuchThirdRoute (int currentArea){

        Vertex v201 = new Vertex("JD1", new Point(548,128));
        Vertex v202 = new Vertex("D301", new Point(548,211));
        Vertex v203 = new Vertex("D305", new Point(287,211));

        v201.adjacencies = new Edge[]{new Edge(v201,v202)};
        v202.adjacencies = new Edge[]{new Edge(v202,v201), new Edge(v202,v203)};
        v203.adjacencies = new Edge[]{new Edge(v203, v202)};

        computePaths(v201);

        if(targetAreaNumber ==currentArea)
            routeNumber = targetRoomNumber;
        else if(targetAreaNumber <currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v202);
            case 1:
                return getShortestPathTo(v203);
            default:
                return getShortestPathTo(v201);
        }


    }

    private static ArrayList<Vertex> getYuchFourthRoute (int currentArea) {

        Vertex v211 = new Vertex("JD11", new Point(548,128));
        Vertex v212 = new Vertex("D402", new Point(548,211));
        Vertex v213 = new Vertex("D405", new Point(253,211));

        v211.adjacencies = new Edge[]{new Edge(v211, v212)};
        v212.adjacencies = new Edge[]{new Edge(v212, v211), new Edge(v212, v213)};
        v213.adjacencies = new Edge[]{new Edge(v213, v212)};

        computePaths(v211);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v212);
            case 1:
                return getShortestPathTo(v213);
            default:
                return getShortestPathTo(v211);
        }
    }

    private static ArrayList<Vertex> getYuchFifthRoute ( int currentArea){

        Vertex v221 = new Vertex("JD21", new Point(548,128));
        Vertex v222 = new Vertex("D501", new Point(548,211));
        Vertex v223 = new Vertex("D509", new Point(222,211));

        v221.adjacencies = new Edge[]{new Edge(v221, v222)};
        v222.adjacencies = new Edge[]{new Edge(v222, v221), new Edge(v222, v223)};
        v223.adjacencies = new Edge[]{new Edge(v223, v222)};

        computePaths(v221);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v222);
            case 1:
                return getShortestPathTo(v223);
            default:
                return getShortestPathTo(v221);
        }
    }

    private static ArrayList<Vertex> getYuchSixthRoute (int currentArea){

        Vertex v231 = new Vertex("JD31", new Point(548,128));
        Vertex v232 = new Vertex("D601", new Point(548,211));
        Vertex v233 = new Vertex("D607", new Point(205,211));

        v231.adjacencies = new Edge[]{new Edge(v231, v232),};
        v232.adjacencies = new Edge[]{new Edge(v232, v231), new Edge(v232, v233)};
        v233.adjacencies = new Edge[]{new Edge(v233, v232)};

        computePaths(v231);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v232);
            case 1:
                return getShortestPathTo(v233);
            default:
                return getShortestPathTo(v231);
        }
    }

    private static ArrayList<Vertex> getAndrewFirstRoute (int currentArea){

        Vertex v1001 = new Vertex("JR1", new Point(71,177));
        Vertex v1002 = new Vertex("JR2", new Point(140,177));
        Vertex v1003 = new Vertex("JR3", new Point(140,203));
        Vertex v1004 = new Vertex("JR4", new Point(332,203));
        Vertex v1005 = new Vertex("JR5", new Point(332,172));

        v1001.adjacencies = new Edge[]{new Edge(v1001, v1002)};
        v1002.adjacencies = new Edge[]{new Edge(v1002, v1001), new Edge(v1002, v1003)};
        v1003.adjacencies = new Edge[]{new Edge(v1003, v1002), new Edge(v1003, v1004)};
        v1004.adjacencies = new Edge[]{new Edge(v1004, v1003), new Edge(v1004, v1005)};
        v1005.adjacencies = new Edge[]{new Edge(v1005, v1004)};

        computePaths(v1001);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            default:
                return getShortestPathTo(v1005);
        }

    }

    private static ArrayList<Vertex> getAndrewEightRoute (int currentArea){

        Vertex v1011 = new Vertex("JR11", new Point(321,171));
        Vertex v1012 = new Vertex("JR12", new Point(321,204));
        Vertex v1013 = new Vertex("R807", new Point(131,204));
        Vertex v1014 = new Vertex("R801", new Point(514,204));

        v1011.adjacencies = new Edge[]{new Edge(v1011, v1012)};
        v1012.adjacencies = new Edge[]{new Edge(v1012, v1011), new Edge(v1012, v1014), new Edge(v1012, v1013),};
        v1013.adjacencies = new Edge[]{new Edge(v1013, v1012)};
        v1014.adjacencies = new Edge[]{new Edge(v1014, v1012)};

        computePaths(v1011);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v1013);
            case 1:
                return getShortestPathTo(v1014);
            default:
                return getShortestPathTo(v1011);
        }
    }

    private static ArrayList<Vertex> getAndrewNinthRoute (int currentArea){

        Vertex v1021 = new Vertex("JR21", new Point(321,171));
        Vertex v1022 = new Vertex("JR22", new Point(321,204));
        Vertex v1023 = new Vertex("R907", new Point(151,204));
        Vertex v1024 = new Vertex("R905", new Point(380,204));

        v1021.adjacencies = new Edge[]{new Edge(v1021, v1022)};
        v1022.adjacencies = new Edge[]{new Edge(v1022, v1022), new Edge(v1022, v1024), new Edge(v1022, v1023),};
        v1023.adjacencies = new Edge[]{new Edge(v1023, v1022)};
        v1024.adjacencies = new Edge[]{new Edge(v1024, v1022)};

        computePaths(v1021);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v1023);
            case 1:
                return getShortestPathTo(v1024);
            default:
                return getShortestPathTo(v1021);
        }
    }

    private static ArrayList<Vertex> getWilliamFirstRoute (int currentArea){

        Vertex v401 = new Vertex("JH01", new Point(269,163));
        Vertex v402 = new Vertex("JH02", new Point(296,163));
        Vertex v403 = new Vertex("JH03", new Point(296,116));
        Vertex v404 = new Vertex("JH04", new Point(335,116));

        v401.adjacencies = new Edge[]{new Edge(v401, v402),};
        v402.adjacencies = new Edge[]{new Edge(v402, v401), new Edge(v402, v403)};
        v403.adjacencies = new Edge[]{new Edge(v403, v402), new Edge(v403, v404)};
        v404.adjacencies = new Edge[]{new Edge(v404, v403)};

        computePaths(v401);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            default:
                return getShortestPathTo(v401);
        }
    }

    private static ArrayList<Vertex> getWilliamSecondRoute (int currentArea){
        Vertex v411 = new Vertex("JH11", new Point(326,98));
        Vertex v412 = new Vertex("JH12", new Point(301,98));
        Vertex v413 = new Vertex("H201", new Point(301,156));
        Vertex v414 = new Vertex("H202", new Point(301,261));

        v411.adjacencies = new Edge[]{new Edge(v411, v412),};
        v412.adjacencies = new Edge[]{new Edge(v412, v411), new Edge(v412, v413)};
        v413.adjacencies = new Edge[]{new Edge(v413, v412), new Edge(v413, v414)};
        v414.adjacencies = new Edge[]{new Edge(v414, v413)};
        computePaths(v411);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v413);
            case 1:
                return getShortestPathTo(v414);
            default:
                return getShortestPathTo(v411);
        }
    }

    private static ArrayList<Vertex> getWilliamThirdRoute(int currentArea){
        Vertex v421 = new Vertex("JH21", new Point(313,77));
        Vertex v422 = new Vertex("H301", new Point(289,77));
        Vertex v423 = new Vertex("H303", new Point(289,252));

        v421.adjacencies = new Edge[]{new Edge(v421, v422),};
        v422.adjacencies = new Edge[]{new Edge(v422, v421), new Edge(v422, v423)};
        v423.adjacencies = new Edge[]{new Edge(v423, v422)};

        computePaths(v421);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v422);
            case 1:
                return getShortestPathTo(v423);
            default:
                return getShortestPathTo(v421);
        }
    }

    private static ArrayList<Vertex> getJohnSecondRoute(int currentArea){
        Vertex v1211 = new Vertex("JB11", new Point(15,206));
        Vertex v1212 = new Vertex("JB12", new Point(15,272));
        Vertex v1213 = new Vertex("JB13", new Point(68,272));
        Vertex v1214 = new Vertex("JB14", new Point(68,228));
        Vertex v1215 = new Vertex("B201", new Point(150,272));
        Vertex v1216 = new Vertex("B202", new Point(240,272));

        v1211.adjacencies = new Edge[]{new Edge(v1211, v1212),};
        v1212.adjacencies = new Edge[]{new Edge(v1212, v1211), new Edge(v1212, v1213)};
        v1213.adjacencies = new Edge[]{new Edge(v1213, v1212), new Edge(v1213, v1214), new Edge(v1213, v1215)};
        v1214.adjacencies = new Edge[]{new Edge(v1214, v1213),};
        v1215.adjacencies = new Edge[]{new Edge(v1215, v1213), new Edge(v1215, v1216)};
        v1216.adjacencies = new Edge[]{new Edge(v1216, v1215)};

        computePaths(v1211);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v1215);
            case 1:
                return getShortestPathTo(v1216);
            default:
                return getShortestPathTo(v1214);
        }
    }

    private static ArrayList<Vertex> getJohnThirdRoute(int currentArea){
        Vertex v1221 = new Vertex("JB21", new Point(15,272));
        Vertex v1222 = new Vertex("JB22", new Point(68,272));
        Vertex v1223 = new Vertex("B301", new Point(150,272));
        Vertex v1224 = new Vertex("B302", new Point(240,272));

        v1221.adjacencies = new Edge[]{new Edge(v1221, v1222),};
        v1222.adjacencies = new Edge[]{new Edge(v1222, v1221), new Edge(v1222, v1223)};
        v1223.adjacencies = new Edge[]{new Edge(v1223, v1222), new Edge(v1223, v1224)};
        v1224.adjacencies = new Edge[]{new Edge(v1224, v1223),};

        computePaths(v1221);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v1223);
            case 1:
                return getShortestPathTo(v1224);
            default:
                return getShortestPathTo(v1221);
        }
    }

    private static ArrayList<Vertex> getLSFirstRoute(int currentArea){
        Vertex v101 = new Vertex("JA01", new Point(614,192));
        Vertex v102 = new Vertex("JA02", new Point(560,192));
        Vertex v103 = new Vertex("JA03", new Point(560,221));
        Vertex v104 = new Vertex("JA04", new Point(589,221));
        Vertex v105 = new Vertex("A125", new Point(525,192));
        Vertex v106 = new Vertex("A113", new Point(256,192));

        v101.adjacencies = new Edge[]{new Edge(v101, v102),};
        v102.adjacencies = new Edge[]{new Edge(v102, v101), new Edge(v102, v103)};
        v103.adjacencies = new Edge[]{new Edge(v103, v102), new Edge(v103, v104)};
        v104.adjacencies = new Edge[]{new Edge(v104, v103)};
        v105.adjacencies = new Edge[]{new Edge(v105, v102), new Edge(v105, v106)};
        v106.adjacencies = new Edge[]{new Edge(v106, v105)};

        computePaths(v101);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v105);
            case 1:
                return getShortestPathTo(v106);
            default:
                return getShortestPathTo(v104);
        }
    }

    private static ArrayList<Vertex> getLSSecondRoute(int currentArea){
        Vertex v121 = new Vertex("JA21", new Point(571,221));
        Vertex v122 = new Vertex("JA22", new Point(558,221));
        Vertex v123 = new Vertex("JA23", new Point(558,192));
        Vertex v124 = new Vertex("A219", new Point(477,192));
        Vertex v125 = new Vertex("A215", new Point(370,192));

        v121.adjacencies = new Edge[]{new Edge(v121, v122),};
        v122.adjacencies = new Edge[]{new Edge(v122, v121), new Edge(v122, v123)};
        v123.adjacencies = new Edge[]{new Edge(v123, v122), new Edge(v123, v124)};
        v124.adjacencies = new Edge[]{new Edge(v124, v123), new Edge(v124, v125)};
        v125.adjacencies = new Edge[]{new Edge(v125, v124)};

        computePaths(v121);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v124);
            case 1:
                return getShortestPathTo(v125);
            default:
                return getShortestPathTo(v121);
        }
    }

    private static ArrayList<Vertex> getRazonFirstRoute(int currentArea){
        Vertex v421 = new Vertex("JH21", new Point(313,77));
        Vertex v422 = new Vertex("H301", new Point(289,77));
        Vertex v423 = new Vertex("H303", new Point(289,252));

        v421.adjacencies = new Edge[]{new Edge(v421, v422),};
        v422.adjacencies = new Edge[]{new Edge(v422, v421), new Edge(v422, v423)};
        v423.adjacencies = new Edge[]{new Edge(v423, v422)};

        computePaths(v421);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v422);
            case 1:
                return getShortestPathTo(v423);
            default:
                return getShortestPathTo(v421);
        }
    }

    private static ArrayList<Vertex> getRazonSeventhRoute(int currentArea){
        Vertex v421 = new Vertex("JH21", new Point(313,77));
        Vertex v422 = new Vertex("H301", new Point(289,77));
        Vertex v423 = new Vertex("H303", new Point(289,252));

        v421.adjacencies = new Edge[]{new Edge(v421, v422),};
        v422.adjacencies = new Edge[]{new Edge(v422, v421), new Edge(v422, v423)};
        v423.adjacencies = new Edge[]{new Edge(v423, v422)};

        computePaths(v421);

        if (targetAreaNumber == currentArea)
            routeNumber = targetRoomNumber;
        else if (targetAreaNumber < currentArea)
            return null;
        else
            routeNumber = -1;

        switch (routeNumber) {
            case 0:
                return getShortestPathTo(v423);
            default:
                return getShortestPathTo(v421);
        }
    }


}




