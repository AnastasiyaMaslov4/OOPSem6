/* Фабричный метод (англ. Factory Method), или виртуальный конструктор (англ. Virtual Constructor) — 
порождающий шаблон проектирования, предоставляющий подклассам (дочерним классам, субклассам) 
интерфейс для создания экземпляров некоторого класса. 
В момент создания наследники могут определить, какой класс создавать. 
Иными словами, данный шаблон делегирует создание объектов наследникам родительского класса. 
Это позволяет использовать в коде программы не конкретные классы, а манипулировать абстрактными объектами на более высоком уровне.
 */

interface SweetFood {}

class Cake implements SweetFood {}

class Cupcake implements SweetFood {}

abstract class Baking {
    public abstract SweetFood makeSweetFoodMethod();
}

class CakeBaking extends Baking {

    @Override
    public SweetFood makeSweetFoodMethod() {
        return new Cake();
    }
    
}

class CupcakeBaking extends Baking {

    @Override
    public SweetFood makeSweetFoodMethod() {
        return new Cupcake();
    }
    
}

public class FactoryMethod {
    public static void main(String[] args) {
        Baking[] bakingArr = {new CakeBaking(), new CupcakeBaking()};
        for (Baking creator: bakingArr) {
            SweetFood product = creator.makeSweetFoodMethod();
            System.out.printf("Created {%s}\n", product.getClass());
        }
    }
}