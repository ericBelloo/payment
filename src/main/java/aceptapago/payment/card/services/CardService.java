package aceptapago.payment.card.services;

import aceptapago.payment.card.model.SaveCard;
import aceptapago.payment.card.repository.CardRepository;
import aceptapago.payment.commond.service.ISaveService;
import aceptapago.payment.commond.service.ISelectedElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
public class CardService implements ISaveService<String, SaveCard>,
        ISelectedElement<Object, Integer> {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public String save(SaveCard instance) {
        return cardRepository.saveCard(instance);
    }

    @Override
    public Object selectedElement(Integer instance) {
        return cardRepository.selectedCard(instance);
    }
}
