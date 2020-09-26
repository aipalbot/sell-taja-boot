package com.aipalbot.sell.taja.configurations;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DataConfigurationTest {

   // @Mock
    DataConfiguration dataConfigurationMock = new DataConfiguration();


    @Test
    public void testUsernamePropertyValid(){

        assertEquals(dataConfigurationMock.getUserName(),"tajauser101");
    }
}
