package livre.model;

public class Readbooks {
    private int readbook_id;
    private String bookname;
    private String imagelink;
    private String pdflink;
    private String category;

    // Getters and setters
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getPdflink() {
        return pdflink;
    }

    public void setPdflink(String pdflink) {
        this.pdflink = pdflink;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReadbookId() {
        return readbook_id;
    }

    public void setReadbookId(int newBookId) {
        this.readbook_id = newBookId;
    }

    // Constructors
    public Readbooks(int readbook_id, String bookname, String imagelink, String pdflink, String category) {
        super();
        this.readbook_id = readbook_id;
        this.bookname = bookname;
        this.imagelink = imagelink;
        this.pdflink = pdflink;
        this.category = category;
    }

    public Readbooks() {
        // Default constructor
    }

    public Readbooks(int readbook_id2, String bookname2, String imagelink2, int i, String category2) {
        // Constructor with parameters, but not all parameters are used
    }

    // Override toString method to provide a human-readable representation
    @Override
    public String toString() {
        return "Readbooks [bookname=" + bookname + ", imagelink=" + imagelink + ", pdflink=" + pdflink
                + ", category=" + category + "]";
    }
}
