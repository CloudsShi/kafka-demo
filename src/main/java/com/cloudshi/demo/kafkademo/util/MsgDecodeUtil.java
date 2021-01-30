package com.cloudshi.demo.kafkademo.util;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 信息解码工具
 */
@Slf4j
public class MsgDecodeUtil {
    /**
     * 设备数据键
     */
    private static final String DEVICE_DATA_KEY="R";


    /**
     * 解码
     * @param ciphertext 密文
     * @return
     */
    public static String decode(String ciphertext) {
        log.info("密文：{}", ciphertext);
        AtomicReference<String> plaintext=new AtomicReference<>();
        if(StrUtil.isNotBlank(ciphertext)) {
            List<Map<String,String>> stationDeviceList=JSONArray.parseObject(ciphertext, List.class);
            stationDeviceList.forEach(item ->
                item.forEach((k,v) -> {
                    if(k.equals(DEVICE_DATA_KEY) && StrUtil.isNotBlank(v)) {
                        plaintext.set(ZipUtil.gunzip(v));
                    }
                })
            );
        }
        return plaintext.get();
    }
}
