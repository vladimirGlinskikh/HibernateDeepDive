package kz.zhelezyaka.fundamentalsCore.generators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;
import java.util.UUID;

public class UUIDGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return sign(UUID.randomUUID().toString());
    }

    private String sign(String primaryKeyValue) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(primaryKeyValue.getBytes());
            byte[] result = signature.sign();
            return primaryKeyValue + "." + Base64.getEncoder().encodeToString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
