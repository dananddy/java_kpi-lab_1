package main;

import java.util.HashSet;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Triangle> triangles = new HashSet<>();

        Triangle triangle1 = new Triangle(34,234,12,141,34,100);
        Triangle triangle2 = new Triangle(100,0,0,0,0,100);
        Triangle triangle3 = new Triangle(13,2,23,2,89,10);

        triangles.add(triangle1);
        triangles.add(triangle2);
        triangles.add(triangle3);

        for(Triangle triangle: triangles){
            System.out.println( triangle.getaSide()+" "+ triangle.getbSide()+" "+ triangle.getcSide());
            System.out.println(triangle.checkType());
        }
        System.out.println(triangles.size());

    }


}
