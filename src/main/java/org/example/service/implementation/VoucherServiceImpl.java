package org.example.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.example.common.request.VoucherRequest;
import org.example.entity.OfferEntity;
import org.example.entity.RecipientEntity;
import org.example.entity.VoucherEntity;
import org.example.exception.ServiceException;
import org.example.repository.OfferRepository;
import org.example.repository.RecipientRepository;
import org.example.repository.VoucherRepository;
import org.example.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    @Value("${voucher.code.length:8}")
    private int codeLength;

    public List<VoucherEntity> getAllVoucher() {
        List<VoucherEntity> voucherList = voucherRepository.findAll();
        log.info("All offer list: {}", voucherList);
        return voucherList;
    }

    public VoucherEntity generateVoucher(VoucherRequest request) {
        log.info("User request: {}", request);

        //  Check if offer is exist
        OfferEntity offerEntity = offerRepository.findByName(request.getOfferName()).orElseThrow(() -> new ServiceException("Offer doesn't exist", null, HttpStatus.BAD_REQUEST));

        //  Check if recipient is exist
        RecipientEntity recipientEntity = recipientRepository.findByEmail(request.getRecipientEmail()).orElseThrow(() -> new ServiceException("Recipient doesn't exist", null, HttpStatus.BAD_REQUEST));

        LocalDate now = LocalDate.now();
        LocalDate expiredDate = now.plusDays(request.getValidDays());

        log.info("OfferEntity: {}\nRecipientEntity: {}\nExpired date: {}", offerEntity, recipientEntity, expiredDate);

        try {
            VoucherEntity voucher = new VoucherEntity();
            voucher.setCode(generateVoucherCode(codeLength));
            voucher.setOffer(offerEntity);
            voucher.setRecipient(recipientEntity);
            voucher.setUsed(false);
            voucher.setExpiredDate(expiredDate);
            return voucherRepository.save(voucher);
        } catch (Exception e) {
            log.error("Error while generate new voucher. :", e);
            throw new ServiceException("Failed to generate new voucher", e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public VoucherEntity redeemVoucher(String code) {
        log.info("Redeem voucher code: {}", code);

        //  Check if voucher code is exist
        VoucherEntity voucherEntity = voucherRepository.findByCode(code).orElseThrow(() -> new ServiceException("Voucher code is not valid!", null, HttpStatus.BAD_REQUEST));

        //  Check now date < expired date
        LocalDate now = LocalDate.now();
        if (now.isAfter(voucherEntity.getExpiredDate())) {
            throw new ServiceException("Voucher already expired!", null, HttpStatus.BAD_REQUEST);
        }

        //  Now check recipient already use the voucher or not
        if (voucherEntity.getUsed()) {
            throw new ServiceException("Voucher already used!", null, HttpStatus.BAD_REQUEST);
        }

        //  Proceed with redeeming the voucher code
        try {
            voucherEntity.setUsed(true);
            voucherEntity.setUsedDate(now);
            return voucherRepository.save(voucherEntity);
        } catch (Exception e) {
            log.error("Error while redeeming voucher: ", e);
            throw new ServiceException("Failed to redeem voucher!", e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generateVoucherCode(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length).toUpperCase();
    }
}
