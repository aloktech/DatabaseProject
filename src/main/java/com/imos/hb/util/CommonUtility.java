/**
 * 
 */
package com.imos.hb.util;

import java.io.File;
import java.util.List;

/**
 * @author Pintu
 *
 */
public class CommonUtility {
	
	public static List<String> extractPackageNameFromFilePath(String filePath, List<String> paths, String fileExt) {
		File dir = new File(filePath);
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				if (file.isFile()) {
					String path = file.getPath();
					path = path.substring(path.contains("src") ? path.indexOf("src") + 4 : 0, path.indexOf(fileExt) - 1);
					path = path.replaceAll("\\\\", ".");
					paths.add(path);
				}
			}
		}

		return paths;
	}
}
