package org.ownbit.password.manager.jarloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * The Class JarRsrcLoader.
 */
public class JarRsrcLoader {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws ClassNotFoundException the class not found exception
     * @throws IllegalArgumentException the illegal argument exception
     * @throws IllegalAccessException the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws SecurityException the security exception
     * @throws NoSuchMethodException the no such method exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException,
	    IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException, IOException {

	ManifestInfo mi = getManifestInfo();
	ClassLoader cl = Thread.currentThread().getContextClassLoader();
	URL.setURLStreamHandlerFactory(new RsrcURLStreamHandlerFactory(cl));
	URL[] rsrcUrls = new URL[mi.rsrcClassPath.length];

	for (int i = 0; i < mi.rsrcClassPath.length; i++) {
	    String rsrcPath = mi.rsrcClassPath[i];
	    if (rsrcPath.endsWith("/")) {
		rsrcUrls[i] = new URL("rsrc:" + rsrcPath);
	    } else {
		rsrcUrls[i] = new URL("jar:rsrc:" + rsrcPath + "!/");
	    }
	}

	ClassLoader jceClassLoader = new URLClassLoader(rsrcUrls, null);
	Thread.currentThread().setContextClassLoader(jceClassLoader);
	Class<?> c = Class.forName(mi.rsrcMainClass, true, jceClassLoader);
	Method main = c.getMethod("main", new Class[] { args.getClass() });
	main.invoke(null, new Object[] { args });
    }

    /**
     * Gets the manifest info.
     *
     * @return the manifest info
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static ManifestInfo getManifestInfo() throws IOException {
	Enumeration<?> resEnum = Thread.currentThread().getContextClassLoader().getResources("META-INF/MANIFEST.MF");
	while (resEnum.hasMoreElements()) {
	    try {
		URL url = (URL) resEnum.nextElement();
		InputStream is = url.openStream();
		if (is != null) {
		    ManifestInfo result = new ManifestInfo(null);
		    Manifest manifest = new Manifest(is);
		    Attributes mainAttribs = manifest.getMainAttributes();
		    result.rsrcMainClass = mainAttribs.getValue("Rsrc-Main-Class");
		    String rsrcCP = mainAttribs.getValue("Rsrc-Class-Path");

		    if (rsrcCP == null) {
			rsrcCP = "";
		    }
		    result.rsrcClassPath = splitSpaces(rsrcCP);

		    if ((result.rsrcMainClass != null) && (!result.rsrcMainClass.trim().equals(""))) {
			return result;
		    }
		}
	    } catch (Exception localException) {
	    }
	}
	System.err.println("Missing attributes for JarRsrcLoader in Manifest (Rsrc-Main-Class, Rsrc-Class-Path)");
	return null;
    }

    /**
     * Split spaces.
     *
     * @param line the line
     * @return the string[]
     */
    private static String[] splitSpaces(String line) {
	if (line == null) {
	    return null;
	}
	List<String> result = new ArrayList<String>();
	int firstPos = 0;
	while (firstPos < line.length()) {
	    int lastPos = line.indexOf(' ', firstPos);
	    if (lastPos == -1) {
		lastPos = line.length();
	    }
	    if (lastPos > firstPos) {
		result.add(line.substring(firstPos, lastPos));
	    }
	    firstPos = lastPos + 1;
	}
	return (String[]) result.toArray(new String[result.size()]);
    }

    /**
     * The Class ManifestInfo.
     */
    private static class ManifestInfo {
	
	/** The rsrc main class. */
	String rsrcMainClass;
	
	/** The rsrc class path. */
	String[] rsrcClassPath;

	/**
	 * Instantiates a new manifest info.
	 */
	private ManifestInfo() {
	}

	/**
	 * Instantiates a new manifest info.
	 *
	 * @param paramManifestInfo the param manifest info
	 */
	ManifestInfo(ManifestInfo paramManifestInfo) {
	    this();
	}
    }
}