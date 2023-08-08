package org.ownbit.password.manager.jarloader;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * The Class RsrcURLStreamHandler.
 */
public class RsrcURLStreamHandler extends URLStreamHandler {
    
    /** The class loader. */
    private ClassLoader classLoader;

    /**
     * Instantiates a new rsrc URL stream handler.
     *
     * @param classLoader the class loader
     */
    public RsrcURLStreamHandler(ClassLoader classLoader) {
	this.classLoader = classLoader;
    }

    /* (non-Javadoc)
     * @see java.net.URLStreamHandler#openConnection(java.net.URL)
     */
    protected URLConnection openConnection(URL u) throws IOException {
	return new RsrcURLConnection(u, this.classLoader);
    }

    /* (non-Javadoc)
     * @see java.net.URLStreamHandler#parseURL(java.net.URL, java.lang.String, int, int)
     */
    protected void parseURL(URL url, String spec, int start, int limit) {
	String file;
	if (spec.startsWith("rsrc:")) {
	    file = spec.substring(5);
	} else {
	    if (url.getFile().equals("./")) {
		file = spec;
	    } else {
		if (url.getFile().endsWith("/")) {
		    file = url.getFile() + spec;
		} else {
		    file = spec;
		}
	    }
	}
	setURL(url, "rsrc", "", -1, null, null, file, null, null);
    }
}