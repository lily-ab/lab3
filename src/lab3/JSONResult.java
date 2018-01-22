package lab3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.print.Doc;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONResult {
    private String fileName;

    public JSONResult(String fileName){
        this.fileName=fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean parseToJSON(Document doc){
        try {
            JSONObject jsonObj=new JSONObject();
           // JSONArray arr=getJSONArr(doc.getChildNodes());
            NodeList lst=doc.getChildNodes();
            for(int i=0;i<lst.getLength();i++){
                jsonObj.put(lst.item(i).getNodeName(),getJSONArr(lst.item(i).getChildNodes()));
            }
            writeFile(jsonObj);
            System.out.println(jsonObj);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void writeFile(JSONObject jsonObj){
        try (FileWriter writer = new FileWriter(fileName)){
            writer.write(jsonObj.toString());
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
//    public void printJSON(){
//        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//        if (doc.hasChildNodes()) {
//            JSONArray arr = getJSONArr(doc.getFirstChild().getChildNodes());
//            System.out.println( arr);
//        }
//    }

    public static JSONArray getJSONArr(NodeList nodeList) throws JSONException {
        JSONArray arr=new JSONArray();
        JSONObject obj=new JSONObject();
        for(int i=0;i<nodeList.getLength();i++){
            Node node=nodeList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                if (node.hasChildNodes() && node.getChildNodes().getLength() > 1){
                    JSONArray tempArr = getJSONArr(node.getChildNodes());
                    if (obj.has(node.getNodeName())) {
                        obj.getJSONArray(node.getNodeName()).put(tempArr.getJSONObject(0));
                    } else{
                        obj.put(node.getNodeName(),tempArr);
                    }
                }
            }
            else{
                obj.put(node.getNodeName(), node.getTextContent());
            }
        }
        arr.put(obj);
        return arr;
    }
}
