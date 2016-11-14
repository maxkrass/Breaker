package bruchrechnen;
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    int z1=1;
    int n1=4;
    int z2=8;
    int n2=2;
    int zFinal, nFinal;
    
    public void main(String[] args){
    	dividieren();
    }
    
    public void plus(){
        erweitern();
        zFinal=z1+z2;
        kuerzen();
    }
    
    public void minus(){
        erweitern();
        zFinal=z1-z2;
        kuerzen();
    }
    
    public void multiplizieren(){
        zFinal = z1*z2;
        nFinal = n1*n2;
        kuerzen();
    }
    
    public void dividieren(){
        int z2t = z2;
        z2=n2;
        n2=z2t;
        multiplizieren();
    }
    // erweitert immer n1*n2
    public void erweitern(){
        if (n1!=n2){
            z1=z1*n2;
            n1=n1*n2;
            z2=z2*n1;
            n2=n2*n1;
        }
    }

    public void kuerzen(){
        if (nFinal>zFinal){
            for(int i=nFinal;i>1;i--){
                if ((zFinal%i==0)&& (nFinal%i==0)){
                    zFinal=zFinal/i;
                    nFinal=nFinal/i;
                    System.out.println("gekürzt mit "+i);
                }
            }
        }
        else{
            for(int i=zFinal;i>1;i--){
                if ((zFinal%i==0)&& (nFinal%i==0)){
                    zFinal=zFinal/i;
                    nFinal=nFinal/i;
                    System.out.println("gekürzt mit "+i);
                }
            }
        }
        System.out.println(zFinal);
        System.out.println("-");
        System.out.println(nFinal);
    }
}