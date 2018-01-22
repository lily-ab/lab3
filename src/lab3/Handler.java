package lab3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Handler {
    private String xmlPath;
    private String jsonPath;
    private Way way;
    public Handler(String xmlPath, String jsonPath,Way way){
        this.jsonPath=jsonPath;
        this.xmlPath=xmlPath;
        this.way=way;
    }
    public boolean parse(){
        if(way==Way.FILE){
            try {
                FileInputStream fStream=new FileInputStream(xmlPath);
                SourceXML xml=new SourceXML(fStream);
                JSONResult json=new JSONResult(jsonPath);
                return json.parseToJSON(xml.getDOMParser());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                URL url=new URL(xmlPath);
                InputStream fStream=url.openStream();
                SourceXML xml=new SourceXML(fStream);
                JSONResult json=new JSONResult(jsonPath);
                return json.parseToJSON(xml.getDOMParser());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
