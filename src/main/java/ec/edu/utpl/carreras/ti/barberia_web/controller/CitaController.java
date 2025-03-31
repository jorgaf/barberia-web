package ec.edu.utpl.carreras.ti.barberia_web.controller;

import ec.edu.utpl.carreras.ti.barberia_web.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/citas")
public class CitaController {
    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    String getAllCitas(Model model) {
        var citas = citaService.getAllCitas();
        model.addAttribute("citas", citas);
        return "citastmplt";
    }
}