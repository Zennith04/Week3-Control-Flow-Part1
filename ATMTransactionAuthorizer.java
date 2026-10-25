public class Main { 
    public static void main(String[] args) { 
 
        // Account information 
        String correctUsername = "johnfol_03"; 
        String correctPin = "04302003"; 
 
        String enteredUsername = "student"; 
        String enteredPin = "08012007"; 
 
        double balance = 25000.00; 
        double withdrawalAmount = 5000.00; 
 
        double dailyWithdrawn = 2000.00; 
        double dailyLimit; 
 
 
 
        String tier; 
        double feeRate = 0.0; 
        double transactionFee = 0.0; 
        double totalDeduction = 0.0; 
 
        boolean approved = false; 
        String reason = ""; 
 
        System.out.println("=== ATM Transaction Authorizer ==="); 
 
        // 1. Validate username and PIN using nested if statements 
        if (enteredUsername.equals(correctUsername)) { 
            if (enteredPin.length() == 4 
                    && enteredPin.matches("[0-9]{4}") 
                    && enteredPin.equals(correctPin)) { 
 
                System.out.println("Login successful."); 
 
                // 2. Determine account tier using an else-if ladder 
                if (balance < 10000) { 
                    tier = "Bronze"; 
                    dailyLimit = 5000; 
                } else if (balance < 25000) { 
                    tier = "Silver"; 
                    dailyLimit = 10000; 
                } else if (balance < 50000) { 
                    tier = "Gold"; 
                    dailyLimit = 20000; 
                } else { 
                    tier = "Platinum"; 
                    dailyLimit = 50000; 
                } 
 
                System.out.println("Account Tier: " + tier); 
                System.out.println("Account Balance: ₱" + balance); 
                System.out.println("Withdrawal Amount: ₱" + withdrawalAmount); 
 
                // 3. Select transaction fee using switch 
                switch (tier) { 
                    case "Bronze": 
                        feeRate = 0.02; 
                        break; 
                    case "Silver": 
                        feeRate = 0.015; 
                        break; 
                    case "Gold": 
                        feeRate = 0.01; 
 
 
                        break; 
                    case "Platinum": 
                        feeRate = 0.005; 
                        break; 
                    default: 
                        feeRate = 0.0; 
                } 
 
                transactionFee = withdrawalAmount * feeRate; 
                totalDeduction = withdrawalAmount + transactionFee; 
 
                System.out.println("Transaction Fee: ₱" + transactionFee); 
                System.out.println("Daily Withdrawal Limit: ₱" + dailyLimit); 
 
                // 4. Nested withdrawal authorization 
                if (withdrawalAmount > 0) { 
                    if (withdrawalAmount + dailyWithdrawn <= dailyLimit) { 
                        if (totalDeduction <= balance) { 
                            approved = true; 
                            reason = "Transaction meets all requirements."; 
                        } else { 
                            reason = "Insufficient balance to cover withdrawal and fee."; 
                        } 
                    } else { 
                        reason = "Daily withdrawal limit exceeded."; 
                    } 
                } else { 
                    reason = "Withdrawal amount must be greater than zero."; 
                } 
 
                // 5. Final approval or denial 
                if (approved) { 
                    System.out.println("Transaction: APPROVED"); 
                    System.out.println("Amount Withdrawn: ₱" + withdrawalAmount); 
                    System.out.println("Transaction Fee: ₱" + transactionFee); 
                    System.out.println("Total Deduction: ₱" + totalDeduction); 
 
                    balance -= totalDeduction; 
                    System.out.println("Remaining Balance: ₱" + balance); 
                } else { 
                    System.out.println("Transaction: DENIED"); 
                    System.out.println("Reason: " + reason); 
                } 
 
            } else { 
                System.out.println("Transaction: DENIED"); 
                System.out.println("Reason: Incorrect PIN or PIN must be exactly 4 digits."); 
            } 
 
 
        } else { 
            System.out.println("Transaction: DENIED"); 
            System.out.println("Reason: Incorrect username."); 
        } 
    } 
}