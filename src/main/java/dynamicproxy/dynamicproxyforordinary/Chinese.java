package dynamicproxy.dynamicproxyforordinary;

public class Chinese implements Person {
    int i = 0;
    public void sayHello(String str) {
        System.out.println("这是我第"+i+"次说"+str+"。");
    }

    public void sayGoodBye(){
        System.out.println("这是我第"+i+"次说再见。");
    }
}
