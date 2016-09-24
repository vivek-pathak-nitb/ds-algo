/**
 * Created by vivek.pathak on 11/03/16.
 */
public class Builder {

    private int x;
    private int y;
    private int z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public static class BuilderBuilder {

        private Builder builder;

        public BuilderBuilder() {
            builder = new Builder();
        }

        public BuilderBuilder withX(int x) {
            builder.setX(x);
            return this;
        }

        public BuilderBuilder withY(int y) {
            builder.setY(y);
            return this;
        }

        public BuilderBuilder withZ(int z) {
            builder.setZ(z);
            return this;
        }

        public Builder build() {
            return builder;
        }
    }

    public static void main(String[] args) {
        BuilderBuilder builderBuilder = new BuilderBuilder();
        final Builder builder = builderBuilder.withX(1).withY(2).withZ(3).build();
        System.out.println("X is " + builder.getX());
        System.out.println("Y is " + builder.getY());
        System.out.println("Z is " + builder.getZ());
    }


}
