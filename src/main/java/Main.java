import com.github.sardine.DavResource;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by petho on 2017-01-02.
 */
public class Main {

    private static final String PATH = "http://192.168.0.103/webdav/test/";

    public static void main(String[] args){
        Sardine sardine = SardineFactory.begin("test","test");
        try{
            sardine.createDirectory(PATH+"/test/");
            sardine.put(PATH+"a.txt","a".getBytes());
            sardine.put(PATH+"b.txt","b".getBytes());

            List<DavResource> res = sardine.list(PATH);
            for(DavResource dr : res){
                System.out.println(dr);
            }
            System.out.println();

            sardine.delete(PATH+"b.txt");
            res = sardine.list(PATH);
            for(DavResource dr : res){
                System.out.println(dr);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
