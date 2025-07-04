// 901. Online Stock Span

// Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
//
// The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
//
// For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
// Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
// Implement the StockSpanner class:
//
// StockSpanner() Initializes the object of the class.
// int next(int price) Returns the span of the stock's price given that today's price is price.
//
//
// Example 1:
//
// Input
// ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
// [[], [100], [80], [60], [70], [60], [75], [85]]
// Output
// [null, 1, 1, 1, 2, 1, 4, 6]
//
// Explanation
// StockSpanner stockSpanner = new StockSpanner();
// stockSpanner.next(100); // return 1
// stockSpanner.next(80);  // return 1
// stockSpanner.next(60);  // return 1
// stockSpanner.next(70);  // return 2
// stockSpanner.next(60);  // return 1
// stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
// stockSpanner.next(85);  // return 6
//
//
// Constraints:
//
// 1 <= price <= 105
// At most 104 calls will be made to next.

// Runtime 2040 ms Beats 5.4%
// Memory 54.7 MB Beats 18.34%
class StockSpanner {

    private class Info {
        int price;
        int count;

        Info(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }

    private List<Info> prices;
    public StockSpanner() {
        this.prices = new ArrayList<>();
    }
    
    public int next(int price) {
        int count = 1;
        if (prices.size() > 0) {
            int lastIndex = prices.size() - 1;
            Info last = prices.get(lastIndex);
            if (last.price <= price) {
                count = count + last.count;
                int prevIndex = lastIndex - 1;
                while (prevIndex >= 0) {
                    Info prev = prices.get(prevIndex);
                    if (prev.price > price) {
                        break;
                    }
                    if (prev.price > last.price && prev.price <= price) {
                        count = count + prev.count;
                        last = prev;
                    } 
                    prevIndex--;
                }
            }
        }
        prices.add(new Info(price, count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
 
// Runtime 31 ms Beats 93.12%
// Memory 54.9 MB Beats 14.21%
class StockSpanner {

    private class Info {
        int price;
        int count;

        Info(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }

    private List<Info> prices;
    public StockSpanner() {
        this.prices = new ArrayList<>();
    }
    
    public int next(int price) {
        int count = 1;
        if (prices.size() == 0) {
            prices.add(new Info(price, count));
            return count;
        }
        int lastIndex = prices.size() - 1;
        Info last = prices.get(lastIndex);
        if (last.price <= price) {
            count = count + last.count;
            int prevIndex = lastIndex - 1;
            while (prevIndex >= 0) {
                Info prev = prices.get(prevIndex);
                if (prev.price > price) {
                    break;
                }
                if (prev.price > last.price && prev.price <= price) {
                    count = count + prev.count;
                    last = prev;
                } 
                prevIndex--;
            }
            prices.set(lastIndex, new Info(price, count));
        } else {
            prices.add(new Info(price, count));
        }
        return count;
    }
}
