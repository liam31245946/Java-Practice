public class Main {
    private static class Car {
        private String color;
        private int horsePower;

        Car(String color, int horsePower) {
            this.color = color;
            this.horsePower = horsePower;
        }

        public String describe() {
            return " color: " + color + ", horsePower: " + horsePower;
        }
    }

    private static class Lamboghini extends Car {
        public Lamboghini(String color, int horsePower) {
            super(color, horsePower);
        }

        @Override
        public String describe() {
            return "Lamboghini" + super.describe();
        }
    }

    private static class Ferrari extends Car {
        public Ferrari(String color, int horsePower) {
            super(color, horsePower);
        }

        @Override
        public String describe() {
            return "Ferrari" + super.describe();
        }
    }

    public static void main(String[] args) {
        Lamboghini myLambo = new Lamboghini("Black", 720);
        Ferrari myFerrari = new Ferrari("White", 800);

        System.out.println(myLambo.describe());
        System.out.println(myFerrari.describe());
    }
}
