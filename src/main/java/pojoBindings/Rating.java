package pojoBindings;

public class Rating {
    private Float value;
    private Float scale;

    public Rating(float value, float scale) {
        this.value = value;
        this.scale = scale;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getScale() {
        return scale;
    }

    public void setScale(Float scale) {
        this.scale = scale;
    }
}
