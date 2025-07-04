// 1169. Invalid Transactions
//
// A transaction is possibly invalid if:
//
// the amount exceeds $1000, or;
// if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
// You are given an array of strings transaction where transactions[i] consists of comma-separated values representing the name, time (in minutes), amount, and city of the transaction.
//
// Return a list of transactions that are possibly invalid. You may return the answer in any order.
//
//
//
// Example 1:
//
// Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
// Output: ["alice,20,800,mtv","alice,50,100,beijing"]
// Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
// Example 2:
//
// Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
// Output: ["alice,50,1200,mtv"]
// Example 3:
//
// Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
// Output: ["bob,50,1200,mtv"]
//
//
// Constraints:
//
// transactions.length <= 1000
// Each transactions[i] takes the form "{name},{time},{amount},{city}"
// Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
// Each {time} consist of digits, and represent an integer between 0 and 1000.
// Each {amount} consist of digits, and represent an integer between 0 and 2000.
//
// Runtime 14 ms Beats 44.92% of users with Java
// Memory 44.44 MB Beats 63.77% of users with Java
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        Map<String, List<Info>> transMap = new HashMap<>();
        for (String transaction: transactions) {
            Info info = new Info(transaction);
            List<Info> infoList = transMap.getOrDefault(info.name, new ArrayList<>());
            infoList.add(info);
            transMap.put(info.name, infoList);
        }

        for (List<Info> list: transMap.values()) {
            Collections.sort(list, (a, b) -> a.time - b.time);
            for (Info info: list) {
                if (info.amount > 1000) {
                    ans.add(info.original);
                    continue;
                }
                for (Info record: list) {
                    if (Math.abs(info.time - record.time) <= 60 && !info.city.equals(record.city)) {
                        ans.add(info.original);
                        break;
                    }
                }
            }
        }

        return ans;
    }

    class Info {
        String name;
        int amount;
        int time;
        String city;
        String original;
        public Info(String transaction) {
            String[] arr = transaction.split(",");
            this.name = arr[0];
            this.time = Integer.valueOf(arr[1]);
            this.amount = Integer.valueOf(arr[2]);
            this.city = arr[3];
            this.original = transaction;
        }
    }
}


// Runtime 10 ms Beats 60.38% of users with Java
// Memory 44.54 MB Beats 53.76% of users with Java
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        Map<String, List<Info>> transMap = new HashMap<>();
        for (String transaction: transactions) {
            Info info = new Info(transaction);
            List<Info> infoList = transMap.getOrDefault(info.name, new ArrayList<>());
            infoList.add(info);
            transMap.put(info.name, infoList);
        }

        for (List<Info> list: transMap.values()) {
            for (Info info: list) {
                if (info.amount > 1000) {
                    ans.add(info.original);
                    continue;
                }
                for (Info record: list) {
                    if (Math.abs(info.time - record.time) <= 60 && !info.city.equals(record.city)) {
                        ans.add(info.original);
                        break;
                    }
                }
            }
        }

        return ans;
    }

    class Info {
        String name;
        int amount;
        int time;
        String city;
        String original;
        public Info(String transaction) {
            String[] arr = transaction.split(",");
            this.name = arr[0];
            this.time = Integer.valueOf(arr[1]);
            this.amount = Integer.valueOf(arr[2]);
            this.city = arr[3];
            this.original = transaction;
        }
    }
}