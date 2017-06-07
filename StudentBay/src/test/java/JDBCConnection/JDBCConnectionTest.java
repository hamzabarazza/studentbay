/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBCConnection;

import bonn.org.studentbay.model.objects.dto.User;
import bonn.org.studentbay.process.control.RegistrationControl;
import bonn.org.studentbay.process.control.exceptions.RegisterFail;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
/**
 *
 * @author jens
 */
public class JDBCConnectionTest {

	

	final String username = "superman";
	final String vorname = "super";
        final String nachname = "man";
        final String email = "super@man.com";
	final String password = "super123";
        final LocalDate geburtstag= null;
	
        User user = new User();
        
        RegistrationControl regcontrol = new RegistrationControl();

        
        @Test
        public void JDBCConnection_CREATEandREAD(){
            
            try {
                regcontrol.registerUser(username,vorname,nachname, geburtstag, email, password);
            } catch (RegisterFail ex) {
                Logger.getLogger(JDBCConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            assertEquals( "superman", user.getUsername() );
            assertEquals( "super", user.getVorname() );
            assertEquals( "super123", user.getPasswort() );
            assertNotNull(user.getID());
        }

        @Test
        public void JDBCConnection_UPDATE(){
            user.setVorname("Rudolf");
            user.setPasswort("rudolf123");
            assertEquals("Rudolf", user.getVorname());
            assertEquals("rudolf123", user.getPasswort());
        }
        
        
        @Test
        public void JDBCConnection_DELETE(){
            
            user.deleteData();
            
            assertNull(user.getUsername());
            assertNull(user.getVorname());
            assertNull(user.getNachname());
            assertNull(user.getPasswort());
            assertNull(user.getID());
        }
        
        
}
