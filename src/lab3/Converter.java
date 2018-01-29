package lab3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class Converter implements IConverter {
    public JSONObject convert(Document doc){
        try {
            JSONObject jsonObj=new JSONObject();
            NodeList lst=doc.getChildNodes();
            for(int i=0;i<lst.getLength();i++){
                if(lst.item(i).getNodeType()== Element.ELEMENT_NODE) {
                    jsonObj.put(lst.item(i).getNodeName(), getJSONArr(lst.item(i).getChildNodes()));
                }
            }
            System.out.println(jsonObj);
            return jsonObj;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONArray getJSONArr(NodeList nodeList) throws JSONException {
        JSONArray arr=new JSONArray();
        JSONObject obj=new JSONObject();
        for(int i=0;i<nodeList.getLength();i++){
            Node node=nodeList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                if (node.hasChildNodes() && node.getChildNodes().getLength() > 1){
                    JSONArray tempArr = getJSONArr(node.getChildNodes());
                    if (obj.has(node.getNodeName())) {
                        obj.getJSONArray(node.getNodeName()).put(tempArr.getJSONObject(0));
                    }
                    else{
                        obj.put(node.getNodeName(),tempArr);
                    }
                }
                else{
                    obj.put(node.getNodeName(), node.getTextContent());
                }
            }

        }
        arr.put(obj);
        return arr;
    }

    public Document getXMLDocument(InputStream stream) {
        try {
            DocumentBuilder xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = xmlDoc.parse(stream);
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
            Node el = doc.getFirstChild();
            do {
                if(el.getNodeType()==Node.ELEMENT_NODE){
                    System.out.println(el.getNodeName() + ": " + el.getTextContent());
                }
                el = el.getNextSibling();
            }
            while (el != null);
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
