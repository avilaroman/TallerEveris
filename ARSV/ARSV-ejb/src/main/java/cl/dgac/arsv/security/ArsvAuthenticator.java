package cl.dgac.arsv.security;


import javax.ejb.Stateful;
import javax.inject.Named;

@Stateful
@Named("authenticator")
public class ArsvAuthenticator /*extends BaseAuthenticator implements Authenticator*/ {

	/*private static Logger log = Logger.getLogger(ArsvAuthenticator.class);

    @Inject Identity identity;
    @Inject Credentials credentials;*/
    
	/*@Override
	public void authenticate() {	
    	log.info("authenticating" + credentials.getUsername());
        //write your authentication logic here,
        //return true if the authentication was
        //successful, false otherwise
        if ("admin".equals(credentials.getUsername()))
        {
            identity.addRole("admin","USERS", "GROUP");
        }
        
    }*/

}
