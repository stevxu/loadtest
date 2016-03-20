package com.weibo.loadtest;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.TimerTask;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class Senddata extends TimerTask{
	
	Properties props;
	ProducerConfig config;
	Producer<String, String> producer;
	String[] req = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
	Random rnd = new Random();

	public Senddata() {
		props = new Properties();
		props.put("metadata.broker.list", "10.13.4.44:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("producer.type", "sync");
		config = new ProducerConfig(props);
		producer = new Producer<String, String>(config);
	}

	@Override
	public void run() {

		for (long nEvents = 0; nEvents < 10000; nEvents++) {
			String time = MyTimeUtil.getDate();
			String ip = "" + rnd.nextInt(225) + "." + rnd.nextInt(225) + "."
					+ rnd.nextInt(225) + "." + rnd.nextInt(225);
			String uid = "955305" + rnd.nextInt(4583);
			String path = req[rnd.nextInt(9)];
			String data1 = "asdfasdf|["
					+ time
					+ "]`-`GET /2/statuses/publi"
					+ path
					+ "_timeline?gsid=_2A257rFO&wm=3333_2001&i=33c4749&b=1&from=1061093010&c=iphone&networktype=3g&v_p=27&skin=default&v_f=1&s=4b61a37b&lang=zh_CN&sflag=1&ua=iPhone6,1__weibo__6.1.0__iphone__os9.2.1&aid=01At1xFj90p8WbaohhcFvVn_OFS-2sbCC_oiswJnkOGZ5UwLY.&position=feed HTTP/1.1`Weibo/6348 (iPhone; iOS 9.2.1; Scale/2.00)`200`["
					+ ip
					+ "]`"
					+ uid
					+ "`-`0.055`823`-`171.220.12.166`1002794733523946840`api.weibo.cn`-`0.055`626`yhg";
			KeyedMessage<String, String> data = new KeyedMessage<String, String>(
					"wlfzz_source_test", ip, data1);
			producer.send(data);

		}
		System.out.println(" " + new Date().getSeconds() + " success");
	}

}
