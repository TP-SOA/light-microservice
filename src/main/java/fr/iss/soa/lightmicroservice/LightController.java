package fr.iss.soa.lightmicroservice;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@RestController
public class LightController {

    private final LightModel lightModel;

    public LightController(LightModel lightModel){
        this.lightModel = lightModel;
        Timer t = new Timer();
        // Update light status every 5 seconds
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Light l = lightModel.findById(7);
                if (l != null) {
                    l.setEnabled(!l.isEnabled());
                }
            }
        }, 0, 5*1000);
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
