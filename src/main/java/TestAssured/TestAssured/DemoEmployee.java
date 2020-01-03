package TestAssured.TestAssured;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class DemoEmployee {
	
	
	private int id= 0;
	private String employee_name=null;
	private float employee_salary= 0;
	private int age=0;
	private String profile_image=null;
	
	
	    private static transient Gson gson = new Gson();

    public String toJSON() {
        return gson.toJson(this);
    }

    public JsonObject getJsonObject() {
        JsonElement element = gson.fromJson(gson.toJson(this), JsonElement.class);
        return element.getAsJsonObject();
    }
}