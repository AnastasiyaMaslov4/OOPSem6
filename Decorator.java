// Декоратор (англ. Decorator) — структурный шаблон проектирования, 
// предназначенный для динамического подключения дополнительного поведения к объекту. 
// Шаблон Декоратор предоставляет гибкую альтернативу практике создания подклассов с целью расширения функциональности.

interface BakeIt {
    void bakingSomething();
}

class BakeCake implements BakeIt {

    @Override
    public void bakingSomething() {
        System.out.println("Печется торт");        
    }
    
}

abstract class BaseDecorator implements BakeIt {

    protected BakeIt bake;

    public BaseDecorator (BakeIt b) {
		bake = b;
	}
	
	@Override
	public void bakingSomething() {
		bake.bakingSomething();
	}

}

class BakeAndPackDecorator extends BaseDecorator {

    public BakeAndPackDecorator(BakeIt b) {
        super(b);
    }

    public void bakingSomething() {
        super.bakingSomething();
        System.out.println("Торт упакован");
    }

}

class BakeAndSendDecorator extends BaseDecorator {

    public BakeAndSendDecorator(BakeIt b) {
        super(b);
    }

    public void bakingSomething() {
        super.bakingSomething();
        System.out.println("Торт отправлен");
    }

}

public class Decorator {
    public static void main(String[] args) {
        BakeCake b = new BakeCake();
        b.bakingSomething(); // Метод только для выпечки торта

        BakeAndPackDecorator bAndP = new BakeAndPackDecorator(b);
        bAndP.bakingSomething(); // Метод для выпечки и упаковки

        BakeAndSendDecorator bAndS = new BakeAndSendDecorator(bAndP);
        bAndS.bakingSomething(); // Метод для выпечки, упаковки и отправки
    }
}
