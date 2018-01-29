package lab3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


import java.io.*;
import java.io.InputStream;

public class FileInputStreamXML implements IInputStream {
    private InputStream fStream;
    private String path;

    public void setPath(String path){
        this.path=path;
    }

    public InputStream getInputStream() {
        return fStream;
    }

    public void read(){
            try {
                fStream = new FileInputStream(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
