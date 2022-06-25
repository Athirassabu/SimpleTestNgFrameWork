package com.check24.config;

import org.aeonbits.owner.Config;
@Config.Sources(value="file:${user.dir}/src/test/resources/config/config.properties")
public interface FrameworkConfig extends Config {

    long timeout();
    String url();
    String browser();
    String homePageTitle();
    String email();
    String card();
    String date();
    String cvv();
    String zip();
    String paymentSuccessMessage();
}
