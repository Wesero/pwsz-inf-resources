import java.util.Random;



class Point {

    public float x;
    public float y;


    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void movePoint(float xAxisShift, float yAxisShift) {
        this.x += xAxisShift;
        this.y += yAxisShift;
    }
}




class Square {
    public Point center;
    public float side;
    public Point A;
    public Point B;
    public Point C;
    public Point D;

    public Square(Point center, float side) {
        this.center = center;
        this.side = side;
    }

    public void printCoordinates() {
        System.out.println("\nSquare center");
        System.out.println("x: " + this.center.x);
        System.out.println("y: " + this.center.y);
        System.out.println("Side: " + this.side);
    }

    public void PointsCoordinates() {

         A = new Point  ((this.center.x - (this.side/2)) , (this.center.y - (this.side/2)));
         B = new Point  ((this.center.x + (this.side/2)) , (this.center.y - (this.side/2)));
         C = new Point  ((this.center.x + (this.side/2)) , (this.center.y + (this.side/2)));
         D = new Point  ((this.center.x - (this.side/2)) , (this.center.y + (this.side/2)));

    }

    public void printPointsCoordinates() {
    System.out.println("\nSquare points:");
    System.out.println("A ( " + A.x + " , " + A.y + " )");
    System.out.println("B ( " + B.x + " , " + B.y + " )");
    System.out.println("C ( " + C.x + " , " + C.y + " )");
    System.out.println("D ( " + D.x + " , " + D.y + " )");

     }
}





public class Main {

    public static void main(String[] args) {
        float inputX = 0;
        float inputY = 0;
        int n=5;
        float inputSide;

        Point point = new Point(inputX, inputY);
        for(int i=0;i<n;i++) {
            inputSide = Main.getRandomNumber();
            Square square = new Square(point, inputSide);
            square.center.movePoint(Main.getRandomNumber(), Main.getRandomNumber());
            square.printCoordinates();
            square.PointsCoordinates();
            square.printPointsCoordinates();
        }
    }

    public static float getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(10);
    }

}