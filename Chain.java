class Order {

    Integer id;
    String clientsName;
    Boolean orderInSystem;
    Boolean orderIsPayed;
    Boolean orderIsReady;

    public Order (Integer id, String clientsName, Boolean orderInSystem, Boolean orderIsPayed, Boolean orderIsReady) {
        this.id = id;
        this.clientsName = clientsName;
        this.orderInSystem = orderInSystem;
        this.orderIsPayed = orderIsPayed;
        this.orderIsReady = orderIsReady;
    }
}

interface GetOrder {
    void checkIt(Order o);
}

class OrderInSystem implements GetOrder{
    
    @Override
    public void checkIt(Order o) {
        if (o.orderInSystem == true) new OrderIsPayed().checkIt(o);
        else System.out.println("Заказа нет в системе");
    }

}

class OrderIsPayed implements GetOrder {

    @Override
    public void checkIt(Order o) {
        if (o.orderIsPayed == true) new OrderIsReady().checkIt(o);
        else System.out.println("Заказ не оплачен"); 
    }
    
}

class OrderIsReady implements GetOrder {

    @Override
    public void checkIt(Order o) {
        if (o.orderIsReady == true) System.out.println("Заказ выдается");
        else System.out.println("Заказ еще не готов");
        
    }
    
}


public class Chain {
    public static void main(String[] args) {
        Order o = new Order(1, "Maks", true, true, true);
        OrderInSystem check = new OrderInSystem();
        check.checkIt(o); // Проверка заказа проходит всю цепочку и заказ выдается

        Order newO = new Order(2, "Anna", true, false, null);
        check.checkIt(newO); // На проверке оплаты выпадает ошибка
    }
}
