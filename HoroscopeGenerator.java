
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This application will display the horoscope for a given birthdate.  
 * @author Jeremy Timothy Brown
 *
 */
public class HoroscopeGenerator extends JFrame {


	private JLabel instructions;
	private JPanel panel;
	public static ArrayList<String> horoscopes;
	
	/** Months of the year **/
	public static String [] months = {"January", "February", "March", "April",
		"May", "June", "July", "August", "September", "October", "November",
		"December"};

	/** Zodiac signs **/
	public static String [] zodiacs = {"Sagittarius", "Capricorn", "Aquarius", "Pisces", "Aries",
		"Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio" };


	/**
	 * Create the window by setting the title, size, and adding the panel which contains
	 * all of the necessary components. This constructor should also read in all of the horoscopes
	 * from the input file and store them (in an ArrayList).  
	 * @throws IOException 
	 */
	public HoroscopeGenerator(){
		setTitle("Horoscope Generator");
		setSize(400, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();
		add(panel);
		setVisible(true);
	}
	
	/*
	 * Build the panel by adding all of the necessary GUI components including
	 * instructions, entering the birthdate, the horoscope text area, and a button to 
	 * generate the horoscope. 
	 */
	private void buildPanel(){
		
		
		panel = new JPanel();
		instructions = new JLabel("Enter your birthdate");
		JComboBox<String> monthCB = new JComboBox<String>(months);
		JComboBox<Integer> days = new JComboBox<Integer>();
		for(int i=1; i<32; i++){
			days.addItem(i);
		}
		JTextArea display = new JTextArea();
		display.setPreferredSize(new Dimension(300, 480));
		display.setEditable(false);
		display.setFont(new Font("Serif", Font.ITALIC, 16));
		display.setLineWrap(true);
		display.setWrapStyleWord(true);
		JButton button = new JButton("Find My Horoscope");
		panel.add(instructions);
		panel.add(monthCB);
		panel.add(days);
		panel.add(button);
		panel.add(display);
		
		class AddClickListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				display.setText(null);
				Random rand = new Random();
				int rInt = rand.nextInt(20145);
				int x = monthCB.getSelectedIndex();
				int y = (int) days.getSelectedItem();
				String text = getSign(x,y)+": "+horoscopes.get(rInt);
		        display.append(text);
		        display.selectAll();
			}
		}
		
		ActionListener ClickListener = new AddClickListener();
		button.addActionListener(ClickListener);
		
	}
	
	/**
	 * Gets zodiac sign for the birthdate entered by the user.
	 * @param m the user entered month
	 * @param d the user entered day
	 * @return the zodiac sign
	 */
	public static String getSign(int m, int d){
		String s = "";
		
		//Aries, March 21-April 19
		if(months[m].compareTo("March") == 0){
			if(d >= 21){
				s = zodiacs[4];
			}
		}
		else if(months[m].compareTo("April") == 0){
			if(d <= 19){
				s = zodiacs[4];
			}
		}
		
		//Taurus, April 20-May 20
		if(months[m].compareTo("April") == 0){
			if(d >= 20){
				s = zodiacs[5];
			}
		}
		else if(months[m].compareTo("May") == 0){
			if(d <= 20){
				s = zodiacs[5];
			}
		}
		
		//Gemini, May 21-June 20
		if(months[m].compareTo("May") == 0){
			if(d >= 21){
				s = zodiacs[6];
			}
		}
		else if(months[m].compareTo("June") == 0){
			if(d <= 20){
				s = zodiacs[6];
			}
		}
		
		//Cancer, June 21-July 22
		if(months[m].compareTo("June") == 0){
			if(d >= 21){
				s = zodiacs[7];
			}
		}
		else if(months[m].compareTo("July") == 0){
			if(d <= 22){
				s = zodiacs[7];
			}
		}
		
		//Leo, July 23-August 22
		if(months[m].compareTo("July") == 0){
			if(d >= 23){
				s = zodiacs[8];
			}
		}
		else if(months[m].compareTo("August") == 0){
			if(d <= 22){
				s = zodiacs[8];
			}
		}
		
		//Virgo, August 23-September 22
		if(months[m].compareTo("August") == 0){
			if(d >= 23){
				s = zodiacs[9];
			}
		}
		else if(months[m].compareTo("September") == 0){
			if(d <= 22){
				s = zodiacs[9];
			}
		}
		
		//Libra, September 23-October 22
		if(months[m].compareTo("September") == 0){
			if(d >= 23){
				s = zodiacs[10];
			}
		}
		else if(months[m].compareTo("October") == 0){
			if(d <= 22){
				s = zodiacs[10];
			}
		}
		
		//Scorpio, October 23-November 21
		if(months[m].compareTo("October") == 0){
			if(d >= 23){
				s = zodiacs[11];
			}
		}
		else if(months[m].compareTo("November") == 0){
			if(d <= 21){
				s = zodiacs[11];
			}
		}
		
		//Sagittarius, November 22 - December 21
		if(months[m].compareTo("November") == 0){
			if(d >= 22){
				s = zodiacs[0];
			}
		}
		else if(months[m].compareTo("December") == 0){
			if(d <= 21){
				s = zodiacs[0];
			}
		}
		
		//Capricorn, December 22-January 19
		if(months[m].compareTo("December") == 0){
			if(d >= 22){
				s = zodiacs[1];
			}
		}
		else if(months[m].compareTo("January") == 0){
			if(d <= 19){
				s = zodiacs[1];
			}
		}
		
		//Aquarius, January 20-February 18
		if(months[m].compareTo("January") == 0){
			if(d >= 20){
				s = zodiacs[2];
			}
		}
		else if(months[m].compareTo("February") == 0){
			if(d <= 18){
				s = zodiacs[2];
			}
		}
		
		//Pisces, February 19-March 20
		if(months[m].compareTo("February") == 0){
			if(d >= 19){
				s = zodiacs[3];
			}
		}
		else if(months[m].compareTo("March") == 0){
			if(d <= 20){
				s = zodiacs[3];
			}
		}
		
		return s;
		
	}
	
 
	/**
	 * Create an instance of the window.
	 * @param args Command-line arguments (ignored).
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		String fName = "horoscopes.txt";
		String line;
		
		File file = new File(fName);
		horoscopes = new ArrayList();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((line = br.readLine()) != null) {
			horoscopes.add(line);
        }   
        br.close();
		
		HoroscopeGenerator window = new HoroscopeGenerator();
		

	}

}
