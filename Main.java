import javax.imageio.ImageIO;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JPanel{
	
	static Main m = new Main();
	static JFrame frame = new JFrame("Leddy Bookstore");
	static JPanel panel;

 
	private static Color appColor = new Color(220,220,220);
	private static Color picColor = new Color(128,128,128);
	
	private static String currentPage = "Textbooks";
	
	
	private String name = "Supreyo";
	private String textbookTitle = "Data Structures and Algorithms";
	private int makeYear = 2015;
	private String author = "Mike Long";
	private String publisher = "Publisher X";
	private String category = "Computer Science";
	private double price = 299.99;
	private int stock = 10;
	
	private static String loginUsername;
	private static String loginPassword;
	
	private static String signupUsername;
	private static String signupPassword;

	public BufferedImage returnImg() {
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("./src/Logo.png"));
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
		
	public void drawHeader(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
        g.setColor(appColor);
        g.fillRect(0, 0, 1280, 120);
        
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
        g2d.drawString("Leddy Bookstore", 110, 75);

        g2d.drawImage(returnImg(), 10, 10, null);
	}
	public void loggedInHeader(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
        g2d.drawString("Hello, " + name, 1100, 45);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
        g2d.drawString("Logout", 1185, 110);
    
        if (currentPage == "Textbooks") {
	        g.setFont(new Font("TimesRoman", Font.BOLD, 17)); 
	        g2d.drawString("Textbooks", 520, 110);
	        g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
	        g2d.drawString("Wishlist", 610, 110);
	        g2d.drawString("Return", 680, 110);
	        g2d.drawString("Rent", 740, 110);
        }
        
        if (currentPage == "Wishlist") {
	        g.setFont(new Font("TimesRoman", Font.BOLD, 17)); 
	        g2d.drawString("Wishlist", 610, 110);
	        g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
	        g2d.drawString("Textbooks", 520, 110);
	        g2d.drawString("Return", 680, 110);
	        g2d.drawString("Rent", 740, 110);
        }
        
        if (currentPage == "Return") {
	        g.setFont(new Font("TimesRoman", Font.BOLD, 17)); 
	        g2d.drawString("Return", 680, 110);
	        g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
	        g2d.drawString("Textbooks", 520, 110);
	        g2d.drawString("Rent", 740, 110);
	        g2d.drawString("Wishlist", 610, 110);
        }
        
        if (currentPage == "Rent") {
	        g.setFont(new Font("TimesRoman", Font.BOLD, 17)); 
	        g2d.drawString("Rent", 740, 110);
	        g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
	        g2d.drawString("Textbooks", 520, 110);
	        g2d.drawString("Return", 680, 110);
	        g2d.drawString("Wishlist", 610, 110);
        }
	}
	
	public void drawLogin(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g2d.drawString("Login/Signup", 10, 150);
        
		g.setColor(appColor);
        g.fillRect((1280/2) - 450, (720/2) - 150, 900, 400);
        
        g.setColor(picColor);
        g.fillRect(580, 550, 160, 40);
        g.setColor(Color.black);
        g2d.drawString("Username", 610, 280);
        g2d.drawString("Password", 610, 380);
        g2d.drawString("Login", 630, 580);
	}
	
	public void drawSignUp(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g2d.drawString("Login/Signup", 10, 150);
        
		g.setColor(appColor);
        g.fillRect((1280/2) - 450, (720/2) - 150, 900, 400);
        
        g.setColor(picColor);
        g.fillRect(580, 550, 160, 40);
        g.setColor(Color.black);
        g2d.drawString("Username", 610, 280);
        g2d.drawString("Password", 610, 380);
        g2d.drawString("Signup", 625, 580);
	}
	
	public void drawTextbookList(Graphics g, int y) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(appColor);
        g.fillRect(15, 170 + y, 1240, 125);
        g.setColor(picColor);
        g.fillRect(15, 170 + y, 125, 125);
        
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g2d.drawString(currentPage, 10, 150);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
        g2d.drawString(textbookTitle, 150, 190 + y);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        g2d.drawString(Integer.toString(makeYear), 370, 190 + y);
        g2d.drawString("Author: " + author, 150, 220 + y);
        g2d.drawString("Publisher: " + publisher, 150, 240 + y);
        g2d.drawString("Category: " + category, 150, 260 + y);
        
        g2d.drawString("Add to Wishlist", 700, 220 + y);
        g2d.drawString("Rent", 700, 240 + y);
        g2d.drawString("Purchase", 700, 260 + y);
        g2d.drawString("Stock: " + Integer.toString(stock), 1000, 260 + y);
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g2d.drawString("$" + Double.toString(price), 1000, 240 + y);
	}
	
	public void drawWishList(Graphics g, int y) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(appColor);
        g.fillRect(15, 170 + y, 1240, 125);
        g.setColor(picColor);
        g.fillRect(15, 170 + y, 125, 125);
        
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g2d.drawString(currentPage, 10, 150);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
        g2d.drawString(textbookTitle, 150, 190 + y);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        g2d.drawString(Integer.toString(makeYear), 370, 190 + y);
        g2d.drawString("Author: " + author, 150, 220 + y);
        g2d.drawString("Publisher: " + publisher, 150, 240 + y);
        g2d.drawString("Category: " + category, 150, 260 + y);
        
        g2d.drawString("Remove from Wishlist", 700, 220 + y);
        g2d.drawString("Rent", 700, 240 + y);
        g2d.drawString("Purchase", 700, 260 + y);
        g2d.drawString("Stock: " + Integer.toString(stock), 1000, 260 + y);
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g2d.drawString("$" + Double.toString(price), 1000, 240 + y);
	}
	
	public void drawReturnList(Graphics g, int y) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(appColor);
        g.fillRect(15, 170 + y, 1240, 125);
        g.setColor(picColor);
        g.fillRect(15, 170 + y, 125, 125);
        
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g2d.drawString(currentPage, 10, 150);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
        g2d.drawString(textbookTitle, 150, 190 + y);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        g2d.drawString(Integer.toString(makeYear), 370, 190 + y);
        g2d.drawString("Author: " + author, 150, 220 + y);
        g2d.drawString("Publisher: " + publisher, 150, 240 + y);
        g2d.drawString("Category: " + category, 150, 260 + y);
        
        g2d.drawString("Return", 700, 260 + y);
        g2d.drawString("Stock: " + Integer.toString(stock), 1000, 260 + y);
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g2d.drawString("$" + Double.toString(price), 1000, 240 + y);
	}
	
	public void drawRentList(Graphics g, int y) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(appColor);
        g.fillRect(15, 170 + y, 1240, 125);
        g.setColor(picColor);
        g.fillRect(15, 170 + y, 125, 125);
        
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g2d.drawString(currentPage, 10, 150);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
        g2d.drawString(textbookTitle, 150, 190 + y);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        g2d.drawString(Integer.toString(makeYear), 370, 190 + y);
        g2d.drawString("Author: " + author, 150, 220 + y);
        g2d.drawString("Publisher: " + publisher, 150, 240 + y);
        g2d.drawString("Category: " + category, 150, 260 + y);
        
        g2d.drawString("Rent", 700, 260 + y);
        g2d.drawString("Stock: " + Integer.toString(stock), 1000, 260 + y);
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g2d.drawString("$" + Double.toString(price), 1000, 240 + y);
	}
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        
        drawHeader(g);
        
        if (currentPage == "Login") {
            drawLogin(g);
            
        }
        
        else if (currentPage == "Signup") {
            drawSignUp(g);
            
        }
        
        else if (currentPage == "Textbooks") {
        	loggedInHeader(g);
        	
            for (int i = 0; i < 3; i++) {
            	drawTextbookList(g, 150 * i);
            }
        }
        
        else if (currentPage == "Wishlist") {
        	loggedInHeader(g);
        	
            for (int i = 0; i < 3; i++) {
            	drawWishList(g, 150 * i);
            }
        }
        
        else if (currentPage == "Return") {
        	loggedInHeader(g);
        	
            for (int i = 0; i < 3; i++) {
            	drawReturnList(g, 150 * i);
            }
        }
        
        else if (currentPage == "Rent") {
        	loggedInHeader(g);
        	
            for (int i = 0; i < 3; i++) {
            	drawRentList(g, 150 * i);
            }
        }
    }
	
	public static void main(String args[]) {

        if (currentPage == "Login" || currentPage == "Signup") {
	    	JTextField usernameField = new JTextField("Enter Username");
	    	usernameField.setBounds(100,50, 980,30);
	    	frame.add(usernameField);
	    	
	    	JTextField passwordField = new JTextField("Enter Password");
	    	passwordField.setBounds(100, 150, 980, 30);
	    	frame.add(passwordField);
	    	
	    	if (currentPage == "Login") {
		    	JButton submitButton = new JButton("Login");
		    	submitButton.setBounds((1280/2) - 125, 300, 250, 30);
		    	frame.add(submitButton);
	    	
		    	submitButton.addActionListener(new ActionListener() {
		    		@Override
		    	    public void actionPerformed(ActionEvent e) {
		    		  	loginUsername = usernameField.getText();
		    	    	loginPassword = passwordField.getText();
		    	    	
		    	    	System.out.println("Login Username: " + loginUsername);
		    	        System.out.println("Login Password: " + loginPassword);
		    	    }
		    	});
	    	}
	    	
	    	else {
		    	JButton submitButton = new JButton("Signup");
		    	submitButton.setBounds((1280/2) - 125, 300, 250, 30);
		    	frame.add(submitButton);
	    	
		    	submitButton.addActionListener(new ActionListener() {
		    		@Override
		    	    public void actionPerformed(ActionEvent e) {
		    		  	signupUsername = usernameField.getText();
		    		  	signupPassword = passwordField.getText();
		    	    	
		    	    	System.out.println("Signup Username: " + signupUsername);
		    	        System.out.println("Signup Password: " + signupPassword);
		    	    }
		    	});
	    	}
	    	
	    	
	    	frame.setLayout(null);
        }
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280,720);
		frame.setVisible(true);
		frame.add(m);
	}
}


