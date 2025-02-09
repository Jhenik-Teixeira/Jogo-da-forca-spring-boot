package br.edu.ifpi.jogodaforca.services;

import br.edu.ifpi.jogodaforca.models.Palavra;
import br.edu.ifpi.jogodaforca.repositories.PalavraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private PalavraRepository palavraRepository;

    public Palavra getRandomPalavra() {
        return palavraRepository.findRandomPalavra();
    }
}

