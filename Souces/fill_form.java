package fill_cerfa;

import java.io.IOException;

public class fill_cerfa {
	 
	
	public void pdftk(String ex){
		
		/* Récupération de l'environnement d'exécution */  
		Runtime runtime = Runtime.getRuntime();
		
		try {
			/* Création et lancement de processus*/
			Process p = runtime.exec(ex);
	
			
			/* Lancement du thread de récupération de la sortie en erreur */
			new RecuperationSorties(p.getErrorStream()).start();
			
			p.waitFor();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fill_cerfa nv = new fill_cerfa();
		if (args.length >= 4)
		{
			/*création de la ligne de commande à éxécuté*/
			String ex = "/usr/local/bin/pdftk "+ args[0] + " fill_form " + args[1] + " output " + args[3] + args[2];
			nv.pdftk(ex);
		}
		else
		{
			System.out.println("Pas assez d'arguments (\"fomulaire pdf\" \"fichier.xml\" \"resultat.pdf\" \"chemin\")");
			System.exit(2);
		}
	}

}
