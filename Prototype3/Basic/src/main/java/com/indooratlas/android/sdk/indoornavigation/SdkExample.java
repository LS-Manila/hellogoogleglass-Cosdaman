package com.indooratlas.android.sdk.indoornavigation;

import android.support.annotation.StringRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Activities tagged with this annotation are listed in the main view as indoornavigation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SdkExample {

    /**
     * Resource identifier that's content will be shown in first line in indoornavigation list entry. If
     * not set, activity's label will be used.
     */
    @StringRes int title() default -1;

    /**
     * Resource identified that's content will be shown on second line in indoornavigation list entry.
     * Describes what the example is showcasing.
     */
    @StringRes int description();

}
