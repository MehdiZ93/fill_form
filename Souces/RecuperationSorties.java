package fill_cerfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RecuperationSorties extends Thread {  

	/* Le flux à rediriger  */
	private InputStream flux;

	/**
	 * Constructeur de RecuperationSorties
	 * @param flux
	 *  Le flux à rediriger
	 */
	public RecuperationSorties(InputStream flux){
		this.flux = flux;
	}
	 
	public void run(){
		try {    
			InputStreamReader reader = new InputStreamReader(flux);
			BufferedReader br = new BufferedReader(reader);
			String ligne=null;
			if ( (ligne = br.readLine()) != null){
				System.out.println(ligne);
				System.exit(1);
			}
		}
		catch (IOException ioe){
			ioe.printStackTrace();
			System.exit(1);
		}
	}
}