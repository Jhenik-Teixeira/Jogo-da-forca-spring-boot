package br.edu.ifpi.jogodaforca.controllers;

import br.edu.ifpi.jogodaforca.dto.PalavraDTO;
import br.edu.ifpi.jogodaforca.services.PalavraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/jogo")
public class PalavraController {

    @Autowired
    private PalavraService palavraService;

    @GetMapping("/palavras/nova")
    public String novaPalavraForm() {
        return "adicionar-palavra";
    }

    @PostMapping("/palavras/adicionar")
    public String adicionarPalavra(@ModelAttribute PalavraDTO palavraDTO, RedirectAttributes redirectAttributes) {
        try {
            // Validações básicas
            if (palavraDTO.getPalavra() == null || palavraDTO.getPalavra().trim().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "A palavra não pode estar vazia!");
                return "redirect:/jogo/palavras/nova";
            }

            if (palavraDTO.getDica() == null || palavraDTO.getDica().trim().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "A dica não pode estar vazia!");
                return "redirect:/jogo/palavras/nova";
            }

            // Validar se contém apenas letras (sem números ou caracteres especiais)
            if (!palavraDTO.getPalavra().matches("^[A-Za-zÀ-ÿ\\s]+$")) {
                redirectAttributes.addFlashAttribute("error", "A palavra deve conter apenas letras!");
                return "redirect:/jogo/palavras/nova";
            }

            palavraService.adicionarPalavra(palavraDTO);
            redirectAttributes.addFlashAttribute("message", "Palavra e dica  '" + palavraDTO.getPalavra().toUpperCase() + "' adicionada com sucesso!");
            return "redirect:/jogo/ranking";

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/jogo/palavras/nova";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao adicionar palavra: " + e.getMessage());
            return "redirect:/jogo/palavras/nova";
        }
    }
} 