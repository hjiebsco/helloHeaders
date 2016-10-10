package com.hji.ping;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HeaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeaderApplication.class, args);
	}
}

@RestController
class AppControler {

	@RequestMapping("/public")
	public Object ok(@RequestHeader HttpHeaders headers) {
		return dumpHeaders(headers);
	}

	@RequestMapping("/private")
	public Object notOK(@RequestHeader HttpHeaders headers) {
		return dumpHeaders(headers);
	}

	private Map<String, List<String>> dumpHeaders(HttpHeaders headers) {
		Map<String, List<String>> map = new TreeMap<>();
		for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
			map.put(entry.getKey(), entry.getValue());
		}
		return map;
	}

}
