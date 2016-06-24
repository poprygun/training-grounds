package io.pivotal.tg;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RefreshScope
public class TechniqueController {

    @Value("${dojo.discipline}")
    private String discipline;

    @RequestMapping("/techniques")
    public List<Technique> techniques() {
        if (Discipline.BJJ.toString().equalsIgnoreCase(discipline)) {
            return Arrays.asList(new Technique("omoplata"), new Technique("de la riva"));
        } else {
            return Arrays.asList(new Technique("seoi nage"));
        }
    }
}
