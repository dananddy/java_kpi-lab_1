package main;



import java.util.Arrays;
import java.util.Objects;

public class Triangle {
    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;
    private int aSide;
    private int bSide;
    private int cSide;

    public Triangle(int x1,int x2,int x3, int y1, int y2, int y3){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.aSide = calcSideLength(x1,x2,y1,y2);
        this.bSide = calcSideLength(x2,x3,y2,y3);
        this.cSide = calcSideLength(x3,x1,y3,y1);

    }


    public int getaSide() {
        return aSide;
    }

    public int getbSide() {
        return bSide;
    }

    public int getcSide() {
        return cSide;
    }

    private int calcSideLength(int x1, int x2, int y1, int y2){
        return (int)Math.sqrt( (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
    }

    public String checkType(){
        String triangleType = new String();
        if ((aSide+bSide <= cSide) || (aSide+cSide <= bSide) || (bSide+cSide <= aSide)) {
            triangleType+="Такой треугольник не существует.";
        }
        else
            if ((aSide != bSide) &&  (aSide != cSide) && (bSide != cSide)){
                triangleType+= "Это разносторонний треугольник.";
            }
        else
            if ((aSide == bSide) && (bSide == cSide)){
                triangleType+= "Это равносторонний треугольник.";
            }
            else
                if((aSide == (Math.sqrt(bSide*bSide+cSide*cSide)))
                    ||((bSide == (Math.sqrt(aSide*aSide+cSide*cSide)))
                    ||((cSide == (Math.sqrt(bSide*bSide+aSide*aSide)))))){
                    triangleType+= "Это прямоугольный треугольник.";
            }
            else triangleType+= "Это равнобедренный треугольник.";
            return triangleType;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;

        return
                x1 == triangle.x1 &&
                x2 == triangle.x2 &&
                x3 == triangle.x3 &&
                y1 == triangle.y1 &&
                y2 == triangle.y2 &&
                y3 == triangle.y3 &&
                aSide == triangle.aSide &&
                bSide == triangle.bSide &&
                cSide == triangle.cSide;

    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2, x3, y1, y2, y3, aSide, bSide, cSide);
    }

}
