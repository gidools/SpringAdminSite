package com.gidools.admin.controller;

import com.gidools.admin.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {
        return "Hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        String password = pwd;
        System.out.println("id : " + id + ", password : " + password);
        return "Hi getParameter";
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getPage());
        return searchParam;
    }

}
