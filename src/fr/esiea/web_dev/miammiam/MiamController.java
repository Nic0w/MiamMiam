/**
 * 
 */
package fr.esiea.web_dev.miammiam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author broquet
 *
 */
public interface MiamController {

	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
