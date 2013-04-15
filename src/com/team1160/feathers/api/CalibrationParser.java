package com.team1160.feathers.api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

/**
 * A class that will take a
 * calibration file and will
 * read the values and assign them
 *
 * @Author Ethan
 */
public class CalibrationParser{
    protected Map<String, Double> left, right, middle, general;
    
    /**
     * Will parse a config file for the new values
     *
     * @param config a file that represents the config file, if null the system will look in default locations for the config
     */
    protected static CalibrationParser INSTANCE;

	private Scanner config;

	
    private CalibrationParser(){

    }
    
    public CalibrationParser getInstance(){
	if(INSTANCE == null){
	    INSTANCE = new CalibrationParser();
	}
	return INSTANCE;
    }

    public void parse(File configFile) throws FileNotFoundException{
	// If fed no config get a default one
	if(configFile == null){
	    configFile = findDefault();
	}
	config = new Scanner(new BufferedReader(new FileReader(configFile)));
	config.useDelimiter("\n");
	while(config.hasNext()){
	    String[] words = config.next().split(" ");
	    if(checkValidity(words)){
		if(words[3].equals("left")){
			left.put(words[1], Double.parseDouble(words[4]));
		    }
		    
	    }
	}
    }
    protected boolean checkValidity(String[] words){
	return((words.length == 5) &&
	       (words[0].equals("v")) &&
	       (words[2].equals("s")) &&
	       ((words[3].equals("left")) || 
	    	(words[3].equals("right")) ||
	    	(words[3].equals("middle")) ||
	    	(words[3].equals("general"))
	    		   )
			);
    }

    /**
     * Simple function that creates the dictionaries
     */
    protected void initTables(){
	// Just makes all the dictionaries
	left = new HashMap<String, Double>();
	right = new HashMap<String, Double>();
	middle = new HashMap<String, Double>();
	general = new HashMap<String, Double>();
    }

    /**
     * Returns a default config file.
     *
     * @return a default config file
     */
    protected File findDefault(){
	// For now there is no default config	
    	return null;
    }

    public Map<String, Double> getLeftConfig(){
    	return this.left;
    }

    public Map<String, Double> getRightConfig(){
    	return this.right;
    }
    
    public Map<String, Double> getMiddleConfig(){
    	return this.middle;
    }

    public Map<String, Double> getGeneralConfig(){
    	return this.general;
    }

}
