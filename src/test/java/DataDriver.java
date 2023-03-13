import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;

public class DataDriver {
    public File file ;
    public FileReader fileReader;
    public JSONTokener jsonTokener ;
    public JSONObject jsonObject;

    public DataDriver() {
    }

    public DataDriver(String  url) {
        file = new File(url);
        jsonTokener = new JSONTokener(fileReader);
        try {
            jsonObject = new JSONObject(jsonTokener);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
