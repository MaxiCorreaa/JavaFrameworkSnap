package commons;

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class ReadConfigFile {

    private static final String PATH_INI = System.getProperty("user.dir") + "\\src\\main\\resources\\config.ini";
    private static Wini ini_file;

    private static String url;
    private static String browser;
    private static String headless;
    private static String privado;
    private static String implicitlyWait;
    private static String pageLoadTimeout;


    public ReadConfigFile() {
        if (ini_file == null) {
            try {
                ini_file = new Wini(new File(PATH_INI));
                url = ini_file.get("config", "url");
                browser = ini_file.get("config", "browser");
                headless = ini_file.get("config", "headless");
                privado = ini_file.get("config", "private");
                implicitlyWait = ini_file.get("config", "implicitlyWait");
                pageLoadTimeout = ini_file.get("config", "implicitlyWait");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public String getHeadless() {
        return headless;
    }

    public String getPrivado() {
        return privado;
    }

    public Long getImplicitlyWait() {
        return Long.parseLong(implicitlyWait);
    }

    public Long getPageLoadTimeout() {
        return Long.parseLong(pageLoadTimeout);
    }
}
