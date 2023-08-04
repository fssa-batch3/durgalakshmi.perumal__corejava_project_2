package livre.model;

public class UpadteReadBooks {
	public static void main(String[] args) {
        Readbooks updatedBook = new Readbooks("Book Title", "new_image_link", "new_pdf_link", "new_category");

        
        updatedBook.setBookname("Book Title"); 
        updatedBook.setImagelink("new_image_link");
        updatedBook.setPdflink("new_pdf_link");
        updatedBook.setCategory("new_category");
}
}