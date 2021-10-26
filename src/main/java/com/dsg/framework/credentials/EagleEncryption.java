package com.dsg.framework.credentials;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class EagleEncryption {

  private static String encryptionKey = "MZygpewJsCpRrfOq"; // 128 bit security key
  private static String password = "QAAutomation";
  private static String delimiter = ":::";

  public static String encryptCredential(EagleCredential credential) throws Exception {

    String encryptionString = credential.getUserName() + delimiter + credential.getPassword();
    return encrypt(encryptionString);
  }

  private static String encrypt(String input) throws Exception {

    byte[] bytesInput = input.getBytes("UTF-8");

    Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
    //
    byte[] encryptedBytes = cipher.doFinal(bytesInput); // final encrypted output
    // print the string
    // System.out.println("Encrypted string :" + Base64.encodeBase64String(encryptedBytes));
    // return Base64.getEncoder().encodeToString(encryptedBytes);

    return Base64.encodeBase64String(encryptedBytes);
  }

  public static EagleCredential decryptCredential(String encryptedString) throws Exception {

    String decryptedText = EagleEncryption.decrypt(encryptedString);

    String[] strings = decryptedText.split(delimiter);

    if (strings.length > 0) return new EagleCredential(strings[0], strings[1]);
    else return new EagleCredential(null, null);
  }

  private static String decrypt(String encryptedString) throws Exception {
    String text;
    try {
      Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
      // convert the input to the base 64 byte array
      text = new String(cipher.doFinal(Base64.decodeBase64(encryptedString)), "UTF-8");

    } catch (Exception e) {
      throw new Exception(String.format("Unable to Decrypt %s", encryptedString), e);
    }

    return text;
  }

  private static Cipher getCipher(int cipherMode) throws Exception {

    String encryptionAlgorithm = "AES"; // use AES algorithm
    // using a encryption key to generate a secret Key ,
    // And salt with password

    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    // PBEParameterSpec pbeParamspec=new PBEParameterSpec(encryptionKey.getBytes(),1);//salt
    PBEKeySpec spec =
        new PBEKeySpec(password.toCharArray(), encryptionKey.getBytes(), 1, 128); // password

    SecretKey temp = factory.generateSecret(spec);

    SecretKeySpec keySpecification = new SecretKeySpec(temp.getEncoded(), encryptionAlgorithm);

    Cipher cipher = Cipher.getInstance(encryptionAlgorithm);

    cipher.init(cipherMode, keySpecification);

    return cipher;
  }
}
