package Chapter01;

/**
 * @author zhangjingyu
 * @version V1.0.0
 * @Title: ConcurrenTest
 * @Package Chapter01
 * @Description: TODO
 * @date 2020/8/15 18:36
 */
public class ConcurrenTest {
    private static final long COUNT = 1000000001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    /**
     * @return void
     * @Title concurrency
     * @Description //TODO
     * @author zhangjingyu
     * @date 2020/8/15 18:47
     * @version V1.0.0
     */
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < COUNT; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency:" + time + "ms,b=" + b);
    }

    /**
     * @return void
     * @Title serial
     * @Description //TODO
     * @author zhangjingyu
     * @date 2020/8/15 18:47
     * @version V1.0.0
     */
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }
}
