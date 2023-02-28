package RefTypeAndThreadLocal;

/**
 * @author tangqiuyue
 * @author 2022/8/30
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        //没死的时候调用
        System.out.println("finalize");
    }
}
