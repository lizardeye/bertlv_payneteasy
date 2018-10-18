package com.payneteasy.tlv;

import org.junit.Test;

/**
 * Created by ekandaurova on 17.10.2018.
 */
public class BertlvBankTest {
    @Test
    public void testBankExample() {
        BerTlv tlv = new BerTlvParser().parseConstructed(HexUtil.parseHex("F020C016T408178100000000000564C902TY"));
        BerTlvLogger.log("    ", tlv);
        assert tlv!=null;
    }

}
