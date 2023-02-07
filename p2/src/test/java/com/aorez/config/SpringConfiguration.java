package com.aorez.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration
@Import({DataSourceConfiguration.class})
@ComponentScan("com.aorez")
public class SpringConfiguration {
}
