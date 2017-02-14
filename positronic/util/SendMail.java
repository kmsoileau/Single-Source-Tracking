package positronic.util;

import java.applet.Applet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ProtocolException;
import java.net.Socket;

public class SendMail extends Applet
{
	private static final long serialVersionUID = 5948807191053324085L;

	public SendMail() throws IOException
	{
		sendMail("ksoileau@yahoo.com", "kerry.m.soileau@nasa.gov", "Test Message", "Hello World");
	}
	
	private String readLine(BufferedReader in) throws IOException
	{
		return in.readLine();
	}

	public void sendMail(String to_address,   // Destinataire du message
    String from_address, // Emeteur du message
    String sSu,          // Sujet du message
    String sMess) throws IOException
	{
		Socket socket;       // Le Socket
		BufferedReader in;  // Le stream de lecture du Socket
		PrintStream out;     // Le stream d'ecriture du Socket
		String host;         // Identification du poste
		String str;          // Pour la lecture de donnees
		
		// Identification du poste
		// host peut etre force a www.ibm.com ou autre en cas de probleme
		host = InetAddress.getLocalHost().toString() ;
		
		// Ouverture du socket (connection au mailServer)
		//   et des streams de lecture et d'ecriture
		
		socket = new Socket(getDocumentBase().getHost(), 25);
		in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out    = new PrintStream(socket.getOutputStream());
		
		// lecture du message initial
		str = readLine(in);
		if (!str.startsWith("220"))    throw new ProtocolException(str);
		
		while (str.indexOf('-') == 3) 
		{
			str = readLine(in);
			if (!str.startsWith("220"))  throw new ProtocolException(str);
		}
		// fin message initial
		
		// Dialogue avec les Serveur de mail
		// Envoie de HELO au serveur SMTP
		out.println( "HELO " + host );
		out.flush() ;
		str = readLine(in);
		if (!str.startsWith("250"))    
			throw new ProtocolException(str);
		
		// On est connecte au serveur de Mail...
		
		// Envoie du Mail
		out.println( "MAIL FROM: " + from_address );
		out.flush() ;
		str = readLine(in);
		if (!str.startsWith("250"))    
			throw new ProtocolException(str);
		
		// A qui envoie t on cela 
		out.println( "RCPT TO: " + to_address );
		out.flush() ;
		str = readLine(in);
		if (!str.startsWith("250"))    
			throw new ProtocolException(str);
		
		// Est on pret a envoyer les donnees
		out.println( "DATA" );
		out.flush() ;
		str = readLine(in);
		if (!str.startsWith("354"))    
			throw new ProtocolException(str);
		
		// Emmeteur - Destinataire - Sujet
		out.println("From: " + from_address);
		out.println("To: " + to_address);
		out.println( "Subject: " + sSu + "\n" );
		out.flush() ;
		
		out.println("Comment: Unauthenticated sender");
		out.println("X-Mailer: Simple tSmtp");
		out.println("");
		out.println( sMess ) ;
		out.println(".") ;
		out.flush() ;
		
		str = readLine(in);
		if (!str.startsWith("250"))    
			throw new ProtocolException(str);
		
		out.println("QUIT");
		out.flush();
		
		in.close() ;
		socket.close()  ;
	}
}
