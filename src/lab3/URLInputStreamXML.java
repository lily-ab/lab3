package lab3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLInputStreamXML implements IInputStream {
    private InputStream stream;
    private String path;
    @Override
    public void setPath(String path) {
        this.path=path;
    }

    @Override
    public void read() {
        try {
            URL url=new URL(path);
            url.openConnection();
            stream=url.openStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InputStream getInputStream() {
        return stream;
    }
}
