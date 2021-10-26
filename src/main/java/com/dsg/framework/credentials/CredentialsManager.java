package com.dsg.framework.credentials;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.Base64;

public class CredentialsManager {

  public static boolean waiting = true;

  public static void setCredentials(String directory) {

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    JLabel lblApplication = new JLabel("Application:");
    JLabel lblUsername = new JLabel("Username:");
    JLabel lblPassword = new JLabel("Password:");
    JTextField txtApplication = new JTextField(20);
    JTextField txtUsername = new JTextField(20);
    JPasswordField txtPassword = new JPasswordField(20);
    JButton btnStore = new JButton("Store");
    btnStore.addActionListener(
        ae -> {
          StringBuilder passString = new StringBuilder();
          for (int i = 0; i < txtPassword.getPassword().length; i++) {
            passString.append(txtPassword.getPassword()[i]);
          }
          // framework.credentials.CredentialsManagerXML.writeCredential(txtApplication.getText(),
          // txtUsername.getText(), passString);
          // CredentialsManagerXML.writeCredential(txtApplication.getText(), txtUsername.getText(),
          // passString.toString(), directory);
          try {
            writeCredential(
                txtApplication.getText(), txtUsername.getText(), passString.toString(), directory);
          } catch (Exception e) {
            e.printStackTrace();
          }
          frame.dispose();
          waiting = false;
        });
    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(ae -> System.exit(0));

    panel.add(lblApplication);
    panel.add(txtApplication);
    panel.add(lblUsername);
    panel.add(txtUsername);
    panel.add(lblPassword);
    panel.add(txtPassword);
    panel.add(btnStore);
    panel.add(btnCancel);
    frame.getContentPane().add(BorderLayout.CENTER, panel);

    frame.setSize(300, 250);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation(
        dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    frame.setVisible(true);
  }

  public static String encryptDecryptCredentials(String encOrDec, String target) {
    String key;
    boolean is32bit;
    if (System.getProperty("os.name").contains("Windows")) {
      is32bit = (System.getenv("ProgramFiles(x86)") == null);
      if (is32bit) {
        key = "9FCD95723E4C5758";
      } else {
        key = "7A91F9BAA1CD75DE9FCD95723E4C5758";
      }

    } else {
      key = "7A91F9BAA1CD75DE9FCD95723E4C5758";
    }
    // String key = "7A91F9BAA1CD75DE9FCD95723E4C5758";
    // String key32 = "9FCD95723E4C5758";
    String encDecString = "";
    Security.setProperty("crypto.policy", "unlimited");

    if (encOrDec.equals("encrypt")) {
      try {
        SecretKeySpec skeyspec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
        // encrypt AES
        byte[] encrypted = cipher.doFinal(target.getBytes(StandardCharsets.UTF_8));
        // encode
        encDecString = Base64.getEncoder().encodeToString(encrypted);
        // System.out.println("base 64 Encrypted string: " + encDecString);

      } catch (Exception e) {
        e.printStackTrace();
        // ErrorLog.printErrors(e.toString());
      }
    } else if (encOrDec.equals("decrypt")) {
      try {
        SecretKeySpec skeyspec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeyspec);
        // decode base 64
        byte[] decodedBytes = Base64.getDecoder().decode(target);
        // decrypt cipher
        byte[] decrypted = cipher.doFinal(decodedBytes);
        encDecString = new String(decrypted);
        // System.out.println("Decrypted string: " + encDecString);

      } catch (Exception e) {
        e.printStackTrace();
        // ErrorLog.printErrors(e.toString());
      }
    } else {
      System.out.println("Invalid input");
    }
    return encDecString;
  }

  /*public static CredentialsDTO GetCredentails(String application)
  {
      List<CredentialsDTO> list = CredentialsManagerXML.getCredentialsFromXML();

      CredentialsDTO creds = null;

      //System.out.println("Requested credentials for: " + application);

      for (CredentialsDTO credentialsDTO : list) {
          if (credentialsDTO.getApplication().equals(application)) {
              creds = credentialsDTO;
              break;
          }
      }

      //System.out.println("Username: " + creds.getUser());
      //System.out.println("Password: " + creds.getPassword());

      return creds;
  }*/

  public static void writeCredential(String app, String user, String password, String directory)
      throws Exception {

    System.out.println("Writing credentials to: " + directory);
    File newFile = new File(directory + "/newCredentials.properties");

    EagleCredential creds = new EagleCredential(user, password);
    String encryptedCred = EagleEncryption.encryptCredential(creds);

    FileWriter writer = new FileWriter(newFile);

    // Check in newCredentials file exists
    if (newFile.exists()) {

      writer.append(app).append("=").append(encryptedCred);
      writer.close();
      System.out.println(
          "Encrypted credential file located at: " + newFile.toString() + " has been updated");

    } else {
      if (newFile.createNewFile()) {

        writer.write(app + "=" + encryptedCred);
        writer.close();
        System.out.println("Encrypted credential file located at: " + newFile.toString());
      } else {
        System.out.println("Unable to create new credential file");
      }
    }

    System.out.println("Complete");
  }
}
