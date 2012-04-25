package progtest.addons.gcov;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class FileUtil {

	public static List<File> list(File dir, String extensionFilter) {
		List<File> files = new ArrayList<File>();
		File[] localFiles = dir.listFiles();
		for (File file : localFiles) {
			if (file.isDirectory()) {
				files.addAll(list(file, extensionFilter));
			} else if (file.getName().endsWith(extensionFilter)) {
				files.add(file);
			}
		}
		return files;
	}

	public static File createTempDirectory() throws IOException {

		String prefix = "temp";
		String suffix = String.valueOf(new Date().getTime());

		File tmpFile = File.createTempFile(prefix, suffix);
		tmpFile.delete();
		tmpFile.mkdir();
		
		return tmpFile;

	}

	public static File copy(File src, File dst) throws IOException {
		
		if (!dst.exists())
			dst.mkdirs();
		
		if (src.isDirectory()) {
			
			String[] children = src.list();
			
			for (int i = 0; i < children.length; i++)
				copy(new File(src, children[i]), new File(dst, src.getName()));
		
		} else {
			
			copyContent(src, new File(dst + File.separator + src.getName()));
		
		}
		
		return new File(dst + File.separator + src.getName());
	
	}

	public static void copyContent(File src, File dst) throws IOException {
		
		if (src.isDirectory()) {
			
			if (!dst.exists())
				dst.mkdirs();
			
			String[] children = src.list();
			
			for (int i = 0; i < children.length; i++)
				copy(new File(src, children[i]), dst);
		
		} else {
			
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);
			
			byte[] buf = new byte[1024];
			
			int len;
			
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			
			in.close();
			out.close();
			
		}
		
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

	public static File createTempFile() throws IOException {

		String prefix = "temp";
		String suffix = String.valueOf(new Date().getTime());

		return File.createTempFile(prefix, suffix);

	}

	public static void unzip(File zipFile, File dst) throws IOException {

		ZipFile zip = null;
		File arquivo = null;
		InputStream is = null;
		OutputStream os = null;
		byte[] buffer = new byte[1024];

		try {

			if (!dst.exists())
				dst.mkdirs();

			if (!dst.isDirectory())
				throw new IOException();

			zip = new ZipFile(zipFile);

			Enumeration<?> e = zip.entries();
			while (e.hasMoreElements()) {

				ZipEntry entrada = (ZipEntry) e.nextElement();
				arquivo = new File(dst, entrada.getName());

				if (arquivo.exists())
					continue;

				if (entrada.isDirectory() && !arquivo.exists()) {
					arquivo.mkdirs();
					continue;
				}

				if (!arquivo.getParentFile().exists())
					arquivo.getParentFile().mkdirs();

				try {

					is = zip.getInputStream(entrada);
					os = new FileOutputStream(arquivo);

					int bytesLidos = 0;

					if (is == null)
						throw new ZipException();

					while ((bytesLidos = is.read(buffer)) > 0)
						os.write(buffer, 0, bytesLidos);

				} finally {

					if (is != null)
						is.close();

					if (os != null)
						os.close();

				}

			}

		} finally {

			if (zip != null)
				zip.close();

		}

	}

}
