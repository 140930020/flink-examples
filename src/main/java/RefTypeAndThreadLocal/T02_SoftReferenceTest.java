package RefTypeAndThreadLocal;

import java.lang.ref.SoftReference;

/**
 * @author tangqiuyue
 * @author 2022/8/30
 */
public class T02_SoftReferenceTest {

    public static void main(String[] args) {

        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(softReference.get());
        //再分配一个数组，heap装不下，这个时候系统会垃圾回收，先回收一次，如果不够，会把软引用T掉
        byte[] bytes = new byte[1024 * 1024 * 15];
        System.out.println(softReference.get());

    }
}
