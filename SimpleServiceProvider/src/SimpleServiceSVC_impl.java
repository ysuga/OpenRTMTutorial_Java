// -*-Java-*-
/*!
 * @file  SimpleServiceSVC_impl.java
 * @brief Service implementation code of SimpleService.idl
 *
 */
import ysuga.SimpleServicePOA;
/*!
 * @class SimpleServiceSVC_impl
 * Example class implementing IDL interface ysuga::SimpleService
 */
public class SimpleServiceSVC_impl extends SimpleServicePOA{
    
	private int data;
	final public int getData() {return data;}
	final public void setData(int d) {data = d;}
	
    public SimpleServiceSVC_impl() {
        // Please add extra constructor code here.
    }

    /*
     * Methods corresponding to IDL attributes and operations
     */
    public int read(org.omg.CORBA.IntHolder data) {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <int read(org.omg.CORBA.IntHolder data)>"
    	data.value = this.data;
        return 0;
    }

    public int write(int data) {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <int write(int data)>"
    	this.data = data;
        return 0;
    }

    public int reset() {
        // Please insert your code here and remove the following warning pragma
        // TODO "Code missing in function <int reset()>"
    	int buf = data;
    	data = 0;
        return buf;
    }

//  End of example implementational code
}
