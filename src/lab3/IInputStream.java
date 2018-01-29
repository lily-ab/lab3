package lab3;

import org.w3c.dom.Document;

import java.io.InputStream;

public interface IInputStream {
    /**
     * Sets path of the XML-structured file
     * @param path is a way to the file
     */
    void setPath(String path);

    /**
     * Creates the stream for reading file;
     */
    void read();

    /**
     * @return stream for reading file;
     */
    InputStream getInputStream();
}
