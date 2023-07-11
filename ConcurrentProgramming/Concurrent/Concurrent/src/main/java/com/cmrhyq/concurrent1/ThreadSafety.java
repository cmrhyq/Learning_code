package com.cmrhyq.concurrent1;

import java.util.concurrent.CountDownLatch;

/**
 * <h1 style="color:white">经典关于线程安全的i++问题</h1>
 * <div>
 *  &nbsp;&nbsp;代码模拟了 100 个线程同时对 i 变量执行 100 次 i++ 的操作，但是最终的执行结果并非是 10000，
 *  而且大概率会是一个小于 10000 的数字。通过这个实验我们可以得出一个结论，
 *  那就是：<span style="color:red">i++ 语句并不是一条原子性的指令，它存在着线程安全问题</span>
 * </div>
 * <hr/>
 * <div>
 *  &nbsp;&nbsp;从cpu的角度来看i++的核心部分由3调指令构成
 *  <div style="border: 1px solid #7b8380;">
 *   mov eax, DWORD PTR i[rip]<br/>
 *   add eax, 1<br/>
 *   mov DWORD PTR i[rip], eax
 *  </div>
 *  &nbsp;&nbsp;mov 指令会先将 i 变量加载到 eax 累加寄存器中，然后在寄存器中做加 1 操作，接着才是将加 1 之后的结果放回到i变量原先的内存地址中
 * </div>
 * <div>
 *  &nbsp;&nbsp;不同线程在执行的时候，各自的 eax 累加寄存器中的数值不相同，
 *  从而导致最终i被两次更新，但值却不是 2。
 *  <br/>
 *  例如 i=0 的时候，会有多个 eax 累加器同时执行 i++，最后得到的结果是只有一次的i++
 * </div>
 * <div>
 *  &nbsp;&nbsp;这类现象就是我们常说的线程安全问题了。如果需要解决这类问题，
 *  其实只需要保证每个线程在执行i++ 指令的时候都是一个原子操作即可，例如通过加入一道屏障指令,
 *  通过加入一到屏障指令可以保证数据在被多个线程访问的过程中一次只能有一个线程操作它，
 *  而且下一个线程会处于等待状态。
 * </div>
 * @author Alan Huang
 * @version v0.0.1
 * @project Concurrent
 * @docRoot com.cmrhyq.concurrent1
 * @date 2023-02-16 16:23
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ThreadSafety {

    private static int i = 0;

    static class IncrTask implements Runnable {
        CountDownLatch start;
        CountDownLatch end;

        public IncrTask(CountDownLatch start, CountDownLatch end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public void run() {
            try {
                start.await();
                for (int j = 0; j < 100; j++) {
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                end.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new IncrTask(start, end));
            t.start();
        }

        start.countDown();
        end.await();
        System.out.println("result is: " + i);
    }
}
