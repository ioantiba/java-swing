package org.ownbit.password.manager.model;

/**
 * The Class EmailModel.
 */
public class EmailModel {
    
    /** The from. */
    private String from;
    
    /** The to. */
    private String to;
    
    /** The cc. */
    private String cc;
    
    /** The subject. */
    private String subject;
    
    /** The message. */
    private String message;

    /**
     * Gets the from.
     *
     * @return the from
     */
    public String getFrom() {
	return from;
    }

    /**
     * Sets the from.
     *
     * @param from the new from
     */
    public void setFrom(String from) {
	this.from = from;
    }

    /**
     * Gets the to.
     *
     * @return the to
     */
    public String getTo() {
	return to;
    }

    /**
     * Sets the to.
     *
     * @param to the new to
     */
    public void setTo(String to) {
	this.to = to;
    }

    /**
     * Gets the cc.
     *
     * @return the cc
     */
    public String getCc() {
	return cc;
    }

    /**
     * Sets the cc.
     *
     * @param cc the new cc
     */
    public void setCc(String cc) {
	this.cc = cc;
    }

    /**
     * Gets the subject.
     *
     * @return the subject
     */
    public String getSubject() {
	return subject;
    }

    /**
     * Sets the subject.
     *
     * @param subject the new subject
     */
    public void setSubject(String subject) {
	this.subject = subject;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
	return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
	this.message = message;
    }
}
