package com.cloudshi.demo.kafkademo;

import com.cloudshi.demo.kafkademo.producer.DemoProducer;
import com.cloudshi.demo.kafkademo.util.MsgDecodeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaDemoApplicationTests {
    @Autowired
    private DemoProducer producer;

    @Test
    void producerTest() {
        /*Map<String,String> map=new HashMap<>();
        for(int i=0;i<10;i++) {
            map.put("key_"+i, "val_"+i);
        }
        producer.sendMsg("demo", JSON.toJSONString(map));*/
        String tmp= MsgDecodeUtil.decode("[" +
                "   {" +
                "      \"R\" : \"H4sIAAAAAAAAA+WbvW7sNhCFez/FYmtD4PCfKdM7QNoEqdLepAlSBXn3SCIpX84caskssIVsAy7m0muK4sczczj317fb7fbP9mP9uv/0o1J0v/1w814vUb1/H9dbnNSi23DYw5aPjiXMRqc9bBbThEltYavs4to45bhfUhs3W1wt3jdRu0WdWtqx+0z84puoztNOCzVhs/9BrduPMPsHk9YxRvYv+8fc6d4EI15Bsz+8WUITtSqP5mtiKY9u5211Hd0urN1XRLN1sm6L/vn3t29NNMBoQlFnYdTDaERRr2BUwyj6az7vyGTbd+Xzhmzfti8b7PsX+Ht+ReHzHf2xR6KJPvgPrfyHN2QprHv2GPJX/iWjnTVh/SaVv+7bgH/fO9AY/lryHCN7LQczDjEjPqM+UuowQx1mImTGpVFmHNupmZkVjoCYUWz/FmjIRU/j0IgVrNAgZojYs1dmCDETdYeZeF1mYvvID5hxAhr/FDRqCJqg2PvKkwxsPxVoNDsQCzR6sQgaYqMfCY3rCI0bFhouhAUafupnaChwicjQqBCSH4dGrGCGRqhBpkanBUAj4MjQKOpAoy8LzarxcRSa9tQr0LgXQOMcTs/4iVioCTwcSxhBw3ZeZsakwBDLzBh+xnwmZ230NDlLgBnij1iExrDRhRnjrA7jzIgFzMxYKDRicGaGS29hxnkeN0jDLoRMYufpqc54mZvZFxCTcEGTuJ7UvacRMKLMqfVMLzcLAJktN+sgQ+PIGIRMxMgohm7NzUzyEwWNWMHTgiYSlx9CFJR6xvE65/r1jBmXGfJAZswLoLH8DZxCw7f7UdAkDE2HmQ4yHiMzYQE4gIyxnI2cmaVOORN8TOPIiPWryBiEjDNQZgybeJUZrlXXL2dY6fkgM7MCGXoBMoadqJUYaAHweqMQI9QnFb6og0yCzPACft4C4EJVmOH+WEUGEBPJpgmN4atXeYmIFyvKkBPPzK3TcBAYd11gYnu4PQBG8KJeITH8pD0qGagxwhaolQwhYgQBDxMzLDJ6FBg+vaOUgZ6Z5nV7MZqVW9kdFxmhVQUaDaFJfMOXWgbW/3K0gaOvBI0dV5n2AM/UpGeg0Wms/A8wL+MpTmGGZ+KFGUFYfiRu5D5SGV6K/B/PDGZmAXtmBhYz0QbisnRW/vMFrJaZR8x4/uzVM7OIGce9j8wMXVhoYphgpilSi9LoV0CDb2eIW5yFGp77FGqYRBznQIcZfDnD/aRDaMx4ZgY9M4+Fhj9iZsb5GGYss97dDLSZxehzz0xc2hioYRdiJpmJC00rmYmvQIaLwdEFMFXNwPrfwruZzWdGzGxxB5lxYZwZAsysiW9CzPBTvDoAPsaJC02xghUaKDRrujXjAPB7ny/gmul2OR8kZ8ICeOpCcxCaIC4jSxcATM46phmn4zDNbAeaDjMdB2A4N3MwN9MWOgD8KujwmUOYyM3E+lVkLEIm8H6EmptBZILwxwzM+66EDE0gE6TR/FTjjI5DyHieHB86A68zeclxpGbQNuNu2iczpgNNp3MmjgsNhEZIQU3OYBOA0XbGBRBLeCo0vnc7ExA1/gu2zriJK00js7OnmgAGqXE82z+oga0znstSpQYqjYM2gEniIoZqvJOeTZjNiBril02nPZrrCqYZG0DUSwnmW6WkCRymAk2E0Aj0Lt8GMMeM58w81QYwygxPFx4x0zEBYLtZX2nmWmdmShrkN69Kg/oAJErVb/ZxxgcQHaBnfQBOlCNn0DjxKddXGrtMQCPSs6faAEbTs1mh6aRnBkPTExp0R3PiA0wIjUXQ8PP6gAYWNXqu30ws4Xl6xnPTc6XhZuAX8AFmihrZcfac3TwGDS95ayNAmELGYWRQI8CGTOwg07mimahokM4Y7lIcyMCKhuJUL4DwDM56AQK/zarEGERMIB6/vg3gxonRBP4vwFPIhBNkfv6lbPe7se+q930fnE9U9EGjE3n77e0/v0iNTgE3AAA=\"," +
                "      \"ST\" : \"838676\"," +
                "      \"T\" : \"132543737270000000\"" +
                "   }" +
                "]");
        System.out.println(tmp);
//        System.out.println(new Date(132543737270000000L/100000));
    }

}
