package yixin_tsfa;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.annotation.JunitPerfRequire;
import com.github.houbb.junitperf.core.rule.JunitPerfRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by DELL on 2018/10/31.
 */
public class HelloWordTest {
    @Rule
    public JunitPerfRule junitPerfRule = new JunitPerfRule();

    @Test
    @JunitPerfConfig(threads = 1000,warmUp = 1000,duration = 2000)
    //线程、准备时间，持续时间
    //@JunitPerfRequire(min = 2100,max=2050,average=225,timesPerSecond = 110,percentiles = {"20：2200","30:5000"})
    //一般很少用
    public void helloWorldTest() throws InterruptedException {
        System.out.println("hello world");
        Thread.sleep(20);
    }
}
