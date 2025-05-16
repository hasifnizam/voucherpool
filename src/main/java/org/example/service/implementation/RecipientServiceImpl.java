package org.example.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.example.common.request.RecipientRequest;
import org.example.entity.RecipientEntity;
import org.example.exception.ServiceException;
import org.example.repository.RecipientRepository;
import org.example.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RecipientServiceImpl implements RecipientService {

    @Autowired
    private RecipientRepository recipientRepository;

    public List<RecipientEntity> getAllRecipient() {
        List<RecipientEntity> recipientList = recipientRepository.findAll();
        log.info("All recipient list: {}", recipientList);
        return recipientList;
    }

    public RecipientEntity registerNewUser(RecipientRequest request) {
        log.info("User request: {}", request);

        try {
            //Assign request to entity object
            RecipientEntity recipient = new RecipientEntity();
            recipient.setName(request.getName());
            recipient.setEmail(request.getEmail());
            return recipientRepository.save(recipient);
        } catch (Exception e) {
            log.error("Error while registering new user. :", e);
            throw new ServiceException("Failed to register new user. Email already exist", e);
        }
    }
}
