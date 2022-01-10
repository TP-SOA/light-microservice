package fr.iss.soa.lightmicroservice;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LightController {

    private final LightModel lightModel;

    public LightController(LightModel lightDao){
        this.lightModel = lightDao;
    }

    @GetMapping("/lights")
    public List<Light> lights() {
        return lightModel.findAll();
    }

    @GetMapping(value = "/lights/{id}")
    public Light lightsID(@PathVariable int id) {
        return lightModel.findById(id);
    }

    @PostMapping(value="/lights/{id}")
    public void setLight(@PathVariable int id, @RequestBody String requestBody) {
        JSONObject jsonBody = new JSONObject(requestBody);
        try {
            boolean enabled = jsonBody.getBoolean("enabled");
            lightModel.update(id, enabled);
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }
}
