package livre.model;

public class UserBookInteraction {
	//getter and setter
	 private int userId;
	    private int readBookId;

	    public UserBookInteraction(int userId, int readBookId) {
	        this.userId = userId;
	        this.readBookId = readBookId;
	    }

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getReadBookId() {
			return readBookId;
		}

		public void setReadBookId(int readBookId) {
			this.readBookId = readBookId;
		}
}
