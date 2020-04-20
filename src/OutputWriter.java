import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {
	File fout;
	File dir = new File(".");

	public OutputWriter(File file) {
		this.fout = file;

		if (fout.exists()){
			fout.delete();
		}
		
		System.out.println(fout.toString());
	}

	public void writeOutput(String line) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			if (!fout.exists()) {
				fout.createNewFile();
			}

			fw = new FileWriter(fout, true);
			bw = new BufferedWriter(fw);
			bw.write(line + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}}
	