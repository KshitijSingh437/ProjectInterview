package interviewQues;

public class SingletonImp {

    public String s;

    private SingletonImp() {
        s = "Hello I am a string part of Singleton class";
    }

    public static SingletonImp getInstance() {
        return InnerSingleton.INSTANCE;
    }

    static class InnerSingleton {
        private static final SingletonImp INSTANCE = new SingletonImp();
    }
}
