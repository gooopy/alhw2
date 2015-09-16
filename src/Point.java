/**
 * Created by hyunseok on 9/15/15.
 */



public class Point implements Comparable<Point>{
    public static final float MAX_SLOPE = -100000;

    protected int x;
    protected int y;

    public Point(int _x, int _y){
        x = _x;
        y = _y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int newX){
        x = newX;
    }

    public void setY(int newY){
        y = newY;
    }

    public boolean isLine(Point q, Point r){
        Point p = this;
        float firstSlope;
        float secondSlope;

        if(p.getX() == q.getX()){
            firstSlope = MAX_SLOPE;
        } else {
            firstSlope = ((float)p.getY() - (float)q.getY()) / ((float)p.getX() - (float)q.getX());
        }

        if(q.getX() == r.getX()){
            secondSlope = MAX_SLOPE;
        } else {
            secondSlope = ((float)q.getY() - (float)r.getY()) / ((float)q.getX() - (float)r.getX());
        }


        if(firstSlope == secondSlope) {
            System.out.println(firstSlope + " " +secondSlope);
            return true;
        }

        return false;
    }

    public boolean isSame(Point p){
        if(x == p.getX() && y == p.getY()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Point p){
        if(x == p.getX()){
            return y - p.getY();
        }

        return x - p.getX();

    }
}

