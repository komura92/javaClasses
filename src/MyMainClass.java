class Outer {
    //default access is package-private (public in package)
    int outerField = 1;
    private int outerPrivateField = 2; //no access from child objects | if needed -> protected

    class Inner {
        int innerField = 3;
    }

    static class StaticInner {
        int staticInnerField = 4;
    }
}

class Child extends Outer {
    int childField = 5;

    public Child() {
        //this.outerPrivateField = 10; //NO ACCESS!!!
    }
}

public class MyMainClass {
    public static void main(String[] args) {
        //Creating instance of inner class
        Outer outer = new Outer();

        //Creating instance of child class
        Child child = new Child();

        //Creating instance of inner class
        Outer.Inner inner1 = new Outer().new Inner();
        Outer.Inner inner2 = outer.new Inner();
        Child.Inner inner3 = new Child().new Inner();
        Child.Inner inner4 = child.new Inner();


        //Creating instance of static inner class
        Outer.StaticInner staticInner1 = new Outer.StaticInner();
        Child.StaticInner staticInner2 = new Child.StaticInner();


        System.out.println(outer.outerField);

        System.out.println(child.outerField);
        System.out.println(child.childField);

        System.out.println(inner1.innerField);

        System.out.println(staticInner1.staticInnerField);
    }
}