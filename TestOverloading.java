package interviewQues;

public class TestOverloading {
    TestOverloading(byte a, long b) {
        System.out.println("a = " + a + " b = " + b);
    }

    TestOverloading(float a, int b) {
        System.out.println("a = " + a + " b = " + b);
    }

    TestOverloading(int a, float b) {
        System.out.println("a = " + a + " b = " + b);
    }

    public static void main(String[] args) {
        byte a = 10;
        byte b = 15;
        TestOverloading test = new TestOverloading(b, (long) a);

        String s1 = "code";
        String s2 = "code";
        s2.intern();
        System.out.println(s1 == s2);
    }
}
