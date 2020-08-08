package arquivos;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ListSubDirs {

	public static void main(String[] args) throws IOException {
		
		String inicio;
		if (args.length > 0) {
			inicio = args[0];
		} else {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Informe o diretório inicial: ");
			inicio = scan.nextLine();
		}
		Path path = Paths.get(inicio);
		DirectoryStream<Path> ds = Files.newDirectoryStream(path);
		listDir(ds);
	}

	private static void listDir(DirectoryStream<Path> ds) throws IOException {
		for (Path p : ds) {
			File f = p.toFile();
			System.out.println(f);
			if (f.isDirectory()) {
				DirectoryStream<Path> d = Files.newDirectoryStream(p);
				listDir(d);
			}
		}
	}

}
