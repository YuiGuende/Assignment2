package model;
public class Reader {
    private String rcode; 
    private String name;
    private int byear;   

    public Reader(String rcode, String name, int byear) {
        this.rcode = rcode;
        this.name = name;
        setByear(byear);
    }

    public String getRcode() {
        return rcode; 
    }
    public void setRcode(String rcode) { 
        this.rcode = rcode; 
    }

    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }

    public int getByear() { 
        return byear; 
    }
    public void setByear(int byear) {
        if (byear >= 1900 && byear <= 2010) {
            this.byear = byear;
        } else {
            System.out.println("Error: Birth year must be between 1900 and 2010.");
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "rcode='" + rcode + '\'' +
                ", name='" + name + '\'' +
                ", byear=" + byear +
                '}';
    }
}
