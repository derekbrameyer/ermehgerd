package com.doomonafireball.ermahgerd;

import junit.framework.Assert;

import org.junit.Test;

/**
 * User: derek Date: 9/30/13 Time: 6:55 PM
 */
public class ErmahgerdTest {

    @Test
    public void terstErmahgerds() {
        Assert.assertEquals(Ermahgerd.translate("AWESOME"), "ERSUM");
        Assert.assertEquals(Ermahgerd.translate("FALLING"), "FERLIN");
        Assert.assertEquals(Ermahgerd.translate("PANCAKES"), "PERNCERKS");
        Assert.assertEquals(Ermahgerd.translate("OH"), "ER");
    }
}
