package com.aoc.util.md5;

import com.aoc.util.log.Logger;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author maczaka.
 */
public class MD5 {

    private static final Logger LOG = new Logger();

    private static MessageDigest digest;

    static {
        try {
            digest = MessageDigest.getInstance("md5");
        } catch (final NoSuchAlgorithmException e) {
            LOG.log(e);
        }
    }


    public static byte[] md5(final String input) {
        return digest.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String getMD5AsHexString(final String input) {
        final byte[] bytes = md5(input);
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }
}
