
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
         * File I/O stream set-up
         */

        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        File inFile = new File(inputFilePath);
        FileWriter outFile = new FileWriter(outputFilePath);

        BufferedWriter writeFile = new BufferedWriter(outFile);


        Scanner sc = null;
        try {
            sc = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int caseNum = sc.nextInt();
        sc.nextLine();
        sc.nextLine();

        for(int i=0; i<caseNum; i++){
            int pointNum = sc.nextInt();
            LinkedList<Point> pointList = new LinkedList<Point>();
            LinkedList<Line> lineList = new LinkedList<Line>();
            LinkedList<Point> crossingPoints = new LinkedList<Point>();
            Set<Point> result = new HashSet<Point>();

            ArrayList<Point> sortedResult = new ArrayList<Point>();




            for(int j=0; j<pointNum; j++){
                Point temp = new Point(sc.nextInt(), sc.nextInt());
                pointList.add(temp);
            }



            for(int p=0; p<pointList.size()-2; p++){
                for(int q = p+1; q<pointList.size()-1; q++){
                    for(int r = q+1; r<pointList.size(); r++){
                        if(pointList.get(p).isLine(pointList.get(q), pointList.get(r))){
                            Line temp = new Line(pointList.get(p), pointList.get(q), pointList.get(r));
                            lineList.add(temp);
                        }
                    }
                }
            }
            

            for(int b=0; b<lineList.size(); b++){
                lineList.get(b).print();
            }

            for(int l=0; l<lineList.size()-1; l++){
                for(int m=l+1; m<lineList.size(); m++){
                    lineList.get(l);
                    lineList.get(m);

                    if(lineList.get(l).isSame(lineList.get(m))) {
                        continue;
                    } else {
                        Point tmp = lineList.get(l).crossingPoint(lineList.get(m));
                        if(tmp.getX() == -1) {
                            continue;
                        } else {
                            crossingPoints.add(tmp);
                        }
                    }


                }
            }



            for(int c=0; c<crossingPoints.size(); c++){
                result.add(crossingPoints.get(c));
            }


            writeFile.write(Integer.toString(result.size()));
            writeFile.newLine();

            for(Point p : result){
                sortedResult.add(p);
            }

            Collections.sort(sortedResult);


            for (Point p : sortedResult) {
                StringBuilder sb = new StringBuilder();
                sb.append(p.getX());
                sb.append(" ");
                sb.append(p.getY());
                sb.append("\n");
                writeFile.write(sb.toString());


                System.out.printf("%d %d \n", p.getX(), p.getY());

            }



            writeFile.newLine();




        }

        writeFile.close();


    }
}
