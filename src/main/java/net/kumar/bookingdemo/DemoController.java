package net.kumar.bookingdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping("/hello")
    public String hello()
    {
        int a =10;
        int b =20;
        int c=30;
        int d = a+b+c;

        return "Hello";
    }
}
