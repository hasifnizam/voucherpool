package org.example.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.example.common.request.OfferRequest;
import org.example.entity.OfferEntity;
import org.example.exception.ServiceException;
import org.example.repository.OfferRepository;
import org.example.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<OfferEntity> getAllOffer() {
        List<OfferEntity> offerList = offerRepository.findAll();
        log.info("All offer list: {}", offerList);
        return offerList;
    }

    public OfferEntity createNewOffer(OfferRequest request) {
        log.info("User request: {}", request);
        try {
            //Assign request to entity object
            OfferEntity offer = new OfferEntity();
            offer.setName(request.getName());
            offer.setDiscount(request.getDiscount());
            return offerRepository.save(offer);
        } catch (Exception e) {
            log.error("Error while create new offer:", e);
            throw new ServiceException("Failed to create offer", e);
        }
    }
}
