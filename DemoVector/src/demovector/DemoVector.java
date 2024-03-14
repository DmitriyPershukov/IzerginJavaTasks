package demovector;

import vector.Vector;
import vector.VectorActions;

public class DemoVector {

    public static void main(String[] args) {
        Vector v = Vector.createVectorFromValues(-4, 4, 2);
        System.out.println(v.getModule());
        Vector v1 = Vector.createVectorFromValues(4, 5, 2);
        Vector v2 = Vector.createVectorFromValues(3, 2, 3);
        System.out.println(VectorActions.dotProduct(v1, v2));
        System.out.println(VectorActions.add(v1, v2));
        System.out.println(VectorActions.subtract(v1, v2));
        System.out.println(VectorActions.multiplyByScalar(v2, 3));
    }
}
