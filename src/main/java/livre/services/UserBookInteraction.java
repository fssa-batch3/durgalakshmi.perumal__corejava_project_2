package livre.services;

public class UserBookInteraction {
    public static void main(String[] args) {
        int userId = 10;
        int readBookId = 12;

        UserBookInteraction interactionService = new UserBookInteraction();
        interactionService.insertUserBookInteraction(userId, readBookId);

        System.out.println("User-book interaction added successfully.");
    }

    private void insertUserBookInteraction(int userId, int readBookId) {
        UserBookInteractionService interactionService = new UserBookInteractionService();
        interactionService.addUserBookInteraction(userId, readBookId);
    }
}
