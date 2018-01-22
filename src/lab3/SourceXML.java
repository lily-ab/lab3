package lab3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SourceXML {
    private String path;
    private InputStream fStream;
    public SourceXML(InputStream fStream) {
        this.fStream=fStream;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Document getDOMParser() {
        try {
           // FileInputStream fStream=new FileInputStream(path);
            DocumentBuilder xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = xmlDoc.parse(fStream);
            doc.normalize();
            return doc;
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printXML(Document doc){
        try {
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            System.out.println("Child elements: ");
            NodeList lst1 = doc.getChildNodes();
            Node el = doc.getFirstChild();
            do {
                System.out.println(el.getNodeName() + ": " + el.getTextContent());
                el = el.getNextSibling();
            }
            while (el != null);
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
