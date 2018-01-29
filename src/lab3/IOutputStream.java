package lab3;

import org.json.JSONObject;

public interface IOutputStream {
    /**
     * @param path sets path for the further writing of the JSON-file
     */
    void setPath(String path);

    /**
     * @param jsonObj creates new JSON file on at the specified address
     */
    void write(JSONObject jsonObj);
}
