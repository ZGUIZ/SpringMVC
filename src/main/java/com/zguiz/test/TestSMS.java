package com.zguiz.test;

import com.zguiz.utils.SMSUtil;
import org.junit.Test;

public class TestSMS {

    @Test
    public void testSendSMS(){
        String res=SMSUtil.sendSMS("13414852324");
        if (res != null) {
            System.out.println(res);
        }
        else {
            System.out.println("发送失败");
        }
    }
}
