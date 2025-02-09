package br.edu.ifpi.jogodaforca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jogo")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String jogo(Model model) {
        Palavra palavra = gameService.getRandomPalavra();
        model.addAttribute("palavra", palavra);
        model.addAttribute("topScores", usuarioService.getTopScores());
        return "jogo";
    }

    @PostMapping("/resultado")
    @ResponseBody
    public void salvarPontuacao(@RequestParam String nickname, @RequestParam int pontuacao) {
        usuarioService.saveOrUpdateUsuario(nickname, pontuacao);
    }
}
