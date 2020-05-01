package DesignPattern;

/**
 * https://www.runoob.com/design-pattern/singleton-pattern.html
 * 菜鸟教程详细解释 
 */
public class Singleton1 {
    //懒汉模式
    private static Singleton1 firstinstance = null;

    private Singleton1(){}

    public synchronized static Singleton1 getInstance(){
        if (firstinstance == null)
        {
            firstinstance = new Singleton1();
        }
        return firstinstance;
    }
}
