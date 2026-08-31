package main;

public class MarketDataFeed{

    private volatile double latestPrice;

    public void updatePrice(double price){
        latestPrice = price;
    }

    public double getLatestPrice() {
        return latestPrice;
    }

    public static void main(String[] args) {
        MarketDataFeed feed = new MarketDataFeed();

        Thread publisher = new Thread(
                () -> {feed.updatePrice(101.25);}
        );

        Thread consumer = new Thread(
                () -> {
                    while (feed.getLatestPrice() == 0.0){
                        // wait for first price
                    }
                    System.out.println("Latest price: "+ feed.getLatestPrice());
                }
        );
        consumer.start();
        publisher.start();


    }
}