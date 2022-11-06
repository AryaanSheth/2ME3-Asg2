// Singleton Obj for HomeBase
public class homeBase{
    private static homeBase instance = null;
    private int key;

    private homeBase() {} // void construct

    public static homeBase getInstance() {
        if (instance == null) {
            System.out.println("Creating new instance");
            instance = new homeBase();
        }
        return instance;
    }
}