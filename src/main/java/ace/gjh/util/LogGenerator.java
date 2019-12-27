package ace.gjh.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.Random;
import java.util.UUID;

public class LogGenerator {


    //日志类型
    private static String[] logTypes = {"EVALUATE", "EVALUATE", "SUCCESS"};


    //用户ID
    private static String[] userIDs = {
            "USER1001",
            "USER1002",
            "USER1003",
            "USER1004",
            "USER1005",
            "USER1006",
            "USER1007",
            "USER1008",
            "USER1009",
            "USER1000",
    };

    //用户密码
    private static String[] passwords = {
            "USER1001",
            "USER1002",
            "USER1003",
            "USER1004",
            "USER1005",
            "USER1006",
            "USER1007",
            "USER1008",
            "USER1009",
            "123456",
            "apple123",
            "apple456",
            "apple12",
            "apple23",
            "apple",
    };

    //地点
    private static String[] regions = {
            "beijing",
            "zhengzhou",
            "tianjin",
            "guangzhou",
            "yunnan"
    };

    //经纬度
    private static String[] LatAndLongs = {
            "40.1,116.5",
            "113.6,34.5",
            "117.2,40.6",
            "113.4,22.7",
            "102.1,23.2"
    };

    //输入特征
    private static String[] featureVectors = {
            "1023.0,1832.1,2800.2",
            "1223.3,2432.3,3060.3",
            "1423.3,7432.3,3050.3",
            "4623.3,4432.3,3780.3",
            "1723.3,1632.3,3400.3",
            "1823.3,1332.3,4000.3",
            "1323.3,1032.3,7000.3",
            "6923.3,1532.3,3200.3",
            "1653.3,1472.3,6700.3",
            "1843.3,1482.3,3100.3"
    };

    //user-agent
    private static String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763";


    /**
     * 创建日志
     * @param count 日志数量
     * @throws IOException  IO异常
     * @throws ParseException   转换异常
     * @throws InterruptedException 中断异常
     */
    public static  void GenerateLogs(Class appName, int count, int basic, int bound) throws IOException, ParseException, InterruptedException {
        if (count < 0) throw new RuntimeException("生成文件数不能为负数！");
        if (count > 300) throw new RuntimeException("日志生成数大于300条！");
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            buildLog(appName);
            Thread.sleep(random.nextInt(bound)+ basic);
        }
    }



    /**
     * 输出日志信息
     * @return 日志信息
     * @throws ParseException 日期类型转换异常
     */
    public static  String buildLog(Class appName) throws ParseException {
        Random random = new Random();
        String logType = logTypes[random.nextInt(logTypes.length)];
        String userId = "["+userIDs[random.nextInt(userIDs.length)]+"]";
        String deviceId = UUID.randomUUID().toString().replaceAll("-", "");
        String password = "\""+passwords[random.nextInt(passwords.length)]+"\"";
        String region = regions[random.nextInt(regions.length)];
        String LatAndLong = "\""+LatAndLongs[random.nextInt(LatAndLongs.length)]+"\"";
        String feature = "[" + featureVectors[random.nextInt(featureVectors.length)]+"]";

        String log = logType + " "
                + userId + " "
                + deviceId + " "
                + password + " "
                + region + " "
                + LatAndLong + " "
                + feature + " "
                + "\""+userAgent+"\"";

        Logger logger = LoggerFactory.getLogger(appName);
        logger.info(log);
        return log;
    }

}
