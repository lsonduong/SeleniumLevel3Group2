package Cores.Supporter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import TestData.Constant;
 
public class Config{
   Properties configFile;
   
   public Config(){
	   configFile = new Properties();
	   try {
		   InputStream input = new FileInputStream(Utilities.getProjectPath() + Constant.ConfigFile);
		   configFile.load(input);
		   
	   } catch(Exception e){
		   e.printStackTrace();
	   }
   }
 
   public String getProperty(String key){
	   String value = configFile.getProperty(key);
	   return value;
   }
}
