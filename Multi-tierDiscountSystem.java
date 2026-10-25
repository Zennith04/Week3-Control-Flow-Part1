public class Main { 
    public static void main(String[] args) { 
 
        double purchaseAmount = 6000.00; 
        double discountRate; 
        String discountTier; 
 
        if (purchaseAmount < 1000) { 
            discountRate = 0.00; 
            discountTier = "No Discount (0%)"; 
        } else if (purchaseAmount < 3000) { 
            discountRate = 0.05; 
            discountTier = "Bronze Tier (5%)"; 
        } else if (purchaseAmount < 5000) { 
            discountRate = 0.10; 
            discountTier = "Silver Tier (10%)"; 
        } else { 
            discountRate = 0.15; 
            discountTier = "Gold Tier (15%)"; 
        } 
 
        double discountAmount = purchaseAmount * discountRate; 
        double finalPrice = purchaseAmount - discountAmount; 
 
        System.out.println("=== Multi-Tier Discount System ==="); 
        System.out.println("Purchase Amount: P" + purchaseAmount); 
        System.out.println("Discount Tier: " + discountTier); 
        System.out.println("Discount Amount: P" + discountAmount); 
        System.out.println("Final Discounted Price: P" + finalPrice); 
    } 
}