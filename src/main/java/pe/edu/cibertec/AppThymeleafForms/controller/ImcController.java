package pe.edu.cibertec.AppThymeleafForms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.cibertec.AppThymeleafForms.model.ImcForm;

@Controller
public class ImcController {

    @GetMapping("/calculoimc")
    public String formImc(Model model){
        model.addAttribute("imcForm", new ImcForm());
        model.addAttribute("visualizar", false);
        return "formImc";
    }
}
