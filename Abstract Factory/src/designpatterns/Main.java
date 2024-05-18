package designpatterns;

interface IEngine {
    void releaseEngine();
}

class JapaneseEngine implements IEngine {
    @Override
    public void releaseEngine(){
        System.out.println("Japanese engine\n");
    }
}

class GermanEngine implements  IEngine {
    @Override
    public void releaseEngine(){
        System.out.println("German engine\n");
    }
}

interface ICar {
    void releaseCar(IEngine engine);
}

class JapaneseCar implements ICar {
    @Override
    public void releaseCar(IEngine engine) {
        System.out.println("Assembled a Japanese automobile:\n");
        engine.releaseEngine();
    }
}

class GermanCar implements ICar {
    @Override
    public void releaseCar(IEngine engine) {
        System.out.println("Assembled a German automobile:\n");
        engine.releaseEngine();
    }
}

interface IFactory {
    IEngine createEngine();
    ICar createCar();
}

class JapaneseFactory implements IFactory {
    @Override
    public IEngine createEngine() {
        return new JapaneseEngine();
    }

    @Override
    public ICar createCar() {
        return new JapaneseCar();
    }
}

class GermanFactory implements IFactory {
    @Override
    public IEngine createEngine() {
        return new GermanEngine();
    }

    @Override
    public ICar createCar() {
        return new GermanCar();
    }
}

public class Main {
    public static void main(String[] args) {
        IFactory jFactory = new JapaneseFactory();
        IEngine jEngine = jFactory.createEngine();
        ICar jCar = jFactory.createCar();
        jCar.releaseCar(jEngine);

        IFactory gFactory = new GermanFactory();
        IEngine gEngine = gFactory.createEngine();
        ICar gCar = gFactory.createCar();
        gCar.releaseCar(gEngine);
    }
}