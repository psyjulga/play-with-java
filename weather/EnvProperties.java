package weather;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvProperties {

  // from ChatGPT
  public void loadEnvProperties() {
    Properties props = new Properties();
    FileInputStream fis = null;
    try {
      // play-with-java\weather\env.properties
      fis = new FileInputStream("play-with-java\\weather\\env.properties");
      props.load(fis);
      for (String key : props.stringPropertyNames()) {
        String value = props.getProperty(key);
        System.setProperty(key, value);
      }
    } catch (IOException ex) {
      System.out.println("error by loading env variables");
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException ex) {
          System.out.println("error by closing env file");
        }
      }
    }
  }

}
