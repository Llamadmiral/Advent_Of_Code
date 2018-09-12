package com.aoc.util.md5;

import com.aoc.util.log.Logger;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author maczaka.
 */
public class MD5 {

    private static final Logger LOG = new Logger();


    public static byte[] md5(final String input) {
        byte[] result = null;
        try {
            final MessageDigest digest = MessageDigest.getInstance("md5");
            result = digest.digest(input.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            LOG.log(e);
        }
        return result;
    }

    public static String getMD5AsHexString(final String input) {
        final byte[] bytes = md5(input);
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }
}
