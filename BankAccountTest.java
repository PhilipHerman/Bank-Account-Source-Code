import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *<h1> Bank Account Test </h1>
 *The bank account test program is designed
 *to test the user's bank account, implementing the use
 *of deposits, withdrawals, charges a fee where 
 *appropriate, and prints the user's current balance.
 *<p>
 *
 * @author Emily Lackraj
 * @version 1.0
 * @since 2020-02-10
 */

public class BankAccountTest extends BankAccount {
	
/**
 * The EncryptUserPIN method encrypts the
 * user's PIN.
 * @throws NoSuchAlgorithmException
 * @throws NoSuchPaddingException
 * @throws IllegalBlockSizeException
 * @throws BadPaddingException
 * @throws InvalidKeyException
 */
	public static void EncryptUserPIN () throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		String PIN = "3986";
		String keyBits = "256";
		byte[] encryptionKeyBytes = keyBits.getBytes();
		
		Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKey sk = new SecretKeySpec(encryptionKeyBytes, "AES");
		c.init(Cipher.ENCRYPT_MODE, sk);
		byte[] encryptedMessageBytes = c.doFinal(PIN.getBytes());
	}
	
/**
 * This is the main method which makes use of the deposit,
 * withdraw, charge fee, getBalance, NormalizeString, encodeAcctNum, and EncryptUserPIN methods.
 * @param args Unused
 * @return Nothing
 * @throws Exception Balance in the account cannot be less than
 * the amount the user wants to withdraw.
 */
	public static void main (String []args) throws Exception {
	
		Checking HarrysChecking = new Checking (5000, "3981047", "Harry Jones");
		Savings HarrysSavings = new Savings (2000,"8219304", "Harry Jones");
		
		
		//HarrysChecking.Withdraw(400);
		HarrysChecking.Deposit(100);
		HarrysSavings.Deposit(500);
		//HarrysSavings.Withdraw(300);
		//HarrysChecking.ChargeFee();
		System.out.println("Current balance in Harry Jones's checking account is $ "+HarrysChecking.getBalance());
		System.out.println("Current balance in Harry Jones's savings account is $ "+HarrysSavings.getBalance());
		//System.out.println("Validating the user's account number ");
		//NormalizeString("3981047");
		//System.out.println("Encoding Harry Jones's savings account number: "+encodeAcctNum("8219304"));
		//System.out.println("Encrypting the user's PIN: ");
		//EncryptUserPIN(201, 1024);
		//System.out.println("Decrypting the user's PIN: ");
		//DecryptUserPIN(403, 1024);
		
		
	}
}
