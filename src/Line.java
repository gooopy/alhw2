/**
 * Created by hyunseok on 9/15/15.
 */
public class Line {
    public static final double MAX_SLOPE = -100000;

    private Point p1;
    private Point p2;
    private Point p3;
    private double slope;

    public Line(Point p, Point q, Point r){
        p1 = p;
        p2 = q;
        p3 = r;

        if(p.getX() == q.getX()) {
            slope = MAX_SLOPE;
        } else {
            slope = ((double)p.getY() - (double)q.getY()) / ((double)p.getX() - (double)q.getX());
        }
    }

    public double getSlope(){
        return slope;
    }

    public Point getP1(){
        return p1;
    }

    public Point getP2(){
        return p2;
    }

    public Point getP3(){
        return p3;
    }

    public void print(){
        System.out.printf("%d %d \t", p1.getX(), p1.getY());
        System.out.printf("%d %d \t", p2.getX(), p2.getY());
        System.out.printf("%d %d \n", p3.getX(), p3.getY());
    }

    public boolean isSame(Line l){
        int cnt = 0;

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;

        if(p1.isSame(l.p1) && !flag1){
            cnt++;
            flag1 = !flag1;
        }

        if(p1.isSame(l.p2) && !flag2) {
            cnt++;
            flag2 = !flag2;
        }

        if(p1.isSame(l.p3) && !flag3) {
            cnt++;
            flag3 = !flag3;
        }

        if(p2.isSame(l.p1) && !flag1){
            cnt++;
            flag1 = !flag1;
        }
        if(p2.isSame(l.p2) && !flag2){
            cnt++;
            flag2 = !flag2;
        }
        if(p2.isSame(l.p3) && !flag3){
            cnt++;
            flag3 = !flag3;
        }

        if(p3.isSame(l.p1) && !flag1){
            cnt++;
            flag1 = !flag1;
        }
        if(p3.isSame(l.p2) && !flag2){
            cnt++;
            flag2 = !flag2;
        }
        if(p3.isSame(l.p3) && !flag3){
            cnt++;
            flag3 = !flag3;
        }

        if(cnt > 1) return true;

        return false;
    }

    public Point crossingPoint(Line l){

        if(p1.isSame(l.p1) || p1.isSame(l.p2) || p1.isSame(l.p3)){
            return p1;
        }


        if(p2.isSame(l.p1) || p2.isSame(l.p2) || p2.isSame(l.p3)){
            return p2;
        }

        if(p3.isSame(l.p1) || p3.isSame(l.p2) || p3.isSame(l.p3)){
            return p3;
        }

        Point temp = new Point(-1, -1);
        return temp;
    }
}
