/*
 *    Copyright (C) 2010 - 2015 VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.vrem.wifianalyzer.vendor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VendorServiceTest {
    @Mock
    private VendorCache vendorCache;

    private VendorService fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new VendorService();
        fixture.setVendorCache(vendorCache);
    }

    @Test
    public void testGetVendorName() throws Exception {
        // setup
        String macAddress = "macAddress";
        String vendorName = "vendorName";
        when(vendorCache.find(macAddress)).thenReturn(vendorName);
        // execute
        String actual = fixture.getVendorName(macAddress);
        // validate
        assertEquals(vendorName, actual);
        verify(vendorCache).find(macAddress);
    }

}