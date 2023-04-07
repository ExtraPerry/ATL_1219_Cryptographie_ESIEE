import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Crypto
{
    //===========================================================
    //                METHODES UTILES
    //===========================================================

    /**
     * Convertir une chaine de caracteres en tableau de bytes
     */
    public static byte[] strToByte( final String pMsg )
    {
        return pMsg.getBytes();
    } // strToByte

    /**
     * Convertir un tableau de bytes en une chaine de caracteres
     */
    public static String byteToStr( final byte[] pByteArray )
    {
        return new String(pByteArray);
    } // byteToStr()

    /**
     * Ecrire un texte dans un fichier en conservant son contenu
     * si "pAjout=true", ou en l'ecrasant si "pAjout=false"
     */
    public static void writeFile( final String pContent, final String pFile, final boolean pAjout )
    {
        try {
            FileWriter vWriter = new FileWriter(pFile, pAjout);
            vWriter.write(pContent);
            vWriter.close();
        }
        catch( final IOException pE ) {
            pE.printStackTrace();
        }
    } // writeFile()

    /**
     * Lire le contenu d'un fichier de nom (pFile)
     * et le retourner dans une String
     */
    public static String readFile( final String pFile )
    {
        String vContent = "";
        try {
            vContent = new String( Files.readAllBytes( Paths.get(pFile) ) );
        }
        catch( final IOException pE ) {
            pE.printStackTrace();
        }
        return vContent;
    } // readFile()
    
    //===========================================================
    //                FIN METHODES UTILES
    //===========================================================

    /**
     * Calculer le nombre d'occurence de chaque lettre dans un fichier
     * texte
     */
    
    public static int[] frequences( final String pFile )
    {
        String vTxt = readFile(pFile);
        vTxt = vTxt.toUpperCase();

        /* Tableau de frequences (vOcc[k]:Nbr d'occurrences de la k-ieme
           lettre de l'alphabet dans la chaine vTxt) */
        int[] vOcc= new int[26];
        //========== TODO Question-1
        for(int i = 0 ; i < vTxt.length() ; i++){
            if(vTxt.charAt(i) >= 'A' && vTxt.charAt(i) <= 'Z'){
                vOcc[vTxt.charAt(i) - 65] += 1;
                //System.out.println("\'" + vTxt.charAt(i) + "\' <=> " + (int)vTxt.charAt(i) + "");
            }
        }
        //========== Fin TODO Question-1
        return vOcc;
    } // frequences()

  
      /**
     * Dechiffrer le contenu d'un fichier en appliquant une substitution
     * mono-alphabetique basee sur une table de correspondance de lettres 
     */
    
    public static String subDecrypt( final String pFile, final char[] pKey )
    {                                                   
        String vChiffre = readFile(pFile);
        vChiffre = vChiffre.toUpperCase();
        String vClair = "";
        //=========== TODO Question-3
        for(int i = 0 ; i < vChiffre.length() ; i++){
            if(vChiffre.charAt(i) >= 'A' && vChiffre.charAt(i) <= 'Z'){
                vClair += "" + pKey[vChiffre.charAt(i) - 65] + "";
            }else{
                vClair += " ";
            }
        }
        //=========== Fin TODO Question-3
        return vClair;
    } // subDecrypt()

    public static String decimalToBinary(final String pDecimal){
        String vOutput = "";
        for(int i=0 ; i<pDecimal.length() ; i++){
            switch(pDecimal.charAt(i)){
                case '0':
                    vOutput += "0000";
                    break;
                case '1':
                    vOutput += "0001";
                    break;
                case '2':
                    vOutput += "0010";
                    break;
                case '3':
                    vOutput += "0011";
                    break;
                case '4':
                    vOutput += "0100";
                    break;
                case '5':
                    vOutput += "0101";
                    break;
                case '6':
                    vOutput += "0110";
                    break;
                case '7':
                    vOutput += "0111";
                    break;
                case '8':
                    vOutput += "1000";
                    break;
                case '9':
                    vOutput += "1001";
                    break;
                case 'A':
                    vOutput += "1010";
                    break;
                case 'B':
                    vOutput += "1011";
                    break;
                case 'C':
                    vOutput += "1100";
                    break;
                case 'D':
                    vOutput += "1101";
                    break;
                case 'E':
                    vOutput += "1110";
                    break;
                case 'F':
                    vOutput += "1111";
                    break;
            }
        }
        return vOutput;
    }
    
    public static String binaryToDecimal(final String pBinary){
        String[] vHexaCount = new String[(int)(pBinary.length()/4)];
        
        int vCount = 0;
        for(int i=0 ; i<vHexaCount.length ; i++){
            for(int j=0 ; j<4 ; j++){
               if(vCount<pBinary.length()){
                   vHexaCount[i] += pBinary.charAt(vCount);
                   vCount++;
               } 
            }
        }
        
        String vOutput = "";
        for(int i=0 ; i<vHexaCount.length ; i++){
            switch(vHexaCount[i]){
                case "0000":
                    vOutput += "0";
                    break;
                case "0001":
                    vOutput += "1";
                    break;
                case "0010":
                    vOutput += "2";
                    break;
                case "0011":
                    vOutput += "3";
                    break;
                case "0100":
                    vOutput += "4";
                    break;
                case "0101":
                    vOutput += "5";
                    break;
                case "0110":
                    vOutput += "6";
                    break;
                case "0111":
                    vOutput += "7";
                    break;
                case "1000":
                    vOutput += "8";
                    break;
                case "1001":
                    vOutput += "9";
                    break;
                case "1010":
                    vOutput += "A";
                    break;
                case "1011":
                    vOutput += "B";
                    break;
                case "1100":
                    vOutput += "C";
                    break;
                case "1101":
                    vOutput += "D";
                    break;
                case "1110":
                    vOutput += "E";
                    break;
                case "1111":
                    vOutput += "F";
                    break;
            }
        }
        return vOutput;
    }
    
      /**
     * Chiffrer/Dechiffrer le contenu d'un fichier en appliquant une m�thode
     * par blocs et XOR 
     */
   
    public static void ecbXor( final String pInfile, final String pOutfile, final String pKey )
    {                                                          
        //=========== TODO Question-5
                String vInFileString = readFile(pInfile);
                int vLength = 0;
                if(vInFileString.length() % 4 == 0){
                    vLength = vInFileString.length() / 4;
                }else{
                    vLength = (int)((vInFileString.length() / 4) + 1);
                }
                String[] vStringGroup = new String[vLength];
                byte[][] vByteGroup = new byte[vLength][];
                String[] vBinaryStringOutput = new String[vLength];
                String[] vByteStringOutput = new String[vLength];
                
                byte[] vByteKey = strToByte(pKey);
                String vByteStringKey = "";
                for(int i=0 ; i<vByteKey.length ; i++){
                    vByteStringKey += vByteKey[i];
                }
                System.out.println("Key : \"" + pKey + "\" ==> " + vByteStringKey + " ==> " + decimalToBinary(vByteStringKey));
                
                int vCount = 0;
                for(int i=0 ; i<vStringGroup.length ; i++){
                    vStringGroup[i] = "";
                    for(int j=0 ; j<4 ; j++){
                        if(vCount<vInFileString.length()){
                            vStringGroup[i] += vInFileString.charAt(vCount);
                            vCount++;
                        }
                    }
                    vByteGroup[i] = strToByte(vStringGroup[i]);
                    
                    String vTemp1 = "";
                    for(int j=0 ; j<4 ; j++){
                        if(j<vByteGroup[i].length){
                            vTemp1 += vByteGroup[i][j];
                        }
                    }
                    
                    vBinaryStringOutput[i] = "";
                    for(int j=0 ; j<decimalToBinary(vTemp1).length() && j<decimalToBinary(vByteStringKey).length() ; j++){
                        if(decimalToBinary(vTemp1).charAt(j) != decimalToBinary(vByteStringKey).charAt(j)){
                            vBinaryStringOutput[i] += "1";
                        }else{
                            vBinaryStringOutput[i] += "0";
                        }
                    }
                    
                    
                    
                    
                    
                    vByteStringOutput[i] = binaryToDecimal(vBinaryStringOutput[i]);
                    
                    System.out.print("\"" + vStringGroup[i] + "\" ==> " + vTemp1 + " ==> " + decimalToBinary(vTemp1) + " ==> " + vBinaryStringOutput[i]);
                    System.out.println(" ==> " + vByteStringOutput[i]);
                }
                
                
        //=========== Fin TODO Question-5
    } // ecbXor()

    
    /*=============== Tests et invocations de methodes ============================*/
    
    public static void main( final String[] pArgs )
    {                                
        
        
        //TODO Question-3
        char[] vKey1 = new char[26];
        String vStringKey1 = "V__MHNOPCQRST_IJ_DLEG_UABF";
        for(int i = 0 ; i < vKey1.length ; i++){
            vKey1[i] = (char)(vStringKey1.charAt(i));
        }
        
        System.out.println("-------------------------------------");
        String vText1 = subDecrypt("Crypto1.txt", vKey1);
        System.out.println(vText1);
        System.out.println("-------------------------------------");
        String vText2 = subDecrypt("Crypto2.txt", vKey1);
        System.out.println(vText2);
        //Fin TODO Question-3
        
        /*=============================================================*/
        
        //TODO Question-4
        char[] vKey2 = new char[26];
        String vStringKey2 = "UVWXYZABCDEFGHIJKLMNOPQRST";
        for(int i = 0 ; i < vKey2.length ; i++){
            vKey2[i] = (char)(vStringKey2.charAt(i));
        }
        
        System.out.println("-------------------------------------");
        String vText3 = subDecrypt("QuestionQuatre.txt", vKey2);
        System.out.println(vText3);
        //Fin TODO Question-4
        
        /*=============================================================*/
        
        //TODO Question-6

        //Fin TODO Question-6
        
        /*=============================================================*/

        //TODO Question-8

        //Fin TODO Question-8
        
    } // main()
} // Crypto

