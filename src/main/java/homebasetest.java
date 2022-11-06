public class homebasetest {
    public static void main(String[] args) {
        homeBase base = homeBase.getInstance();
        System.out.println(base.encrypt("Hello World", 5));
        System.out.println(base.decrypt("Mjqqt%\\twqi", 5));
    }
}
