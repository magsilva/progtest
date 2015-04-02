package progtest.addons.jabutiservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Grapher {

	private File tmpDir;

	private File rptDir;

	public Grapher(File tmpDir, File rptDir) {
		this.tmpDir = tmpDir;
		this.rptDir = rptDir;
	}

	public void generateGraphs(Result r) throws IOException {

		String required[][] = r.getRequiredElements();
		String covered[][] = r.getCoveredAndUncoveredElements();

		for (int i = 1; i < required.length && (i * 8 - 7) < covered.length; i++) {

			String[] requiredNodesei = required[i][1].replace(" ", "")
					.replace(";", "").split(",");
			String[] requiredNodesed = required[i][2].replace(" ", "")
					.replace(";", "").split(",");
			String[] requiredEdgesei = required[i][3].replace(" ", "")
					.replace(";", "").replace(",", "->").replace(")->(", ";")
					.replace("(", "").replace(")", "").split(";");
			String[] requiredEdgesed = required[i][4].replace(" ", "")
					.replace(";", "").replace(",", "->").replace(")->(", ";")
					.replace("(", "").replace(")", "").split(";");
			String[] requiredUsesei = required[i][5].replace(" ", "")
					.replace(";", "").replace(">,<", ">;<").split(";");
			String[] requiredUsesed = required[i][6].replace(" ", "")
					.replace(";", "").replace(">,<", ">;<").split(";");
			String[] requiredPotUsesei = required[i][7].replace(" ", "")
					.replace(";", "").replace(">,<", ">;<").split(";");
			String[] requiredPotUsesed = required[i][8].replace(" ", "")
					.replace(";", "").replace(">,<", ">;<").split(";");

			String[] coveredNodesei = covered[i * 8 - 7][2].replace(" ", "")
					.replace(";", "").split(",");
			String[] coveredNodesed = covered[i * 8 - 6][2].replace(" ", "")
					.replace(";", "").split(",");
			String[] coveredEdgesei = covered[i * 8 - 5][2].replace(" ", "")
					.replace(";", "").replace(",", "->").replace(")->(", ";")
					.replace("(", "").replace(")", "").split(";");
			String[] coveredEdgesed = covered[i * 8 - 4][2].replace(" ", "")
					.replace(";", "").replace(",", "->").replace(")->(", ";")
					.replace("(", "").replace(")", "").split(";");

			String[] uncoveredNodesei = covered[i * 8 - 7][3].replace(" ", "")
					.replace(";", "").split(",");
			String[] uncoveredNodesed = covered[i * 8 - 6][3].replace(" ", "")
					.replace(";", "").split(",");
			String[] uncoveredEdgesei = covered[i * 8 - 5][3].replace(" ", "")
					.replace(";", "").replace(",", "->").replace(")->(", ";")
					.replace("(", "").replace(")", "").split(";");
			String[] uncoveredEdgesed = covered[i * 8 - 4][3].replace(" ", "")
					.replace(";", "").replace(",", "->").replace(")->(", ";")
					.replace("(", "").replace(")", "").split(";");

			File gfcFile = new File(tmpDir, "allnodesei-"
					+ required[i][0].replaceAll("[^a-zA-Z 0-9]+","") + ".gfc");
			generateAllNodeseiGraph(gfcFile, coveredNodesei, uncoveredNodesei,
					requiredNodesed, requiredEdgesei, requiredEdgesed);

			gfcFile = new File(tmpDir, "allnodesed-"
					+ required[i][0].replaceAll("[^a-zA-Z 0-9]+","") + ".gfc");
			generateAllNodesedGraph(gfcFile, requiredNodesei, coveredNodesed,
					uncoveredNodesed, requiredEdgesei, requiredEdgesed);

			gfcFile = new File(tmpDir, "alledgesei-"
					+ required[i][0].replaceAll("[^a-zA-Z 0-9]+","") + ".gfc");
			generateAllEdgeseiGraph(gfcFile, requiredNodesei, requiredNodesed,
					coveredEdgesei, uncoveredEdgesei, requiredEdgesed);

			gfcFile = new File(tmpDir, "alledgesed-"
					+ required[i][0].replaceAll("[^a-zA-Z 0-9]+","") + ".gfc");
			generateAllEdgesedGraph(gfcFile, requiredNodesei, requiredNodesed,
					requiredEdgesei, coveredEdgesed, uncoveredEdgesed);

			gfcFile = new File(tmpDir, "allusesei-"
					+ required[i][0].replaceAll("[^a-zA-Z 0-9]+","") + ".gfc");
			generateAllUseseiGraph(gfcFile, requiredNodesei, requiredNodesed,
					requiredEdgesei, requiredEdgesed, requiredUsesei);

			gfcFile = new File(tmpDir, "allusesed-"
					+ required[i][0].replaceAll("[^a-zA-Z 0-9]+","") + ".gfc");
			generateAllUsesedGraph(gfcFile, requiredNodesei, requiredNodesed,
					requiredEdgesei, requiredEdgesed, requiredUsesed);

			gfcFile = new File(tmpDir, "allpotusesei-"
					+ required[i][0].replaceAll("[^a-zA-Z 0-9]+","") + ".gfc");
			generateAllPotUseseiGraph(gfcFile, requiredNodesei,
					requiredNodesed, requiredEdgesei, requiredEdgesed,
					requiredPotUsesei);

			gfcFile = new File(tmpDir, "allpotusesed-"
					+ required[i][0].replaceAll("[^a-zA-Z 0-9]+","") + ".gfc");
			generateAllPotUsesedGraph(gfcFile, requiredNodesei,
					requiredNodesed, requiredEdgesei, requiredEdgesed,
					requiredPotUsesed);

		}

	}

	private void generateAllNodeseiGraph(File gfcFile, String[] coveredNodesei,
			String[] uncoveredNodesei, String[] requiredNodesed,
			String[] requiredEdgesei, String[] requiredEdgesed)
			throws IOException {

		if (!gfcFile.getParentFile().exists())
			gfcFile.getParentFile().mkdirs();

		PrintWriter pw = new PrintWriter(new FileOutputStream(gfcFile));

		pw.println("digraph{");
		pw.println("size=\"5\";");

		for (int i = 0; i < coveredNodesei.length; i++)
			if (!coveredNodesei[i].isEmpty())
				pw.println(coveredNodesei[i]
						+ " [style=filled, fillcolor=white];");

		for (int i = 0; i < uncoveredNodesei.length; i++)
			if (!uncoveredNodesei[i].isEmpty())
				pw.println(uncoveredNodesei[i]
						+ " [style=filled, fillcolor=red];");

		for (int i = 0; i < requiredNodesed.length; i++)
			if (!requiredNodesed[i].isEmpty())
				pw.println(requiredNodesed[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredEdgesei.length; i++)
			if (!requiredEdgesei[i].isEmpty())
				pw.println(requiredEdgesei[i] + " [color=grey];");

		for (int i = 0; i < requiredEdgesed.length; i++)
			if (!requiredEdgesed[i].isEmpty())
				pw.println(requiredEdgesed[i] + " [color=grey];");

		pw.println("}");

		pw.close();

		compile(gfcFile);

	}

	private void generateAllNodesedGraph(File gfcFile,
			String[] requiredNodesei, String[] coveredNodesed,
			String[] uncoveredNodesed, String[] requiredEdgesei,
			String[] requiredEdgesed) throws IOException {

		if (!gfcFile.getParentFile().exists())
			gfcFile.getParentFile().mkdirs();

		PrintWriter pw = new PrintWriter(new FileOutputStream(gfcFile));

		pw.println("digraph{");
		pw.println("size=\"5\";");

		for (int i = 0; i < requiredNodesei.length; i++)
			if (!requiredNodesei[i].isEmpty())
				pw.println(requiredNodesei[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < coveredNodesed.length; i++)
			if (!coveredNodesed[i].isEmpty())
				pw.println(coveredNodesed[i]
						+ " [style=filled, fillcolor=white];");

		for (int i = 0; i < uncoveredNodesed.length; i++)
			if (!uncoveredNodesed[i].isEmpty())
				pw.println(uncoveredNodesed[i]
						+ " [style=filled, fillcolor=red];");

		for (int i = 0; i < requiredEdgesei.length; i++)
			if (!requiredEdgesei[i].isEmpty())
				pw.println(requiredEdgesei[i] + " [color=grey];");

		for (int i = 0; i < requiredEdgesed.length; i++)
			if (!requiredEdgesed[i].isEmpty())
				pw.println(requiredEdgesed[i] + " [color=grey];");

		pw.println("}");

		pw.close();

		compile(gfcFile);

	}

	private void generateAllEdgeseiGraph(File gfcFile,
			String[] requiredNodesei, String[] requiredNodesed,
			String[] coveredEdgesei, String[] uncoveredEdgesei,
			String[] requiredEdgesed) throws IOException {

		if (!gfcFile.getParentFile().exists())
			gfcFile.getParentFile().mkdirs();

		PrintWriter pw = new PrintWriter(new FileOutputStream(gfcFile));

		pw.println("digraph{");
		pw.println("size=\"5\";");

		for (int i = 0; i < requiredNodesei.length; i++)
			if (!requiredNodesei[i].isEmpty())
				pw.println(requiredNodesei[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredNodesed.length; i++)
			if (!requiredNodesed[i].isEmpty())
				pw.println(requiredNodesed[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < coveredEdgesei.length; i++)
			if (!coveredEdgesei[i].isEmpty())
				pw.println(coveredEdgesei[i] + " [color=black];");

		for (int i = 0; i < uncoveredEdgesei.length; i++)
			if (!uncoveredEdgesei[i].isEmpty())
				pw.println(uncoveredEdgesei[i] + " [color=red];");

		for (int i = 0; i < requiredEdgesed.length; i++)
			if (!requiredEdgesed[i].isEmpty())
				pw.println(requiredEdgesed[i] + " [color=grey];");

		pw.println("}");

		pw.close();

		compile(gfcFile);

	}

	private void generateAllEdgesedGraph(File gfcFile,
			String[] requiredNodesei, String[] requiredNodesed,
			String[] requiredEdgesei, String[] coveredEdgesed,
			String[] uncoveredEdgesed) throws IOException {

		if (!gfcFile.getParentFile().exists())
			gfcFile.getParentFile().mkdirs();

		PrintWriter pw = new PrintWriter(new FileOutputStream(gfcFile));

		pw.println("digraph{");
		pw.println("size=\"5\";");

		for (int i = 0; i < requiredNodesei.length; i++)
			if (!requiredNodesei[i].isEmpty())
				pw.println(requiredNodesei[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredNodesed.length; i++)
			if (!requiredNodesed[i].isEmpty())
				pw.println(requiredNodesed[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredEdgesei.length; i++)
			if (!requiredEdgesei[i].isEmpty())
				pw.println(requiredEdgesei[i] + " [color=grey];");

		for (int i = 0; i < coveredEdgesed.length; i++)
			if (!coveredEdgesed[i].isEmpty())
				pw.println(coveredEdgesed[i] + " [color=black];");

		for (int i = 0; i < uncoveredEdgesed.length; i++)
			if (!uncoveredEdgesed[i].isEmpty())
				pw.println(uncoveredEdgesed[i] + " [color=red];");

		pw.println("}");

		pw.close();

		compile(gfcFile);

	}

	private void generateAllUseseiGraph(File gfcFile, String[] requiredNodesei,
			String[] requiredNodesed, String[] requiredEdgesei,
			String[] requiredEdgesed, String[] requiredUsesei)
			throws IOException {

		if (!gfcFile.getParentFile().exists())
			gfcFile.getParentFile().mkdirs();

		PrintWriter pw = new PrintWriter(new FileOutputStream(gfcFile));

		pw.println("digraph{");
		pw.println("size=\"5\";");

		for (int i = 0; i < requiredNodesei.length; i++)
			if (!requiredNodesei[i].isEmpty())
				pw.println(requiredNodesei[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredNodesed.length; i++)
			if (!requiredNodesed[i].isEmpty())
				pw.println(requiredNodesed[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredEdgesei.length; i++)
			if (!requiredEdgesei[i].isEmpty())
				pw.println(requiredEdgesei[i] + " [color=grey];");

		for (int i = 0; i < requiredEdgesed.length; i++)
			if (!requiredEdgesed[i].isEmpty())
				pw.println(requiredEdgesed[i] + " [color=grey];");

		String[] defs = getDefs(requiredUsesei);

		for (int i = 0; i < defs.length; i++)
			if (!defs[i].isEmpty())
				pw.println(defs[i]);

		String[] uses = getUses(requiredUsesei);

		for (int i = 0; i < uses.length; i++)
			if (!uses[i].isEmpty())
				pw.println(uses[i]);

		pw.println("}");

		pw.close();

		compile(gfcFile);

	}

	private void generateAllUsesedGraph(File gfcFile, String[] requiredNodesei,
			String[] requiredNodesed, String[] requiredEdgesei,
			String[] requiredEdgesed, String[] requiredUsesed)
			throws IOException {

		if (!gfcFile.getParentFile().exists())
			gfcFile.getParentFile().mkdirs();

		PrintWriter pw = new PrintWriter(new FileOutputStream(gfcFile));

		pw.println("digraph{");
		pw.println("size=\"5\";");

		for (int i = 0; i < requiredNodesei.length; i++)
			if (!requiredNodesei[i].isEmpty())
				pw.println(requiredNodesei[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredNodesed.length; i++)
			if (!requiredNodesed[i].isEmpty())
				pw.println(requiredNodesed[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredEdgesei.length; i++)
			if (!requiredEdgesei[i].isEmpty())
				pw.println(requiredEdgesei[i] + " [color=grey];");

		for (int i = 0; i < requiredEdgesed.length; i++)
			if (!requiredEdgesed[i].isEmpty())
				pw.println(requiredEdgesed[i] + " [color=grey];");

		String[] defs = getDefs(requiredUsesed);

		for (int i = 0; i < defs.length; i++)
			if (!defs[i].isEmpty())
				pw.println(defs[i]);

		String[] uses = getUses(requiredUsesed);

		for (int i = 0; i < uses.length; i++)
			if (!uses[i].isEmpty())
				pw.println(uses[i]);

		pw.println("}");

		pw.close();

		compile(gfcFile);

	}

	private void generateAllPotUseseiGraph(File gfcFile,
			String[] requiredNodesei, String[] requiredNodesed,
			String[] requiredEdgesei, String[] requiredEdgesed,
			String[] requiredPotUsesei) throws IOException {

		if (!gfcFile.getParentFile().exists())
			gfcFile.getParentFile().mkdirs();

		PrintWriter pw = new PrintWriter(new FileOutputStream(gfcFile));

		pw.println("digraph{");
		pw.println("size=\"5\";");

		for (int i = 0; i < requiredNodesei.length; i++)
			if (!requiredNodesei[i].isEmpty())
				pw.println(requiredNodesei[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredNodesed.length; i++)
			if (!requiredNodesed[i].isEmpty())
				pw.println(requiredNodesed[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredEdgesei.length; i++)
			if (!requiredEdgesei[i].isEmpty())
				pw.println(requiredEdgesei[i] + " [color=grey];");

		for (int i = 0; i < requiredEdgesed.length; i++)
			if (!requiredEdgesed[i].isEmpty())
				pw.println(requiredEdgesed[i] + " [color=grey];");

		String[] defs = getDefs(requiredPotUsesei);

		for (int i = 0; i < defs.length; i++)
			if (!defs[i].isEmpty())
				pw.println(defs[i]);

		String[] uses = getUses(requiredPotUsesei);

		for (int i = 0; i < uses.length; i++)
			if (!uses[i].isEmpty())
				pw.println(uses[i]);

		pw.println("}");

		pw.close();

		compile(gfcFile);

	}

	private void generateAllPotUsesedGraph(File gfcFile,
			String[] requiredNodesei, String[] requiredNodesed,
			String[] requiredEdgesei, String[] requiredEdgesed,
			String[] requiredPotUsesed) throws IOException {

		if (!gfcFile.getParentFile().exists())
			gfcFile.getParentFile().mkdirs();

		PrintWriter pw = new PrintWriter(new FileOutputStream(gfcFile));

		pw.println("digraph{");
		pw.println("size=\"5\";");

		for (int i = 0; i < requiredNodesei.length; i++)
			if (!requiredNodesei[i].isEmpty())
				pw.println(requiredNodesei[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredNodesed.length; i++)
			if (!requiredNodesed[i].isEmpty())
				pw.println(requiredNodesed[i]
						+ " [style=filled, fillcolor=grey];");

		for (int i = 0; i < requiredEdgesei.length; i++)
			if (!requiredEdgesei[i].isEmpty())
				pw.println(requiredEdgesei[i] + " [color=grey];");

		for (int i = 0; i < requiredEdgesed.length; i++)
			if (!requiredEdgesed[i].isEmpty())
				pw.println(requiredEdgesed[i] + " [color=grey];");

		String[] defs = getDefs(requiredPotUsesed);

		for (int i = 0; i < defs.length; i++)
			if (!defs[i].isEmpty())
				pw.println(defs[i]);

		String[] uses = getUses(requiredPotUsesed);

		for (int i = 0; i < uses.length; i++)
			if (!uses[i].isEmpty())
				pw.println(uses[i]);

		pw.println("}");

		pw.close();

		compile(gfcFile);

	}

	private String[] getDefs(String[] requiredUsesei) {

		String[] defs = new String[0];

		try {

			String[][] defMatrix = new String[requiredUsesei.length][2];

			for (int i = 0; i < requiredUsesei.length; i++) {
				defMatrix[i][0] = requiredUsesei[i].split(",")[0].replace("<",
						"");
				defMatrix[i][1] = requiredUsesei[i].split(",")[1];
			}

			List<String> verifiedDefs = new ArrayList<String>();

			List<String> defList = new ArrayList<String>();

			for (int i = 0; i < defMatrix.length; i++) {
				if (!verifiedDefs.contains(defMatrix[i][1])) {
					String def = defMatrix[i][1] + "->" + defMatrix[i][1]
							+ " [label=\"Defs={";
					List<String> verifiedVars = new ArrayList<String>();
					for (int j = i; j < defMatrix.length; j++) {
						if (defMatrix[j][1].equals(defMatrix[i][1])
								&& !verifiedVars.contains(defMatrix[j][0])) {
							if (j != i)
								def += ",";
							def += defMatrix[j][0];
							verifiedVars.add(defMatrix[j][0]);
						}
					}
					def += "}\", color=transparent, fontsize=10];";
					defList.add(def);
					verifiedDefs.add(defMatrix[i][1]);
				}
			}

			defs = new String[defList.size()];

			for (int i = 0; i < defList.size(); i++)
				defs[i] = defList.get(i);

			return defs;

		} catch (Throwable t) {

			return defs;

		}

	}

	private String[] getUses(String[] requiredUsesei) {

		String[] uses = new String[0];

		try {

			String[][] useMatrix = new String[requiredUsesei.length][4];

			for (int i = 0; i < requiredUsesei.length; i++) {
				useMatrix[i][0] = requiredUsesei[i].split(",")[0].replace("<",
						"");
				useMatrix[i][1] = requiredUsesei[i].split(",")[1];
				useMatrix[i][2] = requiredUsesei[i].split(",")[2].replace("(",
						"").replace(">", "");
				if (requiredUsesei[i].split(",")[2].startsWith("("))
					useMatrix[i][3] = requiredUsesei[i].split(",")[3].replace(
							")", "").replace(">", "");
				else
					useMatrix[i][3] = "";
			}

			List<String> useList = new ArrayList<String>();

			List<String> verifiedUses = new ArrayList<String>();

			for (int i = 0; i < useMatrix.length; i++) {
				if (useMatrix[i][3].isEmpty()) {
					if (!verifiedUses.contains(useMatrix[i][2])) {
						String use = useMatrix[i][2] + "->" + useMatrix[i][2]
								+ " [label=\"CU={";
						List<String> verifiedVars = new ArrayList<String>();
						for (int j = i; j < useMatrix.length; j++) {
							if (useMatrix[j][2].equals(useMatrix[i][2])
									&& useMatrix[j][3].equals(useMatrix[i][3])
									&& !verifiedVars.contains(useMatrix[j][0])) {
								if (j != i)
									use += ",";
								use += useMatrix[j][0];
								verifiedVars.add(useMatrix[j][0]);
							}
						}
						use += "}\", color=transparent, fontsize=10];";
						useList.add(use);
						verifiedUses.add(useMatrix[i][2]);
					}

				}
			}

			verifiedUses = new ArrayList<String>();

			for (int i = 0; i < useMatrix.length; i++) {
				if (!useMatrix[i][3].isEmpty()) {
					if (!verifiedUses.contains(useMatrix[i][2] + "->" + useMatrix[i][3])) {
						String use = useMatrix[i][2] + "->" + useMatrix[i][3]
								+ " [label=\"PU={";
						List<String> verifiedVars = new ArrayList<String>();
						for (int j = i; j < useMatrix.length; j++) {
							if (useMatrix[j][2].equals(useMatrix[i][2])
									&& useMatrix[j][3].equals(useMatrix[i][3])
									&& !verifiedVars.contains(useMatrix[j][0])) {
								if (j != i)
									use += ",";
								use += useMatrix[j][0];
								verifiedVars.add(useMatrix[j][0]);
							}
						}
						use += "}\", color=transparent, fontsize=10];";
						useList.add(use);
						verifiedUses.add(useMatrix[i][2] + "->" + useMatrix[i][3]);
					}

				}
			}

			uses = new String[useList.size()];

			for (int i = 0; i < useList.size(); i++)
				uses[i] = useList.get(i);

			return uses;

		} catch (Throwable t) {

			return uses;

		}

	}

	private void compile(File gfcFile) throws IOException {

		String args[] = new String[5];

		args[0] = "dot";
		args[1] = "-Tpng";
		args[2] = gfcFile.getPath();
		args[3] = "-o";
		args[4] = rptDir + File.separator
				+ gfcFile.getName().replace(".gfc", ".png");

		ProcessBuilder pb = new ProcessBuilder(args);
		pb.start();

	}

}
