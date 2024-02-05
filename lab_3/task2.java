import java.math.BigInteger;
import java.util.Scanner;
 
class task2 {
    public static void main(String [] args)
    {
        String a1,a2;
        
        Scanner in = new Scanner(System.in);
        System.out.print("a1=");
                a1=in.next();
        System.out.print("a2=");
                a2=in.next();
        
        Rational r1 = new Rational(a1);
        Rational r2 = new Rational(a2);
        Rational r  = r1.add(r2);
        System.out.println("add="+r.toString());
        System.out.println("sub="+(r2.sub(r1)).toString());
        System.out.println("mul="+(r2.mul(r1)).toString());
        
    }       
}

class Rational {
    
    private BigInteger num;
    private BigInteger den;
    
    Rational(String s)
    {
       if (s.contains("/"))
       {
          String [] nd = s.split("/");   
          num=new BigInteger(nd[0]);
          den=new BigInteger(nd[1]);        
       }
       else
       {
          num=new BigInteger(s);
          den=new BigInteger("1");        
       }
    }
    Rational(String n, String d)
    {
        BigInteger tmp=new BigInteger(n);
        if (tmp.intValue()==0)
        {
            num=new BigInteger("0");
            den=new BigInteger("1");
        }
        else
        {           
           num=new BigInteger(n);
           den=new BigInteger(d);
        }   
    }
    Rational(BigInteger n, BigInteger d)
    {
        num=n;
        den=d;
    }
    Rational(BigInteger n)
    {
        num=n;
        den=new BigInteger("1");
    }
    public Rational add(Rational a) {
        BigInteger n1,d1,n2,d2,nn1,nn2,nn,dd,g;
        n1=num;
        d1=den;
        n2=a.num;
        d2=a.den;
        nn1=n1.multiply(d2);
        nn2=n2.multiply(d1);
        nn =nn2.add(nn1);
        dd =d1.multiply(d2);
        g  =nn.gcd(dd);
        nn =nn.divide(g);
        dd =dd.divide(g);
        Rational r=new Rational(nn,dd);
        return r;
    }
    public Rational sub(Rational a) {
        BigInteger n1,d1,n2,d2,nn1,nn2,nn,dd,g;
        n1=num;
        d1=den;
        n2=a.num;
        d2=a.den;
        nn1=n1.multiply(d2);
        nn2=n2.multiply(d1);
        nn =nn2.subtract(nn1);
        dd =d1.multiply(d2);
        g  =nn.gcd(dd);
        nn =nn.divide(g);
        dd =dd.divide(g);
        Rational r=new Rational(nn,dd);
        return r;
    }
    public Rational mul(Rational a) {
        BigInteger n1,d1,n2,d2,nn1,nn2,nn,dd,g;
        n1=num;
        d1=den;
        n2=a.num;
        d2=a.den;
        nn1=n1.multiply(n2);
        dd =d1.multiply(d2);
        g  =nn1.gcd(dd);
        nn =nn1.divide(g);
        dd =dd.divide(g);
        Rational r=new Rational(nn,dd);
        return r;
    }
 
    public String toString() {
        if (num.compareTo(den)==0)
           return "1";  
            else
             if (num.compareTo( new BigInteger("0"))==0)
            return "0";
                 else
                        return num.toString()+"/"+den.toString();
    }
}
