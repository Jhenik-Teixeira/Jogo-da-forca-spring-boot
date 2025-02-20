package br.edu.ifpi.jogodaforca.controllers;

import br.edu.ifpi.jogodaforca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jogo")
public class RankingController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/ranking")
    public String mostrarRanking(Model model) {
        model.addAttribute("topScores", usuarioService.getTopScores());
        return "ranking";
    }
} 