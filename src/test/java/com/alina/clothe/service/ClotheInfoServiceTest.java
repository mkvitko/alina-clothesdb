package com.alina.clothe.service;

import com.alina.clothe.config.WebAppConfigurationTest;
import com.alina.clothe.entity.ClotheInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by mkvitko on 3/28/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfigurationTest.class, com.alina.clothe.config.WebAppConfiguration.class})
@WebAppConfiguration
public class ClotheInfoServiceTest {

    @Autowired
    private ClotheInfoService clotheInfoService;

    @Test
    public void testSaveClotheInfo() {
        ClotheInfo clotheInfo = new ClotheInfo();

        clotheInfo.setName("First");
        clotheInfo.setNewPrice(450);
        clotheInfo.setOldPrice(400);

        clotheInfoService.save(clotheInfo);

        for (ClotheInfo ci : clotheInfoService.findAll()) {
            System.out.println(ci.getId());
        }

        System.out.println(clotheInfoService.findByName("First").getNewPrice());
    }
}
