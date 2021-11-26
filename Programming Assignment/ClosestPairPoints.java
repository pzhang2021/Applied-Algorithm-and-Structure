import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClosestPairPoints {

  public static void main(String[] args) {
    ArrayList<Point> data = new ArrayList<>();
    try {
      /** rename the directory **/
      File myObj = new File("/Users/pengju/IdeaProjects/LearnJava/src/Demo11/1000points.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        Scanner line = new Scanner(myReader.nextLine());
        // String line = myReader.nextLine();
        ArrayList<Integer> temp = new ArrayList<>();
        while(line.hasNext()) {
          temp.add(Integer.parseInt(line.next()));
        }
        data.add(new Point(temp.get(0), temp.get(1)));
        // System.out.println(data.get(data.size()-1).x + " " + data.get(data.size()-1).y);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    res(data);
  }

  private static double dist(Point p1, Point p2) {
    double dx = p2.getX() - p1.getX();
    double dy = p2.getY() - p1.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

  private static ArrayList<Point> getResult(ArrayList<Point> data) {
    double minDistance = Integer.MAX_VALUE;
    ArrayList<Point> closestTwoPoints = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      for (int j = i + 1; j < data.size(); j ++) {
        double currentDistance = dist(data.get(i), data.get(j));
        if (currentDistance < minDistance) {
          minDistance = currentDistance;
          closestTwoPoints.add(data.get(i));
          closestTwoPoints.add(data.get(j));
        }
      }
    }
    return closestTwoPoints;
  }

  private static void res(ArrayList<Point> data) {
    ArrayList<Point> twoPoints = getResult(data);
    Point p1 = twoPoints.get(twoPoints.size() - 2);
    Point p2 = twoPoints.get(twoPoints.size() - 1);
    System.out.println("The minimum distance is: ");
    System.out.println(dist(p1, p2) + ": " + "(" + p1.getX() + ", " + p1.getY() + ")<--->("+ p2.getX() + ", " + p2.getY() + ")");
  }
}
