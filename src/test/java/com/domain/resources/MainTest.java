package com.domain.resources;

import static org.junit.Assert.assertEquals;

import com.domain.heroku.Main;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.junit.Test;



public class MainTest {

  @Test
  public void testMain() throws Exception {
    Main main = new Main();
    main.start();
    HttpURLConnection conn =
        (HttpURLConnection) new URL("http://localhost:8080/apiserver").openConnection();
    StringBuilder textBuilder = new StringBuilder();
    InputStream reader = conn.getInputStream();
    int c = 0;
    while ((c = reader.read()) != -1) {
      textBuilder.append((char) c);
    }
    reader.close();
    main.stop();
    Main.main(new String[] {"test"});

    assertEquals(textBuilder.toString(), "{\"response\":\"success!\"}");
  }

}
