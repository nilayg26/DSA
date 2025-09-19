package LabCat;

import java.util.ArrayList;

public class JarvisMarch  {
    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object p2){
            if (p2.getClass()== this.getClass()) {
                Point p3= (Point) p2;
                return this.x==p3.x && this.y==p3.y;
            }
            return false;
        }
        @Override
        public String toString(){
            return this.x +","+this.y;
        }
    }
    public static void main(String[] args) {
        Point[] points = {
                new Point(0, 3),
                new Point(2, 2),
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 0),
                new Point(0, 0),
                new Point(3, 3),
                new Point(1, 2),
                new Point(4, 2),
                new Point(2, 4)
        };
        Point minX= points[0];
        for(int i=0;i<10;i++){
            if(minX.x>points[i].x){
                minX=points[i];
            }
        }
        Point onHull=minX;
        ArrayList <Point> list = new ArrayList<>(); 
        //O(n*h)
        while (true) {
            list.add(onHull);
            Point nextPoint = points[0];
            for (int i = 0; i < points.length; i++) {
                if (nextPoint.equals(onHull) || isCounterClockwise(onHull, nextPoint, points[i])==1) {
                    nextPoint = points[i];
                }
                else if(isCounterClockwise(onHull, nextPoint,points[i])==0){
                    if (distanceSquared(points[i], onHull)>distanceSquared(nextPoint, onHull)) {
                        nextPoint=points[i];
                    }
                }
            }
            onHull = nextPoint;
            if (onHull.equals(list.get(0))) {
                break;
            }
        }
        System.out.println(list);
    }
    private static int isCounterClockwise(Point p1, Point p2,Point p3){ 
        int val =((p3.y-p2.y)*(p2.x-p1.x))-((p2.y-p1.y)*(p3.x-p2.x));
        if (val >0) {
            return 1;
        }
        else if(val==0){
            return 0;
        }
        else{
            return -1;
        }
    }
    private static int distanceSquared(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
