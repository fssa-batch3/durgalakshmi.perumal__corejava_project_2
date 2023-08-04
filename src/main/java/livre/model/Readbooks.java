package livre.model;

public class Readbooks {
	   private int readbook_id;
	private String bookname;
	private String imagelink;
	private String pdflink;
    private String category;
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
	
	 public int getReadbookId() {
	        return readbook_id;
	    }

	    public void setReadbookId(int newBookId) {
	        this.readbook_id = newBookId;
	    }
	public Readbooks(int readbook_id,String bookname, String imagelink, String pdflink, String category) {
		super();
		 this.readbook_id = readbook_id;
		this.bookname = bookname;
		this.imagelink = imagelink;
		this.pdflink = pdflink;
		this.category = category;
	}
	
	

	public Readbooks() {
		// TODO Auto-generated constructor stub
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Readbooks [bookname=" + bookname + ", imagelink=" + imagelink + ", pdflink=" + pdflink + ", category="
				+ category + "]";
	}
	

	
}
