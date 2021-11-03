package es.iespuertodelacruz.adrian.TCadrian;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class ManejoFichero {

	Path path;

	public ManejoFichero() {
	}

	public ManejoFichero(String archivo) {
		path = Paths.get(archivo);
	}

	public void guardar(String txt) {

		try {
			File file = new File(path.toString());
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(txt);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String leer() throws IOException {
		if (!path.toFile().exists()) {
			path.toFile().createNewFile();
		} else {
			try (BufferedReader reader = Files.newBufferedReader(new File(path.toString()).toPath())) {
				String texto = "";
				String line;
				while ((line = reader.readLine()) != null) {
					texto += line + "\n";

				}
				return texto;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}


}
