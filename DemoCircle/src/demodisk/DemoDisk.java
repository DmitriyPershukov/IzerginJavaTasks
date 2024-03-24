package demodisk;

import disk.Disk;
import disk.Point;

public class DemoDisk {

    public static void main(String[] args) {
        Point center = new Point(3, 5);
        Disk disk = new Disk(center, 7);
        System.out.println(disk.IsPointInsideCircle(new Point(1, 2)));
        System.out.println(disk.IsPointInsideCircle(new Point(23, 4)));
        disk.setCenter(new Point(5, 8));
        disk.setRadius(5);
    }
}
