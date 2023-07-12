import configurati.BaseClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Testik extends BaseClass {
    @Test
    public void t() throws IOException {
driver.get("https://www.instagram.com/p/CuhtSfNOBEd/");
List<WebElement> list=driver.findElements(By.xpath("//ul[@class=\"_a9ym\"]"));
        Map<String, Set<String>> map=new HashMap<>();
        Set<String> set=null;
        System.out.println(list.size());
        for (WebElement l : list) {
            set=new HashSet<>();
            String name=l.findElement(By.className("xt0psk2")).getText();

            for (WebElement f : l.findElement(By.className("_a9zs")).findElements(By.tagName("a"))) {
                set.add(f.getText());
            }
            try {
                set.addAll(map.get(name));
            }catch (Exception ignore){};
            map.put(name,set);
        }
        System.out.println(map);
        String data=new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        File file= new File(data+"_pisunu"+".txt");
        FileWriter writer=null;
        writer=new FileWriter(file);
        for(Map.Entry<String, Set<String>> l:map.entrySet()){
            writer.write(l.getValue().size()+","+l.getKey()+","+l.getValue().toString().replace("[","").replace("]","")+",\n");
        }
        writer.flush();
        writer.close();
    }
}
