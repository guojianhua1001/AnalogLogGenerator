package ace.gjh.apps;

import ace.gjh.util.LogGenerator;

import java.io.IOException;
import java.text.ParseException;

public class APP2 {
    public static void main(String[] args) throws ParseException, InterruptedException, IOException {
        LogGenerator.GenerateLogs(APP2.class, 50, 1000, 1000);
    }
}
