/*  Caesar Cipher: encrypting and decrypting uppercase and lowercase letters
 * 
 *  Input: Text consisting of upper and lowercase letters
 *
 *  Output: Encrypted and plain text
 *
 */ 

public class CaesarCipher{
    protected char[] encoder_upper = new char[26];
    protected char[] decoder_upper = new char[26];

    protected char[] encoder_lower = new char[26];
    protected char[] decoder_lower = new char[26];

    public CaesarCipher(int rotation){
        for (int k = 0; k < 26; k++){
            encoder_upper[k] = (char) ('A' + (k + rotation) % 26);
            encoder_lower[k] = (char) ('a' + (k + rotation) % 26);
            decoder_upper[k] = (char) ('A' + (k - rotation + 26) % 26);
            decoder_lower[k] = (char) ('a' + (k - rotation + 26) % 26);
        }
    }    

        public String encrypt(String message){
            return transform(message, encoder_upper, encoder_lower);
        }

        public String decrypt(String secret){
            return transform(secret, decoder_upper, decoder_lower);
        }

        private String transform(String original, char[] code_upper, char[] code_lower){
            char[] msg = original.toCharArray();
            for (int k = 0; k < msg.length; k++){
                if (Character.isUpperCase(msg[k])){
                    int j = msg[k] - 'A';
                    msg[k] = code_upper[j];
                }     

                if (Character.isLowerCase(msg[k])){ 
                    int j = msg[k] - 'a';
                    msg[k] = code_lower[j];
                } 
            }               
            return new String(msg);   
        }

        public static void main(String[] args){
            CaesarCipher cipher = new CaesarCipher(3);
            System.out.println("----------Uppercase----------------");
            System.out.println("Encryption code = " + new String(cipher.encoder_upper));
            System.out.println("Decryption code = " + new String(cipher.decoder_upper));
            System.out.println("----------Lowercase----------------");
            System.out.println("Encryption code = " + new String(cipher.encoder_lower));
            System.out.println("Decryption code = " + new String(cipher.decoder_lower));
            String message = "HELLO WORLD hi world";
            String coded = cipher.encrypt(message);
            String decoded = cipher.decrypt(coded);
            
            System.out.println("Original message: " + message);
            System.out.println("Secret: " + coded);
            System.out.println("Message: " + decoded);

        }
    }
 
