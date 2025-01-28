import java.util.ArrayList;

class User {
    int userID;
    String name;
    int age;
    ArrayList<Integer> friendIDs; // List of Friend IDs
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    User head;

    // Add a new user
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User " + name + " added.");
    }

    // Add a friend connection
    public void addFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 != null && user2 != null) {
            user1.friendIDs.add(userID2);
            user2.friendIDs.add(userID1);
            System.out.println("Friend connection added between User " + userID1 + " and User " + userID2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find a user by ID
    public User findUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Display friends of a user
    public void displayFriends(int userID) {
        User user = findUserByID(userID);
        if (user != null) {
            System.out.println("Friends of " + user.name + ":");
            for (int friendID : user.friendIDs) {
                System.out.print(friendID + " ");
            }
            System.out.println();
        } else {
            System.out.println("User not found.");
        }
    }
}

public class SocialMediaConnections {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Santa", 25);
        sm.addUser(2, "Banta", 30);
        sm.addUser(3, "Charlie", 22);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);

        sm.displayFriends(1);
    }
}
