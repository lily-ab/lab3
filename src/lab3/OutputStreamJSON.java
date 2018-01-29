package lab3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.*;

import java.io.FileWriter;
import java.io.IOException;


public class OutputStreamJSON implements IOutputStream {
    private String path;

    public void setPath(String path) {
        this.path = path;
    }


    public void write(JSONObject jsonObj) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(jsonObj.toString());
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}