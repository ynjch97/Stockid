package com.eunjy.stockid.utiliy;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

/**
 * Yaml Properties 클래스
 *
 * <PRE>
 * 1. ClassName: PropertiesYaml
 * 2. 작성자   : ynjch97
 * 3. 작성일   : 2021.7.3.
 * 4. 변경이력
 *		이름			일자				변경내용
 *     ———————————————————————————————————————————
 *		ynjch97		2021.7.3.		신규 개발
 * </PRE>
 */
@Configuration //value를 통해 값이 있는 위치를 명시해준다.
@PropertySource(value = "classpath:properties/configuration.yml", factory = YamlPropertySourceFactory.class) // yml 파일에서 가져올 변수 이름을 명시해준다. 
@ConfigurationProperties(prefix = "settings") 
@Setter 
@Getter
public class ConfigurationYaml {
	private List<String> noSession;
	private List<String> noSessionPattern;
	private List<Map<String, String>> fruits;
}
