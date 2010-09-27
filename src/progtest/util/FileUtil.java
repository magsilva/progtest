package progtest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class FileUtil {

	public static File copy(File src, File dst) throws IOException {

		if (!dst.exists())
			dst.mkdirs();

		if (src.isDirectory()) {

			String[] children = src.list();

			for (int i = 0; i < children.length; i++)
				copy(new File(src, children[i]), new File(dst, src.getName()));

		} else {

			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst + File.separator
					+ src.getName());

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			in.close();
			out.close();

		}

		return new File(dst + File.separator + src.getName());

	}

	public static void copyContent(File src, File dst) throws IOException {

		if (!dst.exists())
			dst.mkdirs();

		if (src.isDirectory()) {

			String[] children = src.list();

			for (int i = 0; i < children.length; i++)
				copy(new File(src, children[i]), dst);

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

	public static void move(File src, File dst) throws IOException {
		copy(src, dst);
		delete(src);
	}

	public static void zip(File[] inputFiles, File outputFile)
			throws IOException {
		if (inputFiles != null && inputFiles.length > 0) {
			if (!outputFile.getParentFile().exists())
				outputFile.getParentFile().mkdirs();
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					outputFile));
			Stack<File> parentDirs = new Stack<File>();
			zipFiles(parentDirs, inputFiles, out);
			out.close();
		}
	}

	private static void zipFiles(Stack<File> parentDirs, File[] inputFiles,
			ZipOutputStream out) throws IOException {

		byte[] buf = new byte[1024];

		for (int i = 0; i < inputFiles.length; i++) {

			if (inputFiles[i].isDirectory()) {

				parentDirs.push(inputFiles[i]);
				zipFiles(parentDirs, inputFiles[i].listFiles(), out);
				parentDirs.pop();

			} else {

				FileInputStream in = new FileInputStream(inputFiles[i]);

				String path = "";
				for (File parentDir : parentDirs) {
					path += parentDir.getName() + "/";
				}

				out.putNextEntry(new ZipEntry(path + inputFiles[i].getName()));

				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}

				out.closeEntry();
				in.close();

			}
		}
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

	public static List<File> listFiles(File dir) {
		List<File> files = new ArrayList<File>();
		File[] localFiles = dir.listFiles();
		for (File file : localFiles) {
			if (file.isDirectory()) {
				files.addAll(FileUtil.listFiles(file));
			} else {
				files.add(file);
			}
		}
		return files;
	}

	public static List<File> listFiles(File dir, String extensionFilter) {
		List<File> files = new ArrayList<File>();
		File[] localFiles = dir.listFiles();
		for (File file : localFiles) {
			if (file.isDirectory()) {
				files.addAll(FileUtil.listFiles(file, extensionFilter));
			} else if (file.getName().endsWith(extensionFilter)) {
				files.add(file);
			}
		}
		return files;
	}

	public static List<String> list(File dir) {
		List<String> files = new ArrayList<String>();
		File[] localFiles = dir.listFiles();
		for (File file : localFiles) {
			if (file.isDirectory()) {
				files.addAll(FileUtil.list(file));
			} else {
				files.add(file.getName());
			}
		}
		return files;
	}

	public static List<String> list(File dir, String extensionFilter) {
		List<String> files = new ArrayList<String>();
		File[] localFiles = dir.listFiles();
		for (File file : localFiles) {
			if (file.isDirectory()) {
				files.addAll(FileUtil.list(file, extensionFilter));
			} else if (file.getName().endsWith(extensionFilter)) {
				files.add(file.getName());
			}
		}
		return files;
	}

	public static List<String> list(File dir, String extensionFilter,
			String separator) {
		List<String> files = new ArrayList<String>();
		File[] localFiles = dir.listFiles();
		for (File file : localFiles) {
			if (file.isDirectory()) {
				files.addAll(FileUtil.list(file, extensionFilter, separator
						+ file.getName()));
			} else if (file.getName().endsWith(extensionFilter)) {
				files.add(separator + file.getName());
			}
		}
		return files;
	}

	public static boolean mkdir(File rootDir) {
		return rootDir.mkdir();
	}

	public static boolean mkdirs(File rootDir) {
		return rootDir.mkdirs();
	}

	public static void merge(File src1, File src2, File dst) throws IOException {
		copyContent(src1, dst);
		copyContent(src2, dst);
	}

}
