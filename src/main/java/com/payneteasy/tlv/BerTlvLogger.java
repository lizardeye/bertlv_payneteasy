package com.payneteasy.tlv;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerTlvLogger {

    private final static Logger LOG = LoggerFactory.getLogger(BerTlvLogger.class);

    public static void log(String aPadding, BerTlvs aTlv) {
        if (LOG.isDebugEnabled()) {
            for (BerTlv tlv : aTlv.getList()) {
                log(aPadding, tlv);
            }
        }
    }

    public static void log(String aPadding, BerTlv aTlv) {
        if (aTlv == null) {
            LOG.debug("{} is null", aPadding);
            return;
        }

        if (aTlv.isConstructed()) {
            LOG.debug("{} [{}]", aPadding, HexUtil.toHexString(aTlv.getTag().bytes));
            for (BerTlv child : aTlv.getValues()) {
                log(aPadding + "    ", child);
            }
        } else {
            LOG.debug("{} [{}] {}", aPadding, HexUtil.toHexString(aTlv.getTag().bytes), aTlv.getHexValue());
        }

    }

}
