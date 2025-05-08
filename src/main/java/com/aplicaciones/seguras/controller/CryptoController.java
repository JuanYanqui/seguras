package com.aplicaciones.seguras.controller;

import com.aplicaciones.seguras.service.AesEncryptionService;
import com.aplicaciones.seguras.service.RsaEncryptionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crypto")

public class CryptoController {
    private final AesEncryptionService aesService;
    private final RsaEncryptionService rsaService;

    public CryptoController() throws Exception {
        this.aesService = new AesEncryptionService();
        this.rsaService = new RsaEncryptionService();
    }

    @PostMapping("/aes/encrypt")
    public String encryptAes(@RequestBody String input) throws Exception {
        return aesService.encrypt(input);
    }

    @PostMapping("/aes/decrypt")
    public String decryptAes(@RequestBody String input) throws Exception {
        return aesService.decrypt(input);
    }

    @PostMapping("/rsa/encrypt")
    public String encryptRsa(@RequestBody String input) throws Exception {
        return rsaService.encrypt(input);
    }

    @PostMapping("/rsa/decrypt")
    public String decryptRsa(@RequestBody String input) throws Exception {
        return rsaService.decrypt(input);
    }

}
