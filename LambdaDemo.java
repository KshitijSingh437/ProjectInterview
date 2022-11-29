package interviewQues;


interface A {

    void show();

}

//class XYZ implements A {
//
//    @Override
//    public void show() {
//        System.out.println("Hello");
//    }
//}

public class LambdaDemo {


    public static void main(String[] args) {

//        // A obj = new XYZ();
//        A obj = new A(){ --> Anonymous Inner Class
//
//            @Override
//            public void show() {
//                System.out.println("Hello")
//            }
//        };
        A obj = () -> System.out.println("Hello");
        obj.show();

    }
}
