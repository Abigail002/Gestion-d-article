package com.defitech.tp_vente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
    @GetMapping("/home")
    public String indexf() {
        return "/NiceAdmin/index";
    }
}
