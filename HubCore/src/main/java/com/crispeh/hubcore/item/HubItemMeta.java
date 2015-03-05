package com.crispeh.hubcore.item;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Joey on 3/5/2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HubItemMeta {

    /**
     * The Key of the object for the config
     * @return the key
     */
    public String key() default "";

    /**
     * Whether the object is hidden ~ implemented in code but not given to users
     * @return whether object is hidden
     */
    public boolean hidden() default false;

    /**
     * The permission node needed to get the item
     * @return the permission node needed to get the item
     */
    public String permission() default "";

    /**
     * The Slot that is preferred for this item to go in
     * @return the slot that is preferred for this item to go in
     */
    public int slot() default -1;
}
