package RefTypeAndThreadLocal;

import java.io.IOException;

/**
 * @author tangqiuyue
 * @author 2023/2/28
 * 强引用
 */
public class T01_NormalReference {
    public static void main(String[] args) throws IOException {
        M m=new M();
        m=null;
        System.gc();        //DisableExceptionGC
        System.out.println(m);
        System.in.read();  //阻塞main线程，给垃圾回收线程时间执行
    }
}
