package apps;

import java.util.ArrayList;
import java.util.List;
public class CustomerUser {
    private int customerId;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String location;
    private double walletBalance;
    private List<String> orderHistory;
    private List<String> reviewHistory;
    private boolean isVerified;

    public CustomerUser() {
        this.customerId = 0;
        this.fullName = "";
        this.phoneNumber = "";
        this.email = "";
        this.location = "";
        this.walletBalance = 0.0;
        this.orderHistory = new ArrayList<>();
        this.reviewHistory = new ArrayList<>();
        this.isVerified = false;

    }
    public CustomerUser(int customerId, String fullName, String phoneNumber, String email, String location){
        this.customerId = customerId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.location = location;
        this.walletBalance = 0.0;
        this.orderHistory = new ArrayList<>();
        this.reviewHistory = new ArrayList<>();
        this.isVerified = false;

    }
    public int getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public List<String> getOrderHistory() {
        return orderHistory;
    }

    public List<String> getReviewHistory() {
        return reviewHistory;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setVerified(boolean verified) {
        this.isVerified = verified;
    }

    public void topUpWallet(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up failed: Amount must be greater than zero.");
            return;
        }
        this.walletBalance += amount;
        System.out.println("Wallet topped up successfully. New balance: UGX" + this.walletBalance);
    }

    public boolean placeOrder(String vendorName, String itemName, double price) {
        if (!isVerified) {
            System.out.println("Order failed: your account is not yet verified.");
            return false;
        }
        if (price > this.walletBalance) {
            System.out.println("Order failed: Insufficient wallet balance.");
            System.out.println("Required: UGX" + price + " | Available: UGX" + this.walletBalance);
            return false;
        }
        this.walletBalance -= price;
        String orderRecord = "Order -> Vendor: " + vendorName + " | Item: " + itemName + " | Price: UGX" + price;
        this.orderHistory.add(orderRecord);
        System.out.println("Order placed successfully!");
        System.out.println(orderRecord);
        System.out.println("Remaining wallet balance: UGX" + this.walletBalance);
        return true;
    }

    public void leaveReview(String vendorName, String review, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Review failed: Rating must be between 1 and 5.");
            return;
        }
        String reviewRecord = "Review for " + vendorName + " [" + rating + "/5]: " + review;
        this.reviewHistory.add(reviewRecord);
        System.out.println("Review submitted: " + reviewRecord);
    }

    public void viewOrderHistory() {
        System.out.println("\nOrder History for " + this.fullName);
        if (orderHistory.isEmpty()) {
            System.out.println("No orders placed yet.");
        } else {
            for (int i = 0; i < orderHistory.size(); i++) {
                System.out.println((i + 1) + ". " + orderHistory.get(i));
            }
        }
    }

    public void viewReviewHistory() {
        System.out.println("Reviews by " + this.fullName);
        if (reviewHistory.isEmpty()) {
            System.out.println("No reviews submitted yet.");
        } else {
            for (int i = 0; i < reviewHistory.size(); i++) {
                System.out.println((i + 1) + ". " + reviewHistory.get(i));
            }
        }
    }

    public void displayProfile() {
        System.out.println("Customer Profile:");
        System.out.println("ID: " + this.customerId);
        System.out.println("Name: " + this.fullName);
        System.out.println("Phone: " + this.phoneNumber);
        System.out.println("Email: " + this.email);
        System.out.println("Location: " + this.location);
        System.out.println("Wallet Balance: UGX" + this.walletBalance);
        System.out.println("Verified: " + (this.isVerified ? "Yes" : "No"));
        System.out.println("Orders Placed: " + this.orderHistory.size());
        System.out.println("Reviews Given: " + this.reviewHistory.size());
    }

    @Override
    public String toString() {
        return "CustomerUser{" +
                "customerId=" + customerId +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", walletBalance=UGX" + walletBalance +
                ", orderHistory=" + orderHistory.size() +
                ", reviewHistory=" + reviewHistory.size() +
                ", isVerified=" + isVerified +
                '}';
    }
}
    