import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Write a description of class RandomCrap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomCrap
{
    /**
     * Constructor for objects of class RandomCrap
     */
    public RandomCrap()
    {
        //
    }

    /**
     * Lire le contenu d'un fichier de nom (pFile)
     * et le retourner dans une String
     */
    public String readFile( final String pFile )
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
    
    
    /**
     * Calculer le nombre d'occurence de chaque lettre dans un fichier
     * texte
     */
    public int[] frequences( final String pFile )
    {
        String vTxt = this.readFile(pFile);
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
    
    
    public void main()
    {
        int[] vChiffre = this.frequences("Crypto1.txt");
        String vAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for(int i = 0 ; i < vAlphabet.length() ; i++){
            System.out.println("\'" + vAlphabet.charAt(i) + "\' = " + vChiffre[i] + "");
        }
    }
    
    public void qExTwo(final String pFile)
    {
        String vTxt = this.readFile(pFile);
        vTxt = vTxt.toUpperCase();
        
        System.out.println("----------------------------------------");
        System.out.println(vTxt);
        System.out.println("----------------------------------------");
        
        String vOutput = "";
        
        for(int i = 0 ; i < vTxt.length() ; i++){
            switch(vTxt.charAt(i)){
                case 'T':
                    vOutput += "E";
                    break;
                case 'L':
                    vOutput += "S";
                    break;
                case 'F':
                    vOutput += "N";
                    break;
                case 'G':
                    vOutput += "O";
                    break;
                case 'X':
                    vOutput += "A";
                    break;
                case 'W':
                    vOutput += "U";
                    break;
                case 'M':
                    vOutput += "T";
                    break;
                case 'K':
                    vOutput += "R";
                    break;
                case 'D':
                    vOutput += "M";
                    break;
                case 'S':
                    vOutput += "L";
                    break;
                case 'H':
                    vOutput += "P";
                    break;
                case 'A':
                    vOutput += "V";
                    break;
                case 'I':
                    vOutput += "C";
                    break;
                case 'O':
                    vOutput += "I";
                    break;
                case 'E':
                    vOutput += "H";
                    break;
                case 'J':
                    vOutput += "Q";
                    break;
                case 'Z':
                    vOutput += "F";
                    break;
                case 'R':
                    vOutput += "D";
                    break;
                case 'Y':
                    vOutput += "B";
                    break;
                case 'U':
                    vOutput += "G";
                    break;
                case 'P':
                    vOutput += "J";
                    break;
                default:
                    vOutput += "" + vTxt.charAt(i) + "";
            }
        }
        
        System.out.println(vOutput);
    }
    
    public void runCryOneCryTwo()
    {
        this.qExTwo("Crypto1.txt");
        this.qExTwo("Crypto2.txt");
    }
    
    public void qExFour(final String pFile)
    {
        String vTxt = this.readFile(pFile);
        vTxt = vTxt.toUpperCase();
        
        System.out.println("----------------------------------------");
        System.out.println(vTxt);
        System.out.println("----------------------------------------");
        
        String vOutput = "";
        
        for(int i = 0 ; i < vTxt.length() ; i++){
            switch(vTxt.charAt(i)){
                case 'K':
                    vOutput += "E";
                    break;
                case 'T':
                    vOutput += "S";
                    break;
                case 'Y':
                    vOutput += "N";
                    break;
                    
                default:
                    vOutput += "" + vTxt.charAt(i) + "";
            }
        }
        
        System.out.println(vOutput);
    }
    
    public void runQuesFour()
    {
        int[] vChiffre = this.frequences("QuestionQuatre.txt");
        String vAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for(int i = 0 ; i < vAlphabet.length() ; i++){
            System.out.println("\'" + vAlphabet.charAt(i) + "\' = " + vChiffre[i] + "");
        }
        
        this.qExFour("QuestionQuatre.txt");
    }
}
