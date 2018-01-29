package lab3;

import org.json.JSONObject;
import org.w3c.dom.Document;

import java.io.InputStream;

public interface IConverter {
    /**
     *Converts nodes of XML-document to JSON-structure
     * @param doc XML-structured document
     * @return JSON-structured object that should be written to the file or printed
     */
    JSONObject convert(Document doc);

    /**
     * Gets XML-structured object from incoming stream
     * @param stream is given from file or url
     * @return object of a Document XML type
     */
    Document getXMLDocument(InputStream stream);
}
