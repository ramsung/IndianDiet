package diet.indian.best.indiandiet;

import java.util.ArrayList;

/**
 * Created by RK on 7/21/2017.
 */

public class Questions {

    public String custquest;
    ArrayList<String> options;

    public Questions(String custquest, ArrayList<String> options) {
        this.custquest = custquest;
        this.options = options;
    }

    public String getCustquest() {
        return custquest;
    }

    public void setCustquest(String custquest) {
        this.custquest = custquest;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}
