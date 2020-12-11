package com.aoc.util.md5;

import com.aoc.util.log.Logger;
import com.twmacinta.util.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;


/**
 * @author maczaka.
 */
public class MD5Helper {

    private static final Logger LOG = new Logger();

    private static MessageDigest digest = null;


    public static byte[] md5(final String input) {
        final MD5 md5 = new MD5();
        byte[] result = null;
        try {
            md5.Update(input, null);
            result = md5.Final();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getMD5AsHexString(final String input) {
        final MD5 md5 = new MD5();
        String result = null;
        try {
            md5.Update(input, null);
            result = md5.asHex();
        } catch (final UnsupportedEncodingException e) {
            LOG.log(e);
        }
        return result;
    }
}
