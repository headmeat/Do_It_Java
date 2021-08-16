import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.time.temporal.ChronoUnit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.opencsv.CSVWriter;

public class PriorityExample {
	static double total = 0.0;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
        String prob = "";
        double probability = 0.0;
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalTime time = LocalTime.now();
        
        Thread thread = new Thread() {
			public void run() {
				try {
					//TimeUnit.MINUTES.sleep(2);
					TimeUnit.SECONDS.sleep(5);
					
					throw new Exception();
				}catch(Exception e) {
					System.out.println("GOTCHA?"); //comes here...
				}
			}
		};
        
        while (true) {
        	//TimeUnit.MINUTES.sleep(10);
        	JOptionPane op = new JOptionPane();
        	JDialog jd = op.createDialog("Title");
        	jd.setAlwaysOnTop(true);
        	jd.setVisible(true);

            while(true) {
            	try {
            		
            		
            		prob = JOptionPane.showInputDialog("Faithful?");
            		
            		thread.start();
            		
                    probability = Double.parseDouble(prob);
                    break;
            	}catch(Exception e) {
            		System.out.println("GOTCHA!");
            		probability = 0.0;
            		break;
            	}
            }
            
            if (probability<=0||probability>10)
                break;
            
            total += probability;
            
            System.out.println("\"" + prob + "\"" + "을 입력하였습니다.");
            
            count += 10;
        }
        
        System.out.println("전체 시도 횟수는 "+count+"입니다.");
        System.out.println("전체 성실도는 "+total+"입니다.");
        writeHeaders();
        writeDataLineByLine(date, String.valueOf(total/count), String.valueOf(time.until(LocalTime.now(), ChronoUnit.MINUTES)/60.0));
        
        System.exit(0);
    }
	
	public static void writeHeaders() {
		File file = new File("C:/Users/headm/OneDrive/Desktop/works.csv");
		
		if(isAppend()) return;
		
		try(FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile)){

	        String[] header = {"Date", "Concentration", "Hours"};
	        writer.writeNext(header);
		}catch(Exception e) {}
	}
	
	public static void writeDataLineByLine(String ... args)
	{
	    File file = new File("C:/Users/headm/OneDrive/Desktop/works.csv");
	    
	    try(FileWriter outputfile = new FileWriter(file, isAppend());
		    CSVWriter writer = new CSVWriter(outputfile)) {
	        writer.writeNext(args);
	        writer.close();
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static boolean isAppend() {
		File file = new File("C:/Users/headm/OneDrive/Desktop/works.csv");
		
		if(file.length()<=2) {
			return false;
		}else
			return true;
	}
}
