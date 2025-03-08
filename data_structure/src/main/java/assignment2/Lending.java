package assignment2;
public class Lending {
    private String bcode;  
    private String rcode;  
    private int state;

    public Lending(String bcode, String rcode, int state) {
        this.bcode = bcode;
        this.rcode = rcode;
        setState(state);
    }

    public String getBcode() { 
        return bcode; 
    }
    public void setBcode(String bcode) { 
        this.bcode = bcode; 
    }

    public String getRcode() { 
        return rcode; 
    }
    public void setRcode(String rcode) { 
        this.rcode = rcode; 
    }

    public int getState() { 
        return state; 
    }
    public void setState(int state) {
        if (state >= 0 && state <= 2) {
            this.state = state;
        } else {
            System.out.println("Error: State must be 0, 1, or 2.");
        }
    }

    @Override
    public String toString() {
        return "Lending{" +
                "bcode='" + bcode + '\'' +
                ", rcode='" + rcode + '\'' +
                ", state=" + state +
                '}';
    }
}
