public class FlowControl {


    public static class RichestCustomerHealth {

        // Method to calculate the richest customer's wealth
        public static int maximumWealth(int[][] accounts) {
            int maxWealth = 0;

            // Loop through each customer's bank accounts
            for (int[] customer : accounts) {
                int currentWealth = 0;

                // Sum up the wealth of the customer
                for (int money : customer) {
                    currentWealth += money;
                }

                // Update max wealth if current customer's wealth is greater
                maxWealth = Math.max(maxWealth, currentWealth);
            }

            return maxWealth;
        }
    }


    public static void main(String[] args) {

        int[][] account = { {1, 2, 3}, {3, 2, 1} };


        System.out.println("Max Wealth 1: " + RichestCustomerHealth.maximumWealth(account));
    }
}
