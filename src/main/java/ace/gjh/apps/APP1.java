package ace.gjh.apps;

import ace.gjh.util.LogGenerator;

import java.io.IOException;
import java.text.ParseException;

public class APP1 {
    public static void main(String[] args) throws ParseException, InterruptedException, IOException {
        LogGenerator.GenerateLogs(APP1.class, 100, 500, 1500);
    }
}
