import java.util.*;
class Guest{
    private String guestName;
    private String guestIdNumber;
    Guest(String guestName, String guestIdNumber){
        this.guestName=guestName;
        this.guestIdNumber=guestIdNumber;
    }
    public String getGuestName(){
        return guestName;
    }
    public String getIdNumber(){
        return guestIdNumber;
    }
}
class Room{
    private int roomNumber;
    private String roomType;
    private double price;
    public Room(){

    }
    public Room(int roomNumber, String roomType,double price){
        this.roomNumber=roomNumber;
        this.roomType=roomType;
        this.price=price;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public String getRoomType(){
        return roomType;
    }
    public double getPrice(){
        return price;
    }
}
class SingleRoom extends Room{                        // specialization
    SingleRoom(int roomNumber, String roomType, double price){
        super(roomNumber,roomType,price);
        }
}
class DoubleRoom extends Room{                       //specialization
    DoubleRoom(int roomNumber,String roomType, double price){
        super(roomNumber,roomType,price);
        }
}
// PAYMENT CLASS ----> COMPOSITION
class Payment{
    private double amount;
    private String paymentMethod;
   public  Payment(double amount, String paymentMethod){
    this.amount=amount;
    this.paymentMethod=paymentMethod;
   }
   public double getAmount(){
    return amount;
   }
   public String getPaymentMethod(){
    return paymentMethod;
   }
}
class Booking{
    private Guest guest;
    private Payment payment;
    private List<Room>rooms;
    // Constructor for booking by room type
   public Booking(Guest guest, List<Room> rooms) { 
    this.guest = guest; 
    this.rooms = rooms; 
}
    //Constructor for booking by specific room number
     public Booking(Guest guest, Room room) { 
        this.guest = guest; 
        this.rooms = new ArrayList<>();
         this.rooms.add(room); 
    }
    public void setPayment(Payment payment) { 
        this.payment = payment;
     }
     public void displayBookingDetails() { 
        System.out.println("Guest: " + guest.getGuestName() + ", Email: " + guest.getIdNumber());
         for (Room room : rooms) { 
            System.out.println("Room Number: " + room.getRoomNumber() + ", Room Type: " + room.getRoomType() + ", Price: " + room.getPrice());
         } if (payment != null) { 
            System.out.println("Payment Amount: " + payment.getAmount() + ", Payment Method: " + payment.getPaymentMethod());
         }
         }
}
// Main class to demonstrate the hotel booking system
public class HotelBookingSystem{
    public static void main(String[] args) {
        Guest guest = new Guest("John Doe", "john.doe@example.com");

        Room singleRoom = new SingleRoom(101,"SingleRoom", 100.0);
        Room doubleRoom = new DoubleRoom(102,"DoubleRoom", 150.0);

        List<Room> rooms = new ArrayList<>();
        rooms.add(singleRoom);
        rooms.add(doubleRoom);

        Booking booking1 = new Booking(guest, rooms);
        Payment payment1 = new Payment(250.0, "Credit Card");
        booking1.setPayment(payment1);
        booking1.displayBookingDetails();

        Booking booking2 = new Booking(guest, singleRoom);
        Payment payment2 = new Payment(100.0, "Cash");
        booking2.setPayment(payment2);
        booking2.displayBookingDetails();
    }
}