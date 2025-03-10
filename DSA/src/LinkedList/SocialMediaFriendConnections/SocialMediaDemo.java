 package LinkedList.SocialMediaFriendConnections;

 import java.util.*;

 class User {
     int userId;
     String name;
     int age;
     List<Integer> friends;
     User next;

     public User(int userId, String name, int age) {
         this.userId = userId;
         this.name = name;
         this.age = age;
         this.friends = new ArrayList<>();
         this.next = null;
     }
 }

 class SocialMedia {
     private User head;

     // Add a new user
     public void addUser(int userId, String name, int age) {
         User newUser = new User(userId, name, age);
         if (head == null) {
             head = newUser;
         } else {
             User temp = head;
             while (temp.next != null) {
                 temp = temp.next;
             }
             temp.next = newUser;
         }
     }

     // Find a user by ID
     private User findUser(int userId) {
         User temp = head;
         while (temp != null) {
             if (temp.userId == userId) {
                 return temp;
             }
             temp = temp.next;
         }
         return null;
     }

     // Add a friend connection
     public void addFriend(int userId1, int userId2) {
         User user1 = findUser(userId1);
         User user2 = findUser(userId2);
         
         if (user1 != null && user2 != null && userId1 != userId2) {
             if (!user1.friends.contains(userId2)) {
                 user1.friends.add(userId2);
                 user2.friends.add(userId1);
             }
         }
     }

     // Remove a friend connection
     public void removeFriend(int userId1, int userId2) {
         User user1 = findUser(userId1);
         User user2 = findUser(userId2);
         
         if (user1 != null && user2 != null) {
             user1.friends.remove((Integer) userId2);
             user2.friends.remove((Integer) userId1);
         }
     }

     // Display all friends of a user
     public void displayFriends(int userId) {
         User user = findUser(userId);
         if (user != null) {
             System.out.println("Friends of " + user.name + ": " + user.friends);
         }
     }

     // Find mutual friends
     public void findMutualFriends(int userId1, int userId2) {
         User user1 = findUser(userId1);
         User user2 = findUser(userId2);
         
         if (user1 != null && user2 != null) {
             Set<Integer> mutual = new HashSet<>(user1.friends);
             mutual.retainAll(user2.friends);
             System.out.println("Mutual Friends: " + mutual);
         }
     }

     // Search user by ID or Name
     public void searchUser(String name) {
         User temp = head;
         while (temp != null) {
             if (temp.name.equalsIgnoreCase(name)) {
                 System.out.println("User Found: " + temp.name + " (ID: " + temp.userId + ")");
                 return;
             }
             temp = temp.next;
         }
         System.out.println("User not found");
     }

     // Count friends of each user
     public void countFriends() {
         User temp = head;
         while (temp != null) {
             System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
             temp = temp.next;
         }
     }
 }

 public class SocialMediaDemo {
     public static void main(String[] args) {
         SocialMedia sm = new SocialMedia();
         
         sm.addUser(1, "Alice", 25);
         sm.addUser(2, "Bob", 30);
         sm.addUser(3, "Charlie", 22);
         
         sm.addFriend(1, 2);
         sm.addFriend(1, 3);
         sm.displayFriends(1);
         
         sm.findMutualFriends(2, 3);
         sm.countFriends();
     }
 }

