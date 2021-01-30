package com.cloudshi.demo.kafkademo.consumer;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.cloudshi.demo.kafkademo.util.MsgDecodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * demo消费者
 */
@Component
@Slf4j
public class DemoConsumer {
    /**
     * 批量接受信息
     * @param records 信息列表
     */
    @KafkaListener(topicPartitions ={@TopicPartition(topic = "${kafka.topic}", partitions = "${kafka.partition}")})
    public void listener(ConsumerRecords<String, String> records) {
        log.info("此线程消费{}条消息----线程名: {}", records.count(), Thread.currentThread().getName());
        records.forEach(record -> {
            log.info("Kafka接受到信息：{}", record);
            String oMsg=record.value().trim();
            String nMsg=null;
            if (StrUtil.isNotBlank(oMsg) && !StrUtil.NULL.equals(oMsg)) {
                nMsg= MsgDecodeUtil.decode(oMsg);
            }
            log.info("解码后信息：{}", nMsg);
            log.info("列表对象：{}", StrUtil.isNotBlank(nMsg) ?JSONArray.parse(nMsg.replaceAll("inf", "null").replaceAll("-nan", "null")).toString() :"");
        });
    }
}
