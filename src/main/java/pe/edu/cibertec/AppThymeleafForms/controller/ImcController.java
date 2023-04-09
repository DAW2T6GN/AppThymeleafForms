package pe.edu.cibertec.AppThymeleafForms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.AppThymeleafForms.model.ImcForm;

@Controller
public class ImcController {

    @GetMapping("/calculoimc")
    public String formImc(Model model){
        model.addAttribute("imcForm", new ImcForm());
        model.addAttribute("visualizar", false);
        return "formImc";
    }

    @PostMapping("/calculoimc")
    public String formImc(@ModelAttribute("imcForm") ImcForm imcForm,
                          Model model){
        Double tallam = imcForm.getTalla() / 100;
        Double valorImc = imcForm.getPeso() / (tallam * tallam);
        String resultadoImc ="";
        String colorMensaje = "alert-warning";
        if(valorImc <= 18.5){
            resultadoImc = "Por debajo del peso";
            colorMensaje = "alert-dark";
        } else  if(valorImc <= 25){
            resultadoImc = "Con peso normal";
            colorMensaje = "alert-primary";
        } else if(valorImc <= 30){
            resultadoImc = "Con sobrepeso";
            colorMensaje = "alert-warning";
        } else if(valorImc <= 35){
            resultadoImc = "Obesidad leve";
            colorMensaje = "alert-danger";
        } else if(valorImc <= 39){
            resultadoImc = "Obesidad media";
            colorMensaje = "alert-danger";
        }else {
            resultadoImc = "Obesidad mórbida";
            colorMensaje = "alert-danger";
        }
        model.addAttribute("visualizar", true);
        model.addAttribute("resultado", "Su valor de IMC es: "+
                String.format("%.2f", valorImc)+ ", usted se encuentra "+ resultadoImc);
        model.addAttribute("colormensaje", colorMensaje);
        return "formImc";
    }
}
