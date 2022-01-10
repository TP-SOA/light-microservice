package fr.iss.soa.lightmicroservice;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LightModel {
    public static List<Light> lights = new ArrayList<>();

    static {
        lights.add(new Light(1, true));
        lights.add(new Light(7, false));
        lights.add(new Light(11, false));
        lights.add(new Light(114, true));
        lights.add(new Light(116, false));
        lights.add(new Light(213, false));
    }

    public List<Light> findAll() {
        return lights;
    }

    public Light findById(int id) {
        for (Light light : lights){
            if(light.getId() == id){
                return light;
            }
        }
        return null;
    }

    public void update(int id, boolean enabled) {
        Light l = findById(id);
        l.setEnabled(enabled);
    }
}