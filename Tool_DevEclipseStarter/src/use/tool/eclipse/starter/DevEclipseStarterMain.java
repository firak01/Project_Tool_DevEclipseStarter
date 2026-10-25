package use.tool.eclipse.starter;

import java.io.File;
import java.util.HashMap;


/**Klasse, mit der man sich die per Batch beim Eclipsstart übergebenen Variablen ansehen kann.
 * 
 * Merke:
 * Nur standard Java, also keine ZKernel-Klassen verwenden, da dieses Projekt in Umgebungen ohne diese Projekte funktionieren soll.
 * 
 * @author Fritz Lindhauer
 *
 */
public class DevEclipseStarterMain {

	//#######################################
	//### Eintragen von github.com in die C:\Users\<User>\.ssh\known_hosts Datei
	//### Die notwendigen Einträge können hier gefunden werden.
	//### https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/githubs-ssh-key-fingerprints?utm_source=chatgpt.com
	//###
	//### Es sollte aber mit der JschConfigSessionFactoryZZZ diese Prüfung verhindert werden.
	//######################################

	//#######################################
	//### Pfad zum certifier - store, je nach Arbeitsumgebung ist das ein anderer.
	//### Diesen in der Startkonfiguration der JVM setzen
	//### von DEV04
	//### -Djavax.net.ssl.trustStore=C:\java\jdk1.8.0\jre\lib\security\cacerts  -Djavax.net.ssl.trustStorePassword=changeit
	//###
	//### von ERMANARICH / TUBAF
	//### -Djavax.net.ssl.trustStore=C:\java\jdk1.8.0_202\jre\lib\security\cacerts  -Djavax.net.ssl.trustStorePassword=changeit
    //###
	//#########################################
	
	//#########################################
	//### Syntax der Batch-Zeile, für den Aufruf
	//###  -Djavax.net.ssl.trustStore=C:\java\jdk1.8.0\jre\lib\security\cacerts ^
	//###   -Djavax.net.ssl.trustStorePassword=changeit ^
	//###   -cp JgitStarter.jar JgitStarterMain %1
	//###
	//##########################################
	
	//#######################################################
	//### Es gibt:
	//### a) Verschiedene lokale Repos, je nachdem welches Eclipse/welche Entwicklungsumgebung
	//### b) Der RemoteAlias kann ggfs. anders definiert worden sein. Normalfall scheint "origin" zu sein.
	//### Der zu verwendenden Name steht in der Datei .git\config
	//###	 z.B.:
	//###	[remote "JAZDummy"]
	//###	url = git@github.com:firak01/Projekt_Kernel02_JAZDummy.git
	//###	fetch = +refs/heads/*:refs/remotes/JAZDummy/*
	//###
	//######################################################
	
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//+++ INHALT DES secret_starterZZZ.bat
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	//#####################################################
	//### GITHUB PAT (personal access token)
	//### für den Zugriff mit jgit über das HTTPS-Protokoll notwendig
	//#####################################################
	
	//######################################################
	//### API KEYs
	//### a) Als Python Projekte nutze ich OpenAI
	//###    
	//### 

	 /*
	 * @param args
	 * @author Fritz Lindhauer, 22.03.2026, 07:01:47
	 */
	public static void main(String[] args) {
		//siehe: https://www.baeldung.com/jgit
		//siehe: https://www.vogella.com/tutorials/JGit/article.html
		//siehe: https://medium.com/autotrader-engineering/working-with-git-in-java-part-1-a-jgit-tutorial-bc03b404a517
		
		/*Merke:
		 https://stackoverflow.com/questions/11200237/how-do-i-get-git-to-default-to-ssh-and-not-https-for-new-repositories
		 
		 But here is what you can directly add in your .gitconfig:
		# Enforce SSH
		[url "ssh://git@github.com/"]
  			insteadOf = https://github.com/
		[url "ssh://git@gitlab.com/"]
  			insteadOf = https://gitlab.com/
		[url "ssh://git@bitbucket.org/"]
  			insteadOf = https://bitbucket.org/
		 */
		main:{
			try {	
				//Umgebungsvariablen an die Methode des konkreten Projekts durchreichen
				//Sie sind pro Maschine/Eclipse Instanz ggfs. unterschiedlich
				//Nicht vergessen: Diese Umgebungsvariablen werden NUR beim Eclipsestart(!) im entsprechenden Starter gesetzt.
				System.out.println("Vorhandene Umgebungsvariablen, seit Eclipsestart.");				
				System.out.println("Genutzt in JAZxJgit: ...");
				System.out.println("Pfad zum Eclipse repo:\t" + System.getenv("sRLZZZ"));
				System.out.println("Pfad zu cacert:\t\t" + System.getenv("MY_TRUSTSTORE"));
				System.out.println("Github Domain:\t\t" + System.getenv("sRRHZZZ"));		
				System.out.println("Github Account:\t\t" + System.getenv("sRRACZZZ"));
				System.out.println("GitHub PAT:\t\t" + System.getenv("sPATZZZ"));				
				System.out.println();
				System.out.println("Genutzt in PYZxOpenAi: ...");
				System.out.println("API-Key OpenAI:\t\t" + System.getenv("sOPENAIZZZ"));
				
				
			} catch (IllegalStateException e) {
				e.printStackTrace();		
			}
		}//end main:
	}
}
