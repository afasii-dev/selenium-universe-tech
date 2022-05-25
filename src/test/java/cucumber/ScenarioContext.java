package cucumber;

import enums.Data;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<String, Object>();
    }

    public void saveData(Data key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public void updateData(Data key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getData(Data key) {
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Data key) {
        return scenarioContext.containsKey(key.toString());
    }
}
