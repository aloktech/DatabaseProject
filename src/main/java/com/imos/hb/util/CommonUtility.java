/**
 * 
 */
package com.imos.hb.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pintu
 *
 */
public class CommonUtility {

	public static List<String> extractPackageNameFromFilePath(String filePath, String startPhrase, String fileExt) {
		List<String> paths = new ArrayList<>();
		for (String p : filePath.split(",")) {
			File dir = new File(p);
			if (dir.isDirectory()) {
				for (File file : dir.listFiles()) {
					if (file.isFile() && file.getName().endsWith(fileExt)) {
						String path = file.getPath();
						path = path.substring(path.indexOf(startPhrase) + startPhrase.length(),
								path.lastIndexOf(fileExt) - 1);
						path = path.replaceAll("\\\\", ".");
						paths.add(path);
					}
				}
			}
		}

		return paths;
	}
}
