/**
 * IT 178
 */
package edu.ilstu;
import java.util.*;
/**
 * 
 * @author Brandon Claahsen
 * 
 * Reviewing arrays in Java with a cryptogram
 * 
 * ULID: bdclaah
 * 
 * Date: 1/10/22
 *
 */
public class CryptogramClient {

	/**
	 * @param args
	 */
	public static void main( String [] args )
	  {
	    Cryptogram cg = new Cryptogram( );
	    System.out.println( cg ); // print alphabet and substitution code

	    Scanner scan = new Scanner( System.in );

	    System.out.println( "\nEnter the phrase to encrypt:" );
	    String phrase = scan.nextLine( );

	    String code = cg.encrypt( phrase );

	    System.out.println( "The encrypted phrase is " +  code );

	    String plainText = cg.decrypt( code );

	    System.out.println( "The decrypted phrase is " +  plainText );
	  }

}
