package org.ownbit.password.manager.jarloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

/**
 * The Class RsrcURLConnection.
 */
public class RsrcURLConnection extends URLConnection {
    
    /** The class loader. */
    private ClassLoader classLoader;

    /**
     * Instantiates a new rsrc URL connection.
     *
     * @param url the url
     * @param classLoader the class loader
     */
    public RsrcURLConnection(URL url, ClassLoader classLoader) {
	super(url);
	this.classLoader = classLoader;
    }

    /* (non-Javadoc)
     * @see java.net.URLConnection#connect()
     */
    public void connect() throws IOException {
    }

    /* (non-Javadoc)
     * @see java.net.URLConnection#getInputStream()
     */
    public InputStream getInputStream() throws IOException {
	String file = URLDecoder.decode(this.url.getFile(), "UTF-8");
	InputStream result = this.classLoader.getResourceAsStream(file);
	if (result == null) {
	    throw new MalformedURLException("Could not open InputStream for URL '" + this.url + "'");
	}
	return result;
    }
}