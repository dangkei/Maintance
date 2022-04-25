package ftp;
import java.util.UUID;
import org.apache.log4j.PropertyConfigurator ; 
import org.apache.log4j.Logger ;

public class GUID {
	static Logger logger = Logger.getLogger(GUID.class.getName()) ; 
	private  UUID uuid ;
	public static void main(String[] args) {
		PropertyConfigurator.configure ( "log.properties" ) ;
	    UUID uuid = UUID.randomUUID();     
	    logger.info(uuid);  
	}  
	public UUID getGuid(){
	   UUID uuid = UUID.randomUUID();
	    return uuid;
	}
}
