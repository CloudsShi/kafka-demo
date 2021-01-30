package com.cloudshi.demo.kafkademo.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.List;

/**
 * demo生产者
 */
@Component
@Slf4j
public class DemoProducer {
    @Value("${kafka.topic}")
    private String topic;
    @Value("${kafka.partition}")
    private int partition;

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    /**
     * 发送信息
     * @param key 信息键
     * @param msg 信息
     */
    public void sendMsg(String key, String msg) {
        kafkaTemplate.send(topic, partition, key, msg).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("发送消息失败：{}", ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("发送消息成功：{}", result);
            }
        });
    }
}
