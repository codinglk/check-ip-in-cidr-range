package com.codinglk.cidr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class IPWithGivenRangeCheckTests {
    @Test
    void contextLoads() {
    }

    @Test
    void givenIPv4Addresses_whenIsInRange_thenReturnsTrue() throws Exception {
        assertTrue(IPWithGivenRangeCheck.checkIPIsInGivenRange("192.220.3.0", "192.210.0.0", "192.255.0.0"));
    }

    @Test
    void givenIPv4Addresses_whenIsNotInRange_thenReturnsFalse() throws Exception {
        assertFalse(IPWithGivenRangeCheck.checkIPIsInGivenRange("192.200.0.0", "192.210.0.0", "192.255.0.0"));
    }

    @Test
    void givenIPv6Addresses_whenIsInRange_thenReturnsTrue() throws Exception {
        assertTrue(IPWithGivenRangeCheck.checkIPIsInGivenRange(
                "2001:db8:85a3::8a03:a:b", "2001:db8:85a3::8a00:ff:ffff", "2001:db8:85a3::8a2e:370:7334"));
    }

    @Test
    void givenIPv6Addresses_whenIsNotInRange_thenReturnsFalse() throws Exception {
        assertFalse(IPWithGivenRangeCheck.checkIPIsInGivenRange(
                "2002:db8:85a3::8a03:a:b", "2001:db8:85a3::8a00:ff:ffff", "2001:db8:85a3::8a2e:370:7334"));
    }

}
