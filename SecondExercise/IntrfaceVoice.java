public interface Voice {

    void voice();
}
    class Cat implements Voice {

        @Override
        public void voice() {
            System.out.println("Meow!");
        }
    }

//release of interface

    class Dog implements Voice {


        @Override
        public void voice() {
            System.out.println("Wow!");
        }
    }

    class Cow implements Voice {

        @Override
        public void voice() {
            System.out.println("Myy!");
        }
    }

class InterfaceRun {

    public static void main (String[] args) {

        Voice [] animals = {new Cat(), new Dog(), new Cow()};

        for (Voice s: animals)
            s.voice();
    }
}
