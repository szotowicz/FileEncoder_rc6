/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szyfrator;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.BufferedReader;
import java.security.SecureRandom;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import org.bouncycastle.crypto.engines.RC6Engine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
/**
 *
 * @author Mikołaj
 */
public class RC6BouncyCastle {
    private static final SecureRandom secureRandom = new SecureRandom();
    
    public RC6BouncyCastle(){
        // Use bouncy castle as our provider
        //Security.addProvider(new BouncyCastleProvider());
    }
    
    
    public void encrypt(String filePathInput, String filePathOutput, String keyString, String encryptMode, int keySize, int subBlockSize, byte[] IV) {
        System.out.println("pathIn: " + filePathInput + " pathOut: " + filePathOutput + " key: " + keyString 
                + " mode: " + encryptMode + " block: " + keySize + " subBlock: " + subBlockSize);
        
        String nameFile = "";
        char[] fileCharArray = filePathOutput.toCharArray();
        for(int i = fileCharArray.length - 1; i > 0; i--){
            if(fileCharArray[i] == '\\'){
                for(int j = i+1; j < fileCharArray.length; j++){
                    nameFile += fileCharArray[j];
                }
                break;
            }
        }
        byte[] key = keyString.getBytes();
        
        PaddedBufferedBlockCipher rc6 = new PaddedBufferedBlockCipher(new RC6Engine(), new PKCS7Padding());
        
        switch (encryptMode) {
            case "ECB":
                rc6 = new PaddedBufferedBlockCipher(new RC6Engine());
                break;
            case "CBC":
                rc6 = new PaddedBufferedBlockCipher(new CBCBlockCipher(new RC6Engine()));
                break;
            case "OFB":
                rc6 = new PaddedBufferedBlockCipher(new OFBBlockCipher(new RC6Engine(), subBlockSize));
                break;
            case "CFB":
                rc6 = new PaddedBufferedBlockCipher(new CFBBlockCipher(new RC6Engine(), subBlockSize));
                break;
            default:
                System.out.println("Error: encryptMode is not correct   //method: encrypt(String filePath, String keyString, String encryptMode, int blockSize)");
                break;
        }
        
        try {
            if (encryptMode.equals("ECB")) {
                rc6.init(true, new KeyParameter(key));
            } else {
                System.out.println("IV: " + Base64.encode(IV) + " s: " + rc6.getBlockSize());
                
                rc6.init(true, new ParametersWithIV(new KeyParameter(key), IV ));
            }
            
            FileInputStream fis = new FileInputStream(new File(filePathInput));
            FileOutputStream fos = new FileOutputStream(new File(filePathOutput), true);
            FileOutputStream fos2 = new FileOutputStream(new File("bin/"+nameFile), true);
                        
            int inputSize = rc6.getBlockSize();
            
            byte[] buffer = new byte[inputSize];
            byte[] outBuffer = new byte[inputSize + rc6.getOutputSize(buffer.length)];

            int inCount = 0;
            int outCount = 0;

            while ((inCount = fis.read(buffer, 0, buffer.length)) > 0) {
                outCount = rc6.processBytes(buffer, 0, inCount, outBuffer, 0);
                fos.write(outBuffer, 0, outCount);
                fos2.write(outBuffer, 0, outCount);
            }
            
            outCount = rc6.doFinal(outBuffer, 0);
            fos.write(outBuffer, 0, outCount);
            fos2.write(outBuffer, 0, outCount);

            
        } catch (Exception e) {
            System.out.println("Error: TODO");
        }
        
        
        System.out.println("Encrypt ok! Finish.");
        
    }
    
    public void decrypt(String filePathInput, String filePathOutput, String sessionKey, String encryptMode, int keySize, int subBlockSize, byte[] IV) {
        System.out.println("pathIn: " + filePathInput + " pathOut: " + filePathOutput + " sessionKey: " + sessionKey 
                + " mode: " + encryptMode + " block: " + keySize + " sublock: " + subBlockSize);
        String nameFile = "";
        char[] fileCharArray = filePathInput.toCharArray();
        for(int i = fileCharArray.length - 1; i > 0; i--){
            if(fileCharArray[i] == '\\'){
                for(int j = i+1; j < fileCharArray.length; j++){
                    nameFile += fileCharArray[j];
                }
                break;
            }
        }
        byte[] key = sessionKey.getBytes();
        
        PaddedBufferedBlockCipher rc6 = new PaddedBufferedBlockCipher(new RC6Engine(), new PKCS7Padding());
        
        switch (encryptMode) {
            case "ECB":
                rc6 = new PaddedBufferedBlockCipher(new RC6Engine());
                break;
            case "CBC":
                rc6 = new PaddedBufferedBlockCipher(new CBCBlockCipher(new RC6Engine()));
                break;
            case "OFB":
                rc6 = new PaddedBufferedBlockCipher(new OFBBlockCipher(new RC6Engine(), subBlockSize));
                break;
            case "CFB":
                rc6 = new PaddedBufferedBlockCipher(new CFBBlockCipher(new RC6Engine(), subBlockSize));
                break;
            default:
                System.out.println("Error: encryptMode is not correct   //method: encrypt(String filePath, String keyString, String encryptMode, int blockSize)");
                break;
        }
        
        try {
            if (encryptMode.equals("ECB")) {
                rc6.init(false, new KeyParameter(key));
            } else {
                rc6.init(false, new ParametersWithIV(new KeyParameter(key), IV ));
            }
            
            FileInputStream fis = new FileInputStream(new File("bin/"+nameFile));
            FileOutputStream fos = new FileOutputStream(new File(filePathOutput), true);
                        
            int inputSize = rc6.getBlockSize();
            
            byte[] buffer = new byte[inputSize];
            byte[] outBuffer = new byte[inputSize + rc6.getOutputSize(buffer.length)];

            int inCount = 0;
            int outCount = 0;

            while ((inCount = fis.read(buffer, 0, buffer.length)) > 0) {
                outCount = rc6.processBytes(buffer, 0, inCount, outBuffer, 0);
                fos.write(outBuffer, 0, outCount);
            }
            
            outCount = rc6.doFinal(outBuffer, 0);
            fos.write(outBuffer, 0, outCount);

        } catch (Exception e) {
            System.out.println("Error: DecryptFile");
        }
        
        
        System.out.println("Decrypt ok! Finish.");
        
    }
    
    public void readCryptogram(String filePathInput){
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            FileInputStream in = new FileInputStream(new File(filePathInput));
            FileOutputStream out = new FileOutputStream("encfile.temp");
            
            FileWriter output = new FileWriter("encfile.temp",true);
            FileReader input = new FileReader(filePathInput);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = bufRead.readLine();
            Scanner s = new Scanner(System.in);
            
            
            char c;
            String str = "";
            while (true) {
                c = (char) s.next().charAt(0);
                if (c == '\n') {
                    if (str.contains("</EncryptedFile>")) {
                        break;
                    } else {
                        str = "";
                    }
                } else {
                    str += c;
                }
            }
            
            while ((bytesRead = in.read(buffer, 0, buffer.length)) > 0) {
                out.write(buffer, 0, bytesRead);
            }

            output.close();
        } catch (Exception e) {
            System.out.println("Error: readCryptogram");
        }
    }
    
    public void decryptKey(String filePathInput, String filePathOutput, String sessionKey, String encryptMode, int keySize, int subBlockSize, byte[] IV) {
        System.out.println("pathIn: " + filePathInput + " pathOut: " + filePathOutput + " sessionKey: " + sessionKey 
                + " mode: " + encryptMode + " block: " + keySize + " sublock: " + subBlockSize);
        
        byte[] key = sessionKey.getBytes();
        
        PaddedBufferedBlockCipher rc6 = new PaddedBufferedBlockCipher(new RC6Engine(), new PKCS7Padding());
        
        switch (encryptMode) {
            case "ECB":
                rc6 = new PaddedBufferedBlockCipher(new RC6Engine());
                break;
            case "CBC":
                rc6 = new PaddedBufferedBlockCipher(new CBCBlockCipher(new RC6Engine()));
                break;
            case "OFB":
                rc6 = new PaddedBufferedBlockCipher(new OFBBlockCipher(new RC6Engine(), subBlockSize));
                break;
            case "CFB":
                rc6 = new PaddedBufferedBlockCipher(new CFBBlockCipher(new RC6Engine(), subBlockSize));
                break;
            default:
                System.out.println("Error: encryptMode is not correct   //method: encrypt(String filePath, String keyString, String encryptMode, int blockSize)");
                break;
        }
        
        try {
            if (encryptMode.equals("ECB")) {
                rc6.init(false, new KeyParameter(key));
            } else {
                rc6.init(false, new ParametersWithIV(new KeyParameter(key), IV ));
            }
            
            FileInputStream fis = new FileInputStream(new File(filePathInput));
            FileOutputStream fos = new FileOutputStream(new File(filePathOutput), true);
                        
            int inputSize = rc6.getBlockSize();
            
            byte[] buffer = new byte[inputSize];
            byte[] outBuffer = new byte[inputSize + rc6.getOutputSize(buffer.length)];

            int inCount = 0;
            int outCount = 0;
            String absoluteKey = "";
            
            while ((inCount = fis.read(buffer, 0, buffer.length)) > 0) {
                outCount = rc6.processBytes(buffer, 0, inCount, outBuffer, 0);
                fos.write(outBuffer, 0, outCount);
            }
            
            outCount = rc6.doFinal(outBuffer, 0);
            fos.write(outBuffer, 0, outCount);

            fos.close();
        } catch (Exception e) {
            System.out.println("Error: DecryptFile");
        }
        
        
        System.out.println("Decrypt ok! Finish.");
        
    }
    
    
    private static byte[] generateIV(int sizeBlock) throws Exception {
        byte [] ivBytes = new byte[sizeBlock];
        secureRandom.nextBytes(ivBytes);
        return ivBytes;
    }
    
    
}


