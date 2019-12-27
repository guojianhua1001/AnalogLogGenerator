package ace.gjh.test;

import ace.gjh.util.LogGenerator;
import org.junit.Test;

import java.text.ParseException;

/**
 * 测试模拟日志生成器
 */
public class TestLogGenerator {

    @Test
    public void testBuildLog() throws ParseException {

        LogGenerator.buildLog(TestLogGenerator.class);


    }

}
