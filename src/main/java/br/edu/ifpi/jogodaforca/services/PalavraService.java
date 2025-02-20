package br.edu.ifpi.jogodaforca.services;

import br.edu.ifpi.jogodaforca.models.Palavra;
import br.edu.ifpi.jogodaforca.repositories.PalavraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.edu.ifpi.jogodaforca.dto.PalavraDTO;

@Service
public class PalavraService {

    @Autowired
    private PalavraRepository palavraRepository;

    // Retorna todas as palavras
    public List<Palavra> findAll() {
        return palavraRepository.findAll();
    }

    // Busca uma palavra aleatória utilizando o repositório
    public Optional<Palavra> getRandomPalavra() {
        return Optional.ofNullable(palavraRepository.findRandomPalavra());
    }

    // Salvar uma palavra
    public Palavra save(Palavra palavra) {
        return palavraRepository.save(palavra);
    }

    public Palavra adicionarPalavra(PalavraDTO palavraDTO) {
        // Validações básicas
        if (palavraDTO.getPalavra() == null || palavraDTO.getPalavra().trim().isEmpty()) {
            throw new IllegalArgumentException("A palavra não pode estar vazia");
        }
        if (palavraDTO.getDica() == null || palavraDTO.getDica().trim().isEmpty()) {
            throw new IllegalArgumentException("A dica não pode estar vazia");
        }

        Palavra novaPalavra = new Palavra(
            palavraDTO.getPalavra().toUpperCase(),
            palavraDTO.getDica()
        );
        
        return palavraRepository.save(novaPalavra);
    }
}
