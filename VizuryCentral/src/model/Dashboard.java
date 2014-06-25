package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;


public class Dashboard {

private List<List<String>> rows = new ArrayList<List<String>>();
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<List<String>> getRows() {
return rows;
}

public void setRows(List<List<String>> rows) {
this.rows = rows;
}

@Override
public String toString() {
return ToStringBuilder.reflectionToString(this);
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
