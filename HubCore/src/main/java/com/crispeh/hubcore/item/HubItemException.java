package com.crispeh.hubcore.item;

/**
 * Created by Joey on 3/5/2015.
 */
public class HubItemException extends Exception {
    public HubItemException() { super(); }
    public HubItemException(String message) { super(message); }
    public HubItemException(String message, Throwable cause) { super(message, cause); }
    public HubItemException(Throwable cause) { super(cause); }
}
