package yixin_tsfa;

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by DELL on 2018/8/8.
 */
public class DemoServiceTest {

    @Rule
    //三种方式报告的位置
    //public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("perf/report.html"));//自定义报告
    //public JUnitPerfRule perfTestRule = new JUnitPerfRule(new ConsoleReportGenerator());//控制台打印出报告参数
    //public JUnitPerfRule perfTestRule = new JUnitPerfRule(new CsvReportGenerator("E:\\workspace\\TEST_wiremock\\perf\\report.csv"));
    public JUnitPerfRule perfTestRule = new JUnitPerfRule();//设置默认报告路径

    /**
     * 被测试类方法
     */
    DemoPerfService demoPerfService;

    @Before
    public void setupService(){
        this.demoPerfService = new DemoPerfService();
    }

    @Test
    @JUnitPerfTest(threads = 500,durationMs = 1200,warmUpMs = 100,maxExecutionsPerSecond = 110)
    @JUnitPerfTestRequirement(percentiles = "90:7,95:7,98:7,99:8", executionsPerSec = 10, allowedErrorPercentage = 0.10f)
    public void getServiceId() {

        String result =demoPerfService.getServiceId("userid");
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    @JUnitPerfTest(threads = 500,durationMs = 1200,warmUpMs = 100,maxExecutionsPerSecond = 110)
    public void getServiceId_withoutTestRequirement() {

        String result =demoPerfService.getServiceId("userid");
        System.out.println(result);
        Assert.assertNotNull(result);
    }
}
