import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//import com.sat.tmf.paymentscli.entity.User;

public class PaymentsFileOps {
	public final String usersFilePath = "F:\\sivasai\\PaymentAppFile\\Payments_CLI_USers.csv";
	
	public void writeUserToFile(User u) throws IOException {
		File userFile = new File(usersFilePath);
		FileWriter fw = new FileWriter(userFile,true);
		fw.write(u.userToFileRecord());
		
		fw.flush();
		fw.close();
	}

}
