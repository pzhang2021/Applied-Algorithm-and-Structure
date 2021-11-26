package Demo10;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JarvisMarchAlgorithm {

  public static void main(String[] args) {
    ArrayList<Point> data = new ArrayList<>();
    try {
      /** rename the directory **/
      File myObj = new File("/Users/pengju/IdeaProjects/LearnJava/src/Demo10/case6.txt");
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

    // System.out.println(convexHull(data));
    for(int i: convexHull(data)) {
      System.out.println(data.get(i).x + " " + data.get(i).y);
    }
  }

  private static boolean CCW(Point p, Point q, Point r)
  {
    int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

    if (val >= 0)
      return false;
    return true;
  }

  public static ArrayList<Integer> convexHull(ArrayList<Point> points)
  {
    int n = points.size();
    ArrayList<Integer> next = new ArrayList<>();

    int leftMost = 0;
    for (int i = 1; i < n; i++)
      if (points.get(i).x < points.get(leftMost).x)
        leftMost = i;
    int p = leftMost, q;

    next.add(p);
    do
    {
      q = (p + 1) % n;
      for (int i = 0; i < n; i++)
        if (CCW(points.get(p), points.get(i), points.get(q)))
          q = i;

      next.add(q);
      p = q;
    } while (p != leftMost);
    return next;
  }


}
