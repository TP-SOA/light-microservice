package fr.iss.soa.lightmicroservice;


public class Light {
    private final int id;
    private boolean enabled;

    public Light(int id, boolean enabled) {
        this.id = id;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

