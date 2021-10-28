
import VendingMachine.Controller.VendingMachineController;
import VendingMachine.Service.VendingMachineServiceLayer;
import VendingMachine.dao.VendingMachineDao;
import VendingMachine.dao.VendingMachineDaoFileimpl;
import VendingMachine.dao.VendingMachineExceptions;
import VendingMachine.ul.UserIO;
import VendingMachine.ul.UserIOConsoleImpl;
import VendingMachine.ul.VendingMachineView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author QUEEN
 */
public class App {
    public static void main(String[] args) throws VendingMachineExceptions {
//        UserIO myIo = new UserIOConsoleImpl();
//        VendingMachineView myView = new VendingMachineView(myIo);
//        VendingMachineDao myDao = new VendingMachineDaoFileimpl();
//        VendingMachineServiceLayer service = new VendingMachineServiceLayer(myDao);
//        VendingMachineController myController = new VendingMachineController( service, myView);  
//        myController.run();

     ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = 
           ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
    
}
