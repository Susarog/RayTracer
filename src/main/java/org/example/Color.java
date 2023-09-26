package org.example;

public class Color {
    public Color(float red, float green, float blue) {
        colorModel = new Tuple(red,green,blue);
    }
    public Color(Tuple a) {
        colorModel = a;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Color other)) {
            return false;
        }
        return colorModel.equals(other.colorModel);
    }
    public float getRed() {
        return colorModel.getValue();
    }

    public float getGreen() {
        return colorModel.getValue1();
    }

    public float getBlue() {
        return colorModel.getValue2();
    }

    public Color add(Color b){
        return new Color(this.colorModel.add(b.colorModel));
    }

    public Color subtract(Color b) {
        return new Color(this.colorModel.subtract(b.colorModel));
    }
    public Color multiply(float scalar) {
        return new Color(this.colorModel.multiply(scalar));
    }

    /**
     * Returns a new Color object from multiplying two Color Object.
     * This blends the two colors into one.
     * @param color a class that gives the rgb values of the specific color
     * @return new Color based on the new rgb values
     */
    public Color hadamardProduct(Color color) {
        float red = this.getRed() * color.getRed();
        float green = this.getGreen() * color.getGreen();
        float blue = this.getBlue() * color.getBlue();
        return new Color(red,green,blue);
    }

    private Tuple colorModel;
}
