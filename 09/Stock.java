public class Stock {
  String symbol;
  String name;
  double previousClosingPrice;
  double currentPrice;

  Stock(String symbol, String name) {
    this.symbol = symbol;
    this.name = name;
  }

  double getChangePercent() {
    double change = currentPrice - previousClosingPrice;
    return (change / previousClosingPrice) * 100.0;
  }
}
