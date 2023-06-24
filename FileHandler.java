import java.io.FileWriter;
import java.io.PrintWriter;

public class FileHandler {
	private String surveyFile = "survey_results.csv";
	private FileWriter fileOutput;
	private PrintWriter printWriter;
	//The FileHandler class will write out the surveyData read from the gui onto the csv file.
	public FileHandler(){
		try {
			fileOutput = new FileWriter(surveyFile, true);
			printWriter = new PrintWriter(fileOutput);
			printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
		}
		catch(Exception e) {
			
		}
	}
	
	//Writes results out to the survey file
	public void writeResults(String surveyData) {
	    try {
	    	fileOutput = new FileWriter(surveyFile, true);
			printWriter = new PrintWriter(fileOutput);
			printWriter.println(surveyData);
	    	printWriter.close();
	    	fileOutput.close();
	    }
	    catch(Exception e) {
	    	
	    }
	}
}
