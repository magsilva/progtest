package progtest.addons.junit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	public static List<File> listFiles(File dir, String extensionFilter) {
		List<File> files = new ArrayList<File>();
		File[] localFiles = dir.listFiles();
		for (File file : localFiles) {
			if (file.isDirectory()) {
				files.addAll(listFiles(file, extensionFilter));
			} else if (file.getName().endsWith(extensionFilter)) {
				files.add(file);
			}
		}
		return files;
	}

	public static void clean(File f) {
		if (f.isDirectory()) {
			File[] children = f.listFiles();
			for (int i = 0; i < children.length; i++)
				delete(children[i]);
		}
	}

	public static void delete(File f) {
		clean(f);
		f.delete();
	}

}
