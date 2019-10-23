package teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ssss {

	public static void main(String[] args) throws IOException {
		/*
		 * OutputStream bytes = new FileOutputStream("saida.txt", true); // passado
		 * "true" para gravar no mesmo arquivo OutputStreamWriter chars = new
		 * OutputStreamWriter(bytes); BufferedWriter strings = new
		 * BufferedWriter(chars);
		 * 
		 * strings.write("Guj"); strings.replace("emprestrado", "devolvido");
		 * 
		 * strings.close();
		 */
		
		Path path = Paths.get("saida.txt");
        List<String> linhas = Files.readAllLines(path);

        String novoConteudo = 
            linhas.get(0).substring(0, 7) + "conteudo" + linhas.get(0).substring(15);

        linhas.remove(0);
        linhas.add(0, novoConteudo);

        Files.write(path, linhas);
	}

}
